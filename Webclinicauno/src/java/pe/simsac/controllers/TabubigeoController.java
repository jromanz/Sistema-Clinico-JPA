package pe.simsac.controllers;

import pe.simsac.entidades.Tabubigeo;
import pe.simsac.controllers.util.JsfUtil;
import pe.simsac.controllers.util.PaginationHelper;
import pe.simsac.facade.TabubigeoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("tabubigeoController")
@SessionScoped
public class TabubigeoController implements Serializable {

    private Tabubigeo current;
    private DataModel items = null;
    @EJB
    private pe.simsac.facade.TabubigeoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public TabubigeoController() {
    }

    public Tabubigeo getSelected() {
        if (current == null) {
            current = new Tabubigeo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TabubigeoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(100000) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Tabubigeo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Tabubigeo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TabubigeoCreated"));
            recreateModel();
            return "List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Tabubigeo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TabubigeoUpdated"));
            recreateModel();
            return "List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Tabubigeo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TabubigeoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

//    public SelectItem[] getItemsAvailableSelectOne() {
//        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
//    }
    public SelectItem[] getItemsAvailableSelectOne() {
        List<Tabubigeo> entities = ejbFacade.findAll();
        boolean selectOne = true;
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];

        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "Selecione Uno");
            i++;
        }
        for (Tabubigeo x : entities) {

            if (!x.getCoddistUbig().toString().equals("00")) {
                items[i++] = new SelectItem(x, x.toString());
            }
        }
        SelectItem[] items2 = new SelectItem[i];
        int r=0;
        for (r=0; r<i; r++ ) {
                items2[r] =  items[r];
        }
        return items2;
    }

    public Tabubigeo getTabubigeo(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Tabubigeo.class)
    public static class TabubigeoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TabubigeoController controller = (TabubigeoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tabubigeoController");
            return controller.getTabubigeo(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tabubigeo) {
                Tabubigeo o = (Tabubigeo) object;
                return getStringKey(o.getIdUbig());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Tabubigeo.class.getName());
            }
        }
    }
}

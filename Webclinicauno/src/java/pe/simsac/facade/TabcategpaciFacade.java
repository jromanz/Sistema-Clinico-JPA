/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Tabcategpaci;

/**
 *
 * @author simsac
 */
@Stateless
public class TabcategpaciFacade extends AbstractFacade<Tabcategpaci> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TabcategpaciFacade() {
        super(Tabcategpaci.class);
    }
    
}

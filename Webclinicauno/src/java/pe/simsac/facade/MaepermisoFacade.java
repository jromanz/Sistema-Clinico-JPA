/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Maepermiso;

/**
 *
 * @author simsac
 */
@Stateless
public class MaepermisoFacade extends AbstractFacade<Maepermiso> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaepermisoFacade() {
        super(Maepermiso.class);
    }
    
}

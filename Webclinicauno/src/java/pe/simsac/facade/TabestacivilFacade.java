/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Tabestacivil;

/**
 *
 * @author simsac
 */
@Stateless
public class TabestacivilFacade extends AbstractFacade<Tabestacivil> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TabestacivilFacade() {
        super(Tabestacivil.class);
    }
    
}

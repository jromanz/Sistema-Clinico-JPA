/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Tabformpago;

/**
 *
 * @author simsac
 */
@Stateless
public class TabformpagoFacade extends AbstractFacade<Tabformpago> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TabformpagoFacade() {
        super(Tabformpago.class);
    }
    
}

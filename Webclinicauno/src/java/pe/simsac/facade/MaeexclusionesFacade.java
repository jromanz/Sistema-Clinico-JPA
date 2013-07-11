/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Maeexclusiones;

/**
 *
 * @author simsac
 */
@Stateless
public class MaeexclusionesFacade extends AbstractFacade<Maeexclusiones> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaeexclusionesFacade() {
        super(Maeexclusiones.class);
    }
    
}

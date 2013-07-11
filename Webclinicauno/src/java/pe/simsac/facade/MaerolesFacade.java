/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Maeroles;

/**
 *
 * @author simsac
 */
@Stateless
public class MaerolesFacade extends AbstractFacade<Maeroles> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaerolesFacade() {
        super(Maeroles.class);
    }
    
}

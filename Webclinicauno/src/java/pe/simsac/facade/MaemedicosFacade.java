/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Maemedicos;

/**
 *
 * @author simsac
 */
@Stateless
public class MaemedicosFacade extends AbstractFacade<Maemedicos> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaemedicosFacade() {
        super(Maemedicos.class);
    }
    
}

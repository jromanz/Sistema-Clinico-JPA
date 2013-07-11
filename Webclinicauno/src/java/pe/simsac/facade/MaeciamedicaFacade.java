/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.simsac.entidades.Maeciamedica;

/**
 *
 * @author simsac
 */
@Stateless
public class MaeciamedicaFacade extends AbstractFacade<Maeciamedica> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaeciamedicaFacade() {
        super(Maeciamedica.class);
    }
    
}

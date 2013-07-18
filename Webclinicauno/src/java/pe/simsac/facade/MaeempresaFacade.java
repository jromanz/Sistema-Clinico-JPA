/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.simsac.entidades.Maeempresa;

/**
 *
 * @author simsac
 */
@Stateless
public class MaeempresaFacade extends AbstractFacade<Maeempresa> {
    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaeempresaFacade() {
        super(Maeempresa.class);
    }
    
    public List<Maeempresa> findIdAndRuc(){
        Query query = em.createNamedQuery("findIdAndRuc");
        return query.getResultList();
    }
}

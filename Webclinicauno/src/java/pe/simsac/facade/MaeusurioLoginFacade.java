package pe.simsac.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.simsac.entidades.Maeusurio;

@Stateless
public class MaeusurioLoginFacade implements MaeusurioLoginService {

    @PersistenceContext(unitName = "sgClinicacsbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Maeusurio validarUsuario(String user, String password) {
        Query query = em.createNamedQuery("Maeusurio.findByUserAndPassword", Maeusurio.class)
                .setParameter("loginUsua", user)
                .setParameter("claveUsua", password);
        List<Maeusurio> resultado = query.getResultList();

        if (resultado == null) {
            return null;
        } else if (resultado.size() != 1) {
            return null;
        } else {
            return resultado.get(0);
        }
    }
}

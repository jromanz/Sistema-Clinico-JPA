package pe.simsac.facade;

import pe.simsac.entidades.Maeusurio;

public interface MaeusurioLoginService {
    public Maeusurio validarUsuario(String user, String password);
}

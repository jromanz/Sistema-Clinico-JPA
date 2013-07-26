package pe.simsac.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.simsac.entidades.Maeusurio;
import pe.simsac.facade.MaeusurioCredentials;
import pe.simsac.facade.MaeusurioLoginService;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private pe.simsac.facade.MaeusurioLoginService maeusuriologinFacade;
    @Inject
    private MaeusurioCredentials maeusurioCredentials;
    private Maeusurio loginUsuario;

    public LoginController() {
    }

    public String validarUsuario() {
        loginUsuario = maeusuriologinFacade.validarUsuario(
                maeusurioCredentials.getUser(), maeusurioCredentials.getPassword());
        if (loginUsuario == null) {
            return "index";
        }
        return "principalClinica";
    }

    public MaeusurioLoginService getMaeusuriologinFacade() {
        return maeusuriologinFacade;
    }

    public void setMaeusuriologinFacade(MaeusurioLoginService maeusuriologinFacade) {
        this.maeusuriologinFacade = maeusuriologinFacade;
    }

    public MaeusurioCredentials getMaeusurioCredentials() {
        return maeusurioCredentials;
    }

    public void setMaeusurioCredentials(MaeusurioCredentials maeusurioCredentials) {
        this.maeusurioCredentials = maeusurioCredentials;
    }

    public Maeusurio getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(Maeusurio loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
    
    
}

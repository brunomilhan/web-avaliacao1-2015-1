package inscricao.faces.mngbeans;


import entity.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by bruno on 01/11/16.
 */
@Named
@RequestScoped
public class LoginBean {

    @Inject
    private RegistroBean registroBean = new RegistroBean();

    private User user;

    public LoginBean (){
        user = new User();

    }

    public String login(){
        if(!this.user.getUser().equals(this.user.getPassword())){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Acesso negado", "Acesso negado");
            FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
        } else {
            registroBean.save(user);
            if (user.isAdmin())
                return "admin";
            else
                return "cadastro";
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

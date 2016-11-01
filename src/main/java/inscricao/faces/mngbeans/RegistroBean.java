package inscricao.faces.mngbeans;

import entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 01/11/16.
 */
@Named
@ApplicationScoped
public class RegistroBean {

    private List<User> userList;

    public RegistroBean() {
        userList = new ArrayList<>();
    }

    public void save(User user) {
        user.setLoginDate(new Date(System.currentTimeMillis()));
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

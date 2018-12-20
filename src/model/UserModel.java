package model;

import beans.User;
import dao.UserDao;

import java.util.List;

public class UserModel {

    private User user = null;
    private UserDao dao =null;
    private String email = "";

    public UserModel() {
        user = new User();
        dao = new UserDao();
    }

    // Crud
    public boolean ajouter() { return dao.ajouter(user); }
    public boolean modifier() { return dao.modifier(email, user); }
    public boolean supprimer() { return dao.supprimer(email); }
    public User getUserByEmail() { return dao.getObject(email); }
    public List<User> getCategories() { return dao.getAll(); }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

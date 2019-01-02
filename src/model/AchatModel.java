package model;

import beans.Achat;
import dao.AchatDao;

import java.util.List;

public class AchatModel {

    private Achat achat = null;
    private AchatDao dao = null;
    private int userId;

    public AchatModel() {
        achat = new Achat();
        dao = new AchatDao();
    }

    public boolean ajouter() { return dao.ajouter(achat); }
    public List<Achat> getAchatsByUser() { return dao.getAchatsByUser(userId); }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
}

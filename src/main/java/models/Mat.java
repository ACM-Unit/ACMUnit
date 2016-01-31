package models;

/**
 * Created by Admin on 20.01.2016.
 */
public class Mat extends AbstractModelBean {
    private static final long serialVersionUID = 1044362348404780110L;
    private int id;
    private String codename;
    private int sizerol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getSizerol() {
        return sizerol;
    }

    public void setSizerol(int sizerol) {
        this.sizerol = sizerol;
    }
}

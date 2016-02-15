package models;

/**
 * Created by Admin on 20.01.2016.
 */
public class Precence extends AbstractModelBean {
    private static final long serialVersionUID = 1044362348404780110L;
    private int id;
    private int name;
    private int len;
    private int stat;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}

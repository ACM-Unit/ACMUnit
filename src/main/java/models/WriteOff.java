package models;

/**
 * Created by Admin on 20.01.2016.
 */
public class WriteOff extends AbstractModelBean {
    private static final long serialVersionUID = 1044362348404780110L;
    private int id;
    private int precence;
    private int len;
    private int typeWriteOf;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecence() {
        return precence;
    }

    public void setPrecence(int precence) {
        this.precence = precence;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getTypeWriteOf() {
        return typeWriteOf;
    }

    public void setTypeWriteOf(int typeWriteOf) {
        this.typeWriteOf = typeWriteOf;
    }
}

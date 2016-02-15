package models;

/**
 * Created by Admin on 20.01.2016.
 */
    public class TypeWriteOf extends AbstractModelBean {
    private static final long serialVersionUID = 1044362348404780110L;
    private int id;
    private String WriteOf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriteOf() {
        return WriteOf;
    }

    public void setWriteOf(String writeOf) {
        WriteOf = writeOf;
    }
}

package models;

/**
 * Created by Admin on 21.02.2016.
 */
public class Price  extends AbstractModelBean  {

    private int id;
    private String model;
    private String price;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




}

package app.modul;

import lombok.Data;


@Data
public class Employee {
    private int id;
    private String name;
    private String dec;
    private float price;

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Employee(int id, String name, String dec, float price) {
        this.id = id;
        this.name = name;
        this.dec = dec;
        this.price = price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDec() {
        return dec;
    }

    public float getPrice() {
        return price;
    }
}

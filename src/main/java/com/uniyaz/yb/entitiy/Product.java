package com.uniyaz.yb.entitiy;

import java.io.Serializable;

public  class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;


    public Product() {
        this.id = ListContainer.productDb.size() + 1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

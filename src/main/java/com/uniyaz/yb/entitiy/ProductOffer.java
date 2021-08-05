package com.uniyaz.yb.entitiy;

import java.io.Serializable;
import java.util.Comparator;

public class ProductOffer implements Serializable {

    private static final long serialVersionUID = -628789568975888036L;

    private int id;
    private String company_name;
    private String phone;
    private String price;
    private Product product;


    public ProductOffer() {
        this.id = ListContainer.productOfferDb.size() + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductOffer{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", phone='" + phone + '\'' +
                ", price='" + price + '\'' +
                ", product=" + product +
                '}';
    }


    public static Comparator<ProductOffer> comparePrice = new Comparator<ProductOffer>() {
        public int compare(ProductOffer p1, ProductOffer p2)
        {
            int price1 = Integer.parseInt(p1.getPrice());
            int price2 = Integer.parseInt(p2.getPrice());

            return price1 - price2;


        }
    };

}

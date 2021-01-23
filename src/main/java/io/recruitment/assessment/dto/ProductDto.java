package io.recruitment.assessment.dto;


public class ProductDto extends BaseDto  {
    private double price;
    private String description;

    public ProductDto(String name, String description, double price, Integer id) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.description = description;
    }

    public double getProductPrice() {
        return this.price;
    }

    public void setProductPrice(double newPrice) {
         this.price = newPrice;
    }

    public String getDesription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
         this.description = newDescription;
    }
}
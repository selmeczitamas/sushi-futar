package com.sushifutar.model;

import javax.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;
    @Enumerated(EnumType.STRING)
    private FoodSubCategory foodSubCategory;
    private double price;
    private String pictureURL;
    @OneToMany
    @Transient
    private Order order;


    public Food() {
    }

    public Food(String name, String description, FoodCategory foodCategory, FoodSubCategory foodSubCategory, double price, String pictureURL) {
        this.name = name;
        this.description = description;
        this.foodCategory = foodCategory;
        this.foodSubCategory = foodSubCategory;
        this.price = price;
        this.pictureURL = pictureURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodSubCategory getFoodSubCategory() {
        return foodSubCategory;
    }

    public void setFoodSubCategory(FoodSubCategory foodSubCategory) {
        this.foodSubCategory = foodSubCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foodSubCategory=" + foodSubCategory +
                ", price=" + price +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }
}

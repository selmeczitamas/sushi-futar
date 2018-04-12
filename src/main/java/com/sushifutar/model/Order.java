package com.sushifutar.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    @Transient
    private List<Food> foods = new ArrayList<>();
    private Date orderDate;
    private double totalOrderPrice;
    @ManyToOne
    private User user;

    public Order() {
    }

    public Order(Date orderDate, double totalOrderPrice) {
        this.orderDate = orderDate;
        this.totalOrderPrice = totalOrderPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFood(Food food) {
        foods.add(food);
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", foods=" + foods +
                ", orderDate=" + orderDate +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}

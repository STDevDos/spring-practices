package com.froyo.dto;

import java.util.Objects;

public class Order {

    private String name;
    private String cardType;
    private int discount;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return discount == order.discount && price == order.price && Objects.equals(name, order.name)
                && Objects.equals(cardType, order.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardType, discount, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", cardType='" + cardType + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}

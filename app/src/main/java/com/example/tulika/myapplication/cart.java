package com.example.tulika.myapplication;

public class cart
{
     String name;
     int qty,price;;


     public cart()
     {

     }
    public cart(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }
}

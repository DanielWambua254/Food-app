package com.example.foodapp.Domain;

import java.io.Serializable;

public class Foods implements Serializable {

    private int CategoryId;
    private String Description;
    private boolean BestFood;
    private int id;
    private int LocationId;
    private float Price;
    private String ImagePath;
    private int PriceId;
    private float Star;
    private int TimeId;
    private int TimeValue;
    private String Title;
    private  int NumberInCart;

    @Override
    public String toString() {
        return Title ;
    }


    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = timeValue;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumberInCart() {
        return NumberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        NumberInCart = numberInCart;
    }


    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBestFood() {
        return BestFood;
    }

    public void setBestFood(boolean bestFood) {
        BestFood = bestFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getPriceId() {
        return PriceId;
    }

    public void setPriceId(int priceId) {
        PriceId = priceId;
    }

    public float getStar() {
        return Star;
    }

    public void setStar(float star) {
        Star = star;
    }

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = timeId;
    }


    public Foods() {
    }
}

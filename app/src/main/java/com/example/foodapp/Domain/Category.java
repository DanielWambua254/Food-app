package com.example.foodapp.Domain;

public class Category {
    private int Id;
    private String ImagePath;
    private  String Name;

    public Category() {
    }

    public void setId(int id) {
        Id = id;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getName() {
        return Name;
    }

}



package com.praktikum.data;

import com.praktikum.users.User;
public class Item {
    private String itemName;
    private String location;
    private String description;
    private String status;
    private User reported;

    public Item(String itemName, String location, String description, User reported) {
        this.itemName = itemName;
        this.location = location;
        this.description = description;
        this.reported = reported;
        this.status = "Reported";
    }

    public String getitemName() {
        return itemName;
    }

    public String getlocation() {
        return location;
    }

    public String getdescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getreported() {
        return reported;
    }

    @Override
    public String toString() {
        return "Barang: " + itemName + "\nLokasi: " + location + "\nDeskripsi: " + description + "\nDilaporkan oleh: " + reported.getNama();
    }
}

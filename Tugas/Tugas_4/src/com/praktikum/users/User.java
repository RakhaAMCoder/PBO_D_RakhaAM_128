package com.praktikum.users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim =nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean login(String inputNama, String inputNim){
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    public void displayInfo(){
        System.out.println("Nama : " + nama);
        System.out.println("Nim  : " + nim);
    }

    public abstract void dispLayAppMenu();

}
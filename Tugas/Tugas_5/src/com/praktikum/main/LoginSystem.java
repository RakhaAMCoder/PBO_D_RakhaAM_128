package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        userList.add(new Admin("CrownVex999", "999", "admin999", "pw999"));
        userList.add(new Mahasiswa("Rakha", "202410370110128"));
        userList.add(new Mahasiswa("Ghetto", "202410370110111"));

        while (true) {
            System.out.println("\nPilih Jenis Login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan Anda: ");

            int pilihan = -1;
            try {
                pilihan = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scan.nextLine();
                continue;
            }
            scan.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan Username Admin: ");
                String username = scan.nextLine();
                System.out.print("Masukkan Password Admin: ");
                String password = scan.nextLine();

                boolean loginBerhasil = false;

                for (User user : userList) {
                    if (user instanceof Admin && user.login(username, password)) {
                        user.displayInfo();
                        user.dispLayAppMenu();
                        loginBerhasil = true;
                        break;
                    }
                }
                if (!loginBerhasil) {
                    System.out.println("\nUsername atau Password Salah! Coba lagi.");
                }

            } else if (pilihan == 2) {
                System.out.print("Masukkan Nama Mahasiswa: ");
                String nama = scan.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = scan.nextLine();

                boolean loginBerhasil = false;

                for (User user : userList) {
                    if (user instanceof Mahasiswa && user.login(nama, nim)) {
                        user.displayInfo();
                        user.dispLayAppMenu();
                        loginBerhasil = true;
                        break;
                    }
                }

                if (!loginBerhasil) {
                    System.out.println("Nama atau Nim Salah! Coba lagi.");
                }

            } else if (pilihan == 3) {
                System.out.println("Keluar dari sistem. Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

}

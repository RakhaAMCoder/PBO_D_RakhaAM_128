package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner scan = new Scanner(System.in);
    public Mahasiswa(String nama, String nim){
        super(nama,nim);

    }

    @Override
    public boolean login(String inputNama, String inputNim){
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void reportItem() {
        System.out.println("\n=== Form Laporan Barang ===");
        System.out.print("Nama Barang: ");
        String itemName = scan.nextLine();
        System.out.print("Deskripsi Barang: ");
        String description = scan.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String location = scan.nextLine();

        Item item = new Item(itemName, description, location, this);
        LoginSystem.getReportedItems().add(item);

        System.out.println("\nBarang berhasil dilaporkan!");
    }

    @Override
    public void viewReportedItems() {
        System.out.println("\n=== Laporan Barang Anda ===");
        int i = 1;
        for (Item item : LoginSystem.getReportedItems()) {
            if (item.getreported().equals(this) && "Reported".equals(item.getStatus())) {
                System.out.println("[" + i++ + "] " + item);
            }
        }
        if (i == 1) {
            System.out.println("Belum ada laporan barang.");
        }
    }


    @Override
    public void dispLayAppMenu() {
        while (true) {
            System.out.println("\n=== MENU UTAMA MAHASISWA ===");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Barang yang Dilaporkan");
            System.out.println("3. Logout");
            System.out.print("Masukkan Pilihan Anda: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            if (pilihan == 1) {
                reportItem();
            } else if (pilihan == 2) {
                viewReportedItems();
            } else if (pilihan == 3) {
                System.out.println("Logout dari Mahasiswa berhasil.\n");
                break;
            } else {
                System.out.println("Pilihan tidak valid! Silakan pilih antara (1-3).");
            }
        }
    }
}
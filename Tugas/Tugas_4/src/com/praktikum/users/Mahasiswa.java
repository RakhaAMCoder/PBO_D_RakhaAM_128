package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;


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
    public void displayInfo(){
        System.out.println("Login berhasil! Selamat datang, " + getNama() + ("\n"));
    }

    @Override
    public void reportItem() {
        System.out.print("Masukkan Nama Barang: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsi = scan.nextLine();
        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scan.nextLine();

        System.out.println("Nama Barang:"+nama);
        System.out.println("Deskripsi Barang:"+deskripsi);
        System.out.println("Lokasi Terakhir/Ditemukan:"+lokasi);    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");

    }
    @Override
    public void dispLayAppMenu() {
        while (true){
            System.out.println("MENU UTAMA MAHASISWA");
            System.out.println("1. Laporkan Barang Temuan/Hilang ");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("3. Logout");

            System.out.print("Masukkan Pilihan Anda: ");
            int pilihan = scan.nextInt();
            scan.nextLine();
            if (pilihan == 1){
                reportItem();
            } else if (pilihan == 2) {
                viewReportedItems();
            } else if (pilihan == 3) {
                System.out.println("Anda Logout Dari Mahasiswa!!" + ("\n"));
                break;
            }else
                System.out.println("Inputan tidak valid! Pilih antara (1//3)");
        }

    }
}
package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.Scanner;
import java.util.Iterator;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;
    private Scanner scan = new Scanner(System.in);

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUser, String inputPassword) {
        return this.username.equals(inputUser) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("\nLogin berhasil sebagai Admin: " + getNama());
    }

    @Override
    public void manageItems() {
        while (true) {
            System.out.println("\n=== KELOLA LAPORAN BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            if (pilihan == 1) {
                lihatSemuaLaporan();
            } else if (pilihan == 2) {
                tandaiBarangClaimed();
            } else if (pilihan == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void lihatSemuaLaporan() {
        System.out.println("\n=== Daftar Laporan Barang ===");
        if (LoginSystem.getReportedItems().isEmpty()) {
            System.out.println("Belum ada barang yang dilaporkan.");
        } else {
            int i = 1;
            for (Item item : LoginSystem.getReportedItems()) {
                System.out.println("[" + i++ + "] " + item + " | Status: " + item.getStatus());
            }
        }
    }

    private void tandaiBarangClaimed() {
        System.out.println("\n=== Tandai Barang Telah Diambil ===");
        if (LoginSystem.getReportedItems().isEmpty()) {
            System.out.println("Tidak ada barang yang dilaporkan.");
            return;
        }

        int i = 1;
        for (Item item : LoginSystem.getReportedItems()) {
            if ("Reported".equals(item.getStatus())) {
                System.out.println("[" + i + "] " + item);
            }
            i++;
        }

        System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
        try {
            int indeks = Integer.parseInt(scan.nextLine());
            if (indeks <= 0 || indeks > LoginSystem.getReportedItems().size()) {
                System.out.println("Indeks tidak valid.");
                return;
            }
            Item item = LoginSystem.getReportedItems().get(indeks - 1);
            item.setStatus("Claimed");
            System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks di luar jangkauan!");
        }
    }

    @Override
    public void manageUsers() {
        while (true) {
            System.out.println("\n=== KELOLA DATA MAHASISWA ===");
            System.out.println("1. Lihat Daftar Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            int pilih;
            try {
                pilih = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            if (pilih == 1) {
                lihatDaftarMahasiswa();
            } else if (pilih == 2) {
                System.out.print("Masukkan Nama Mahasiswa: ");
                String nama = scan.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = scan.nextLine();
                Mahasiswa mhs = new Mahasiswa(nama, nim);
                LoginSystem.getUserList().add(mhs);
                System.out.println("Mahasiswa berhasil ditambahkan.");
            } else if (pilih == 3) {
                System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                String nimToRemove = scan.nextLine();
                boolean removed = false;
                Iterator<User> iterator = LoginSystem.getUserList().iterator();
                while (iterator.hasNext()) {
                    User user = iterator.next();
                    if (user instanceof Mahasiswa && user.getNim().equals(nimToRemove)) {
                        iterator.remove();
                        removed = true;
                        System.out.println("Mahasiswa berhasil dihapus.");
                        break;
                    }
                }
                if (!removed) {
                    System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                }
            } else if (pilih == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void lihatDaftarMahasiswa() {
        System.out.println("\n=== Daftar Mahasiswa Terdaftar ===");
        int i = 1;
        for (User user : LoginSystem.getUserList()) {
            if (user instanceof Mahasiswa) {
                System.out.println("[" + i++ + "] Nama: " + user.getNama() + ", NIM: " + user.getNim());
            }
        }
        if (i == 1) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
        }
    }


    @Override
    public void dispLayAppMenu() {
        while (true) {
            System.out.println("\n=== MENU UTAMA ADMIN ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
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
                manageItems();
            } else if (pilihan == 2) {
                manageUsers();
            } else if (pilihan == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid! Silakan pilih antara 1 hingga 3.");
            }
        }
    }
}


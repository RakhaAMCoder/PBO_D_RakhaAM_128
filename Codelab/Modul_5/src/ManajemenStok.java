import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                continue;
            }

            switch (pilihan) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    try {
                        System.out.print("Masukkan jumlah stok: ");
                        int stok = scanner.nextInt();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang " + ("'") + (nama) + ("'") + (" Berhasil Ditambahkan. Sebanyak: " + ("'") + (stok) + ("'")));
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.next();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\n--==Daftar Barang==--");
                        for (Barang barang : daftarBarang) {
                            System.out.println("- " + barang.getNama() + ": " + barang.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang yang tersedia.");
                        break;
                    }

                    System.out.println("\nPilih barang untuk dikurangi stok:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println(i + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
                    }

                    try {
                        System.out.print("Masukkan indeks barang: ");
                        int indeks = scanner.nextInt();

                        Barang barang = daftarBarang.get(indeks);

                        System.out.print("Masukkan jumlah yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();

                        if (jumlahDiambil > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println("Barang " + ("'") + (barang.getNama()) + ("'") + (" Berhasil Dikurangi. Sisa Stok: " + ("'") + (barang.getStok()) + ("'")));
                    } catch (InputMismatchException e) {
                        System.out.println("Input indeks atau jumlah harus berupa angka!");
                        scanner.next();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
        scanner.close();
    }
}

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaAdmin = "Rk Admin";
        String nimAdmin = "202410370110999";

        String namaMhs = "Rakha Aminullah Muhran";
        String nimMhs = "202410370110128";

        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine(); // consume newline

        if (pilihan == 1) {
            Admin admin = new Admin(namaAdmin, nimAdmin);
            if (admin.login()) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            Mahasiswa mhs = new Mahasiswa(namaMhs, nimMhs);
            if (mhs.login()) {
                mhs.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}

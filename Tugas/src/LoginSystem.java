import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaMahasiswa = "Rakha Aminullah Muhran";
        String nimMahasiswa = "202410370110128";
        String tigaDigitAkhir = nimMahasiswa.substring(nimMahasiswa.length() - 3);

        Admin admin = new Admin(tigaDigitAkhir);
        Mahasiswa mahasiswa = new Mahasiswa(namaMahasiswa, nimMahasiswa);

        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = input.nextLine();

            System.out.print("Masukkan password: ");
            String password = input.nextLine();

            if (admin.login(username, password)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();

            System.out.print("Masukkan NIM: ");
            String nim = input.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        input.close();
    }
}

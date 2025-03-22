import java.util.Scanner;

// Kelas User (Superclass)
class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean login(String nama, String nim) {
        return this.nama.equals(nama) && this.nim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

// Kelas Admin (Subclass dari User)
class Admin extends User {
    private String username;
    private String password;

    public Admin(String lastThreeDigitsNIM) {
        super("Admin", lastThreeDigitsNIM);
        this.username = "Admin" + lastThreeDigitsNIM;
        this.password = "Password" + lastThreeDigitsNIM;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
    }
}

// Kelas Mahasiswa (Subclass dari User)
class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nim) {
        return super.getNama().equals(nama) && super.getNim().equals(nim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        super.displayInfo();
    }
}

// Kelas LoginSystem (Program utama)
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            Admin admin = new Admin("128");
            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (choice == 2) {
            System.out.print("Masukkan Nama: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa("Rakha Aminullah Muhran", "202410370110128");
            if (mahasiswa.login(name, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}

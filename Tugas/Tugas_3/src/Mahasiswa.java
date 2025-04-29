public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String inputNama = input.nextLine();
        System.out.print("Masukkan NIM: ");
        String inputNim = input.nextLine();

        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}

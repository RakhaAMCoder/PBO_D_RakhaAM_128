public class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

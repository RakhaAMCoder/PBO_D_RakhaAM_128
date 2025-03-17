class Hewan {
    String nama;
    String jenis;
    String suara;

    Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Miauw!!");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
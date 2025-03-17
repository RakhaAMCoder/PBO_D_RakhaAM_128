class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }

    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Berhasil menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Jumlah setor harus positif!");
        }
    }

    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Berhasil menarik Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Jumlah penarikan tidak valid atau saldo tidak mencukupi!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank("202410370110128", "Rakha A.M", 5000000);
        RekeningBank rekening2 = new RekeningBank("202410370110129", "Azizi", 3000000);

        rekening1.tampilkanInfo();
        rekening1.setorUang(700000);
        rekening1.tarikUang(1000000);
        System.out.println();

        rekening2.tampilkanInfo();
        rekening2.setorUang(500000);
        rekening2.tarikUang(750000);
    }
}

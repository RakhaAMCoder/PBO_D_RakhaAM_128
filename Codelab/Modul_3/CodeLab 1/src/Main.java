class KarakterGame {
    protected String nama;
    protected int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.nama);
    }
}

class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.nama + " menggunakan Orbital Strike!");
        target.kesehatan -= 20;
        System.out.println(target.nama + " sekarang memiliki kesehatan " + target.kesehatan);
    }
}

class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.nama + " menggunakan Snake Bite!");
        target.kesehatan -= 15;
        System.out.println(target.nama + " sekarang memiliki kesehatan " + target.kesehatan);
    }
}

public class Main {
    public static void main(String[] args) {
        KarakterGame umum = new KarakterGame("Karakter Umum", 100);
        Pahlawan CrownVex = new Pahlawan("CrownVex", 128);
        Musuh BlackJack = new Musuh("BlackJack", 228);

        System.out.println("Status awal:");
        System.out.println(CrownVex.nama + " memiliki kesehatan: " + CrownVex.kesehatan);
        System.out.println(BlackJack.nama + " memiliki kesehatan: " + BlackJack.kesehatan);

        CrownVex.serang(BlackJack);
        BlackJack.serang(CrownVex);
    }
}

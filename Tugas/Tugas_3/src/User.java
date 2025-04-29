public class User {
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

    public boolean login() {
        return false;
    }

    public void displayInfo() {
        System.out.println("Info login belum tersedia.");
    }
}

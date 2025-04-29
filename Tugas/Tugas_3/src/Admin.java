public class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim) {
        super(nama, nim);
        this.username = "Admin" + nim.substring(nim.length() - 3);
        this.password = "Pass" + nim.substring(nim.length() - 3);
    }

    @Override
    public boolean login() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Masukkan username: ");
        String user = input.nextLine();
        System.out.print("Masukkan password: ");
        String pass = input.nextLine();

        return user.equals(username) && pass.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }
}

public class Admin {
    private String username;
    private String password;

    public Admin(String nimAkhir) {
        this.username = "Admin" + nimAkhir;
        this.password = "Password" + nimAkhir;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

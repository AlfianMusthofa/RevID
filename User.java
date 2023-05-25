abstract class User{

    private String username;
    private String password;
    private int nik;
    private int ponsel;

    public User(String username, String password, int nik, int ponsel){
        this.username = username;
        this.password = password;
        this.nik = nik;
        this.ponsel = ponsel;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getNik(){
        return nik;
    }

    public int getPonsel(){
        return ponsel;
    }

    public abstract void displayInfo();

}
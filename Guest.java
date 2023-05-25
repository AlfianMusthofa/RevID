/**
 * Guest
 */
public class Guest extends User {

    int noKursi;

    public Guest(String username, String password, int nik, int ponsel, int noKursi) {
        super(username, password, nik, ponsel);
        this.noKursi = noKursi;
    }

    public int getNoKursi(){
        return noKursi;
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
    }

    
}
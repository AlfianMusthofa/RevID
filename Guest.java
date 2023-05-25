/**
 * Guest
 */
public class Guest extends User {

    int noKursi;
    int noPonsel;

    public Guest(String username, String password, int nik, int ponsel, int noKursi, int noPonsel) {
        super(username, password, nik, ponsel);
        this.noKursi = noKursi;
        this.noPonsel = noPonsel;
    }

    public int getNoKursi(){
        return noKursi;
    }

    public int getNoponsel(){
        return noPonsel;
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
    }

    
}
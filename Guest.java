/**
 * Guest
 */
public class Guest extends User {

    int noKursi;
    int noPonsel;

    public Guest(String username, String password, int guestNIK, int guestNoponsel, int noKursi, int noPonsel) {
        super(username, password, guestNIK, guestNoponsel);
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
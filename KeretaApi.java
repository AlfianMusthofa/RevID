/**
 * KeretaApi
 */
public class KeretaApi extends User {

    private int tanggalPergi;
    private int NoKursi;
    private int pilihanKereta;

    public KeretaApi(String username, String password, int nik, int ponsel, int tanggalPergi, int NoKursi, int pilihanKereta) {
        super(username, password, nik, ponsel);
        this.tanggalPergi = tanggalPergi;
        this.NoKursi = NoKursi;
        this.pilihanKereta = pilihanKereta;
    }

    @Override
    public void displayInfo() {
        
        String namaKereta = "";

        if (pilihanKereta == 1) {
            namaKereta = "Argo Bromo";
        }
        else {
            namaKereta = "Parahyangan";
        }

        System.out.println("------------------------------");
        System.out.println("-            Ticket           ");
        System.out.println("------------------------------");
        System.out.println("Nama          : " + getUsername());
        System.out.println("NIK           : " + getNik());
        System.out.println("Ponsel        : " + getPonsel());
        System.out.println("Tanggal Pergi : " + this.tanggalPergi);
        System.out.println("No.Kursi      : " + this.NoKursi);
        System.out.println("Nama Kereta   : " + namaKereta);

    }

    
}
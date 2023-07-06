public class KeretaApiBuilder {

    protected String username;
    protected String password;
    protected int nik;
    protected int ponsel;
    protected int tanggalPergi;
    protected int tanggalPulang;
    protected int NoKursi;
    protected int pilihanKereta;
    protected String dari;
    protected String ke;

    public KeretaApiBuilder(String username, String password, int hargaTiket, int noKursi, int nik, int ponsel){
        this.username = username;
        this.password = password;
        this.nik = nik;
        this.ponsel = ponsel;
    }

    public KeretaApiBuilder setTanggalPergi(int tanggalPergi){
        this.tanggalPergi = tanggalPergi;
        return this;
    }

    public KeretaApiBuilder setNoKursi(int NoKursi){
        this.NoKursi = NoKursi;
        return this;
    }

    public KeretaApiBuilder setPilihanKereta(int pilihanKereta){
        this.pilihanKereta = pilihanKereta;
        return this;
    }

    public KeretaApiBuilder setDari(String dari){
        this.dari = dari;
        return this;
    }

    public KeretaApiBuilder setKe(String ke){
        this.ke = ke;
        return this;
    }

    public KeretaApiBuilder setTanggalPulang(int tanggalPulang){
        this.tanggalPulang = tanggalPulang;
        return this;
    }

    public User build(){
        return new KeretaApi(this);
    }


}

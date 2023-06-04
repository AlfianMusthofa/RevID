import java.util.*;
import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {

            char mainmenu;
            char tiket;
            String username = "";
            String password = "";
            int nik = 0;
            int ponsel = 0;
            User regulerUser = null;
            User guestUser = null;
            List<User> users = new ArrayList<>();

            do {
                ClearScreen.clearScreen();
                System.out.println("Main Menu");
                System.out.println("1. Registrasi");
                System.out.println("2. Login");
                System.out.println("3. Beli Saldo TicketWallet");
                System.out.println("4. Cek Saldo TicketWallet");
                System.out.print("Pilihan : ");
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1: // Registrasi
                        System.out.println("-----------------------------");
                        System.out.println("|         Registrasi        |");
                        System.out.println("-----------------------------");
                        System.out.print("| Username  : ");
                        username = input.next();
                        System.out.print("| Password  : ");
                        password = input.next();
                        System.out.print("| NIK       : ");
                        nik = input.nextInt();
                        System.out.print("| No.Ponsel : ");
                        ponsel = input.nextInt();
                        System.out.println("-----------------------------");

                        regulerUser = new Regular(username, password, nik, ponsel, 0, 0, 0, "", "");
                        System.out.println("---------------------------------------");
                        System.out.println("| Registrasi berhasil! silakan login! |");
                        System.out.println("---------------------------------------");

                        break;
                
                    case 2: // Login
                        System.out.println("-----------------------------");
                        System.out.println("|           Login           |");
                        System.out.println("-----------------------------");
                        System.out.print("| Username    : ");
                        String loginUsername = input.next();
                        System.out.print("| Password    : ");
                        String loginPassword = input.next();
                        System.out.println("-----------------------------");

                        if (loginUsername.equals(username) && loginPassword.equals(password)) {
                            System.out.println("Login berhasil!");

                            do {
                                
                                System.out.println("1.Kereta Api");
                                System.out.print("Pilihan: ");
                                int pil_menu = input.nextInt();

                                switch (pil_menu) {
                                    case 1: //KERETA
                                        
                                        System.out.print("Dari : ");
                                        String dari = input.next();
                                        System.out.print("ke   : ");
                                        String ke = input.next();
                                        System.out.print("Jumlah penumpang : ");
                                        int jumlahpenumpang = input.nextInt();
                                        System.out.println("-----------------");
                                        System.out.println("Mode perjalanan");
                                        System.out.println("1. Sekali jalan");
                                        System.out.println("2. Pulang pergi");
                                        System.out.println("-----------------");
                                        System.out.print("pilihan : ");
                                        int modeJalan = input.nextInt();
                                        
                                        switch (modeJalan) {
                                            case 1: // Sekali jalan
                                                
                                                System.out.print("Tanggal pergi : ");
                                                int tanggalPergi = input.nextInt();
                                                System.out.println("1. Argo Bromo");
                                                System.out.println("2. Parahyangan");
                                                System.out.print("Pilihan  : ");
                                                int pilihanKereta = input.nextInt();
                                                System.out.print("No.Kursi : ");
                                                int NoKursi = input.nextInt();

                                                if (jumlahpenumpang == 1) {
                                                    
                                                    KeretaApiBuilder builder = new KeretaApiBuilder(loginUsername, loginPassword, nik, ponsel)
                                                    .setDari(dari)
                                                    .setKe(ke)
                                                    .setTanggalPergi(tanggalPergi)
                                                    .setPilihanKereta(pilihanKereta)
                                                    .setNoKursi(NoKursi);

                                                    regulerUser = builder.build();
                                                    
                                                    users.add(regulerUser);
                                                }

                                                else if (jumlahpenumpang > 1) {

                                                    KeretaApiBuilder builder = new KeretaApiBuilder(loginUsername, loginPassword, nik, ponsel)
                                                    .setDari(dari)
                                                    .setKe(ke)
                                                    .setTanggalPergi(tanggalPergi)
                                                    .setPilihanKereta(pilihanKereta)
                                                    .setNoKursi(NoKursi);

                                                    regulerUser = builder.build();
                                                    users.add(regulerUser);
                       
                                                    for (int i = 1; i < jumlahpenumpang; i++) {
                                                        System.out.println("--------------------------");
                                                        System.out.println("Masukkan data penumpang ke " + (i+1));
                                                        System.out.print("Nama      : ");
                                                        String guestUsername = input.next();
                                                        System.out.print("NIK       : ");
                                                        int guestNIK = input.nextInt();
                                                        System.out.print("No.Kursi  : ");
                                                        int guestNoKursi = input.nextInt();
                                                        System.out.print("No.Ponsel : ");
                                                        int guestNoponsel = input .nextInt();
                                                        System.out.println("--------------------------");
                                                        
                                                        guestUser = new Guest(guestUsername, "", guestNIK, guestNoponsel, guestNoKursi, guestNoponsel);
                                            
                                                        KeretaApiBuilder builder2 = new KeretaApiBuilder(guestUsername, "", guestNIK, guestNoponsel)
                                                        .setNoKursi(guestNoKursi)
                                                        .setTanggalPergi(tanggalPergi)
                                                        .setDari(dari)
                                                        .setKe(ke);
                                                        guestUser = builder2.build();
                                                        users.add(guestUser);
                                                  
                                                    }

                                                }

                                                for(User user : users){
                                                    user.displayInfo();
                                                }

                                                break;
                                        
                                            default: // 2x jalan
                                                System.out.println("Coming Soon!");
                                                break;
                                        }

                                        break;

                                    default: // Lain-lain
                                        break;
                                }

                                System.out.print("Menu [y/t]: ");
                                tiket = input.next().charAt(0);
                            } while (tiket != 't');
                            
                        }

                        else {
                            System.out.println("---------------------------------------------");
                            System.out.println("| Login gagal! Username atau Password salah!|");
                            System.out.println("---------------------------------------------");
                        }

                        break;
                }

                System.out.print("Main menu [y/t]: ");
                mainmenu = input.next().charAt(0);
            } while (mainmenu != 't');

        }

    }
}
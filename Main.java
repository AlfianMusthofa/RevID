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
            List<User> users = new ArrayList<>();

            do {
                
                System.out.println("Main Menu");
                System.out.println("1. Registrasi");
                System.out.println("2. Login");
                System.out.print("Pilihan : ");
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        
                        System.out.println("Registrasi");
                        System.out.print("Username  : ");
                        username = input.next();
                        System.out.print("Password  : ");
                        password = input.next();
                        System.out.print("NIK       : ");
                        nik = input.nextInt();
                        System.out.print("No.Ponsel : ");
                        ponsel = input.nextInt();

                        regulerUser = new Regular(username, password, nik, ponsel);

                        System.out.println("Regsitrasi berhasil! silakan login!");

                        break;
                
                    default:

                        System.out.println("Login");
                        System.out.print("Username    : ");
                        String loginUsername = input.next();
                        System.out.print("Password    : ");
                        String loginPassword = input.next();

                        if (loginUsername.equals(username) && loginPassword.equals(password)) {
                            System.out.println("Login berhasil!");

                            do {
                                
                                System.out.println("1.Kereta Api");
                                System.out.print("Pilihan: ");
                                int pil_menu = input.nextInt();

                                switch (pil_menu) {
                                    case 1: //KERETA
                                        
                                        System.out.print("Tanggal pergi : ");
                                        int tanggalPergi = input.nextInt();
                                        System.out.println("Jumlah penumpang");
                                        int jumlahpenumpang = input.nextInt();
                                        System.out.println("Pilihan kereta : ");
                                        int pilihanKereta = input.nextInt();
                                        System.out.println("No.Kursi : ");
                                        int NoKursi = input.nextInt();

                                        if (jumlahpenumpang == 1) {

                                            regulerUser = new KeretaApi(loginUsername, loginPassword, nik, ponsel, tanggalPergi, NoKursi, pilihanKereta);
                                            regulerUser.displayInfo();
                                        }

                                        else if(jumlahpenumpang > 1){

                                            for (int i = 1; i < jumlahpenumpang; i++) {
                                                
                                                System.out.println("Data penumpang ke " + (i+1));
                                                System.out.print("Username : ");
                                                String guestUsername = input.next();
                                                System.out.print("NIK      : ");
                                                int guestNik = input.nextInt();
                                                System.out.print("No.Ponsel  : ");
                                                int guestPonsel = input.nextInt();

                                                regulerUser = new KeretaApi(guestUsername, loginPassword, guestNik, guestPonsel, tanggalPergi, NoKursi, pilihanKereta);
                                                User guestUser = new Guest(guestUsername, "", guestNik, guestPonsel);
                                                users.add(guestUser);
                                                regulerUser.displayInfo();
                                            
                                            }

                                            for(User guest : users){
                                                guest.displayInfo();
                                            }

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
                            System.out.println("Login gagal!");
                        }

                        break;
                }

                System.out.print("Main menu [y/t]: ");
                mainmenu = input.next().charAt(0);
            } while (mainmenu != 't');

        }

    }
}
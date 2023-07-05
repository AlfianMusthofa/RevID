import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            char mainmenu;
            char tiket;
            String username_reg = "";
            String password_reg = "";
            String nik_reg = "";
            String ponsel_reg = "";
            User regulerUser = null;
            User guestUser = null;
            List<User> users = new ArrayList<>();
            TicketWallet wallet = new TicketWallet();
            int hargaTiket = 0;

            do {

                ClearScreen.clearScreen();
                System.out.println("Main Menu");
                System.out.println("1. Registrasi");
                System.out.println("2. Login");
                System.out.println("3. Beli Saldo TicketWallet");
                System.out.println("4. Cek Saldo TicketWallet");
                System.out.print("Pilihan : ");
                int pilihan = input.nextInt();

                switch (pilihan) { // MAIN MENU
                    case 1:

                        System.out.println("-----------------------------");
                        System.out.println("|         Registrasi        |");
                        System.out.println("-----------------------------");
                        System.out.print("| Username  : ");
                        username_reg = input.next();
                        System.out.print("| Password  : ");
                        password_reg = input.next();
                        System.out.print("| NIK       : ");
                        nik_reg = input.next();
                        System.out.print("| No.Ponsel : ");
                        ponsel_reg = input.next();
                        System.out.println("-----------------------------");

                        // KONEKSI KE DATABASES
                        String url = "jdbc:mysql://localhost:3306/ticket_db";
                        String username = "root";
                        String password = "";

                        try (Connection connection = DriverManager.getConnection(url, username, password)) {

                            String insertQuery = "INSERT INTO user (username, password, nik, nohp) VALUES (?, ?, ?, ?)";

                            try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {

                                pst.setString(1, username_reg);
                                pst.setString(2, password_reg);
                                pst.setString(3, nik_reg);
                                pst.setString(4, ponsel_reg);

                                int k = pst.executeUpdate();

                                if (k == 1) {
                                    System.out.println("User ditambahkan!");
                                } else {
                                    System.out.println("gagal ditambahkan!");
                                }

                            } catch (SQLException e) {
                                System.out.println("Terjadi kesalahan saat menyimpan data pengguna: " + e.getMessage());
                            }

                        } catch (SQLException e) {
                            System.out.println("Koneksi ke database gagal: " + e.getMessage());
                        }

                        break;

                    case 2:

                        System.out.println("-----------------------------");
                        System.out.println("|           Login           |");
                        System.out.println("-----------------------------");
                        System.out.print("| Username    : ");
                        String loginUsername = input.next();
                        System.out.print("| Password    : ");
                        String loginPassword = input.next();
                        System.out.println("-----------------------------");

                        // KONEKSI DATABASES

                        String url_log = "jdbc:mysql://localhost:3306/ticket_db";
                        String username_log = "root";
                        String password_log = "";

                        try (Connection connection = DriverManager.getConnection(url_log, username_log, password_log)) {

                            // logika login
                            String selectQuery = "SELECT * FROM user WHERE username = ? AND password = ?";

                            try (PreparedStatement pst = connection.prepareStatement(selectQuery)) {

                                pst.setString(1, loginUsername);
                                pst.setString(2, loginPassword);
                                ResultSet rs = pst.executeQuery();

                                if (rs.next()) {
                                    // Main tiket prog
                                }
                                else {
                                    System.out.println("Username atau password salah!");
                                }

                            } catch (Exception e) {
                                // TODO: handle exception
                            }

                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                        break;
                }

                System.out.print("Main menu[y/t]: ");
                mainmenu = input.next().charAt(0);
            } while (mainmenu != 't');

        }

    }
}

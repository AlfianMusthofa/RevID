// package koneksi;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.Scanner;

// public class koneksi_prog {
//     public static void main(String[] args) {

//         String url = "jdbc:mysql://localhost:3306/ticket_db";
//         String username = "root";
//         String password = "";

//         try (Connection connection = DriverManager.getConnection(url, username, password)) {

//             System.out.println("Koneksi Berhasil!");

//             Scanner input = new Scanner(System.in);

//             System.out.println("-----------------------------");
//             System.out.println("|         Registrasi        |");
//             System.out.println("-----------------------------");
//             System.out.print("| Username  : ");
//             String username_reg = input.next();
//             System.out.print("| Password  : ");
//             String password_reg = input.next();
//             System.out.print("| NIK       : ");
//             String nik_reg = input.next();
//             System.out.print("| No.Ponsel : ");
//             String ponsel_reg = input.next();
//             System.out.println("-----------------------------");

//             // MENYIMPAN DATA PENGGUNA KE DATABASES
//             String insertQuery = "INSERT INTO user (username, password, nik, nohp) VALUES (?, ?, ?, ?)";

//             try (PreparedStatement statement = connection.prepareStatement(insertQuery)){

//                 statement.setString(1, username_reg);
//                 statement.setString(2, password_reg);
//                 statement.setString(3, nik_reg);
//                 statement.setString(4, ponsel_reg);
//                 statement.executeUpdate();

//                 System.out.println("Registrasi berhasil!");
                
//             } catch (SQLException e) {
//                 System.out.println("Terjadi kesalahan saat menyimpan data pengguna: " + e.getMessage());
//             }

//         } catch (SQLException e) {
//             System.out.println("Koneksi ke database gagal: " + e.getMessage());
//         }

//     }
// }

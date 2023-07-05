package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class koneksi_log {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/ticket_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            System.out.println("Koneksi Sucess!");

             Scanner input = new Scanner(System.in);

            System.out.println("-----------------------------");
            System.out.println("|           Login           |");
            System.out.println("-----------------------------");
            System.out.print("| Username    : ");
            String loginUsername = input.next();
            System.out.print("| Password    : ");
            String loginPassword = input.next();
            System.out.println("-----------------------------");

            // Koneksi databases
            String selectQuery = "SELECT * FROM user WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {

                statement.setString(1, loginUsername);
                statement.setString(2, loginPassword);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login berhasil!");
                } else {
                    System.out.println("Username atau password salah!");
                }
                
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat login: " + e.getMessage());
            }
            
        } catch (Exception e) {
             System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }

    }
}

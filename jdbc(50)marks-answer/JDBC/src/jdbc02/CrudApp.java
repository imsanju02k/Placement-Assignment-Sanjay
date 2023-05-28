package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudApp {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "087407";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");

            Scanner scanner = new Scanner(System.in);
            int choice = -1;

            while (choice != 0) {
                System.out.println("\nCRUD Application Menu");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addRecord(connection, scanner);
                        break;
                    case 2:
                        viewRecords(connection);
                        break;
                    case 3:
                        updateRecord(connection, scanner);
                        break;
                    case 4:
                        deleteRecord(connection, scanner);
                        break;
                    case 0:
                        System.out.println("Exiting the application");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;
                }
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database");
            e.printStackTrace();
        }
    }

    private static void addRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("\nAdd Record");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String insertQuery = "INSERT INTO crud (name, age) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Record added successfully");
        } else {
            System.out.println("Failed to add record");
        }
    }

    private static void viewRecords(Connection connection) throws SQLException {
        System.out.println("\nView Records");

        String selectQuery = "SELECT * FROM crud";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        resultSet.close();
        statement.close();
    }

    private static void updateRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("\nUpdate Record");
        System.out.print("Enter ID of the record to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        String updateQuery = "UPDATE crud SET name = ?, age = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, id);
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Record updated successfully");
        } else {
            System.out.println("Failed to update record");
        }
    }

    private static void deleteRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("\nDelete Record");
        System.out.print("Enter ID of the record to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String deleteQuery = "DELETE FROM crud WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id);
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("Failed to delete record");
        }
    }
    }



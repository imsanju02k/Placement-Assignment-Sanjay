package postgres01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
	
    public static void main(String[] args) {
        String filePath = "D:\\input_data.txt"; // Path to the input data file

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");

            // Create the batch update statement
            String insertQuery = "INSERT INTO student (name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());

                // Add parameters to the batch
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.addBatch();
            }

            // Execute the batch update
            int[] batchResult = preparedStatement.executeBatch();

            // Process the batch update results
            int totalRowsAffected = 0;
            for (int i : batchResult) {
                totalRowsAffected += i;
            }

            System.out.println("Batch update executed successfully. Total rows affected: " + totalRowsAffected);

            preparedStatement.close();
            connection.close();
            reader.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error occurred while reading the input file");
            e.printStackTrace();
        }
    }
}



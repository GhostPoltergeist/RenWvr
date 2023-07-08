package databaseRenWvr;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Encryption.Execute.ExecuteEncryption.encryptionData;
import static Encryption.Execute.ExecuteEncryption.getEncryptedData;
import static programmable.GuiVersion.EncryptionWindow.plainText;

public class DatabaseManager {
    private static final String DB_FILE_PATH = "database/RenWvr.db";
    private static final String TABLE_NAME = "RENWVR";

    private static String InputData = plainText;

    public static void load() {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the existing database
            Connection connection = getConnection();

            // Insert the data
            insertData(connection, InputData);

            printTableData(connection);

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        // Load the RenWvr.db file from the resources folder
        ClassLoader classLoader = DatabaseManager.class.getClassLoader();
        File dbFile = new File(classLoader.getResource(DB_FILE_PATH).getFile());

        // Connect to the existing database
        String jdbcUrl = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        return DriverManager.getConnection(jdbcUrl);
    }

    private static void insertData(Connection connection, String inputData) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (InputedData) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, inputData);

            statement.executeUpdate();

        // Close the statement
        statement.close();
    }
    private static void printTableData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print data rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        }
    }
}
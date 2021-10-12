
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class db {

    static Connection con = null;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "";
    static final String DB_NAME = "LibraryManagementSystem";
    static final String DB_URL = "jdbc:mysql://localhost/";

    public static Connection getConnection() {
        try {
            int db_exist = 0;
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            Statement s = conn.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            conn.close();
            con = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
            return con;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static void createTable(){
        String usersSql = "CREATE TABLE IF NOT EXISTS `librarymanagementsystem`.`users` ("
                + " `userid` INT NOT NULL AUTO_INCREMENT ,"
                + " `user_type` VARCHAR(20) NOT NULL DEFAULT 'Student' ,"
                + " `first_name` VARCHAR(50) NOT NULL ,"
                + " `middle_name` VARCHAR(50) NOT NULL ,"
                + " `last_name` VARCHAR(50) NOT NULL ,"
                + " `email_address` VARCHAR(50) NOT NULL ,"
                + " `phone_number` VARCHAR(15) NOT NULL ,"
                + " `username` VARCHAR(50) NOT NULL ,"
                + " `password` VARCHAR(50) NOT NULL ,"
                + " `sex` VARCHAR(6) NOT NULL ,"
                + " `age` INT NOT NULL ,"
                + " `birthday` DATE NOT NULL ,"
                + " `address` VARCHAR(100) NOT NULL ,"
                + " `Status` VARCHAR(11) NOT NULL DEFAULT 'ACTIVATED' ,"
                + " PRIMARY KEY (`userid`)) ENGINE = InnoDB;";
        
        String booksSql = "CREATE TABLE  IF NOT EXISTS `librarymanagementsystem`.`books` ("
                + " `BookID` INT NOT NULL AUTO_INCREMENT ,"
                + " `Category` VARCHAR(200) NOT NULL ,"
                + " `Book_Title` VARCHAR(200) NOT NULL ,"
                + " `Author` VARCHAR(100) NOT NULL ,"
                + " `Availability` VARCHAR(30) NOT NULL DEFAULT 'Available' ,"
                + " PRIMARY KEY (`BookID`)) ENGINE = InnoDB;";

        try {
            con = getConnection();
            Statement s = con.createStatement();
            s.executeUpdate(usersSql);
            s.executeUpdate(booksSql);
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

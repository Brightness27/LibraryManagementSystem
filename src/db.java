
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

        String transactionSql = "CREATE TABLE IF NOT EXISTS `bookprocessing` (\n"
                + "  `Transaction_No.` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `userid` int(11) NOT NULL,\n"
                + "  `BookID` int(11) NOT NULL,\n"
                + "  `Date_Borrowed` varchar(20) NOT NULL DEFAULT '--',\n"
                + "  `Date_Returned` varchar(20) NOT NULL DEFAULT '--',\n"
                + "  `Status` varchar(10) NOT NULL,\n"
                + "  PRIMARY KEY (`Transaction_No.`),\n"
                + "  KEY `BookID` (`BookID`) USING BTREE,\n"
                + "  KEY `userid` (`userid`),\n"
                + "  CONSTRAINT `bookprocessing_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`) ,\n"
                + "  CONSTRAINT `bookprocessing_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)\n"
                + ") ENGINE=InnoDB ";

        String notificationSql = "CREATE TABLE IF NOT EXISTS `notifications` (\n"
                + "  `NotificationID` int NOT NULL AUTO_INCREMENT,\n"
                + "  `userid` int NOT NULL,\n"
                + "  `Message` varchar(500) NOT NULL,\n"
                + "  `Date` date NOT NULL,\n"
                + "  `Status` varchar(6) NOT NULL DEFAULT 'UNREAD',\n"
                + "  PRIMARY KEY (`NotificationID`),\n"
                + "  KEY `userid` (`userid`),\n"
                + "  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)\n"
                + ") ENGINE=InnoDB";

        try {
            con = getConnection();
            Statement s = con.createStatement();
            s.executeUpdate(usersSql);
            s.executeUpdate(booksSql);
            s.executeUpdate(transactionSql);
            s.executeUpdate(notificationSql);
            
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
//    public static void showQueries(){
//        String showQuery = "SHOW CREATE TABLE notifications";
//        try {
//            con = getConnection();
//            Statement s = con.createStatement();
//            ResultSet rs = s.executeQuery(showQuery);
//            rs.next();
//            
//            System.out.println(rs.getString("Create Table"));
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SqlQueries {

    Connection con = db.getConnection();
    Statement s;
    ResultSet rs;
    PreparedStatement pst;

    String sql;

    public String[] signIn(String username, String password) {
        String user[] = new String[4];
        try {
            //con = db.getConnection();
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
            if (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    user[0] = rs.getString("userid");
                    user[1] = rs.getString("first_name");
                    user[2] = rs.getString("last_name");
                    if (rs.getString("user_type").equals("Student")) {
                        user[3] = "Student";
                    } else {
                        user[3] = "Administrator";
                    }
                } else {
                    user = null;
                }
            } else {
                user = null;
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public int register(String register[]) {
        String checkUser = "SELECT * FROM users WHERE username = '" + register[6] + "'";
        sql = "INSERT INTO `users` (`user_type`,"
                + " `first_name`, `middle_name`, `last_name`,"
                + " `email_address`, `phone_number`, `username`, `password`,"
                + " `sex`, `birthday`, `address`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int successFailed = 0;
        try {
            s = con.createStatement();
            rs = s.executeQuery(checkUser);
            if (rs.next()) {
                successFailed = 1;
            } else {

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, register[0]);
                pst.setString(2, register[1]);
                pst.setString(3, register[2]);
                pst.setString(4, register[3]);
                pst.setString(5, register[4]);
                pst.setString(6, register[5]);
                pst.setString(7, register[6]);
                pst.setString(8, register[7]);
                pst.setString(9, register[8]);
                pst.setString(10, register[9]);
                pst.setString(11, register[10]);
                pst.executeUpdate();
            }
            rs.close();
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
            successFailed = 2;
        }
        return successFailed;
    }
    
    public String[] getUser(int id){
        String user[] = new String[11];
        sql = "SELECT * FROM users WHERE userid = " + id;
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);
            rs.next();
            
            user[0] = rs.getString("user_type");
            user[1] = rs.getString("first_name");
            user[2] = rs.getString("middle_name");
            user[3] = rs.getString("last_name");
            user[4] = rs.getString("address");
            user[5] = rs.getString("username");
            user[6] = rs.getString("password");
            user[7] = rs.getString("phone_number");
            user[8] = rs.getString("sex");
            user[9] = rs.getString("email_address");
            user[10] = rs.getString("birthday");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }

    public String[][] showMembers(int id) {
        sql = "SELECT * FROM users WHERE userid NOT IN (" + id + ")";
        String members[][] = new String[0][5];

        try {
            //con = db.getConnection();
            pst = con.prepareStatement("SELECT COUNT(userid) FROM users");
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            members = new String[rows - 1][5];

            rs.close();
            pst.close();

            s = con.createStatement();
            rs = s.executeQuery(sql);

            for (int i = 0; rs.next(); i++) {
                members[i][0] = rs.getString("userid");
                members[i][1] = rs.getString("first_name");
                members[i][2] = rs.getString("last_name");
                members[i][3] = rs.getString("user_type");
                members[i][4] = rs.getString("status");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return members;
    }

    public String[][] showBooks() {
        sql = "SELECT * FROM books";
        String books[][] = new String[0][5];

        try {
            //con = db.getConnection();
            pst = con.prepareStatement("SELECT COUNT(bookID) FROM books");
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            books = new String[rows][5];

            rs.close();
            pst.close();

            s = con.createStatement();
            rs = s.executeQuery(sql);

            for (int i = 0; rs.next(); i++) {
                books[i][0] = rs.getString("BookID");
                books[i][1] = rs.getString("Category");
                books[i][2] = rs.getString("Book_Title");
                books[i][3] = rs.getString("Author");
                books[i][4] = rs.getString("Availability");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public String[][] showBookTransactions(int id) {
        sql = "SELECT `bp`.`Transaction_No.`, `b`.`book_Title`, `b`.`Author`, `bp`.`Date_Borrowed`, `bp`.`Date_Returned`, `bp`.`Status` "
                + "FROM `bookprocessing` `bp` INNER JOIN `books` `b` ON `bp`.`BookID` = `b`.`BookID` WHERE `bp`.`userid` = " + id;
        String books[][] = new String[0][6];

        try {
            //con = db.getConnection();
            pst = con.prepareStatement("SELECT COUNT(`Transaction_No.`) FROM bookprocessing WHERE userid = " + id);
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            books = new String[rows][6];

            rs.close();
            pst.close();

            s = con.createStatement();
            rs = s.executeQuery(sql);

            for (int i = 0; rs.next(); i++) {
                books[i][0] = rs.getString("Transaction_No.");
                books[i][1] = rs.getString("Book_Title");
                books[i][2] = rs.getString("Author");
                books[i][3] = rs.getString("Date_Borrowed");
                books[i][4] = rs.getString("Date_Returned");
                books[i][5] = rs.getString("Status");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public String[][] showBookRequests() {
        sql = "SELECT `bp`.`Transaction_No.`, `b`.`Book_Title`, `b`.`Author`, `u`.`last_name`, `u`.`first_name`, `bp`.`Date_Borrowed`, `bp`.`Date_Returned`, `bp`.`Status`"
                + " FROM `bookprocessing` `bp` "
                + "INNER JOIN `books` `b` ON `bp`.`bookID` = `b`.`bookID`"
                + "INNER JOIN `users` `u` ON `bp`.`userid` = `u`.`userid` ORDER BY `bp`.`Transaction_No.`";

        String books[][] = new String[0][7];

        try {
            //con = db.getConnection();
            pst = con.prepareStatement("SELECT COUNT(`Transaction_No.`) FROM bookprocessing");
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            books = new String[rows][7];

            rs.close();
            pst.close();

            s = con.createStatement();
            rs = s.executeQuery(sql);

            for (int i = 0; rs.next(); i++) {
                books[i][0] = rs.getString("Transaction_No.");
                books[i][1] = rs.getString("last_name") + ", " + rs.getString("first_name");
                books[i][2] = rs.getString("Book_Title");
                books[i][3] = rs.getString("Author");
                books[i][4] = rs.getString("Date_Borrowed");
                books[i][5] = rs.getString("Date_Returned");
                books[i][6] = rs.getString("Status");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public void registerBook(String[] book) {
        String checkBook = "SELECT * FROM books WHERE Book_Title = '" + book[2] + "' and Author = '" + book[3] + "'";
        sql = "INSERT INTO books(`BookID`, `Category`, `Book_Title`, `Author`) VALUES (?, ?, ?, ?)";
        try {
            //con = db.getConnection();
            s = con.createStatement();
            rs = s.executeQuery(checkBook);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Book already registered", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, book[0]);
                pst.setString(2, book[1]);
                pst.setString(3, book[2]);
                pst.setString(4, book[3]);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Book has been successfully registered", "success", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkBook(String[] book, int id) {
        String result = "";
        sql = "SELECT * FROM books WHERE BookID = '" + book[0] + "'";

        try {
            //con = db.getConnection();
            s = con.createStatement();
            rs = s.executeQuery(sql);
            if (rs.next()) {
                if (book[1].equals(rs.getString("Book_Title")) && book[2].equals(rs.getString("Author"))) {
                    result = rs.getString("Availability");
                    if (result.equals("BORROWED")) {
                        return result;
                    } else {
                        rs = s.executeQuery("SELECT * FROM Bookprocessing WHERE BookID = '" + book[0] + "' AND userid = " + id + " AND Status = 'PENDING'");

                        if (rs.next()) {
                            result = "PENDING";
                        } else {
                            return result;
                        }
                    }
                } else {
                    result = "not found";
                }
            } else {
                result = "not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void requestBook(String bookID, int id) {
        sql = "INSERT INTO bookprocessing (`userid`,`BookID`, `Status`) VALUES (?, ?, 'PENDING')";
        try {
            //con = db.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, bookID);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book requested. Wait for the confirmation of the admin if you are able to borrow the book.", "Success", JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookRequest(String request, String transactionID, String date) {
        sql = "UPDATE bookprocessing bp INNER JOIN books b ON bp.bookID = b.bookID SET bp.Status = 'BORROWED', bp.Date_Borrowed = '" + date + "', b.Availability = 'BORROWED' WHERE `Transaction_No.` = " + transactionID;
        String requestDenied = "UPDATE bookprocessing SET Status = '" + request + "' WHERE `Transaction_No.` = " + transactionID;
        //String notification = "INSERT INTO notifications ("
        try {
            if (request.equals("APPROVED")) {
                pst = con.prepareStatement(sql);

            } else {
                pst = con.prepareStatement(requestDenied);
            }
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBookID(String transactionID) {
        sql = "SELECT BookID FROM bookprocessing WHERE `transaction_No.` = " + transactionID;
        String id = "";
        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);
            rs.next();
            id = rs.getString("BookID");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
    
    public String getTransactID(String bookID,int id, String status){
        
        sql = "SELECT `transaction_No.` FROM bookprocessing WHERE userid = " + id + " AND BookID = " + bookID + " AND Status = '" + status + "'";
        String transactID = "";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);
            rs.next();
            transactID = rs.getString("Transaction_No.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactID;
    }

    public void returnBook(String date, String transactID){
        sql = "UPDATE bookprocessing bp INNER JOIN books b ON bp.bookID = b.bookID"
                + " SET bp.Status = 'RETURNED', bp.Date_Returned = '" + date + "', b.Availability = 'AVAILABLE' WHERE bp.`Transaction_No.` = " + transactID;
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancelRequest(String transactID){
        sql = "UPDATE bookprocessing SET Status = 'CANCELLED' WHERE `Transaction_No.` = " + transactID;
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String[][] getNotifications(int id){
        sql = "SELECT * FROM notifications WHERE userid = " + id + " ORDER BY Date DESC";
        String count = "SELECT COUNT(`notificationID`) FROM notifications WHERE userid = " + id;
        String results[][] = null;
        
        try {
            pst = con.prepareStatement(count);
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            results = new String[rows][4];
            
            rs.close();
            pst.close();
            
            s = con.createStatement();
            rs = s.executeQuery(sql);
            
            for (int i = 0; rs.next(); i++) {
                results[i][0] = rs.getString("notificationID");
                results[i][1] = rs.getString("Message");
                results[i][2] = rs.getString("Date");
                results[i][3] = rs.getString("Status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return results;
    }
    
    public void readNotif(int id){
        sql = "UPDATE notifications SET Status = 'READ' WHERE notificationID = " + id;
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getStatus(int id){
        String sql = "SELECT status FROM notifications WHERE notificationID = " + id;
        String status = "";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);
            rs.next();
            
            status = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public String[][] getMessages(int id){
        sql = "SELECT * FROM messages WHERE userid = " + id + " OR receiverID = " + id;
        String count = "SELECT COUNT(`messageID`) FROM messages WHERE userid = " + id + " OR receiverID = " + id;
        String results[][] = null;
        
        try {
            pst = con.prepareStatement(count);
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            results = new String[rows][6];
            
            rs.close();
            pst.close();
            
            s = con.createStatement();
            rs = s.executeQuery(sql);
            
            for (int i = 0; rs.next(); i++) {
                results[i][0] = rs.getString("messageID");
                results[i][1] = rs.getString("userID");
                results[i][2] = rs.getString("ReceiverID");
                results[i][3] = rs.getString("Message");
                results[i][4] = rs.getString("Date");
                results[i][5] = rs.getString("Status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return results;
    }
}

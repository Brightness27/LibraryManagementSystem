
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
        String user[] = new String[5];
        try {
            //con = db.getConnection();
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
            if (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    user[0] = rs.getString("userid");
                    user[1] = rs.getString("first_name");
                    user[2] = rs.getString("last_name");
                    user[3] = rs.getString("user_type");
                    user[4] = rs.getString("Status");
                    
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
    
    public int updateUser(String register[], int userid) {
        String checkUser = "SELECT * FROM users WHERE username = '" + register[6] + "'";
        sql = "UPDATE users SET user_type = ?,"
                + " first_name = ?,"
                + " middle_name = ?,"
                + " last_name = ?,"
                + " email_address = ?,"
                + " phone_number = ?,"
                + "username = ?,"
                + "password = ?,"
                + " sex = ?,"
                + "birthday = ?"
                + "address = ?"
                + "WHERE userid = ?";
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
                pst.setInt(12, userid);
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
        String user[] = new String[12];
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
            user[11] = rs.getString("Status");
            
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
        sql = "SELECT * FROM books WHERE Availability  NOT IN ('REMOVED')";
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
    
    public String[][] filterTables(String table, String query, int id) {
            String books = "SELECT * FROM books WHERE "
                    + "book_Title LIKE  '%" + query + "%' OR Category LIKE '%" + query + "%' OR Author LIKE '%" + query + "%' OR Availability LIKE '%" + query + "%'";
            String members = "SELECT * FROM users WHERE "
                    + "userid NOT IN (" + id + ") AND"
                    + " (first_name LIKE '%" + query + "%' OR last_name LIKE '%" + query + "%' OR user_type LIKE '%" + query + "%' OR status LIKE '%" + query + "%')";
            
        String tables[][] = new String[0][5];

        try {
            if (table.equals("books")) {
                pst = con.prepareStatement("SELECT COUNT(bookID) FROM books WHERE"
                        + " book_Title LIKE  '%" + query + "%' OR Category LIKE '%" + query + "%' OR Author LIKE '%" + query + "%' OR Availability LIKE '%" + query + "%'");
                rs = pst.executeQuery();
                rs.next();
                int rows = rs.getInt(1);
                tables = new String[rows][5];
                rs.close();
                pst.close();
                s = con.createStatement();
                rs = s.executeQuery(books);
                for (int i = 0; rs.next(); i++) {
                    tables[i][0] = rs.getString("BookID");
                    tables[i][1] = rs.getString("Category");
                    tables[i][2] = rs.getString("Book_Title");
                    tables[i][3] = rs.getString("Author");
                    tables[i][4] = rs.getString("Availability");
                }
            }else if(table.equals("users")){
                pst = con.prepareStatement("SELECT COUNT(userid) FROM users WHERE "
                        + "userid NOT IN (" + id + ") AND"
                    + " (first_name LIKE '%" + query + "%' OR last_name LIKE '%" + query + "%' OR user_type LIKE '%" + query + "%' OR status LIKE '%" + query + "%')");
                rs = pst.executeQuery();
                rs.next();
                int rows = rs.getInt(1);
                tables = new String[rows][5];

                rs.close();
                pst.close();

                s = con.createStatement();
                rs = s.executeQuery(members);

                for (int i = 0; rs.next(); i++) {
                    tables[i][0] = rs.getString("userid");
                    tables[i][1] = rs.getString("first_name");
                    tables[i][2] = rs.getString("last_name");
                    tables[i][3] = rs.getString("user_type");
                    tables[i][4] = rs.getString("status");
                }
            }
            else{
                pst = con.prepareStatement("SELECT first_name, last_name FROM users WHERE userid = " + id);
                rs = pst.executeQuery();
                rs.next();
                String librarian = rs.getString("first_name") + " " + rs.getString("last_name");
                rs.close();
                pst.close();
              
                pst = con.prepareStatement("SELECT COUNT(t.`Transaction_No.`) FROM ("
                        + " SELECT * FROM transactions WHERE NOT (Status = 'BORROWED' AND Librarian = '" + librarian + "')) t"
                        + " INNER JOIN users u ON t.userid = u.userid"
                        + " INNER JOIN books b ON t.BookID = b.BookID"
                        + " WHERE (t.Status NOT IN('PENDING', 'CANCELLED')"
                        + " AND (t.Date_Borrowed LIKE '%" + query + "%' OR t.Date_Returned LIKE '%" + query + "%' OR t.Status LIKE '%" + query + "%'"
                        + " OR t.Librarian LIKE '%" + query + "%' OR CONCAT(u.first_name, ' ', u.last_name) LIKE '%" + query + "%'"
                        + " OR b.book_Title LIKE '%" + query + "%' OR b.Author LIKE '%" + query + "%'))");
                rs = pst.executeQuery();
                rs.next();
                int rows = rs.getInt(1);
                tables = new String[rows][8];

                rs.close();
                pst.close();
                String transactions = "SELECT t.`Transaction_No.`, CONCAT(u.first_name, ' ', u.last_name) as `Borrower`, b.book_Title,"
                        + "b.Author, t.Date_Borrowed, t.Date_Returned, t.Status, t.Librarian FROM ("
                        + " SELECT * FROM transactions WHERE NOT (Status = 'BORROWED' AND Librarian = '" + librarian + "')) t"
                        + " INNER JOIN users u ON t.userid = u.userid"
                        + " INNER JOIN books b ON t.BookID = b.BookID"
                        + " WHERE (t.Status NOT IN('PENDING', 'CANCELLED')"
                        + " AND (t.Date_Borrowed LIKE '%" + query + "%' OR t.Date_Returned LIKE '%" + query + "%' OR t.Status LIKE '%" + query + "%'"
                        + " OR t.Librarian LIKE '%" + query + "%' OR CONCAT(u.first_name, ' ', u.last_name) LIKE '%" + query + "%'"
                        + " OR b.book_Title LIKE '%" + query + "%' OR b.Author LIKE '%" + query + "%')) ORDER BY t.`Transaction_No.` DESC";
                
                s = con.createStatement();
                rs = s.executeQuery(transactions);

                for (int i = 0; rs.next(); i++) {
                    tables[i][0] = rs.getString("Transaction_No.");
                    tables[i][1] = rs.getString("Borrower");
                    tables[i][2] = rs.getString("book_Title");
                    tables[i][3] = rs.getString("Author");
                    tables[i][4] = rs.getString("Date_Borrowed");
                    tables[i][5] = rs.getString("Date_Returned");
                    tables[i][6] = rs.getString("Status");
                    tables[i][7] = rs.getString("Librarian");

                }
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tables;
    }

    public String[][] showBookTransactions(int id) {
        sql = "SELECT `t`.`Transaction_No.`, `b`.`book_Title`, `b`.`Author`, `t`.`Date_Borrowed`, `t`.`Date_Returned`, `t`.`Status`, `t`.`Librarian` "
                + "FROM `transactions` `t` INNER JOIN `books` `b` ON `t`.`BookID` = `b`.`BookID` WHERE `t`.`userid` = " + id + " ORDER BY `Transaction_No.` DESC";
        String books[][] = new String[0][7];

        try {
            pst = con.prepareStatement("SELECT COUNT(`Transaction_No.`) FROM transactions WHERE userid = " + id);
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
                books[i][1] = rs.getString("Book_Title");
                books[i][2] = rs.getString("Author");
                books[i][3] = rs.getString("Date_Borrowed");
                books[i][4] = rs.getString("Date_Returned");
                books[i][5] = rs.getString("Status");
                books[i][6] = rs.getString("Librarian");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public String[][] showBookRequests(String librarian) {
        sql = "SELECT `bp`.`Transaction_No.`, `b`.`Book_Title`, `b`.`Author`, `u`.`last_name`, `u`.`first_name`, `bp`.`Date_Borrowed`, `bp`.`Date_Returned`, `bp`.`Status`, `bp`.`Librarian`"
                + " FROM `transactions` `bp` "
                + "INNER JOIN `books` `b` ON `bp`.`bookID` = `b`.`bookID`"
                + "INNER JOIN `users` `u` ON `bp`.`userid` = `u`.`userid`"
                + " ORDER BY `bp`.`Transaction_No.` DESC";

        String books[][] = new String[0][8];

        try {
            //con = db.getConnection();
            pst = con.prepareStatement("SELECT COUNT(`Transaction_No.`) FROM transactions");
            rs = pst.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            books = new String[rows][8];

            rs.close();
            pst.close();

            s = con.createStatement();
            rs = s.executeQuery(sql);

            for (int i = 0; rs.next(); i++) {
                books[i][0] = rs.getString("Transaction_No.");
                books[i][1] = rs.getString("first_name") + " " + rs.getString("last_name");
                books[i][2] = rs.getString("Book_Title");
                books[i][3] = rs.getString("Author");
                books[i][4] = rs.getString("Date_Borrowed");
                books[i][5] = rs.getString("Date_Returned");
                books[i][6] = rs.getString("Status");
               books[i][7] = rs.getString("Librarian");
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
                        rs = s.executeQuery("SELECT * FROM transactions WHERE BookID = '" + book[0] + "' AND userid = " + id + " AND Status = 'PENDING'");

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
        sql = "INSERT INTO transactions (`userid`,`BookID`, `Status`) VALUES (?, ?, 'PENDING')";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, bookID);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book requested. Wait for the confirmation of the admin if you are able to borrow the book.", "Success", JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookRequest(String request, String transactionID, String date, String librarian) {
        String requestApproved = "UPDATE transactions bp INNER JOIN books b ON bp.bookID = b.bookID SET bp.Status = 'BORROWED',"
                + " bp.Date_Borrowed = '" + date + "', b.Availability = 'BORROWED', bp.Librarian = '" + librarian + "' WHERE `Transaction_No.` = " + transactionID;
        
        String requestDenied = "UPDATE transactions SET Status = '" + request + "', Librarian = '" + librarian + "' WHERE `Transaction_No.` = " + transactionID;
        try {
            if (request.equals("APPROVED")) {
                sql = requestApproved;

            } else {
                sql = requestDenied;
            }
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBookID(String transactionID) {
        sql = "SELECT BookID FROM transactions WHERE `transaction_No.` = " + transactionID;
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
        
        sql = "SELECT `transaction_No.` FROM transactions WHERE userid = " + id + " AND BookID = " + bookID + " AND Status = '" + status + "'";
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
        sql = "UPDATE transactions bp INNER JOIN books b ON bp.bookID = b.bookID"
                + " SET bp.Status = 'RETURNED', bp.Date_Returned = '" + date + "', b.Availability = 'AVAILABLE' WHERE bp.`Transaction_No.` = " + transactID;
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancelRequest(String transactID){
        sql = "UPDATE transactions SET Status = 'CANCELLED' WHERE `Transaction_No.` = " + transactID;
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int changeStatusMember(int id, String status){
        status = status.toUpperCase() + "D";
        sql = "UPDATE users SET status = '" + status + "' WHERE userid = " + id;
        int stat = 0;
        
        try {
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            stat = 1;
        }
        
        return stat;
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

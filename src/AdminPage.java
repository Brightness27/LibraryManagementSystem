
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        initComponents();
    }
    
    String fname;
    String lname;
    int id;
    Calendar cal;
    SqlQueries queries = new SqlQueries();
    String date;
    PersonalInfoPanel pnlInfo;
    
    AdminPage(int id, String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        initComponents();
        hidePanels();
        changeIcon();
        showMembers();
        showBooks();
        setTableColumnSize();
        showBookTransactions();
        setCurrentDate();
    }
    
    public void changeIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Frame-Logo.png")));
        pnlBookList.setVisible(true);
        lblWelcome.setText("Welcome, " + fname);
    }
    
    private void hidePanels(){
        pnlBookList.setVisible(false);
        pnlBookRequests.setVisible(false);
        pnlBorrowHistory.setVisible(false);
        pnlMembers.setVisible(false);
        pnlRegisterBook.setVisible(false);
        if(pnlInfo != null)
            pnlInfo.setVisible(false);
    }
    
    private void showMembers(){
        String members[][] = queries.showMembers(id);
        DefaultTableModel model = (DefaultTableModel) tblMembers.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < members.length; i++){
            model.addRow(members[i]);
        }
    }
    
    private void showBooks(){
        String books[][] = queries.showBooks();
        DefaultTableModel model = (DefaultTableModel) tblBookList.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < books.length; i++){
            model.addRow(books[i]);
        }
    }
    
    private void showBookTransactions(){
        String books[][] = queries.showBookRequests();
        DefaultTableModel bookRequestModel = (DefaultTableModel) tblBookRequests.getModel();
        DefaultTableModel bookHistoryModel = (DefaultTableModel) tblBorrowedHistory.getModel();
        bookRequestModel.setRowCount(0);
        bookHistoryModel.setRowCount(0);
        
        for (int i = 0; i < books.length; i++){
          
            if(books[i][6].equals("RETURNED") || books[i][6].equals("DENIED") || books[i][6].equals("CANCELLED")){
                String borrowHistoryRow[] = {books[i][0], books[i][1], books[i][2], books[i][3], books[i][4], books[i][5], books[i][6]};
                bookHistoryModel.addRow(borrowHistoryRow);
            }
            else{
                String borrowRequest[] = {books[i][0], books[i][1], books[i][2], books[i][3], books[i][4], books[i][6]};
                bookRequestModel.addRow(borrowRequest);
            }
           
        }
    }
    
    private void setCurrentDate(){
        cal = new GregorianCalendar();
        String year = cal.get(Calendar.YEAR)+ "";
        String month = (cal.get(Calendar.MONTH) + 1) + "";
        String day = cal.get(Calendar.DAY_OF_MONTH) + "";
        date = year + "-" + month + "-" + day;
    }
    
    private void setTableColumnSize(){
        TableColumnModel cmTblBookList = tblBookList.getColumnModel();
        cmTblBookList.getColumn(0).setPreferredWidth(10);
        cmTblBookList.getColumn(1).setPreferredWidth(100);
        cmTblBookList.getColumn(2).setPreferredWidth(242);
        cmTblBookList.getColumn(3).setPreferredWidth(50);
        cmTblBookList.getColumn(4).setPreferredWidth(50);
        
        TableColumnModel cmTblBookRequests = tblBookRequests.getColumnModel();
        cmTblBookRequests.getColumn(0).setPreferredWidth(50);
        cmTblBookRequests.getColumn(1).setPreferredWidth(75);
        cmTblBookRequests.getColumn(2).setPreferredWidth(177);
        cmTblBookRequests.getColumn(3).setPreferredWidth(65);
        cmTblBookRequests.getColumn(4).setPreferredWidth(50);
        cmTblBookRequests.getColumn(5).setPreferredWidth(35);
        
        TableColumnModel cmTblBorrowedHistory = tblBorrowedHistory.getColumnModel();
        cmTblBorrowedHistory.getColumn(0).setPreferredWidth(30);
        cmTblBorrowedHistory.getColumn(1).setPreferredWidth(75);
        cmTblBorrowedHistory.getColumn(2).setPreferredWidth(187);
        cmTblBorrowedHistory.getColumn(3).setPreferredWidth(60);
        cmTblBorrowedHistory.getColumn(4).setPreferredWidth(50);
        cmTblBorrowedHistory.getColumn(5).setPreferredWidth(50);
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBookRequests = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnApprove = new javax.swing.JLabel();
        pnlApprove = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBorrower = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnDecline = new javax.swing.JLabel();
        pnlDecline = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookRequests = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        pnlMembers = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtsearchMember = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMembers = new javax.swing.JTable();
        pnlBorrowHistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBorrowedHistory = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        pnlRegisterBook = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtRegBookID = new javax.swing.JTextField();
        txtRegCategory = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRegBookTitle = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnRegisterBook = new javax.swing.JLabel();
        pnlRegBook = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtRegAuthor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        pnlLogout = new javax.swing.JLabel();
        lblNotifiactions = new javax.swing.JLabel();
        lblMessages = new javax.swing.JLabel();
        lblPersonalinfo = new javax.swing.JLabel();
        pnlNotification = new javax.swing.JLabel();
        pnlMessages = new javax.swing.JLabel();
        pnlPersonalInfo = new javax.swing.JLabel();
        pnlBookList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookList = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchtblBookList = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblBorrowHistory = new javax.swing.JLabel();
        lblBookList = new javax.swing.JLabel();
        lblBookRequests = new javax.swing.JLabel();
        pnlBorrowhistory = new javax.swing.JLabel();
        pnlBooklist = new javax.swing.JLabel();
        pnlBookrequests = new javax.swing.JLabel();
        lblRegisterBook = new javax.swing.JLabel();
        pnlRegisterbook = new javax.swing.JLabel();
        lblMembers = new javax.swing.JLabel();
        pnlmembers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(138, 102, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBookRequests.setBackground(new java.awt.Color(226, 200, 171));
        pnlBookRequests.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBookRequests.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(226, 200, 171));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(" Book Request");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        txtBookTitle.setEditable(false);
        txtBookTitle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBookTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBookTitle.setBorder(null);
        jPanel4.add(txtBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 190, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Book Title");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 320, 40));

        txtAuthor.setEditable(false);
        txtAuthor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtAuthor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAuthor.setBorder(null);
        jPanel4.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 190, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Author");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 225, 55));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 225, 55));

        btnApprove.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnApprove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnApprove.setText("Approve");
        btnApprove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApproveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnApproveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnApproveMouseExited(evt);
            }
        });
        jPanel4.add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 155, 55));

        pnlApprove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/approve button.png"))); // NOI18N
        jPanel4.add(pnlApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 155, 55));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Borrower");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 40));

        txtBorrower.setEditable(false);
        txtBorrower.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBorrower.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBorrower.setBorder(null);
        jPanel4.add(txtBorrower, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 190, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel13.setText("jLabel1");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 225, 55));

        btnDecline.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDecline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDecline.setText("Decline");
        btnDecline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDecline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeclineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeclineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeclineMouseExited(evt);
            }
        });
        jPanel4.add(btnDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 155, 55));

        pnlDecline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/decline-button.png"))); // NOI18N
        pnlDecline.setText("jLabel10");
        jPanel4.add(pnlDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 155, 55));

        pnlBookRequests.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 540));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBookRequests.setBackground(new java.awt.Color(226, 200, 171));
        tblBookRequests.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblBookRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "transaction No.", "Borrower", "Book Title", "Author", "Date Borrowed", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookRequests.setRowHeight(30);
        tblBookRequests.setSelectionBackground(new java.awt.Color(247, 234, 212));
        tblBookRequests.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblBookRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookRequestsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBookRequests);

        pnlBookRequests.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 750, 460));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PENDING BOOK REQUESTS");
        pnlBookRequests.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 740, 60));

        jPanel1.add(pnlBookRequests, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        pnlMembers.setBackground(new java.awt.Color(226, 200, 171));
        pnlMembers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlMembers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Search: ");
        pnlMembers.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 40));

        txtsearchMember.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnlMembers.add(txtsearchMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 330, 40));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblMembers.setBackground(new java.awt.Color(226, 200, 171));
        tblMembers.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "User Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMembers.setRowHeight(30);
        tblMembers.setSelectionBackground(new java.awt.Color(247, 234, 212));
        tblMembers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMembersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMembers);

        pnlMembers.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1080, 460));

        jPanel1.add(pnlMembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        pnlBorrowHistory.setBackground(new java.awt.Color(226, 200, 171));
        pnlBorrowHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBorrowHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBorrowedHistory.setBackground(new java.awt.Color(226, 200, 171));
        tblBorrowedHistory.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblBorrowedHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction No.", "Borrower", "Book Title", "Author", "Date Borrowed", "Date Returned", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBorrowedHistory.setRowHeight(30);
        tblBorrowedHistory.setSelectionBackground(new java.awt.Color(247, 234, 212));
        tblBorrowedHistory.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tblBorrowedHistory);

        pnlBorrowHistory.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 94, 1100, 450));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TRANSACTION HISTORY");
        pnlBorrowHistory.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1090, 60));

        jPanel1.add(pnlBorrowHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        pnlRegisterBook.setBackground(new java.awt.Color(226, 200, 171));
        pnlRegisterBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlRegisterBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Register Book");
        pnlRegisterBook.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Book ID");
        pnlRegisterBook.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 320, 40));

        txtRegBookID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtRegBookID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegBookID.setBorder(null);
        pnlRegisterBook.add(txtRegBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, 30));

        txtRegCategory.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtRegCategory.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegCategory.setBorder(null);
        pnlRegisterBook.add(txtRegCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 190, 30));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Category");
        pnlRegisterBook.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 320, 40));

        txtRegBookTitle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtRegBookTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegBookTitle.setBorder(null);
        pnlRegisterBook.add(txtRegBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 190, 30));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Book Title");
        pnlRegisterBook.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel18.setText("jLabel1");
        pnlRegisterBook.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 290, 225, 55));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel19.setText("jLabel1");
        pnlRegisterBook.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 110, 225, 55));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel20.setText("jLabel1");
        pnlRegisterBook.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 200, 225, 55));

        btnRegisterBook.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegisterBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegisterBook.setText("Register Book");
        btnRegisterBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisterBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterBookMouseExited(evt);
            }
        });
        pnlRegisterBook.add(btnRegisterBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 185, 55));

        pnlRegBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button.PNG"))); // NOI18N
        pnlRegBook.setText("jLabel10");
        pnlRegisterBook.add(pnlRegBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 185, 55));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Author");
        pnlRegisterBook.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 320, 40));

        txtRegAuthor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtRegAuthor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegAuthor.setBorder(null);
        pnlRegisterBook.add(txtRegAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 190, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel22.setText("jLabel1");
        pnlRegisterBook.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 380, 225, 55));

        jPanel1.add(pnlRegisterBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 340, 560));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-Logo.png"))); // NOI18N
        logo.setText("LOGO");
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        lblWelcome.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Welcome");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 430, 40));

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout1.png"))); // NOI18N
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });
        jPanel1.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 30, 50, 50));

        pnlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png"))); // NOI18N
        jPanel1.add(pnlLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, -1, -1));

        lblNotifiactions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNotifiactions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotifiactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/notification1.png"))); // NOI18N
        lblNotifiactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNotifiactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNotifiactionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNotifiactionsMouseExited(evt);
            }
        });
        jPanel1.add(lblNotifiactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 50, 50));

        lblMessages.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMessages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/messages1.png"))); // NOI18N
        lblMessages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMessagesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMessagesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMessagesMouseExited(evt);
            }
        });
        jPanel1.add(lblMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 50, 50));

        lblPersonalinfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPersonalinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonalinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profile1.png"))); // NOI18N
        lblPersonalinfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPersonalinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPersonalinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPersonalinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPersonalinfoMouseExited(evt);
            }
        });
        jPanel1.add(lblPersonalinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 50, 50));

        pnlNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png"))); // NOI18N
        jPanel1.add(pnlNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, -1, -1));

        pnlMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png"))); // NOI18N
        jPanel1.add(pnlMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, -1));

        pnlPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png"))); // NOI18N
        jPanel1.add(pnlPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, -1));

        pnlBookList.setBackground(new java.awt.Color(226, 200, 171));
        pnlBookList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBookList.setFocusable(false);
        pnlBookList.setRequestFocusEnabled(false);
        pnlBookList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBookList.setBackground(new java.awt.Color(226, 200, 171));
        tblBookList.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Category", "Book Title", "Author", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookList.setRowHeight(30);
        tblBookList.setSelectionBackground(new java.awt.Color(247, 234, 212));
        tblBookList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblBookList.getTableHeader().setResizingAllowed(false);
        tblBookList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBookList);

        pnlBookList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1100, 470));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Search Book:");
        pnlBookList.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("(Book TItle/Author/Category)");
        pnlBookList.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 190, -1));

        txtSearchtblBookList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlBookList.add(txtSearchtblBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 430, 40));

        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        jPanel3.setBackground(new java.awt.Color(226, 200, 171));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBorrowHistory.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBorrowHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBorrowHistory.setText("Borrow History");
        lblBorrowHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBorrowHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrowHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBorrowHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBorrowHistoryMouseExited(evt);
            }
        });
        jPanel3.add(lblBorrowHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 140, 40));

        lblBookList.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBookList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBookList.setText("Book List");
        lblBookList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBookListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBookListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBookListMouseExited(evt);
            }
        });
        jPanel3.add(lblBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, 40));

        lblBookRequests.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBookRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBookRequests.setText("Book Requests");
        lblBookRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBookRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBookRequestsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBookRequestsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBookRequestsMouseExited(evt);
            }
        });
        jPanel3.add(lblBookRequests, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 40));

        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlBorrowhistory.setText("jLabel1");
        pnlBorrowhistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBorrowhistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBorrowhistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBorrowhistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBorrowhistoryMouseExited(evt);
            }
        });
        jPanel3.add(pnlBorrowhistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, 65));

        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlBooklist.setText("jLabel1");
        pnlBooklist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBooklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBooklistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBooklistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBooklistMouseExited(evt);
            }
        });
        jPanel3.add(pnlBooklist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 65));

        pnlBookrequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlBookrequests.setText("jLabel1");
        pnlBookrequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBookrequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBookrequestsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBookrequestsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBookrequestsMouseExited(evt);
            }
        });
        jPanel3.add(pnlBookrequests, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 65));

        lblRegisterBook.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegisterBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisterBook.setText("Register Book");
        lblRegisterBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegisterBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegisterBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegisterBookMouseExited(evt);
            }
        });
        jPanel3.add(lblRegisterBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 40));

        pnlRegisterbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlRegisterbook.setText("jLabel1");
        pnlRegisterbook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRegisterbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRegisterbookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRegisterbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRegisterbookMouseExited(evt);
            }
        });
        jPanel3.add(pnlRegisterbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 65));

        lblMembers.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMembers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMembers.setText("Members");
        lblMembers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMembersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMembersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMembersMouseExited(evt);
            }
        });
        jPanel3.add(lblMembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 40));

        pnlmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlmembers.setText("jLabel1");
        pnlmembers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlmembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlmembersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlmembersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlmembersMouseExited(evt);
            }
        });
        jPanel3.add(pnlmembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 65));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveMouseEntered
        pnlApprove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-approve button.png")));
        //btnApprove.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnApproveMouseEntered

    private void btnApproveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveMouseExited
        pnlApprove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/approve button.png")));
        btnApprove.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnApproveMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        int logout = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);

        if(logout == 0){
            new LogInForm().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        pnlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        pnlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblNotifiactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifiactionsMouseEntered
        pnlNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblNotifiactionsMouseEntered

    private void lblNotifiactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifiactionsMouseExited
        pnlNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblNotifiactionsMouseExited

    private void lblMessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseEntered
        pnlMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblMessagesMouseEntered

    private void lblMessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseExited
        pnlMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblMessagesMouseExited

    private void lblPersonalinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonalinfoMouseEntered
        pnlPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblPersonalinfoMouseEntered

    private void lblPersonalinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonalinfoMouseExited
        pnlPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblPersonalinfoMouseExited

    private void lblBorrowHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseClicked
        hidePanels();
        pnlBorrowHistory.setVisible(true);
    }//GEN-LAST:event_lblBorrowHistoryMouseClicked

    private void lblBorrowHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseEntered
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowHistoryMouseEntered

    private void lblBorrowHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseExited
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowHistoryMouseExited

    private void lblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseClicked
        hidePanels();
        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));
        pnlBookList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1100, 470));
        pnlBookList.setVisible(true);
    }//GEN-LAST:event_lblBookListMouseClicked

    private void lblBookListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseEntered
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBookListMouseEntered

    private void lblBookListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseExited
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBookListMouseExited

    private void lblBookRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookRequestsMouseClicked
        hidePanels();
        pnlBookRequests.setVisible(true);
    }//GEN-LAST:event_lblBookRequestsMouseClicked

    private void lblBookRequestsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookRequestsMouseEntered
        pnlBookrequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBookRequestsMouseEntered

    private void lblBookRequestsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookRequestsMouseExited
        pnlBookrequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBookRequestsMouseExited

    private void pnlBorrowhistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseClicked
        hidePanels();
        pnlBorrowHistory.setVisible(true);
    }//GEN-LAST:event_pnlBorrowhistoryMouseClicked

    private void pnlBorrowhistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseEntered
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowhistoryMouseEntered

    private void pnlBorrowhistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseExited
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowhistoryMouseExited

    private void pnlBooklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseClicked
        hidePanels();
        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));
        pnlBookList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1100, 470));
        pnlBookList.setVisible(true);
    }//GEN-LAST:event_pnlBooklistMouseClicked

    private void pnlBooklistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseEntered
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBooklistMouseEntered

    private void pnlBooklistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseExited
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBooklistMouseExited

    private void pnlBookrequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookrequestsMouseClicked
        hidePanels();
        pnlBookRequests.setVisible(true);
    }//GEN-LAST:event_pnlBookrequestsMouseClicked

    private void pnlBookrequestsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookrequestsMouseEntered
        pnlBookrequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBookrequestsMouseEntered

    private void pnlBookrequestsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookrequestsMouseExited
        pnlBookrequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBookrequestsMouseExited

    private void pnlRegisterbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegisterbookMouseClicked
        hidePanels();
        pnlBookList.setVisible(true);
        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 760, 560));
        pnlBookList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 740, 460));
        pnlRegisterBook.setVisible(true);
    }//GEN-LAST:event_pnlRegisterbookMouseClicked

    private void pnlRegisterbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegisterbookMouseEntered
        pnlRegisterbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlRegisterbookMouseEntered

    private void pnlRegisterbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegisterbookMouseExited
        pnlRegisterbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlRegisterbookMouseExited

    private void lblRegisterBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterBookMouseClicked
        hidePanels();
        pnlBookList.setVisible(true);
        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 760, 560));
        pnlBookList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 740, 460));
        pnlRegisterBook.setVisible(true);
    }//GEN-LAST:event_lblRegisterBookMouseClicked

    private void lblRegisterBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterBookMouseEntered
        pnlRegisterbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblRegisterBookMouseEntered

    private void lblRegisterBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterBookMouseExited
        pnlRegisterbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblRegisterBookMouseExited

    private void lblMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMembersMouseClicked
        hidePanels();
        pnlMembers.setVisible(true);
    }//GEN-LAST:event_lblMembersMouseClicked

    private void lblMembersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMembersMouseEntered
        pnlmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblMembersMouseEntered

    private void lblMembersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMembersMouseExited
        pnlmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblMembersMouseExited

    private void pnlmembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmembersMouseClicked
        hidePanels();
        pnlMembers.setVisible(true);
    }//GEN-LAST:event_pnlmembersMouseClicked

    private void pnlmembersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmembersMouseEntered
        pnlmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlmembersMouseEntered

    private void pnlmembersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmembersMouseExited
        pnlmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlmembersMouseExited

    private void btnDeclineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeclineMouseEntered
        pnlDecline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-decline-button.png")));
    }//GEN-LAST:event_btnDeclineMouseEntered

    private void btnDeclineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeclineMouseExited
        pnlDecline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/decline-button.png")));
    }//GEN-LAST:event_btnDeclineMouseExited

    private void btnRegisterBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterBookMouseEntered
        pnlRegBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button-hovered.png")));
        btnRegisterBook.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRegisterBookMouseEntered

    private void btnRegisterBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterBookMouseExited
        pnlRegBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button.png")));
        btnRegisterBook.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnRegisterBookMouseExited

    private void lblMessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseClicked
//        boolean show = panelMessages.isVisible();
//        
//            panelMessages.setVisible(!show);
//        
    }//GEN-LAST:event_lblMessagesMouseClicked

    private void btnRegisterBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterBookMouseClicked
        String bookID = txtRegBookID.getText();
        String category = txtRegCategory.getText();
        String bookTitle = txtRegBookTitle.getText();
        String author = txtRegAuthor.getText();
        
        if(bookID.isEmpty() || category.isEmpty() || bookTitle.isEmpty() || author.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String book[] = new String[4];
        book[0] = bookID;
        book[1] = category;
        book[2] = bookTitle;
        book[3] = author;
        queries.registerBook(book);
        showBooks();
        
        txtRegBookID.setText("");
        txtRegCategory.setText("");
        txtRegBookTitle.setText("");
        txtRegAuthor.setText("");
        
    }//GEN-LAST:event_btnRegisterBookMouseClicked
    String transactionID;
    private void tblBookRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookRequestsMouseClicked
        if(evt.getClickCount() == 2){
            int row = tblBookRequests.getSelectedRow();
            
            if(tblBookRequests.getValueAt(row, 5).toString().equals("PENDING")){
                transactionID = tblBookRequests.getValueAt(row, 0).toString();
                String name = tblBookRequests.getValueAt(row, 1).toString();
                String bookTitle = tblBookRequests.getValueAt(row, 2).toString();
                String author = tblBookRequests.getValueAt(row, 3).toString();
                
                txtBorrower.setText(name);
                txtBookTitle.setText(bookTitle);
                txtAuthor.setText(author);
            }
        }
    }//GEN-LAST:event_tblBookRequestsMouseClicked

    private void btnApproveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveMouseClicked
        
        queries.bookRequest("APPROVED", transactionID, date);
        JOptionPane.showMessageDialog(null, "Book request has been approved.", "Approved", JOptionPane.PLAIN_MESSAGE);
        showBooks();
        showBookTransactions();
        
        txtBorrower.setText("");
        txtBookTitle.setText("");
        txtAuthor.setText("");
    }//GEN-LAST:event_btnApproveMouseClicked

    private void btnDeclineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeclineMouseClicked
        
        queries.bookRequest("DENIED", transactionID, date);
        JOptionPane.showMessageDialog(null, "Book request has been denied.", "Denied", JOptionPane.PLAIN_MESSAGE);
        showBooks();
        showBookTransactions();
        
        txtBorrower.setText("");
        txtBookTitle.setText("");
        txtAuthor.setText("");
    }//GEN-LAST:event_btnDeclineMouseClicked

    private void lblPersonalinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonalinfoMouseClicked
        hidePanels();
        pnlInfo = new PersonalInfoPanel(this, "PersonalInfo", id);
        jPanel1.add(pnlInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));
    }//GEN-LAST:event_lblPersonalinfoMouseClicked

    private void tblMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMembersMouseClicked
        if(evt.getClickCount() == 2){
            int row = tblMembers.getSelectedRow();
            
            int id = Integer.parseInt(tblMembers.getValueAt(row, 0).toString());
            hidePanels();
            pnlInfo = new PersonalInfoPanel(this, "Members", id);
        jPanel1.add(pnlInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));
        }
    }//GEN-LAST:event_tblMembersMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnApprove;
    private javax.swing.JLabel btnDecline;
    private javax.swing.JLabel btnRegisterBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBookList;
    private javax.swing.JLabel lblBookRequests;
    private javax.swing.JLabel lblBorrowHistory;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMembers;
    private javax.swing.JLabel lblMessages;
    private javax.swing.JLabel lblNotifiactions;
    private javax.swing.JLabel lblPersonalinfo;
    private javax.swing.JLabel lblRegisterBook;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel pnlApprove;
    private javax.swing.JPanel pnlBookList;
    private javax.swing.JPanel pnlBookRequests;
    private javax.swing.JLabel pnlBooklist;
    private javax.swing.JLabel pnlBookrequests;
    private javax.swing.JPanel pnlBorrowHistory;
    private javax.swing.JLabel pnlBorrowhistory;
    private javax.swing.JLabel pnlDecline;
    private javax.swing.JLabel pnlLogout;
    private javax.swing.JPanel pnlMembers;
    private javax.swing.JLabel pnlMessages;
    private javax.swing.JLabel pnlNotification;
    private javax.swing.JLabel pnlPersonalInfo;
    private javax.swing.JLabel pnlRegBook;
    private javax.swing.JPanel pnlRegisterBook;
    private javax.swing.JLabel pnlRegisterbook;
    private javax.swing.JLabel pnlmembers;
    private javax.swing.JTable tblBookList;
    private javax.swing.JTable tblBookRequests;
    private javax.swing.JTable tblBorrowedHistory;
    private javax.swing.JTable tblMembers;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtBorrower;
    private javax.swing.JTextField txtRegAuthor;
    private javax.swing.JTextField txtRegBookID;
    private javax.swing.JTextField txtRegBookTitle;
    private javax.swing.JTextField txtRegCategory;
    private javax.swing.JTextField txtSearchtblBookList;
    private javax.swing.JTextField txtsearchMember;
    // End of variables declaration//GEN-END:variables
}

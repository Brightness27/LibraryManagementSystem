
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class UserPage extends javax.swing.JFrame {

    String fname;
    String lname;
    int id;
    Calendar cal;
    String date;
    String transactID;
    PopupPanel popNotif;
    PopupPanel popMessage;
    
    SqlQueries queries = new SqlQueries();
    public UserPage() {
        initComponents();
        hidePanels();
        changeIcon();
        showBooks();
        showBorrowedBooks();
        setTableColumnSize();
        setCurrentDate();
    }
    
    UserPage(int id, String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        initComponents();
        popNotif = new PopupPanel(this, 1160, "Notifications", id);
        popMessage = new PopupPanel(this, 1080, "Messages", id);
        hidePanels();
        changeIcon();
        showBooks();
        showBorrowedBooks();
        setTableColumnSize();
        setCurrentDate();
    }
    
    public void changeIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Frame-Logo.png")));
        pnlBookList.setVisible(true);
        lblWelcome.setText("Welcome, " + fname);
    }
    
    private void hidePanels(){
        pnlBookList.setVisible(false);
        pnlBorrowBooks.setVisible(false);
        pnlBorrowHistory.setVisible(false);
        pnlMessage.setVisible(false);
    }
    
    private void showBooks(){
        String books[][] = queries.showBooks();
        DefaultTableModel model = (DefaultTableModel) tblBookList.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < books.length; i++){
            model.addRow(books[i]);
        }
    }
    
    private void showBorrowedBooks(){
        String books[][] = queries.showBookTransactions(id);
        DefaultTableModel requestBooksModel = (DefaultTableModel) tblBorrowedBooks.getModel();
        DefaultTableModel borrowedHistoryModel = (DefaultTableModel) tblBorrowedHistory.getModel();
        requestBooksModel.setRowCount(0);
        borrowedHistoryModel.setRowCount(0);
        for (int i = 0; i < books.length; i++){
            
            if(books[i][5].equals("RETURNED") || books[i][5].equals("CANCELLED") || books[i][5].equals("DENIED")){
                 String borroHistoryRow[] = {books[i][0], books[i][1], books[i][2], books[i][3], books[i][4], books[i][5]};
                 borrowedHistoryModel.addRow(borroHistoryRow);
            }else{
                String requestBookRow[] = {books[i][0], books[i][1], books[i][2], books[i][3], books[i][5]};
                requestBooksModel.addRow(requestBookRow);
            }
        }
    }
    
    public void filterTable(JTable table, String query){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
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
        
        TableColumnModel cmTblBookRequest = tblBorrowedBooks.getColumnModel();
        cmTblBookRequest.getColumn(0).setPreferredWidth(50);
        cmTblBookRequest.getColumn(1).setPreferredWidth(247);
        cmTblBookRequest.getColumn(2).setPreferredWidth(75);
        cmTblBookRequest.getColumn(3).setPreferredWidth(40);
        cmTblBookRequest.getColumn(4).setPreferredWidth(40);
        
        TableColumnModel cmTblBorrowedHistory = tblBorrowedHistory.getColumnModel();
        cmTblBorrowedHistory.getColumn(0).setPreferredWidth(10);
        cmTblBorrowedHistory.getColumn(1).setPreferredWidth(242);
        cmTblBorrowedHistory.getColumn(2).setPreferredWidth(100);
        cmTblBorrowedHistory.getColumn(3).setPreferredWidth(50);
        cmTblBorrowedHistory.getColumn(4).setPreferredWidth(50);
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        pnlBorrowBooks = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTitleRequest = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        txtBookTitle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        lblAuthor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBorrowBook = new javax.swing.JLabel();
        pnlBorrowBook = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBorrowedBooks = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        pnlMessage = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        pnlBorrowHistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBorrowedHistory = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        pnlBookList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookList = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchtblBookList = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        lblBorrowHistory = new javax.swing.JLabel();
        lblBookList = new javax.swing.JLabel();
        lblBorrowBooks = new javax.swing.JLabel();
        pnlBorrowhistory = new javax.swing.JLabel();
        pnlBooklist = new javax.swing.JLabel();
        pnlBorrowbooks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(138, 102, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBorrowBooks.setBackground(new java.awt.Color(226, 200, 171));
        pnlBorrowBooks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBorrowBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(226, 200, 171));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleRequest.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitleRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleRequest.setText("Request Book");
        jPanel4.add(lblTitleRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Book ID");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 320, 40));

        txtBookID.setEditable(false);
        txtBookID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBookID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBookID.setBorder(null);
        jPanel4.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, 30));

        txtBookTitle.setEditable(false);
        txtBookTitle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBookTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBookTitle.setBorder(null);
        jPanel4.add(txtBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 190, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Book Title");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 320, 40));

        txtAuthor.setEditable(false);
        txtAuthor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtAuthor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAuthor.setBorder(null);
        jPanel4.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 190, 30));

        lblAuthor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAuthor.setText("Author");
        jPanel4.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 320, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 310, 225, 55));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 110, 225, 55));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-field.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 210, 225, 55));

        btnBorrowBook.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBorrowBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBorrowBook.setText("Borrow Book");
        btnBorrowBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrowBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrowBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBorrowBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBorrowBookMouseExited(evt);
            }
        });
        jPanel4.add(btnBorrowBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 380, 185, 55));

        pnlBorrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button.PNG"))); // NOI18N
        pnlBorrowBook.setText("jLabel10");
        jPanel4.add(pnlBorrowBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 380, 185, 55));

        pnlBorrowBooks.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 540));

        jScrollPane2.setBackground(new java.awt.Color(226, 200, 171));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBorrowedBooks.setBackground(new java.awt.Color(226, 200, 171));
        tblBorrowedBooks.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblBorrowedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction No.", "Book Title", "Author", "Date Borrowed", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBorrowedBooks.setRowHeight(30);
        tblBorrowedBooks.setSelectionBackground(new java.awt.Color(247, 234, 212));
        tblBorrowedBooks.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblBorrowedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBorrowedBooksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBorrowedBooks);

        pnlBorrowBooks.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 750, 460));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BORROWED BOOKS");
        pnlBorrowBooks.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 740, 60));

        jPanel1.add(pnlBorrowBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        pnlMessage.setBackground(new java.awt.Color(226, 200, 171));
        pnlMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlMessage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtAreaMessage.setColumns(5);
        txtAreaMessage.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtAreaMessage.setRows(5);
        txtAreaMessage.setTabSize(1);
        txtAreaMessage.setWrapStyleWord(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jScrollPane4, org.jdesktop.beansbinding.ELProperty.create("true"), txtAreaMessage, org.jdesktop.beansbinding.BeanProperty.create("lineWrap"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(txtAreaMessage);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 90));

        pnlMessage.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 940, 90));

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        pnlMessage.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 110, 80));

        jPanel1.add(pnlMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        pnlBorrowHistory.setBackground(new java.awt.Color(226, 200, 171));
        pnlBorrowHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBorrowHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBorrowedHistory.setBackground(new java.awt.Color(226, 200, 171));
        tblBorrowedHistory.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblBorrowedHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction No.", "Book Title", "Author", "Date Borrowed", "Date Returned", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        pnlBookList.setBackground(new java.awt.Color(226, 200, 171));
        pnlBookList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBookList.setFocusable(false);
        pnlBookList.setRequestFocusEnabled(false);
        pnlBookList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(226, 200, 171));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBookList.setBackground(new java.awt.Color(226, 200, 171));
        tblBookList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
        tblBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookListMouseClicked(evt);
            }
        });
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
        txtSearchtblBookList.setBorder(null);
        txtSearchtblBookList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchtblBookListKeyReleased(evt);
            }
        });
        pnlBookList.add(txtSearchtblBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 15, 390, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search-field.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        pnlBookList.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 435, 40));

        jPanel1.add(pnlBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 1120, 560));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-Logo.png"))); // NOI18N
        logo.setText("LOGO");
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        lblWelcome.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Welcome");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 390, 40));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNotifiactionsMouseClicked(evt);
            }
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
        jPanel3.add(lblBorrowHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 40));

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

        lblBorrowBooks.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBorrowBooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBorrowBooks.setText("Borrow Books");
        lblBorrowBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBorrowBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrowBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBorrowBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBorrowBooksMouseExited(evt);
            }
        });
        jPanel3.add(lblBorrowBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 40));

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
        jPanel3.add(pnlBorrowhistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 65));

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

        pnlBorrowbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png"))); // NOI18N
        pnlBorrowbooks.setText("jLabel1");
        pnlBorrowbooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBorrowbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBorrowbooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBorrowbooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBorrowbooksMouseExited(evt);
            }
        });
        jPanel3.add(pnlBorrowbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 65));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 670));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblPersonalinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonalinfoMouseEntered
        pnlPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblPersonalinfoMouseEntered

    private void lblMessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseEntered
        pnlMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblMessagesMouseEntered

    private void lblNotifiactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifiactionsMouseEntered
        pnlNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblNotifiactionsMouseEntered

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        pnlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-panel-icons.png")));
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblPersonalinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonalinfoMouseExited
        pnlPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblPersonalinfoMouseExited

    private void lblMessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseExited
       pnlMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblMessagesMouseExited

    private void lblNotifiactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifiactionsMouseExited
         pnlNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblNotifiactionsMouseExited

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        pnlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/panel-icons.png")));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        int logout = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);
        
        if(logout == 0){
            new LogInForm().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseClicked
        hidePanels();
        pnlBookList.setVisible(true);
    }//GEN-LAST:event_lblBookListMouseClicked

    private void lblBorrowBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowBooksMouseClicked
        hidePanels();
        pnlBorrowBooks.setVisible(true);
    }//GEN-LAST:event_lblBorrowBooksMouseClicked

    private void lblBookListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseEntered
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBookListMouseEntered

    private void lblBookListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookListMouseExited
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBookListMouseExited

    private void pnlBooklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseClicked
        hidePanels();
        pnlBookList.setVisible(true);
    }//GEN-LAST:event_pnlBooklistMouseClicked

    private void pnlBooklistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseEntered
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBooklistMouseEntered

    private void pnlBooklistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBooklistMouseExited
        pnlBooklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBooklistMouseExited

    private void pnlBorrowbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowbooksMouseClicked
        hidePanels();
        pnlBorrowBooks.setVisible(true);
    }//GEN-LAST:event_pnlBorrowbooksMouseClicked

    private void pnlBorrowbooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowbooksMouseEntered
        pnlBorrowbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowbooksMouseEntered

    private void lblBorrowBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowBooksMouseEntered
        pnlBorrowbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowBooksMouseEntered

    private void lblBorrowBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowBooksMouseExited
        pnlBorrowbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowBooksMouseExited

    private void lblBorrowHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseClicked
         hidePanels();
        pnlBorrowHistory.setVisible(true);
    }//GEN-LAST:event_lblBorrowHistoryMouseClicked

    private void pnlBorrowhistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseClicked
         hidePanels();
        pnlBorrowHistory.setVisible(true);
    }//GEN-LAST:event_pnlBorrowhistoryMouseClicked

    private void pnlBorrowhistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseEntered
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowhistoryMouseEntered

    private void lblBorrowHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseEntered
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hovered-user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowHistoryMouseEntered

    private void lblBorrowHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrowHistoryMouseExited
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_lblBorrowHistoryMouseExited

    private void pnlBorrowhistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowhistoryMouseExited
        pnlBorrowhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowhistoryMouseExited

    private void pnlBorrowbooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBorrowbooksMouseExited
        pnlBorrowbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-admin-panel.png")));
    }//GEN-LAST:event_pnlBorrowbooksMouseExited

    private void btnBorrowBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrowBookMouseEntered
        pnlBorrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button-hovered.png")));
        btnBorrowBook.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnBorrowBookMouseEntered

    private void btnBorrowBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrowBookMouseExited
        pnlBorrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrow-book-button.png")));
        btnBorrowBook.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnBorrowBookMouseExited

    private void txtSearchtblBookListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchtblBookListKeyReleased
        String query = txtSearchtblBookList.getText();
        
        filterTable(tblBookList, query);
    }//GEN-LAST:event_txtSearchtblBookListKeyReleased

    private void btnBorrowBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrowBookMouseClicked
        String bookID = txtBookID.getText();
        String bookTitle = txtBookTitle.getText();
        String Author = txtAuthor.getText();

        String command = btnBorrowBook.getText();

        if (command.equals("Borrow Book")) {
            String book[] = {bookID, bookTitle, Author};
            String found = queries.checkBook(book, id);
            
            if (found.equals("not found")) {
                JOptionPane.showMessageDialog(null, "Book not found! Ensure that all fields are correctly typed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (found.equals("BORROWED")) {
                JOptionPane.showMessageDialog(null, "Book currently borrowed by another student.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (found.equals("PENDING")) {
                JOptionPane.showMessageDialog(null, "Book request currently pending. Wait for the confirmation of the admin.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (found.equals("AVAILABLE")) {
                queries.requestBook(bookID, id);

            }
        }
        else if(command.equals("Return Book")){
            transactID = queries.getTransactID(bookID, id, "BORROWED");
            queries.returnBook(date, transactID);
            JOptionPane.showMessageDialog(null, "Book has been returned.", "Book Returned", JOptionPane.PLAIN_MESSAGE);
        }
        else if(command.equals("Cancel")){
            transactID = queries.getTransactID(bookID, id, "PENDING");
            queries.cancelRequest(transactID);
            JOptionPane.showMessageDialog(null, "Request has been cancelled.", "Request Cancelled", JOptionPane.PLAIN_MESSAGE);
            
        }

        txtBookID.setText("");
        txtBookTitle.setText("");
        txtAuthor.setText("");
        
        showBorrowedBooks();
        showBooks();
        
    }//GEN-LAST:event_btnBorrowBookMouseClicked

    private void tblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookListMouseClicked
        if(evt.getClickCount() == 2){
            int row = tblBookList.getSelectedRow();
            String book[] = new String[3];
            
            book[0] = tblBookList.getValueAt(row, 0).toString();
            book[1] = tblBookList.getValueAt(row, 2).toString();
            book[2] = tblBookList.getValueAt(row, 3).toString();
            
            hidePanels();
            pnlBorrowBooks.setVisible(true);
            
            txtBookID.setText(book[0]);
            txtBookTitle.setText(book[1]);
            txtAuthor.setText(book[2]);
            
            btnBorrowBook.setText("Borrow Book");
            lblTitleRequest.setText("Request Book");
            lblAuthor.setText("Author");
            
        }
    }//GEN-LAST:event_tblBookListMouseClicked

    private void tblBorrowedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBorrowedBooksMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblBorrowedBooks.getSelectedRow();

            String book[] = new String[3];

            book[0] = tblBorrowedBooks.getValueAt(row, 0).toString();
            book[1] = tblBorrowedBooks.getValueAt(row, 2).toString();
            book[2] = tblBorrowedBooks.getValueAt(row, 3).toString();

            String id = queries.getBookID(book[0]);

            txtBookID.setText(id);
            txtBookTitle.setText(book[1]);
            txtAuthor.setText(book[2]);

            if (tblBorrowedBooks.getValueAt(row, 4).toString().equals("BORROWED")) {
                btnBorrowBook.setText("Return Book");
                lblTitleRequest.setText("Return Book");
                lblAuthor.setText("Date Borrowed");
            } else {
                lblTitleRequest.setText("Cancel Request");
                btnBorrowBook.setText("Cancel");
                lblAuthor.setText("Date Borrowed");
            }

        }
    }//GEN-LAST:event_tblBorrowedBooksMouseClicked

    private void lblMessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessagesMouseClicked
        hidePanels();
        pnlMessage.setVisible(true);
    }//GEN-LAST:event_lblMessagesMouseClicked

    private void lblNotifiactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifiactionsMouseClicked
        if(popMessage.isVisible()){
            popMessage.setVisible(false);
        }
        popNotif.visibility();
    }//GEN-LAST:event_lblNotifiactionsMouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        
    }//GEN-LAST:event_btnSendActionPerformed
       
        
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
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBorrowBook;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookList;
    private javax.swing.JLabel lblBorrowBooks;
    private javax.swing.JLabel lblBorrowHistory;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMessages;
    private javax.swing.JLabel lblNotifiactions;
    private javax.swing.JLabel lblPersonalinfo;
    private javax.swing.JLabel lblTitleRequest;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnlBookList;
    private javax.swing.JLabel pnlBooklist;
    private javax.swing.JLabel pnlBorrowBook;
    private javax.swing.JPanel pnlBorrowBooks;
    private javax.swing.JPanel pnlBorrowHistory;
    private javax.swing.JLabel pnlBorrowbooks;
    private javax.swing.JLabel pnlBorrowhistory;
    private javax.swing.JLabel pnlLogout;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JLabel pnlMessages;
    private javax.swing.JLabel pnlNotification;
    private javax.swing.JLabel pnlPersonalInfo;
    private javax.swing.JTable tblBookList;
    private javax.swing.JTable tblBorrowedBooks;
    private javax.swing.JTable tblBorrowedHistory;
    private javax.swing.JTextArea txtAreaMessage;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtSearchtblBookList;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

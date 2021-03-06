
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class PersonalInfoPanel extends javax.swing.JPanel {

    SqlQueries lms = new SqlQueries();
    String type;
    String cancel;
    int id;
    JFrame frame;

    public PersonalInfoPanel() {
        initComponents();
    }

    public PersonalInfoPanel(JFrame frame, String callType, int id) {
        initComponents();
        this.frame = frame;
        this.type = callType;
        this.id = id;
        lblBdayAlert.setVisible(false);
        yearModel();
        dayModel();
        showPanel();
        cancel = "Are you sure you want to cancel " + (btnRegister.getText().equals("Register") ? "registration?" : "update?");
    }

    private void showPanel() {
        if (type.equals("PersonalInfo")) {
            lblPanelTitle.setText("PERSONAL INFORMATION");
            hideComponents();
            disableComponents();
            setFields();
        } else if (type.equals("Members")) {
            lblPanelTitle.setText("UPDATE USER");
            setFields();
            listUserType.setEnabled(true);
            hideExtraComponents();
            btnRegister.setText("Update");
            btnExit.setVisible(true);
            pnlExit.setVisible(true);
        } else if (type.equals("Signup")) {
            bgUsertype.setVisible(false);
            txtUserType.setVisible(false);

            bgSex.setVisible(false);
            txtSex.setVisible(false);

            btnActivate.setVisible(false);
            pnlActivate.setVisible(false);

            bgBday.setVisible(false);
            txtbday.setVisible(false);
            if (id == -1) {
                listUserType.setEnabled(true);
            }
        }
    }

    private void hideExtraComponents() {
        bgConfirmPass.setVisible(false);
        txtConfirmPassword.setVisible(false);
        lblConfirmPass.setVisible(false);
        btnExit.setVisible(false);
        pnlExit.setVisible(false);
        txtUserType.setVisible(false);
        bgUsertype.setVisible(false);
        bgSex.setVisible(false);
        txtSex.setVisible(false);
        bgBday.setVisible(false);
        txtbday.setVisible(false);

        String num = txtContactNumber.getText().replace("+63", "");
        txtContactNumber.setText(num);
    }

    private void hideComponents() {
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 30));
        jPanel2.add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 170, 30));
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 200, 50));
        listUserType.setVisible(false);
        cmbSex.setVisible(false);
        cmbYear.setVisible(false);
        cmbMonth.setVisible(false);
        cmbDay.setVisible(false);
        btnExit.setVisible(false);
        pnlExit.setVisible(false);
        btnRegister.setVisible(false);
        pnlRegister.setVisible(false);
        lblnum.setVisible(false);
        lblYear.setVisible(false);
        lblMonth.setVisible(false);
        lblDay.setVisible(false);
        bgConfirmPass.setVisible(false);
        txtConfirmPassword.setVisible(false);
        lblConfirmPass.setVisible(false);
        btnActivate.setVisible(false);
        pnlActivate.setVisible(false);

    }

    private void disableComponents() {
        txtUserType.setEditable(false);
        txtFirstName.setEditable(false);
        txtMiddleName.setEditable(false);
        txtLastName.setEditable(false);
        txtEmailAddress.setEditable(false);
        txtContactNumber.setEditable(false);
        txtUsername.setEditable(false);
        txtPassword.setEditable(false);
        txtSex.setEditable(false);
        txtbday.setEditable(false);
        txtAddress.setEditable(false);
    }

    private void setFields() {
        String user[] = lms.getUser(id);
        txtUserType.setText(user[0]);

        txtFirstName.setText(user[1]);
        if (user[2].equals("N/A")) {
            txtMiddleName.setText("");
        } else {
            txtMiddleName.setText(user[2]);
        }
        txtLastName.setText(user[3]);
        txtAddress.setText(user[4]);
        txtUsername.setText(user[5]);
        txtPassword.setText(user[6]);
        txtContactNumber.setText(user[7]);
        txtSex.setText(user[8]);
        txtEmailAddress.setText(user[9]);
        txtbday.setText(user[10]);
        listUserType.setSelectedItem(user[0]);
        cmbSex.setSelectedItem(user[8]);

        String bday[] = user[10].split("-", 3);

        cmbYear.setSelectedItem(bday[0]);
        cmbMonth.setSelectedItem(bday[1]);
        cmbDay.setSelectedItem(bday[2]);
        computeAge(Integer.parseInt(bday[1]), Integer.parseInt(bday[2]), Integer.parseInt(bday[0]));
        if (user[11].equals("ACTIVATED")) {
            btnActivate.setText("Deactivate");
        } else {
            btnActivate.setText("Activate");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        listUserType = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblnum = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        btnRegister = new javax.swing.JLabel();
        pnlRegister = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        cmbYear = new javax.swing.JComboBox<>();
        cmbMonth = new javax.swing.JComboBox<>();
        cmbDay = new javax.swing.JComboBox<>();
        cmbSex = new javax.swing.JComboBox<>();
        lblConfirmPass = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtSex = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtUserType = new javax.swing.JTextField();
        bgSex = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        bgConfirmPass = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnlExit = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        bgUsertype = new javax.swing.JLabel();
        txtbday = new javax.swing.JTextField();
        bgBday = new javax.swing.JLabel();
        lblBdayAlert = new javax.swing.JLabel();
        btnActivate = new javax.swing.JLabel();
        pnlActivate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPanelTitle = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1120, 560));
        setPreferredSize(new java.awt.Dimension(1120, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(226, 200, 171));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Password:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 110, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usertype:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        listUserType.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        listUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Administrator" }));
        listUserType.setEnabled(false);
        listUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listUserTypeActionPerformed(evt);
            }
        });
        jPanel2.add(listUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 130, 30));

        txtUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtUsername.setBorder(null);
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, 30));

        txtPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, 30));

        txtFirstName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtFirstName.setBorder(null);
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("First Name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        txtAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtAddress.setBorder(null);
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 180, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Address:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 110, 30));

        lblDay.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDay.setText("Day");
        jPanel2.add(lblDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 70, 20));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Birthday:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Sex:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 110, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Contact Number:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 130, 30));

        lblnum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblnum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblnum.setText("+63");
        lblnum.setAlignmentX(0.5F);
        jPanel2.add(lblnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 219, -1, 30));

        txtContactNumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtContactNumber.setBorder(null);
        txtContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNumberActionPerformed(evt);
            }
        });
        txtContactNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactNumberKeyTyped(evt);
            }
        });
        jPanel2.add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 220, 140, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Middle Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, 30));

        txtMiddleName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtMiddleName.setBorder(null);
        jPanel2.add(txtMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 180, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Last Name:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 110, 30));

        txtLastName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtLastName.setBorder(null);
        jPanel2.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 180, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Email Address:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 110, 30));

        txtEmailAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtEmailAddress.setBorder(null);
        jPanel2.add(txtEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 180, 30));

        btnRegister.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegister.setText("Register");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        jPanel2.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 100, 50));

        pnlRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttonborder2.png"))); // NOI18N
        pnlRegister.setText("jLabel17");
        jPanel2.add(pnlRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 100, 50));

        btnExit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("Cancel");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 100, 50));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Age:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 110, 30));

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtAge.setText("0");
        txtAge.setBorder(null);
        jPanel2.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 180, 30));

        cmbYear.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYearItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 70, 30));

        cmbMonth.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 50, 30));

        cmbDay.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmbDay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDayItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 50, 30));

        cmbSex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel2.add(cmbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 180, 30));

        lblConfirmPass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConfirmPass.setText("Confrim password:");
        jPanel2.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, 30));

        txtConfirmPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtConfirmPassword.setBorder(null);
        txtConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 180, 30));

        txtSex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtSex.setBorder(null);
        jPanel2.add(txtSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 180, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel18.setText("jLabel17");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 200, 50));

        txtUserType.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtUserType.setBorder(null);
        txtUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserTypeActionPerformed(evt);
            }
        });
        jPanel2.add(txtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 180, 30));

        bgSex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        bgSex.setText("jLabel17");
        jPanel2.add(bgSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 200, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel20.setText("jLabel17");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 200, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel21.setText("jLabel17");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 50));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel22.setText("jLabel17");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 200, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel23.setText("jLabel17");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 200, 50));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel24.setText("jLabel17");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 200, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel26.setText("jLabel17");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 200, 50));

        bgConfirmPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        bgConfirmPass.setText("jLabel17");
        jPanel2.add(bgConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 200, 50));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel31.setText("jLabel17");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 200, 50));

        pnlExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttonborder2.png"))); // NOI18N
        pnlExit.setText("jLabel17");
        jPanel2.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 100, 50));

        lblYear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYear.setText("Year");
        jPanel2.add(lblYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 70, 20));

        lblMonth.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonth.setText("Month");
        jPanel2.add(lblMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 70, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        jLabel25.setText("jLabel17");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 50));

        bgUsertype.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        bgUsertype.setText("jLabel17");
        jPanel2.add(bgUsertype, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 200, 50));

        txtbday.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtbday.setBorder(null);
        txtbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbdayActionPerformed(evt);
            }
        });
        jPanel2.add(txtbday, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 180, 30));

        bgBday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/signup-fields.png"))); // NOI18N
        bgBday.setText("jLabel17");
        jPanel2.add(bgBday, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 200, 50));

        lblBdayAlert.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        lblBdayAlert.setForeground(new java.awt.Color(198, 4, 4));
        lblBdayAlert.setText("<html><pre style = \"font-family: Dialog, font-color: red\">\nMust be 18 years old and above to be\neligible to register\n</pre>\n</html>");
        jPanel2.add(lblBdayAlert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 190, 30));

        btnActivate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnActivate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActivate.setText("Activate");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActivateMouseClicked(evt);
            }
        });
        jPanel2.add(btnActivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 110, 50));

        pnlActivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/activate-button.png"))); // NOI18N
        pnlActivate.setText("jLabel17");
        jPanel2.add(pnlActivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 110, 50));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1120, 480));

        jPanel3.setBackground(new java.awt.Color(138, 102, 63));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPanelTitle.setText("REGISTER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void listUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listUserTypeActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtContactNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactNumberKeyTyped
        char c = evt.getKeyChar();
        if ((!txtContactNumber.getText().isEmpty() && txtContactNumber.getText().length() == 10) || !Character.isDigit(c)) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_txtContactNumberKeyTyped

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        String register[] = new String[12];
        int emptyFields = 0;

        String usertype = listUserType.getSelectedItem().toString();
        String fname = txtFirstName.getText();
        String mname = txtMiddleName.getText();
        String lname = txtLastName.getText();
        String eaddress = txtEmailAddress.getText();
        String phoneNumber = lblnum.getText() + txtContactNumber.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        String sex = cmbSex.getSelectedItem().toString();
        String age = txtAge.getText();
        String bday = cmbYear.getSelectedItem().toString() + "-" + cmbMonth.getSelectedItem().toString() + "-" + cmbDay.getSelectedItem().toString();
        String address = txtAddress.getText();

        if (fname.isEmpty()) {
            emptyFields++;
        }
        if (mname.isEmpty()) {
            mname = "N/A";
        }
        if (lname.isEmpty()) {
            emptyFields++;
        }
        if (eaddress.isEmpty()) {
            emptyFields++;
        }
        if (phoneNumber.equals("+63")) {
            emptyFields++;
        }
        if (username.isEmpty()) {
            emptyFields++;
        }
        if (password.isEmpty()) {
            emptyFields++;
        }
        if (confirmPassword.isEmpty()) {
            emptyFields++;
        }
        if (address.isEmpty()) {
            emptyFields++;
        }

        if (type.equals("Signup")) {
            if (emptyFields != 0) {
                JOptionPane.showMessageDialog(null, "please fill up all neccessary fields", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (phoneNumber.length() != 13) {
                JOptionPane.showMessageDialog(null, "please input valid phone number", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords does not match", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Integer.parseInt(age) < 18) {
                JOptionPane.showMessageDialog(null, "Must be 18 years old and above to be eligible to register.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            register[0] = usertype;
            register[1] = fname;
            register[2] = mname;
            register[3] = lname;
            register[4] = eaddress;
            register[5] = phoneNumber;
            register[6] = username;
            register[7] = password;
            register[8] = sex;
            register[9] = bday;
            register[10] = address;

            int successFailed = lms.register(register);

            if (successFailed == 0) {
                JOptionPane.showMessageDialog(null, "Register Succesful.", "Register", JOptionPane.PLAIN_MESSAGE);
                if (id == 0) {
                    new LogInForm("Logout").setVisible(true);
                    frame.dispose();
                } else {
                    this.setVisible(false);
                }
            } else if (successFailed == 2) {
                JOptionPane.showMessageDialog(null, "Unable to register.", "error", JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
                txtConfirmPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "username already in use.", "error", JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
                txtConfirmPassword.setText("");
            }
        } else {
            if (emptyFields != 0) {
                JOptionPane.showMessageDialog(null, "please fill up all neccessary fields", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (phoneNumber.length() != 13) {
                JOptionPane.showMessageDialog(null, "please input valid phone number", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords does not match", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Integer.parseInt(age) < 18) {
                JOptionPane.showMessageDialog(null, "Must be 18 years old and above to be eligible to register.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            register[0] = usertype;
            register[1] = fname;
            register[2] = mname;
            register[3] = lname;
            register[4] = eaddress;
            register[5] = phoneNumber;
            register[6] = username;
            register[7] = password;
            register[8] = sex;
            register[9] = bday;
            register[10] = address;

            int successFailed = lms.updateUser(register, id);

            if (successFailed == 0) {
                JOptionPane.showMessageDialog(null, "Update Succesful.", "Update", JOptionPane.PLAIN_MESSAGE);

                this.setVisible(false);

            } else if (successFailed == 2) {
                JOptionPane.showMessageDialog(null, "Unable to Update.", "error", JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
                txtConfirmPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "username already in use.", "error", JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
                txtConfirmPassword.setText("");
            }
        }
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        int ask = JOptionPane.showConfirmDialog(null, cancel, "Cancel", JOptionPane.OK_CANCEL_OPTION);
        if (ask == 0) {

            if (id == 0) {
                new LogInForm("Logout").setVisible(true);
                frame.dispose();
            } else {
                this.setVisible(false);

            }
        }


    }//GEN-LAST:event_btnExitMouseClicked

    private void cmbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYearItemStateChanged
        dayModel();
        if (lblBdayAlert.isVisible()) {
            lblBdayAlert.setVisible(false);
        }
        computeAge(Integer.parseInt(cmbMonth.getSelectedItem().toString()), Integer.parseInt(cmbDay.getSelectedItem().toString()), Integer.parseInt(cmbYear.getSelectedItem().toString()));
    }//GEN-LAST:event_cmbYearItemStateChanged

    private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        dayModel();
        if (lblBdayAlert.isVisible()) {
            lblBdayAlert.setVisible(false);
        }
        computeAge(Integer.parseInt(cmbMonth.getSelectedItem().toString()), Integer.parseInt(cmbDay.getSelectedItem().toString()), Integer.parseInt(cmbYear.getSelectedItem().toString()));
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void cmbDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDayItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            computeAge(Integer.parseInt(cmbMonth.getSelectedItem().toString()), Integer.parseInt(cmbDay.getSelectedItem().toString()), Integer.parseInt(cmbYear.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_cmbDayItemStateChanged

    private void txtConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPasswordActionPerformed

    private void txtUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserTypeActionPerformed

    private void txtbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbdayActionPerformed

    private void txtContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNumberActionPerformed

    private void btnActivateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActivateMouseClicked
        String status = btnActivate.getText();
        int confirm = JOptionPane.showConfirmDialog(null, status + " user?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            int changeStatus = lms.changeStatusMember(id, status);
            if (changeStatus == 0) {
                JOptionPane.showMessageDialog(null, "Status changed", "Success", JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Status failed to change", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActivateMouseClicked

    Calendar cal;

    private void dayModel() {
        cal = Calendar.getInstance();
        int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
        int month = Integer.parseInt(cmbMonth.getSelectedItem().toString());
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, (month - 1));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        String model[] = new String[maxDay];
        for (int i = 0; i < model.length; i++) {
            String m = (i + 1) + "";
            if (m.length() == 1) {
                m = "0" + m;
            }
            model[i] = m;
        }
        cmbDay.setModel(new javax.swing.DefaultComboBoxModel<>(model));
    }

    private void yearModel() {
        String model[] = new String[51];
        cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);

        for (int i = 0; i < model.length; i++) {
            model[i] = (year - i) + "";
        }
        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(model));
    }

    private void computeAge(int month_bday, int day_bday, int year_bday) {
        cal = new GregorianCalendar();
        int computeDifference = 0;

        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        if (month_bday < month) {
            computeDifference = year - year_bday;
        } else if (month_bday == month) {
            if (day_bday <= day) {
                computeDifference = year - year_bday;
            } else {
                computeDifference = (year - 1) - year_bday;
            }
        } else {
            computeDifference = (year - 1) - year_bday;
        }

        if (computeDifference < 18) {
            lblBdayAlert.setVisible(true);
        } else {
            lblBdayAlert.setVisible(false);
        }
        txtAge.setText(computeDifference + "");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgBday;
    private javax.swing.JLabel bgConfirmPass;
    private javax.swing.JLabel bgSex;
    private javax.swing.JLabel bgUsertype;
    private javax.swing.JLabel btnActivate;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JComboBox<String> cmbDay;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBdayAlert;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblPanelTitle;
    private javax.swing.JLabel lblYear;
    private javax.swing.JLabel lblnum;
    private javax.swing.JComboBox<String> listUserType;
    private javax.swing.JLabel pnlActivate;
    private javax.swing.JLabel pnlExit;
    private javax.swing.JLabel pnlRegister;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtUserType;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtbday;
    // End of variables declaration//GEN-END:variables
}

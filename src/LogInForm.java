
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicProgressBarUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class LogInForm extends javax.swing.JFrame {

    Connection con;
    SqlQueries lms = new SqlQueries();
    String s;

    public LogInForm() {
        initComponents();
        s = "login";
        db.createTable();
        changeIcon();
        designProgressBar();
        loadingScreen();
        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        lblLoadingIcon.setVisible(false);
    }

    public LogInForm(String logout) {
        initComponents();
        s = logout;
        db.createTable();
        changeIcon();
        designProgressBar();
        setLoginLocation();
        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        lblLoadingIcon.setVisible(false);
        txtusername.requestFocus();
    }

    private void designProgressBar() {
        load.setUI(new BasicProgressBarUI() {

        });
    }

    private void setLoginLocation() {
        jPanel3.add(pnlLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -335, 850, 330));
        jPanel3.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 850, 330));
        
        txtusername.requestFocus();
    }

    public void changeIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Frame-Logo.png")));
    }

    private void loadingScreen() {
        Thread log = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 21; i++) {
                        Thread.sleep(100);
                        load.setValue(i);
                        lblLoading.setText(i + "%");
                        if (i == 1) {
                            lblLoadText.setText("Launching System . . .");
                        } else if (i == 10) {
                            lblLoadText.setText("Preparing Login . . .");
                        }
                    }
                    Thread.sleep(200);
                    lblLoadText.setText("");
                    for (int height = 330; height >= 0; height -= 5) {
                        Thread.sleep(0);
                        int xLoading = pnlLoading.getX();
                        int yLoading = pnlLoading.getY() - 5;
                        int xLogin = pnlLogin.getX();
                        int yLogin = pnlLogin.getY() - 5;

                        pnlLoading.setLocation(xLoading, yLoading);
                        pnlLogin.setLocation(xLogin, yLogin);
                    }
                    setLoginLocation();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        log.start();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        btnexit = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnsignin = new javax.swing.JLabel();
        lblShowPassword = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblsignup = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblLoadingIcon = new javax.swing.JLabel();
        pnlLoading = new javax.swing.JPanel();
        lblLoading = new javax.swing.JLabel();
        load = new javax.swing.JProgressBar();
        lblLoadText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(138, 102, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(226, 200, 171));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(226, 200, 171));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(226, 200, 171));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnexit.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnexit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnexit.setText("   Exit");
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });
        pnlLogin.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 90, 40));

        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtpassword.setBorder(null);
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        pnlLogin.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 330, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("username:");
        pnlLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -10, 140, 50));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("password:");
        pnlLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 140, 50));

        txtusername.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtusername.setBorder(null);
        txtusername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlLogin.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 380, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields.png"))); // NOI18N
        jLabel5.setText("jLabel3");
        pnlLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 430, 64));

        btnsignin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnsignin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnsignin.setText("Login");
        btnsignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsigninMouseClicked(evt);
            }
        });
        pnlLogin.add(btnsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 90, 40));

        lblShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/show password.png"))); // NOI18N
        lblShowPassword.setText("jLabel3");
        lblShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowPasswordMouseClicked(evt);
            }
        });
        pnlLogin.add(lblShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 60, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        pnlLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 430, 64));

        lblsignup.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblsignup.setText("Sign up?");
        lblsignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblsignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsignupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblsignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblsignupMouseExited(evt);
            }
        });
        pnlLogin.add(lblsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 80, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttonborder.png"))); // NOI18N
        jLabel8.setText("jLabel7");
        pnlLogin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 90, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttonborder.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        pnlLogin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 90, 40));

        lblLoadingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/loading2.gif"))); // NOI18N
        pnlLogin.add(lblLoadingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 22, 22));

        jPanel3.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 850, 330));

        pnlLoading.setBackground(new java.awt.Color(226, 200, 171));
        pnlLoading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLoading.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setText("0%");
        pnlLoading.add(lblLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 500, 20));

        load.setBackground(new java.awt.Color(226, 200, 171));
        load.setForeground(new java.awt.Color(138, 102, 63));
        pnlLoading.add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 500, 3));

        lblLoadText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlLoading.add(lblLoadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 124, 500, 20));

        jPanel3.add(pnlLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 330));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 850, 330));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 100));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 860, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 880, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblsignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsignupMouseEntered
        lblsignup.setText("<html><u>Sign up?</u></html>");
        lblsignup.setForeground(Color.RED);
    }//GEN-LAST:event_lblsignupMouseEntered

    private void lblsignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsignupMouseExited
        lblsignup.setText("Sign up?");
        lblsignup.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblsignupMouseExited

    private void lblsignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsignupMouseClicked
        new SignUpForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblsignupMouseClicked

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        signin();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void lblShowPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPasswordMouseClicked
        char c = txtpassword.getEchoChar();
        if (c == '*') {
            txtpassword.setEchoChar((char) 0);
            lblShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hide password.png")));
        } else {
            txtpassword.setEchoChar('*');
            lblShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/show password.png")));
        }

    }//GEN-LAST:event_lblShowPasswordMouseClicked

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        int ex = JOptionPane.showConfirmDialog(null, "Confirm exit?", "exit", JOptionPane.OK_CANCEL_OPTION);
        if (ex == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitMouseClicked

    private void btnsigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsigninMouseClicked
        signin();
    }//GEN-LAST:event_btnsigninMouseClicked

    private void signin() {
        this.requestFocus();
        Thread login = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String username = txtusername.getText();
                    String password = txtpassword.getText();
                    btnsignin.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

                    btnsignin.setForeground(new java.awt.Color(153, 153, 153));
                    btnsignin.setText("logging in...");
                    btnsignin.setEnabled(false);
                    lblLoadingIcon.setVisible(true);

                    Thread.sleep(500);

                    btnsignin.setFont(new java.awt.Font("Dialog", 1, 24));
                    btnsignin.setForeground(Color.BLACK);
                    btnsignin.setText("Login");
                    btnsignin.setEnabled(true);
                    lblLoadingIcon.setVisible(false);

                    String user[] = lms.signIn(username, password);

                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                        txtusername.setText("");
                        txtpassword.setText("");
                        txtusername.requestFocus();

                    } else {
                        if (user[4].equals("DEACTIVATED")) {
                            JOptionPane.showMessageDialog(null, "account deactivated. Contact an admin to reactivate your account", "Error", JOptionPane.ERROR_MESSAGE);
                            txtusername.setText("");
                            txtpassword.setText("");
                            txtusername.requestFocus();

                            return;
                        }
                        
                        int id = Integer.parseInt(user[0]);
                        for (int height = 0; height <= 330; height += 5) {
                            Thread.sleep(0);
                            int xLoading = pnlLoading.getX();
                            int yLoading = pnlLoading.getY() + 5;
                            int xLogin = pnlLogin.getX();
                            int yLogin = pnlLogin.getY() + 5;

                            pnlLoading.setLocation(xLoading, yLoading);
                            pnlLogin.setLocation(xLogin, yLogin);
                        }
                        jPanel3.add(pnlLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 330));
                        jPanel3.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 850, 330));

                        Thread.sleep(200);
                        for (int i = 20; i < 101; i++) {
                            Thread.sleep(50);
                            load.setValue(i);
                            lblLoading.setText(i + "%");
                            if (i == 21) {
                                lblLoadText.setText("Fetching " + user[3] + " data from database . . .");
                            } else if (i == 40) {
                                lblLoadText.setText("Preparing " + user[3] + " UI . . .");
                            } else if (i == 60) {
                                lblLoadText.setText("Fetching Books from database . . .");
                            } else if (i == 80) {
                                lblLoadText.setText("Fetching Transactions . . .");
                            } else if (i == 100) {
                                lblLoadText.setText("Launching " + user[3] + " UI . . .");
                            }
                        }
                        if (user[3].equals("Student")) {
                            new UserPage(id, user[1], user[2]).setVisible(true);
                        } else {
                            new AdminPage(id, user[1], user[2]).setVisible(true);
                        }

                        dispose();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        login.start();

    }

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
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnexit;
    private javax.swing.JLabel btnsignin;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lblLoadText;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblLoadingIcon;
    private javax.swing.JLabel lblShowPassword;
    private javax.swing.JLabel lblsignup;
    private javax.swing.JProgressBar load;
    private javax.swing.JPanel pnlLoading;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}

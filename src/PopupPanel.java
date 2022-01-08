
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class PopupPanel extends javax.swing.JFrame {

    /**
     * Creates new form PopupPanel
     */
    public PopupPanel() {
        initComponents();
    }
    
    int id;
    String title;
    String data[][];
    String data2[][];
    JPanel box[];
    JLabel message[];
    JLabel lbldate[];
    JScrollPane scroller;
    int notifID[];
    JPanel bigBox;
    JLabel receiver[];
    
    SqlQueries queries;
    
    public PopupPanel(JFrame frame, int x, String title, int id){
        initComponents();
        setPosition(x);
        this.title = title;
        this.id = id;
        queries = new SqlQueries();
        data = queries.getNotifications(id);
        //data2 = queries.getMessages(id);
        if (title.equals("Notifications")) {
            box = new JPanel[data.length];
            lbldate = new JLabel[data.length];
            message = new JLabel[data.length];
            notifID = new int[data.length];
            receiver = new JLabel[data.length];
        }
//        else{
//            box = new JPanel[data2.length];
//            lbldate = new JLabel[data2.length];
//            message = new JLabel[data2.length];
//            notifID = new int[data2.length];
//            receiver = new JLabel[data2.length];
//        }
        
        getData();
    }
    
    private void setPosition(int x){
        int xPosition = x - 250;
        this.setBounds(xPosition,130,343, 455);
    }
    
    public void visibility(){
        this.setVisible(!this.isVisible());
    }
    
    private void getData(){
        lblTitle.setText(title);
        bigBox = new JPanel();
        scroller = new JScrollPane();
        scroller.setMaximumSize(new java.awt.Dimension(340, 410));

        javax.swing.GroupLayout bigBoxLayout = new javax.swing.GroupLayout(bigBox);
        bigBox.setLayout(bigBoxLayout);
        bigBoxLayout.setHorizontalGroup(
            bigBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        bigBoxLayout.setVerticalGroup(
            bigBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        bigBox.setLayout(new BoxLayout(bigBox, BoxLayout.PAGE_AXIS));
        scroller.setViewportView(bigBox);
        scroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel3.add(scroller, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 340, 410));
        
        if(title.equals("Notifications")){
            lblMore.setText(". . .");
            for (int i = 0; i < data.length; i++){
                String[] row = new String[4];
                row[0] = data[i][0];
                row[1] = data[i][1];
                row[2] = data[i][2];
                row[3] = data[i][3];
                boxNotif(row, i);
            }
        }//else{
//            lblMore.setText("See all Messages");
//            for (int x = 0; x < data2.length; x++){
//                String[] row = new String[6];
//                
//                
//                row[0] = data2[x][0];
//                row[1] = data2[x][1];
//                row[2] = data2[x][2];
//                row[3] = data2[x][3];
//                row[4] = data2[x][4];
//                row[5] = data2[x][5];
//                boxMessage(row, x);
//            }
//        }
    }
    
    private void boxMessage(String[] row, int i){
        box[i] = new JPanel();
        lbldate[i] = new JLabel();
        message[i] = new JLabel();
        notifID[i] = Integer.parseInt(row[0]);
        receiver[i] = new JLabel();
        
        box[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        box[i].setPreferredSize(new java.awt.Dimension(320, 40));
        box[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].setBackground(new java.awt.Color(255, 255, 255));
        box[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        receiver[i].setFont(new java.awt.Font("Dialog", 0, 12));
        receiver[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiver[i].setText(row[2]);
        receiver[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].add(receiver[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));
        
        message[i].setFont(new java.awt.Font("Dialog", 0, 12));
        message[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        message[i].setText(row[3]);
        message[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].add(message[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 250, 20));
        
        lbldate[i].setFont(new java.awt.Font("Dialog", 0, 10));
        lbldate[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldate[i].setText(row[4]);
        lbldate[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].add(lbldate[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 70, 20));
        
    }
    
    private void boxNotif(String row[], int i){
        box[i] = new JPanel();
        lbldate[i] = new JLabel();
        message[i] = new JLabel();
        notifID[i] = Integer.parseInt(row[0]);
        
        box[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        box[i].setPreferredSize(new java.awt.Dimension(320, 40));
        box[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].setBackground(new java.awt.Color(255, 255, 255));
        box[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        lbldate[i].setFont(new java.awt.Font("Dialog", 0, 11));
        lbldate[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldate[i].setText(row[2]);
        lbldate[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].add(lbldate[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 2, 80, 10));

        message[i].setFont(new java.awt.Font("Dialog", 0, 12));
        message[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message[i].setText(row[1]);
        message[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box[i].add(message[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 320, 30));
        if(row[3].equals("UNREAD")){
            lbldate[i].setFont(new java.awt.Font("Dialog", 1, 11));
            message[i].setFont(new java.awt.Font("Dialog", 1, 14));
        }else{
            lbldate[i].setFont(new java.awt.Font("Dialog", 0, 11));
            message[i].setFont(new java.awt.Font("Dialog", 0, 14));
        }
        
        bigBox.add(box[i]);
        
        box[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifBoxClicked(i);
            }
        });
        
        lbldate[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifBoxClicked(i);
            }
        });
        
        message[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifBoxClicked(i);
            }
        });
        
        box[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxEntered(i);
            }
        });
        
        lbldate[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxEntered(i);
            }
        });
        
        message[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxEntered(i);
            }
        });
        
        box[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxExited(i);
            }
        });
        
        lbldate[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxExited(i);
            }
        });
        
        message[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxExited(i);
            }
        });
    }
    
    public void notifBoxClicked(int i){
        queries.readNotif(notifID[i]);
        lbldate[i].setFont(new java.awt.Font("Dialog", 0, 11));
        message[i].setFont(new java.awt.Font("Dialog", 0, 14));
    }
    
    public void boxEntered(int i){
        box[i].setBackground(new java.awt.Color(224, 224, 224));
    }
    
    public void boxExited(int i){
        box[i].setBackground(new java.awt.Color(255, 255, 255));
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Notifications");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 340, 20));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 340, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMore.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMore.setText("jLabel1");
        jPanel2.add(lblMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 20));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 433, 340, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 346, 456));

        setBounds(0, 0, 352, 456);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PopupPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblMore;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}

package college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanay
 */
public class DashboardHod extends javax.swing.JFrame {

    String UserID,loginAs;
    public DashboardHod(String _UserID,String _loginAs) {
        this.UserID = _UserID;
        this.loginAs=_loginAs;
        initComponents();
        String Account;
        if(loginAs.equals(" loginstudent "))
        {
            Account="Student";
        }
        else
        {
            Account="Teacher";
        }
        
        
         try
        {
             //setup connection with database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college","root","TANay@99");
            
            PreparedStatement stmt=con.prepareStatement
            ("select *,datediff(curdate(),dob) from "+Account+" where UserID = ?");
            stmt.setString(1, UserID);
            
            PreparedStatement stmt1=con.prepareStatement
            ("select count(userid) from loginteacher where status=0");
             ResultSet rs1=stmt1.executeQuery();
             while(rs1.next())
             {
                 int PendingTeacher=rs1.getInt(1);
                 PreparedStatement stmt2=con.prepareStatement
                ("select count(userid) from loginstudent where status=0");
                 ResultSet rs2=stmt2.executeQuery();
                   while(rs2.next())
                 {
                     int PendingStudent=rs2.getInt(1);
                     PendingTeacher+=PendingStudent;
                     jLabel24.setText(String.valueOf(PendingTeacher));
                 }
             }
                    
            
            
            String _title="";
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
            
            
            jLabel10.setText(rs.getString(9));  //qualification
            jLabel19.setText(rs.getString(7));  //designation
            jLabel11.setText(rs.getString(8)+" years");  //Experience
            jLabel15.setText(rs.getString(1));   //username
            jLabel29.setText(rs.getString(2));  //teacherID
            jLabel26.setText(rs.getString(6));  //contact no.
            if(rs.getString(11).equals("Male"))
            {
                 _title="Mr.";
            }
            else
            {
                 _title="Mrs.";
            }
            jLabel9.setText(_title+" "+rs.getString(3)+"  "+rs.getString(5)+"  "+rs.getString(4));//name and title
            
            int days=rs.getInt(13);
            int years=days/365;
            jLabel13.setText(String.valueOf(years)+" years");
            }
     }
         catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,
                "Unable to connect to database.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel3.setText("Username    :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1310, 420, 190, 50);

        jLabel4.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel4.setText("Admission ID :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1960, -140, 210, 50);

        jLabel5.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel5.setText("Qualification :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1310, 260, 210, 50);

        jLabel6.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel6.setText("Experience   :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1310, 330, 200, 60);

        jLabel7.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel7.setText("Age                :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1310, 500, 200, 40);

        jLabel8.setFont(new java.awt.Font("HP Simplified Light", 0, 48)); // NOI18N
        jLabel8.setText("Hello,");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 30, 120, 60);

        jLabel9.setFont(new java.awt.Font("HP Simplified Light", 0, 70)); // NOI18N
        jLabel9.setText("Tanay Dharmendra Patel");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 110, 890, 100);

        jLabel10.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel10.setText("Third year (TE.)");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(1530, 260, 290, 60);

        jLabel11.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel11.setText("02");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(1530, 330, 280, 60);

        jLabel13.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel13.setText("20");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(1530, 490, 310, 60);

        jLabel14.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel14.setText("1234/ABCD");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(2180, -150, 230, 70);

        jLabel15.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel15.setText("HOD");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(1530, 420, 320, 50);

        jLabel16.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel16.setText("Contact         : ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(1310, 650, 200, 40);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jButton1.setText("Results");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(460, 450, 310, 60);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jButton2.setText("Teacher's details");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 570, 310, 60);

        jLabel18.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel18.setText("Designation : ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(1310, 190, 210, 50);

        jLabel19.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel19.setText("Head of department");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(1530, 190, 310, 50);

        jLabel20.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel20.setText("My details :");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(1280, 120, 170, 40);

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tanay\\Downloads\\logout.png")); // NOI18N
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        jPanel1.add(jLabel21);
        jLabel21.setBounds(30, 20, 60, 60);

        jLabel22.setText("Logout");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(50, 70, 48, 16);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jButton3.setText("Review application");
        jButton3.setPreferredSize(new java.awt.Dimension(403, 57));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(670, 340, 310, 60);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jButton4.setText("Notice board");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(260, 340, 310, 60);

        jLabel23.setFont(new java.awt.Font("HP Simplified Light", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Pending :");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel23);
        jLabel23.setBounds(900, 400, 80, 30);

        jLabel24.setFont(new java.awt.Font("HP Simplified Light", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("0");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel24);
        jLabel24.setBounds(970, 400, 30, 20);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jButton5.setText("Student's details");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(670, 570, 310, 60);

        jLabel26.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel26.setText("9403130058");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(1530, 640, 240, 60);

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tanay\\Downloads\\logout.png")); // NOI18N
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel27);
        jLabel27.setBounds(30, 20, 60, 60);

        jLabel28.setText("Logout");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(50, 70, 48, 16);

        jLabel12.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jLabel12.setText("Teacher ID    :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(1310, 560, 220, 70);

        jLabel29.setFont(new java.awt.Font("HP Simplified Light", 0, 36)); // NOI18N
        jPanel1.add(jLabel29);
        jLabel29.setBounds(1540, 560, 270, 70);

        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1280, 170, 560, 560);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tanay\\Desktop\\Final\\Background.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        Login l=new Login();
        l.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MousePressed
 
    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
       TeacherNoticeboard n = new TeacherNoticeboard(UserID,loginAs);
       n.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        ReviewApplication r=new ReviewApplication(UserID,loginAs);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        //Redirect to common result filter page
        StudentsDetail1 s = new StudentsDetail1(UserID,loginAs);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
       StudentsDetail2 s2 = new StudentsDetail2(UserID,loginAs);
        s2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        TeacherDetails t = new TeacherDetails(UserID,loginAs);
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MousePressed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

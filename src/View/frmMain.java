/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package View;

import View.QuanLy.frmQLThucDon;
import View.QuanLy.frmQLNhanVien;
import View.QuanLy.frmQLHangHoa;
import POJO.NhanVien;
import UIS.Auth;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.WindowConstants;

/**
 *
 * @author Nham Ngo
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    NhanVien nv;

    public frmMain() {
        initComponents();
        this.setLocationRelativeTo(null);

//        if(Auth.isManager())
//        {
//            btnQuanLy.setVisible(true);
//        }
//        else
//            btnQuanLy.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        btnQuanLy = new javax.swing.JMenu();
        menuItemQLFood = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(56, 13));

        desktopPane.setPreferredSize(new java.awt.Dimension(1154, 623));

        btnQuanLy.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-manager-20.png")); // NOI18N
        btnQuanLy.setMnemonic('f');
        btnQuanLy.setText("Quản lý");

        menuItemQLFood.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemQLFood.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-menu-20.png")); // NOI18N
        menuItemQLFood.setMnemonic('o');
        menuItemQLFood.setText("Thực đơn");
        menuItemQLFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemQLFoodMouseClicked(evt);
            }
        });
        menuItemQLFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQLFoodActionPerformed(evt);
            }
        });
        btnQuanLy.add(menuItemQLFood);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-port-20.png")); // NOI18N
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Nhập xuất kho");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        btnQuanLy.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveAsMenuItem.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-paid-bill-20.png")); // NOI18N
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Hóa đơn");
        btnQuanLy.add(saveAsMenuItem);

        jMenu1.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-staff-20.png")); // NOI18N
        jMenu1.setText("Nhân Viên");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-statistics-20.png")); // NOI18N
        jMenuItem1.setText("Thông kê");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Quản lý");
        jMenu1.add(jMenuItem2);

        btnQuanLy.add(jMenu1);

        menuBar.add(btnQuanLy);

        editMenu.setMnemonic('e');
        editMenu.setText("Tài khoản");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Thông tin tài khoản");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Đăng xuất");
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu2.setText("Đặt bàn");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemQLFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemQLFoodMouseClicked
        frmQLThucDon frm = new frmQLThucDon();
        frm.setVisible(true);
        frm.setBounds(50, 50, 500, 400);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout());
        this.desktopPane.add(frm);
    }//GEN-LAST:event_menuItemQLFoodMouseClicked

    private void menuItemQLFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQLFoodActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        frmQLThucDon frm = new frmQLThucDon();
        frm.pack();
        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_menuItemQLFoodActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        desktopPane.removeAll();
        frmQLNhanVien frm = new frmQLNhanVien();
        frm.pack();
        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        frmQLHangHoa frm = new frmQLHangHoa();
        frm.pack();
        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here
        desktopPane.removeAll();
        frmDatBan frm = new frmDatBan();
        frm.pack();
        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu btnQuanLy;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemQLFood;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}

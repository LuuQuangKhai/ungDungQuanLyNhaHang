/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Custom.MyFileChooser;
import DAO.LoaiThucDonDAO;
import DAO.ThucDonDAO;
import POJO.LoaiThucDon;
import POJO.MyComboBox;
import POJO.ThucDon;
import UIS.MsgBox;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nham Ngo
 */
public class frmFood extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmFood
     */
    ThucDonDAO dao;
    LoaiThucDonDAO ltdDao;
    File fileAnhSP;
    
    
    //Thêm
    void insert()
    {
        
    }
    //Xóa
    //Sữa
    
    public frmFood() {
        initComponents();
        tbMenu.getColumnModel().getColumn(4).setWidth(0);
        tbMenu.getColumnModel().getColumn(4).setMinWidth(0);
        tbMenu.getColumnModel().getColumn(4).setMaxWidth(0);
        dao = new ThucDonDAO();
        ltdDao = new LoaiThucDonDAO();
        fillToTable(dao.selectAll());
        loadToCbo();
        selectTable();
    }
    ThucDon getForm() {
        ThucDon td = new ThucDon();
        td.setMaMon(txtMaMon.getText());
        td.setTenMon(txtTenMon.getText());
        td.setGiaTien(Float.parseFloat(txtGia.getText()));
        LoaiThucDon a=(LoaiThucDon) cboLoai.getSelectedItem();
        td.setLoai(a.getMaLoaiTD());
        td.setHinhAnh(String.valueOf(fileAnhSP.getName()));
        return td;
    }
    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File(src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("image/SanPham/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File(src);
        } catch (IOException e) {
            fileAnhSP = new File("imgs/anhthe/avatar.jpg");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(130, 117, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }

        return null;
    }

    private void luuFileAnh() {
        BufferedImage bImage = null;
        try {
            File initialImage = new File(fileAnhSP.getPath());
            bImage = ImageIO.read(initialImage);

            ImageIO.write(bImage, "png", new File("image/SanPham/" + fileAnhSP.getName()));

        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
    }

    private void xuLyChonAnh() {
        JFileChooser fileChooser = new MyFileChooser("image/SanPham/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Tệp hình ảnh", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileAnhSP = fileChooser.getSelectedFile();
            txtImg.setIcon(getAnhSP(fileAnhSP.getPath()));
        }
    }

    void fillToTable(List<ThucDon> a) {
        DefaultTableModel model = (DefaultTableModel) tbMenu.getModel();
        model.setRowCount(0);
        for (ThucDon p : a) {
            model.addRow(new Object[]{p.getMaMon(), p.getTenMon(), p.getGiaTien(), ltdDao.selectById(p.getLoai()), p.getHinhAnh()});
        }
    }

    void loadToCbo() {
        DefaultComboBoxModel def = (DefaultComboBoxModel) cboLoai.getModel();
        def.removeAllElements();
        try {
            for (LoaiThucDon ls : ltdDao.selectAll()) {

                def.addElement(ls);
            }
        } catch (Exception e) {
        }
    }

    private ImageIcon loadImage(String tenHinh) {

        ImageIcon ii = new ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\Img\\" + tenHinh);
        return ii;
    }

    boolean checkVal() {
        if (txtMaMon.getText().isEmpty() || txtMaMon.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập mã món ăn!");
            return false;
        } else if (txtMaMon.getText().length() > 3) {
            MsgBox.alert(this, "Mã món ăn tối đa chỉ 3 ký tự!");
            return false;
        }

        if (dao.selectById(txtMaMon.getText()) != null) {
            MsgBox.alert(this, "Mã Món Ăn Này Đã Tồn Tại");
            return false;
        }

        if (txtTenMon.getText().isEmpty() || txtTenMon.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập tên món ăn!");
            return false;
        }
        if (txtGia.getText().isEmpty() || txtGia.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập giá món ăn!");
            return false;
        }
        try {
            Float.valueOf(txtGia.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Giá món ăn không đúng định dạng");
            return false;
        }
        if (cboLoai.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Bạn chưa chọn loại món ăn!");
            return false;
        }
        return true;
    }

    void selectTable() {
        tbMenu.setCellSelectionEnabled(true);
        ListSelectionModel select = tbMenu.getSelectionModel();
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tbMenu.getSelectedRow();
                txtMaMon.setText((String) tbMenu.getValueAt(row, 0));
                txtTenMon.setText((String) tbMenu.getValueAt(row, 1));
                txtGia.setText(String.valueOf(tbMenu.getValueAt(row, 2)));
                LoaiThucDon a = (LoaiThucDon) tbMenu.getValueAt(row, 3);

                int width = 130; // chiều rộng mong muốn của JLabel
                int height = 117; // chiều cao mong muốn của JLabel
                Image img = loadImage(String.valueOf(tbMenu.getValueAt(row, 4))).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                txtImg.setIcon(new ImageIcon(img));
                cboLoai.setSelectedItem(a);
                cboLoai.setSelectedIndex(a.getMaLoaiTD() - 1);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cboLoai = new javax.swing.JComboBox<>();
        pnImage = new javax.swing.JPanel();
        txtImg = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMenu = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInportEX = new javax.swing.JButton();
        btnExPortEX = new javax.swing.JButton();

        setClosable(true);
        setTitle("Quản lý sản phẩm");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel1.setText("QUẢN LÝ THỰC ĐƠN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã món:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên món:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá thành:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Loại:");

        pnImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnImageLayout = new javax.swing.GroupLayout(pnImage);
        pnImage.setLayout(pnImageLayout);
        pnImageLayout.setHorizontalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnImageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnImageLayout.setVerticalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtImg, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        btnChooseImage.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-pictures-folder-20.png")); // NOI18N
        btnChooseImage.setText("Chọn ảnh");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        jLabel3.setText("Tìm kiếm");

        txtSearch.setPreferredSize(new java.awt.Dimension(104, 27));

        btnSearch.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-magnifying-glass-tilted-left-20.png")); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setRowHeaderView(null);

        tbMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã món", "Tên món", "Giá thành", "Loại", "Title 5"
            }
        ));
        tbMenu.setRowSelectionAllowed(false);
        tbMenu.setShowGrid(true);
        jScrollPane1.setViewportView(tbMenu);

        btnInsert.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-plus-20.png")); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-cancel-20.png")); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.setPreferredSize(new java.awt.Dimension(84, 27));

        btnUpdate.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-edit-20.png")); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setPreferredSize(new java.awt.Dimension(84, 27));

        btnInportEX.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-import-csv-20.png")); // NOI18N
        btnInportEX.setText("Nhập");
        btnInportEX.setPreferredSize(new java.awt.Dimension(84, 27));

        btnExPortEX.setIcon(new javax.swing.ImageIcon("D:\\Learn\\period 2\\Java\\QuanLyNhaHangg\\src\\Assets\\icons\\icons8-export-csv-20.png")); // NOI18N
        btnExPortEX.setText("Xuất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(btnInportEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addComponent(btnExPortEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnSearch))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(63, 63, 63)
                                .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtGia))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(pnImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(btnChooseImage)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(btnSearch)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseImage))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInportEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExPortEX))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (dao.FIND_ThucDon(String.valueOf("%" + txtSearch.getText() + "%")) == null)
            MsgBox.alert(this, "Không tộn tại thực đơn");
        else
            fillToTable(dao.FIND_ThucDon(String.valueOf("%" + txtSearch.getText() + "%")));
    }//GEN-LAST:event_btnSearchActionPerformed
//    private ThucDon getThucDonByText()
//    {
//        ThucDon a=new ThucDon();
//        
//    }
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        // TODO add your handling code here:
        xuLyChonAnh();
    }//GEN-LAST:event_btnChooseImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnExPortEX;
    private javax.swing.JButton btnInportEX;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnImage;
    private javax.swing.JTable tbMenu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JLabel txtImg;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}

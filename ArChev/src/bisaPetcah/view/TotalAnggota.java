package bisaPetcah.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import bisaPetcah.auth.Auth;
import bisaPetcah.model.Design;
import bisaPetcah.model.member.Member;
import bisaPetcah.model.member.MemberService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author bisa_petcah
 */
public class TotalAnggota extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    MemberService memberService = new MemberService();

    /**
     * Creates new form Dashboard
     */
    public TotalAnggota() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        initUsername();
        initTable();
    }
    
    public void initUsername() {
        tvUsername.setText(Auth.getNama());
    }

    public void initTable() {
        String[] header = {
            "Nomor", "Nama", "Email", "Divisi", "Angkatan", "Status"
        };

        tableModel = new DefaultTableModel(header, 0);
        table.setModel(tableModel);
        tampilAll();
    }

    public void tampilAll() {
        int i = 1;
        ArrayList<Member> dataAnggota = memberService.order("divisi_id");
        for (Member data : dataAnggota) {
            addDataToTable(i++, data);
        }
    }

    public boolean tampilWithData(ArrayList<Member> dataAnggota) {
        int i = 1;
        for (Member data : dataAnggota) {
            addDataToTable(i++, data);
        }
        return dataAnggota.size() > 0;
    }

    public void updateTable() {
        tableModel.setNumRows(0);
        tampilAll();
    }

    public void addDataToTable(int counter, Member member) {
        String[] data = {
            String.valueOf(counter), member.getNama(), member.getEmail(), member.getNama_divisi(), member.getTahun_angkatan(), member.getStatus()
        };
        tableModel.addRow(data);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dashboard = new javax.swing.JPanel();
        tvUsername = new javax.swing.JLabel();
        tvRole = new javax.swing.JLabel();
        panelSideBarMenu = new javax.swing.JPanel();
        panelInput = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        txtDashboard = new javax.swing.JLabel();
        btnTotalAnggota = new javax.swing.JPanel();
        txtTotalAnggota = new javax.swing.JLabel();
        btnAnggotaAktif = new javax.swing.JPanel();
        txtAnggotaAktif = new javax.swing.JLabel();
        btnAnggotaPasif = new javax.swing.JPanel();
        txtAnggotaPasif = new javax.swing.JLabel();
        btnDivisi = new javax.swing.JPanel();
        txtDivisi = new javax.swing.JLabel();
        panelLog = new javax.swing.JPanel();
        btnLogout = new javax.swing.JPanel();
        txtLogout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logoArchev = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnTambahAnggota = new javax.swing.JButton();
        edtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArChev");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard.setBackground(new java.awt.Color(229, 229, 229));

        tvUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tvUsername.setText("Username");

        tvRole.setText("Admin");

        panelSideBarMenu.setBackground(new java.awt.Color(153, 153, 153));

        panelInput.setBackground(new java.awt.Color(255, 255, 255));

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardMouseExited(evt);
            }
        });

        txtDashboard.setBackground(new java.awt.Color(255, 255, 255));
        txtDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-dashboard.png"))); // NOI18N
        txtDashboard.setText("Dashboard");

        javax.swing.GroupLayout btnDashboardLayout = new javax.swing.GroupLayout(btnDashboard);
        btnDashboard.setLayout(btnDashboardLayout);
        btnDashboardLayout.setHorizontalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnDashboardLayout.setVerticalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTotalAnggota.setBackground(new java.awt.Color(248, 164, 0));

        txtTotalAnggota.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalAnggota.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-people.png"))); // NOI18N
        txtTotalAnggota.setText("Total Anggota");

        javax.swing.GroupLayout btnTotalAnggotaLayout = new javax.swing.GroupLayout(btnTotalAnggota);
        btnTotalAnggota.setLayout(btnTotalAnggotaLayout);
        btnTotalAnggotaLayout.setHorizontalGroup(
            btnTotalAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTotalAnggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnTotalAnggotaLayout.setVerticalGroup(
            btnTotalAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTotalAnggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalAnggota)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAnggotaAktif.setBackground(new java.awt.Color(255, 255, 255));
        btnAnggotaAktif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnggotaAktifMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnggotaAktifMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnggotaAktifMouseExited(evt);
            }
        });

        txtAnggotaAktif.setBackground(new java.awt.Color(255, 255, 255));
        txtAnggotaAktif.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAnggotaAktif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-people.png"))); // NOI18N
        txtAnggotaAktif.setText("Anggota Aktif");

        javax.swing.GroupLayout btnAnggotaAktifLayout = new javax.swing.GroupLayout(btnAnggotaAktif);
        btnAnggotaAktif.setLayout(btnAnggotaAktifLayout);
        btnAnggotaAktifLayout.setHorizontalGroup(
            btnAnggotaAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAnggotaAktifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAnggotaAktif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAnggotaAktifLayout.setVerticalGroup(
            btnAnggotaAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAnggotaAktifLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAnggotaAktif)
                .addContainerGap())
        );

        btnAnggotaPasif.setBackground(new java.awt.Color(255, 255, 255));
        btnAnggotaPasif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnggotaPasifMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnggotaPasifMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnggotaPasifMouseExited(evt);
            }
        });

        txtAnggotaPasif.setBackground(new java.awt.Color(255, 255, 255));
        txtAnggotaPasif.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAnggotaPasif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-people.png"))); // NOI18N
        txtAnggotaPasif.setText("Anggota Pasif");

        javax.swing.GroupLayout btnAnggotaPasifLayout = new javax.swing.GroupLayout(btnAnggotaPasif);
        btnAnggotaPasif.setLayout(btnAnggotaPasifLayout);
        btnAnggotaPasifLayout.setHorizontalGroup(
            btnAnggotaPasifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAnggotaPasifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAnggotaPasif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAnggotaPasifLayout.setVerticalGroup(
            btnAnggotaPasifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAnggotaPasifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAnggotaPasif, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDivisi.setBackground(new java.awt.Color(255, 255, 255));
        btnDivisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDivisiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDivisiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDivisiMouseExited(evt);
            }
        });

        txtDivisi.setBackground(new java.awt.Color(255, 255, 255));
        txtDivisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDivisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-divisi.png"))); // NOI18N
        txtDivisi.setText("Divisi");

        javax.swing.GroupLayout btnDivisiLayout = new javax.swing.GroupLayout(btnDivisi);
        btnDivisi.setLayout(btnDivisiLayout);
        btnDivisiLayout.setHorizontalGroup(
            btnDivisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDivisiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDivisi, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        btnDivisiLayout.setVerticalGroup(
            btnDivisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDivisiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDivisi)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnggotaAktif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTotalAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnggotaPasif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTotalAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnggotaAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnggotaPasif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLog.setBackground(new java.awt.Color(255, 255, 255));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });

        txtLogout.setBackground(new java.awt.Color(255, 255, 255));
        txtLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/icon/icon-logout.png"))); // NOI18N
        txtLogout.setText("Logout");

        javax.swing.GroupLayout btnLogoutLayout = new javax.swing.GroupLayout(btnLogout);
        btnLogout.setLayout(btnLogoutLayout);
        btnLogoutLayout.setHorizontalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        btnLogoutLayout.setVerticalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLogLayout = new javax.swing.GroupLayout(panelLog);
        panelLog.setLayout(panelLogLayout);
        panelLogLayout.setHorizontalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLogLayout.setVerticalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        logoArchev.setBackground(new java.awt.Color(255, 255, 255));
        logoArchev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoArchev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/ArChev-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(logoArchev, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(logoArchev, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelSideBarMenuLayout = new javax.swing.GroupLayout(panelSideBarMenu);
        panelSideBarMenu.setLayout(panelSideBarMenuLayout);
        panelSideBarMenuLayout.setHorizontalGroup(
            panelSideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarMenuLayout.createSequentialGroup()
                .addGroup(panelSideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        panelSideBarMenuLayout.setVerticalGroup(
            panelSideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bisaPetcah/images/tab/total_anggota.png"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Email", "Divisi", "Angkatan", "Status"
            }
        ));
        jScrollPane1.setViewportView(table);

        btnTambahAnggota.setBackground(new java.awt.Color(255, 164, 0));
        btnTambahAnggota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambahAnggota.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahAnggota.setText("Tambah Anggota");
        btnTambahAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahAnggotaActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(255, 164, 0));
        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(panelSideBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                        .addGap(0, 332, Short.MAX_VALUE)
                        .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tvUsername)
                                    .addComponent(tvRole, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(322, 322, 322))))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addComponent(edtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTambahAnggota)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSideBarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(tvUsername)
                .addGap(1, 1, 1)
                .addComponent(tvRole)
                .addGap(8, 8, 8)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahAnggota)
                    .addComponent(edtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, -30, 1550, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        Auth.logout();
        ManagePage.next("login");
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Design.btnHover(btnLogout);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Design.btnInActive(btnLogout);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnAnggotaAktifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaAktifMouseEntered
        Design.btnHover(btnAnggotaAktif);
    }//GEN-LAST:event_btnAnggotaAktifMouseEntered

    private void btnAnggotaAktifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaAktifMouseExited
        Design.btnInActive(btnAnggotaAktif);
    }//GEN-LAST:event_btnAnggotaAktifMouseExited

    private void btnAnggotaPasifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaPasifMouseEntered
        Design.btnHover(btnAnggotaPasif);
    }//GEN-LAST:event_btnAnggotaPasifMouseEntered

    private void btnAnggotaPasifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaPasifMouseExited
        Design.btnInActive(btnAnggotaPasif);
    }//GEN-LAST:event_btnAnggotaPasifMouseExited

    private void btnDivisiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDivisiMouseEntered
        Design.btnHover(btnDivisi);
    }//GEN-LAST:event_btnDivisiMouseEntered

    private void btnDivisiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDivisiMouseExited
        Design.btnInActive(btnDivisi);
    }//GEN-LAST:event_btnDivisiMouseExited

    private void btnAnggotaAktifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaAktifMouseClicked
        ManagePage.next("anggota_aktif");
        this.dispose();
    }//GEN-LAST:event_btnAnggotaAktifMouseClicked

    private void btnAnggotaPasifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnggotaPasifMouseClicked
        ManagePage.next("anggota_pasif");
        this.dispose();
    }//GEN-LAST:event_btnAnggotaPasifMouseClicked

    private void btnDivisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDivisiMouseClicked
        ManagePage.next("divisi");
        this.dispose();
    }//GEN-LAST:event_btnDivisiMouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        ManagePage.next("dashboard");
        this.dispose();
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseExited
        Design.btnInActive(btnDashboard);
    }//GEN-LAST:event_btnDashboardMouseExited

    private void btnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseEntered
        Design.btnHover(btnDashboard);
    }//GEN-LAST:event_btnDashboardMouseEntered

    private void btnTambahAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahAnggotaActionPerformed
        ManagePage.next("tambah_anggota");
        this.dispose();
    }//GEN-LAST:event_btnTambahAnggotaActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        tableModel.setNumRows(0);
        if (edtCari.getText().isBlank()) {
            tampilAll();
        } else {
            ArrayList<Member> dataPelanggan = memberService.where("m.nama LIKE '%" + edtCari.getText() + "%'");
            boolean exist = tampilWithData(dataPelanggan);
            if (!exist) {
                JOptionPane.showMessageDialog(this, "Data tidak ada");
            }
        }
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(TotalAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TotalAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TotalAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TotalAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TotalAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel btnAnggotaAktif;
    private javax.swing.JPanel btnAnggotaPasif;
    private javax.swing.JButton btnCari;
    private javax.swing.JPanel btnDashboard;
    private javax.swing.JPanel btnDivisi;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JButton btnTambahAnggota;
    private javax.swing.JPanel btnTotalAnggota;
    private javax.swing.JTextField edtCari;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoArchev;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelLog;
    private javax.swing.JPanel panelSideBarMenu;
    private javax.swing.JTable table;
    private javax.swing.JLabel tvRole;
    private javax.swing.JLabel tvUsername;
    private javax.swing.JLabel txtAnggotaAktif;
    private javax.swing.JLabel txtAnggotaPasif;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtDivisi;
    private javax.swing.JLabel txtLogout;
    private javax.swing.JLabel txtTotalAnggota;
    // End of variables declaration//GEN-END:variables
}

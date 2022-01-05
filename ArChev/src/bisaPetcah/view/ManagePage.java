/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.view;

import java.util.Stack;

/**
 *
 * @author ma39i
 */
public class ManagePage {

    private static Stack<String> pages = new Stack<>();

    public static void next(String page) {
        pages.push(page);
        convertPage(page);
    }

    public static void next(String page, String data) {
        if (page.equals("login")) {
            pages.empty();
        } else {
            pages.push(page);
        }
        convertPage(page, data);
    }

    public static void back() {
        pages.pop();
        String page = pages.peek();
        convertPage(page);
    }

    public static void convertPage(String page) {
        switch (page) {
            case "dashboard":
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                break;
            case "total_anggota":
                TotalAnggota totalAnggota = new TotalAnggota();
                totalAnggota.setVisible(true);
                break;
            case "anggota_aktif":
                AnggotaAktif anggotaAktif = new AnggotaAktif();
                anggotaAktif.setVisible(true);
                break;
            case "anggota_pasif":
                AnggotaPasif anggotaPasif = new AnggotaPasif();
                anggotaPasif.setVisible(true);
                break;
            case "divisi_web":
                AnggotaDivisiWeb divisiWeb = new AnggotaDivisiWeb();
                divisiWeb.setVisible(true);
                break;
            case "divisi_android":
                AnggotaDivisiAndroid divisiAndroid = new AnggotaDivisiAndroid();
                divisiAndroid.setVisible(true);
                break;
            case "divisi_game":
                AnggotaDivisiGame divisiGame = new AnggotaDivisiGame();
                divisiGame.setVisible(true);
                break;
            case "divisi_startup":
                AnggotaDivisiStartup divisiStartup = new AnggotaDivisiStartup();
                divisiStartup.setVisible(true);
                break;
            case "divisi_uiux":
                AnggotaDivisiUIUX divisiUIUX = new AnggotaDivisiUIUX();
                divisiUIUX.setVisible(true);
                break;
            case "register":
                Register register = new Register();
                register.setVisible(true);
                break;
            case "reset_password":
                ResetPassword resetPassword = new ResetPassword();
                resetPassword.setVisible(true);
                break;
            case "tambah_anggota":
                FormTambahAnggota tambahAnggota = new FormTambahAnggota();
                tambahAnggota.setVisible(true);
                break;
            case "login":
                Login login = new Login();
                login.setVisible(true);
                break;
            case "divisi":
                Divisi divisi = new Divisi();
                divisi.setVisible(true);
                break;
        }

    }

    public static void convertPage(String page, String data) {
        switch (page) {
            case "ubah_anggota":
                UbahAnggota ubahAnggota = new UbahAnggota(data);
                ubahAnggota.setVisible(true);
                break;
        }
    }
}

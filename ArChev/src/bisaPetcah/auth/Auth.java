/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.auth;

import bisaPetcah.model.admin.Admin;
import bisaPetcah.model.admin.AdminService;
import java.util.ArrayList;

/**
 *
 * @author ma39i
 */
public class Auth {

    private static AdminService dataAdmin = new AdminService();
    private static boolean auth;
    private static int id;
    private static String nama;
    private static String username;

    private Auth(boolean isAuth, int id, String nama, String username) {
        this.auth = isAuth;
        this.id = id;
        this.nama = nama;
        this.username = username;
    }

    private Auth(boolean isAuth) {
        if (!isAuth) {
            this.auth = isAuth;
            this.id = 0;
            this.nama = null;
            this.username = null;
        }
    }
    
    public static boolean login(String username, String password) {
        ArrayList<Admin> admin = dataAdmin.where("username = '" + username + "'");
        if (admin.size() != 1) {
            return false;
        }

        Admin data = admin.get(0);

        if (!data.getPassword().equals(password)) {
            return false;
        }

        new Auth(true, data.getId(), data.getNama(), data.getUsername());
        return Auth.isAuth();
    }
    
    public static boolean logout() {
        new Auth(false);
        return Auth.isAuth();
    }

    public static boolean isAuth() {
        return auth;
    }

    public static int getId() {
        return id;
    }

    public static String getNama() {
        return nama;
    }

    public static String getUsername() {
        return username;
    }

}

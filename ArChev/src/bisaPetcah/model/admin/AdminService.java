/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model.admin;

import bisaPetcah.database.ConnectionService;
import bisaPetcah.model.Function;
import bisaPetcah.model.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ma39i
 */
public class AdminService extends Service<Admin> {

    public AdminService() {
        this.table = "admin";
    }

    @Override
    public ArrayList<Admin> all() {
        this.listData = new ArrayList<Admin>();
        try {
            ResultSet result = ConnectionService.get("SELECT * FROM " + this.table);

            while (result.next()) {
                this.listData.add(new Admin(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }

    @Override
    public ArrayList<Admin> where(String where) {
        this.listData = new ArrayList<Admin>();
        try {
            ResultSet result = ConnectionService.get("SELECT * FROM " + this.table + " WHERE " + where);

            while (result.next()) {
                this.listData.add(new Admin(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Admin data) {
        String query = "INSERT INTO %s(username, password, nama) VALUES ('%s', '%s', '%s')";
        String password = data.getPassword();
        password = Function.security(password);
        query = String.format(query, this.table, data.getUsername(), password, data.getNama());
        try {
            int created = ConnectionService.query(query);

            if (created > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionService.close();
        }
        return false;
    }

    @Override
    public boolean update(int id, Admin data) {
        try {
            String query = "UPDATE %s SET password = '%s', nama = '%s' WHERE id = %d";
            query = String.format(query, this.table, data.getPassword(), data.getNama(), id);
            int updated = ConnectionService.query(query);

            if (updated > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionService.close();
        }
        return false;
    }

    @Override
    public boolean updateWhere(String where, Admin data) {
        try {
            String query = "UPDATE %s SET password = '%s', nama = '%s' WHERE %s";
            query = String.format(query, this.table, data.getPassword(), data.getNama(), where);
            int updated = ConnectionService.query(query);

            if (updated > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionService.close();
        }
        return false;
    }
}

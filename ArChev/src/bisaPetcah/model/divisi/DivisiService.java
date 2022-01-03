/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model.divisi;

import bisaPetcah.database.ConnectionService;
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
public class DivisiService extends Service<Divisi> {

    public DivisiService() {
        this.table = "divisi";
    }

    @Override
    public ArrayList<Divisi> all() {
        this.listData = new ArrayList<Divisi>();
        try {
            ResultSet result = ConnectionService.get("SELECT * FROM " + this.table);

            while (result.next()) {
                this.listData.add(new Divisi(result.getInt("id"), result.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DivisiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }

    @Override
    public ArrayList<Divisi> where(String where) {
        this.listData = new ArrayList<Divisi>();
        try {
            ResultSet result = ConnectionService.get("SELECT * FROM " + this.table + " WHERE " + where);

            while (result.next()) {
                this.listData.add(new Divisi(result.getInt("id"), result.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DivisiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }

    @Override
    public boolean insert(Divisi data) {
        try {
            String query = "INSERT INTO %s(nama) VALUES ('%s')";
            query = String.format(query, this.table, data.getNama());
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
    public boolean update(int id, Divisi data) {
        try {
            String query = "UPDATE %s SET nama = '%s' WHERE id = %d";
            query = String.format(query, this.table, data.getNama(), id);
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
    public boolean updateWhere(String where, Divisi data) {
        try {
            String query = "UPDATE %s SET nama = '%s' WHERE %s";
            query = String.format(query, this.table, data.getNama(), where);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model;

import bisaPetcah.database.ConnectionService;
import bisaPetcah.model.divisi.Divisi;
import bisaPetcah.model.divisi.DivisiService;
import bisaPetcah.model.member.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ma39i
 */
public abstract class Service<T> {

    public String table;
    public ArrayList listData;

    public abstract ArrayList all();

    public abstract ArrayList where(String where);

    public abstract boolean insert(T data);

    public abstract boolean update(int id, T data);

    public abstract boolean updateWhere(String where, T data);

    public boolean delete(int id) {
        try {
            String query = "DELETE FROM " + this.table + " WHERE id = '" + id + "'";
            int deleted = ConnectionService.query(query);
            if (deleted > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteWhere(String where) {
        try {
            String query = "DELETE FROM " + this.table + " WHERE " + where;
            int deleted = ConnectionService.query(query);
            if (deleted > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public int countAll() {
        try {
            String query = "SELECT COUNT(id) total FROM %s";
            query = String.format(query, this.table);
            ResultSet result = ConnectionService.get(query);

            while (result.next()) {
                return result.getInt("total");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionService.close();
        }
        return 0;
    }
    
    public int countWhere(String where) {
        try {
            String query = "SELECT COUNT(id) total FROM %s WHERE %s";
            query = String.format(query, this.table, where);
            ResultSet result = ConnectionService.get(query);

            while (result.next()) {
                return result.getInt("total");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionService.close();
        }
        return 0;
    }
}

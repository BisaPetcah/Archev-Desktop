/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model;

import bisaPetcah.database.ConnectionService;
import bisaPetcah.model.member.Member;
import java.util.ArrayList;

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

}

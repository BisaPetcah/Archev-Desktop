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
public class DivisiService extends Service {

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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model.member;

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
public class MemberService extends Service {

    public MemberService() {
        this.table = "member";
    }

    @Override
    public ArrayList<Member> all() {
        this.listData = new ArrayList<Member>();
        try {
            ResultSet result = ConnectionService.get("SELECT m.id, m.nama, m.tahun_angkatan, m.email, d.nama divisi, m.status FROM " + this.table + " m INNER JOIN archev_desktop.divisi d ON d.id = m.divisi_id");
            
            while (result.next()) {
                this.listData.add(new Member(result.getInt("id"), result.getString("nama"), result.getString("tahun_angkatan"), result.getString("email"), result.getString("status"), result.getString("divisi")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }

    @Override
    public ArrayList<Member> where(String where) {
        this.listData = new ArrayList<Member>();
        try {
            ResultSet result = ConnectionService.get("SELECT m.id, m.nama, m.tahun_angkatan, m.email, d.nama divisi, m.status FROM " + this.table + " m INNER JOIN archev_desktop.divisi d ON d.id = m.divisi_id WHERE " + where);

            while (result.next()) {
                this.listData.add(new Member(result.getInt("id"), result.getString("nama"), result.getString("tahun_angkatan"), result.getString("email"), result.getString("status"), result.getString("divisi")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionService.close();
        }
        return this.listData;
    }
}

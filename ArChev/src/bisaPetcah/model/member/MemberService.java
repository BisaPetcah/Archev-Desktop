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
public class MemberService extends Service<Member> {

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
    
    public ArrayList<Member> order(String order) {
        this.listData = new ArrayList<Member>();
        try {
            ResultSet result = ConnectionService.get("SELECT m.id, m.nama, m.tahun_angkatan, m.email, d.nama divisi, m.status FROM " + this.table + " m INNER JOIN archev_desktop.divisi d ON d.id = m.divisi_id ORDER BY " + order);

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
            String query = "SELECT m.id, m.nama, m.tahun_angkatan, m.email, d.nama divisi, m.status FROM %s m INNER JOIN archev_desktop.divisi d ON d.id = m.divisi_id WHERE %s";
            query = String.format(query, this.table, where);
            ResultSet result = ConnectionService.get(query);

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
    public boolean insert(Member data) {
        try {
            String query = "INSERT INTO %s(nama, tahun_angkatan, email, divisi_id, status) VALUES ('%s', '%s', '%s', %d, '%s')";
            query = String.format(query, this.table, data.getNama(), data.getTahun_angkatan(), data.getEmail(), data.getDivisi_id(), data.getStatus());
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
    public boolean updateWhere(String where, Member data) {
        try {
            String query = "UPDATE %s SET nama = '%s', tahun_angkatan = '%s', email = '%s', divisi_id = %d, status = '%s' WHERE %s";
            query = String.format(query, this.table, data.getNama(), data.getTahun_angkatan(), data.getEmail(), data.getDivisi_id(), data.getStatus(), where);
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
    public boolean update(int id, Member data) {
        try {
            String query = "UPDATE %s SET nama = '%s', tahun_angkatan = '%s', email = '%s', divisi_id = %d, status = '%s' WHERE id = %d";
            query = String.format(query, this.table, data.getNama(), data.getTahun_angkatan(), data.getEmail(), data.getDivisi_id(), data.getStatus(), id);
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

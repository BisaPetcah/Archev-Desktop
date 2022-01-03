/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model.member;

/**
 *
 * @author ma39i
 */
public class Member {
    private int id;
    private String nama;
    private String tahun_angkatan;
    private String email;
    private String status;
    private int divisi_id;
    private String nama_divisi;

    public Member(int id, String nama, String tahun_angkatan, String email, String status, int divisi_id) {
        this.id = id;
        this.nama = nama;
        this.tahun_angkatan = tahun_angkatan;
        this.email = email;
        this.status = status;
        this.divisi_id = divisi_id;
    }
    
    public Member(String nama, String tahun_angkatan, String email, String status, int divisi_id) {
        this.nama = nama;
        this.tahun_angkatan = tahun_angkatan;
        this.email = email;
        this.status = status;
        this.divisi_id = divisi_id;
    }
    
    public Member(int id, String nama, String tahun_angkatan, String email, String status, String divisi) {
        this.id = id;
        this.nama = nama;
        this.tahun_angkatan = tahun_angkatan;
        this.email = email;
        this.status = status;
        this.nama_divisi = divisi;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTahun_angkatan() {
        return tahun_angkatan;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public int getDivisi_id() {
        return divisi_id;
    }

    public String getNama_divisi() {
        return nama_divisi;
    }
    
}

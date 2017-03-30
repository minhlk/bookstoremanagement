/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MKZ
 */
public class SACHDTO {
    int idSach,soLuong,giaBan;
    String tenSach,tacGia;

    @Override
    public String toString() {
        return "SACHDTO{" + "idSach=" + idSach + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", tenSach=" + tenSach + ", tacGia=" + tacGia + '}';
    }
    
    public SACHDTO(int idSach, int soLuong, int giaBan, String tenSach, String tacGia) {
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
    }
    public SACHDTO(int soLuong, int giaBan, String tenSach, String tacGia) {
//        this.idSach = idSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
    }
    public SACHDTO() {
//         this.idSach = idSach;
        this.soLuong = 0;
        this.giaBan = 0;
        this.tenSach = "";
        this.tacGia = "";
    }

    
    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    
}

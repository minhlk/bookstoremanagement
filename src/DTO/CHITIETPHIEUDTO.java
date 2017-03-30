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
public class CHITIETPHIEUDTO {
   int idPhieu,idSach,soLuong,giaMua;
   String tenSach;

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public CHITIETPHIEUDTO(int idPhieu, int idSach, int soLuong, int giaMua) {
        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
    }
    public CHITIETPHIEUDTO(int idSach, int soLuong, int giaMua) {
        this.idPhieu = 0;
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
    }
    public CHITIETPHIEUDTO(int idPhieu, int idSach, int soLuong, int giaMua,String tenSach) {
        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.tenSach = tenSach;
    }

    @Override
    public String toString() {
        return "CHITIETPHIEUDTO{" + "idPhieu=" + idPhieu + ", idSach=" + idSach + ", soLuong=" + soLuong + ", giaMua=" + giaMua + '}';
    }

    public int getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(int idPhieu) {
        this.idPhieu = idPhieu;
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

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }
   
}

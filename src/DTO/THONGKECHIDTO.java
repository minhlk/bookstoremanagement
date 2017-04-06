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
public class THONGKECHIDTO {
    int idPhieu,idSach,soLuongNhap,soLuongNhan,giaMua,tongGia,tinhTrang,trangThai;
    String tenSach,ngayLap;

    public THONGKECHIDTO(int idPhieu, int idSach, int soLuongNhap, int soLuongNhan, int giaMua, int tongGia, int tinhTrang, int trangThai, String tenSach, String ngayLap) {
        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuongNhap = soLuongNhap;
        this.soLuongNhan = soLuongNhan;
        this.giaMua = giaMua;
        this.tongGia = tongGia;
        this.tinhTrang = tinhTrang;
        this.trangThai = trangThai;
        this.tenSach = tenSach;
        this.ngayLap = ngayLap;
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

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongNhan() {
        return soLuongNhan;
    }

    public void setSoLuongNhan(int soLuongNhan) {
        this.soLuongNhan = soLuongNhan;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    @Override
    public String toString() {
        return "THONGKECHIDTO{" + "idPhieu=" + idPhieu + ", idSach=" + idSach + ", soLuongNhap=" + soLuongNhap + ", soLuongNhan=" + soLuongNhan + ", giaMua=" + giaMua + ", tongGia=" + tongGia + ", tinhTrang=" + tinhTrang + ", trangThai=" + trangThai + ", tenSach=" + tenSach + ", ngayLap=" + ngayLap + '}';
    }


}

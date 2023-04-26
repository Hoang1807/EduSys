/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.MODEL;

import java.util.Date;

/**
 *
 * @author huuho
 */
public class Nguoihoc {

    private String maNH;
    private String hoTen;
    private Boolean gioiTinh;
    private java.util.Date ngaySinh;
    private String soDienThoai;
    private String email;
    private String ghiChu;
    private java.util.Date ngayDK;
    private String maNVTao;

    public Nguoihoc() {
    }

    public Nguoihoc(String maNH, String hoTen, Boolean gioiTinh, Date ngaySinh, String soDienThoai, String email, String ghiChu, Date ngayDK, String maNVTao) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ghiChu = ghiChu;
        this.ngayDK = ngayDK;
        this.maNVTao = maNVTao;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getMaNVTao() {
        return maNVTao;
    }

    public void setMaNVTao(String maNVTao) {
        this.maNVTao = maNVTao;
    }

}

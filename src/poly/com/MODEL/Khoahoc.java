/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.MODEL;

import java.util.Date;
import poly.com.HELPER.XDate;

/**
 *
 * @author huuho
 */
public class Khoahoc {

    private Integer maKH;
    private Double hocPhi;
    private Integer thoiLuong;
    private java.util.Date ngayKG;
    private String ghiChu;
    private java.util.Date ngayTao;
    private String maNVTao;
    private String maCD;

    public Khoahoc() {
    }

    public Khoahoc(Integer maKH, Double hocPhi, Integer thoiLuong, Date ngayKG, String ghiChu, Date ngayTao, String maNVTao, String maCD) {
        this.maKH = maKH;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKG = ngayKG;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.maNVTao = maNVTao;
        this.maCD = maCD;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(Double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Integer getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNVTao() {
        return maNVTao;
    }

    public void setMaNVTao(String maNVTao) {
        this.maNVTao = maNVTao;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    @Override
    public String toString() {
        return this.getMaCD() + " (" + XDate.toString(this.getNgayKG(), "dd/MM/YYYY") + ")";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.MODEL;

import java.io.File;

/**
 *
 * @author huuho
 */
public class Chuyende {

    private String maCD;
    private String tenCD;
    private Integer thoiLuong;
    private Double hocPhi;
    private byte[] Hinh;
    private String moTa;

    public Chuyende() {
    }

    public Chuyende(String maCD, String tenCD, Integer thoiLuong, Double hocPhi, byte[] Hinh, String moTa) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
        this.Hinh = Hinh;
        this.moTa = moTa;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public Integer getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(Double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return this.getMaCD();
    }

}

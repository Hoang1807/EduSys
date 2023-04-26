/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.MODEL;

/**
 *
 * @author huuho
 */
public class Hocvien {

    private Integer maHV;
    private Integer maKH;
    private String maNH;
    private Double diem;

    public Hocvien() {
    }

    public Hocvien(Integer maHV, Integer maKH, String maNH, Double diem) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.diem = diem;
    }

    public Integer getMaHV() {
        return maHV;
    }

    public void setMaHV(Integer maHV) {
        this.maHV = maHV;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    
}

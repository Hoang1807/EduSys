/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.com.HELPER.jdbcHelper;
import poly.com.MODEL.Khoahoc;

/**
 *
 * @author huuho
 */
public class KhoahocDAO implements EduSysDAO<Khoahoc, Integer> {

    String insertKH = "INSERT INTO KHOAHOC(HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, MaCD) VALUES (?, ?, ?, ?, ?, ?)";
    String updateKH = "UPDATE KHOAHOC SET HocPhi = ? ,ThoiLuong = ?, NgayKG = ?, GhiChu = ?, MaNV = ?, MaCD = ? WHERE MaKH =?";
    String deleteKH = "DELETE FROM KHOAHOC WHERE MaKH = ?";
    String selectAllKH = "SELECT * FROM KHOAHOC";
    String selectById = "SELECT * FROM KHOAHOC WHERE MaKH = ?";
    String selectByCD = "SELECT * FROM KHOAHOC WHERE MaCD = ?";
    String selectAllYear = "SELECT DISTINCT YEAR(NgayKG) from KHOAHOC";

    @Override
    public void insert(Khoahoc entity) {
        try {
            jdbcHelper.update(insertKH, entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNVTao(), entity.getMaCD());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Khoahoc entity) {
        try {
            return jdbcHelper.update(updateKH, entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNVTao(), entity.getMaCD(), entity.getMaKH());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return jdbcHelper.update(deleteKH, id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Khoahoc selectById(Integer id) {
        List<Khoahoc> list = this.selectBySQL(selectById, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Khoahoc> selectAll() {
        return this.selectBySQL(selectAllKH);
    }

    @Override
    public List<Khoahoc> selectBySQL(String sql, Object... arr) {
        List<Khoahoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, arr);
                while (rs.next()) {
                    Khoahoc kh = new Khoahoc(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                    list.add(kh);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Khoahoc> selectByCD(String maCD) {
        return this.selectBySQL(selectByCD, maCD);
    }

    public List<Integer> selectAllYear() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(selectAllYear);
                while (rs.next()) {
                    list.add(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

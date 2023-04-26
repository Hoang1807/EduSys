/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.com.HELPER.jdbcHelper;
import poly.com.MODEL.Hocvien;
import java.sql.*;

/**
 *
 * @author huuho
 */
public class HocvienDAO implements EduSysDAO<Hocvien, Integer> {

    String insertHV = "INSERT INTO HOCVIEN(MaKH,MaNH) VALUES(?,?)";
    String updateHV = "UPDATE HOCVIEN SET MaKH = ? ,MaNH = ?, Diem = ? WHERE MaHV =?";
    String deleteHV = "DELETE FROM HOCVIEN WHERE MaHV = ?";
    String selectAllHV = "SELECT * FROM HOCVIEN";
    String selectById = "SELECT * FROM HOCVIEN WHERE MaHV = ?";
    String selectByKhoaHoc = "SELECT * FROM HOCVIEN WHERE MaKH = ?";
    String selectByHocVienExist = "SELECT * FROM HOCVIEN WHERE MaNH = ? AND MaKH = ?";

    @Override
    public void insert(Hocvien entity) {
        try {
            jdbcHelper.update(insertHV, entity.getMaKH(), entity.getMaNH());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Hocvien entity) {
        try {
            return jdbcHelper.update(updateHV, entity.getMaKH(), entity.getMaNH(), entity.getDiem(), entity.getMaHV());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return jdbcHelper.update(deleteHV, id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Hocvien selectById(Integer id) {
        List<Hocvien> list = this.selectBySQL(selectById, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Hocvien> selectAll() {
        return this.selectBySQL(selectAllHV);
    }

    @Override
    public List<Hocvien> selectBySQL(String sql, Object... arr) {
        List<Hocvien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, arr);
                while (rs.next()) {
                    Hocvien nh = new Hocvien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
                    list.add(nh);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Hocvien> selectByKhoaHoc(int maKH) {
        return this.selectBySQL(selectByKhoaHoc, maKH);
    }

    public boolean selectByHocVienExist(Object... arr) {
        List<Hocvien> hv = this.selectBySQL(selectByHocVienExist, arr);
        if (hv.size() != 0) {
            return false;
        }
        return true;
    }
}

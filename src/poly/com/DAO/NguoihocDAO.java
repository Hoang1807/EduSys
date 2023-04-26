/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.com.HELPER.MsgBox;
import poly.com.HELPER.jdbcHelper;
import poly.com.MODEL.Nguoihoc;

/**
 *
 * @author huuho
 */
public class NguoihocDAO implements EduSysDAO<Nguoihoc, String> {

    String insertNH = "INSERT INTO NGUOIHOC VALUES(?,?,?,?,?,?,?,?,?)";
    String updateNH = "UPDATE NGUOIHOC SET HoTen = ? ,GioiTinh = ?, NgaySinh = ?, DienThoai= ?, Email= ?, GhiChu= ?, NgayDK= ?, MaNV = ? WHERE MaNH =? ";
    String deleteNH = "DELETE FROM NGUOIHOC WHERE MaNH =?";
    String selectAllNH = "SELECT * FROM NGUOIHOC";
    String selectById = "SELECT * FROM NGUOIHOC WHERE MaNH = ?";
    String selectFindNH = "SELECT * FROM NGUOIHOC WHERE HoTen LIKE ?";

    @Override
    public void insert(Nguoihoc entity) {
        try {
            jdbcHelper.update(insertNH, entity.getMaNH(), entity.getHoTen(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getSoDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getNgayDK(), entity.getMaNVTao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Nguoihoc entity) {
        try {
            return jdbcHelper.update(updateNH, entity.getHoTen(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getSoDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getNgayDK(), entity.getMaNVTao(), entity.getMaNH());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String id) {
        try {
            return jdbcHelper.update(deleteNH, id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Nguoihoc selectById(String id) {
        List<Nguoihoc> list = this.selectBySQL(selectById, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Nguoihoc> selectAll() {
        return this.selectBySQL(selectAllNH);
    }

    @Override
    public List<Nguoihoc> selectBySQL(String sql, Object... arr) {
        List<Nguoihoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, arr);
                while (rs.next()) {
                    Nguoihoc nh = new Nguoihoc(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
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

    public List<Nguoihoc> selectFindNH(String Name) {
        return this.selectBySQL(selectFindNH, "%" + Name + "%");
    }
}

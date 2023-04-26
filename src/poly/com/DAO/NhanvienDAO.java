/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.com.HELPER.jdbcHelper;
import poly.com.MODEL.Nhanvien;
import java.sql.*;
import poly.com.HELPER.MsgBox;

/**
 *
 * @author huuho
 */
public class NhanvienDAO implements EduSysDAO<Nhanvien, String> {

    String insertNV = "INSERT INTO NHANVIEN VALUES(?,?,?,?)";
    String updateNV = "UPDATE NHANVIEN SET MatKhau = ?, Hoten = ?, Vaitro = ? WHERE MaNV = ?";
    String deleteNV = "DELETE FROM NHANVIEN WHERE MaNV = ?";
    String selectAllNV = "SELECT * FROM NHANVIEN";
    String selectById = "SELECT * FROM NHANVIEN WHERE MaNV = ?";

    @Override
    public void insert(Nhanvien entity) {
        try {
            jdbcHelper.update(insertNV, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Nhanvien entity) {
        try {
            return jdbcHelper.update(updateNV, entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro(), entity.getMaNV());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String id) {
        try {
            return jdbcHelper.update(deleteNV, id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Nhanvien selectById(String id) {
        List<Nhanvien> list = this.selectBySQL(selectById, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Nhanvien> selectAll() {
        return this.selectBySQL(selectAllNV);
    }

    @Override
    public List<Nhanvien> selectBySQL(String sql, Object... arr) {
        List<Nhanvien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, arr);
                while (rs.next()) {
                    Nhanvien nv = new Nhanvien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                    list.add(nv);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            MsgBox.alert(null, "Không Thể Kết Nối Server");
            e.printStackTrace();
        }
        return list;
    }
}

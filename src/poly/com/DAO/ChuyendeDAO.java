/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.DAO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import poly.com.HELPER.MsgBox;
import poly.com.HELPER.ResizeImage;
import poly.com.HELPER.jdbcHelper;
import poly.com.MODEL.Chuyende;

/**
 *
 * @author huuho
 */
public class ChuyendeDAO implements EduSysDAO<Chuyende, String> {

    String insertCD = "INSERT INTO CHUYENDE VALUES(?,?,?,?,?,?)";
    String updateCD = "UPDATE CHUYENDE SET TenCD =? ,HocPhi = ?, ThoiLuong = ?,Hinh=?,MoTa=? WHERE MaCD =?";
    String deleteCD = "DELETE FROM CHUYENDE WHERE MaCD =?";
    String selectAllCD = "SELECT * FROM CHUYENDE";
    String selectById = "SELECT * FROM CHUYENDE WHERE MaCD = ?";

    @Override
    public void insert(Chuyende entity) {
        try {
            jdbcHelper.update(insertCD, entity.getMaCD(), entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa());
        } catch (Exception e) {
            MsgBox.alert(null, "Lỗi CDDAO");
        }
    }

    @Override
    public int update(Chuyende entity) {
        try {
            return jdbcHelper.update(updateCD, entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa(), entity.getMaCD());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String id) {
         try {
            return jdbcHelper.update(deleteCD, id);
        } catch (Exception e) {
            return 0;
        }
//        try {
//            MsgBox.alert(null, "Xóa thành công");
//            return jdbcHelper.update(deleteCD, id);
//        } catch (Exception e) {
//            MsgBox.alert(null, "Không thể xóa!!!");
//            return 0;
//        }
    }

    @Override
    public Chuyende selectById(String id) {
        List<Chuyende> list = this.selectBySQL(selectById, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Chuyende> selectAll() {
        return this.selectBySQL(selectAllCD);
    }

    @Override
    public List<Chuyende> selectBySQL(String sql, Object... arr) {
        List<Chuyende> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, arr);
                while (rs.next()) {
                    byte imgByte[] = rs.getBytes(5);
                    Chuyende cd = new Chuyende(rs.getString(1), rs.getString(2), rs.getInt(4), rs.getDouble(3), imgByte, rs.getString(6));
                    list.add(cd);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

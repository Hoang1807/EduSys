/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.com.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import poly.com.HELPER.jdbcHelper;

/**
 *
 * @author nhatt
 */
public class ThongKeDAO {

    String bangDiem = "{CALL sp_Bangdiem(?)}";
    String luongNguoiHoc = "{CALL sp_Nguoihoc}";
    String diemChuyenDe = "{CALL sp_Diemchuyende}";
    String doanhThu = "{CALL sp_Doanhthu(?)}";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getBangDiem(Integer maKH) {
        String[] cols = {"MaNH", "HoTen", "Diem", "xephang"};
        return this.getListOfArray(bangDiem, cols, maKH);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String[] cols = {"Year", "SoLuong", "Dkymin", "Dkymax"};
        return this.getListOfArray(luongNguoiHoc, cols);
    }

    public List<Object[]> getDiemChuyenDe() {
        String[] cols = {"TenCD", "SoLuong", "DiemTN", "DiemCN", "TB"};
        return this.getListOfArray(diemChuyenDe, cols);
    }

    public List<Object[]> getDoanhThu(int year) {
        String[] cols = {"TenCD", "SoKhoaHoc", "SoHocVien", "DoanhThu", "DNThapNhat", "DNCaoNhat", "TB"};
        return this.getListOfArray(doanhThu, cols, year);
    }
}

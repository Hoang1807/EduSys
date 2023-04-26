/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.HELPER;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;

/**
 *
 * @author huuho
 */
public class jdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = null;

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUrl(String url) {
        if (url == null || url.isEmpty()) {
            jdbcHelper.url = null;
        } else {
            jdbcHelper.url = "jdbc:sqlserver://" + url + ":1433;Databasename=EduSys;encrypt=true;trustServerCertificate=true;username=sa;password=Huuhoang123";

        }
    }

    public static String getUrl() {
        return url;
    }

    public static PreparedStatement getStatement(String sql, Object... arr) throws SQLException, UnknownHostException {
        //    SQLServerDataSource dataSource = new SQLServerDataSource();
        InetAddress address = InetAddress.getLocalHost();
        if (address.getHostName().equals("MSI") && url == null) {
            url = "jdbc:sqlserver://localhost:1433;Databasename=EduSys;encrypt=true;trustServerCertificate=true;username=sa;password=Huuhoang123";
        }
        if (url == null) {
            MsgBox.alert(null, "Không Thể Kết Nối Server");
            throw new SQLException();
        } else {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement;
            if (sql.trim().startsWith("{")) {
                preparedStatement = conn.prepareCall(sql);
            } else {
                preparedStatement = conn.prepareStatement(sql);
            }
            for (int i = 0; i < arr.length; i++) {
                preparedStatement.setObject(i + 1, arr[i]);
            }
            return preparedStatement;
        }
    }

    public static ResultSet query(String sql, Object... arr) throws SQLException, UnknownHostException {
        PreparedStatement ps = jdbcHelper.getStatement(sql, arr);
        return ps.executeQuery();
    }

    public static int update(String sql, Object... arr) throws SQLException, UnknownHostException {
        PreparedStatement ps = jdbcHelper.getStatement(sql, arr);
        try {
            return ps.executeUpdate();
        } finally {
            ps.getConnection().close();
        }
    }

    public static Object value(String sql, Object... arr) throws SQLException, UnknownHostException {
        ResultSet rs = query(sql, arr);
        while (rs.next()) {
            return rs.getObject(0);
        }
        rs.getStatement().getConnection().close();
        return null;
    }
}

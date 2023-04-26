/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.data;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

/**
 *
 * @author huuho
 */
public class Data {

    @DataProvider(name = "data-formLogin")
    public static Object dataLogin(Method method) {
        Object[][] data = null;
        if (method.getName().equals("testValidate_form_true")) {
            data = new Object[][]{{"PS20003", "123"}, {"   PS23305   ", "  555"}};
        } else if (method.getName().equals("testValidate_form_false")) {
            data = new Object[][]{{"PS20003", ""}, {"", "256"}, {"   ", "    "}, {"", ""}};
        } else if (method.getName().equals("testLogin_true")) {
            data = new Object[][]{{"PS23306", "123"}, {"PS23303", "123"}};
        } else if (method.getName().equals("testLogin_false")) {
            data = new Object[][]{{"PS23355", "123"}, {"PS23303", "huuhoang"}};
        }
        return data;
    }

    @DataProvider(name = "data-QR")
    public static Object dataQR(Method method) {
        Object[][] data = null;
        if (method.getName().equals("testReadImageQR_true")) {
            data = new Object[][]{{"PS23303", "/poly/com/Image/PS23303.png"}, {"PS23306", "/poly/com/Image/PS23306.png"}};
        } else if (method.getName().equals("testReadImageQR_false")) {
            data = new Object[][]{{"/poly/com/Image/qr_err_1.png"}, {"/poly/com/Image/qr_err_2.png"}};
        } else if (method.getName().equals("testCheckImage_true")) {
            data = new Object[][]{{"PS23311", "/poly/com/Image/ps23311.jpg"}};
        } else if (method.getName().equals("testCheckImage_false")) {
            data = new Object[][]{{"/poly/com/Image/qr_err_3.jpg"}};
        }
        return data;
    }

    @DataProvider(name = "data-formNV")
    public static Object dataNhanVien(Method method) {
        Object[][] data = null;
        if (method.getName().equals("testValidate_formNV_true")) {
            data = new Object[][]{{"PS23303", "123", "123", "Nguyễn Hữu Hoàng"}, {"  PS23355   ", "456      ", "     456", "Nguyễn Tiến"}};
        } else if (method.getName().equals("testValidate_formNV_false")) {
            data = new Object[][]{{"", "", "", ""}, {"PS23301", "123", "456", "Bảo Tịnh"}, {"PS23301", "123", "123", ""}, {"PS23307", "123", "", "Nguyễn Bảo Duy"}, {"PS23345", "", "753", "Nguyễn Thùy Trâm"}, {"", "750", "750", "Nguyễn Thanh Thủy"}};
        } else if (method.getName().equals("testAddNV_true")) {
            data = new Object[][]{{"PS23301", "123", "Bùi Tiến Dũng", false}, {"PS23302", "741", "Phan Châu Chinh", true}};
        } else if (method.getName().equals("testAddNV_false")) {
            data = new Object[][]{{"PS23306", "123", "Nguyễn Văn A", false}, {"PS23303", "123", "Bùi Tiến Dũng", false}};
        } else if (method.getName().equals("testUpdateNV_true")) {
            data = new Object[][]{{"PS23306", "123", "Nguyễn Hữu Hoàng", true}, {"PS23303", "123", "Bùi Văn Sửu", false}};
        } else if (method.getName().equals("testUpdateNV_false")) {
            data = new Object[][]{{"PS23315", "123", "Nguyễn Hữu Hoàng", true}};
        } else if (method.getName().equals("testDeleteNV_true")) {
            data = new Object[][]{{"PS23301"}, {"PS23302"}};
        } else if (method.getName().equals("testDeleteNV_false")) {
            data = new Object[][]{{"PS23344"}, {"PS23312"}};
        }
        return data;
    }
}

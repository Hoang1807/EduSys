/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poly.com.ui;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poly.com.DAO.NhanvienDAO;
import poly.com.MODEL.Nhanvien;
import poly.com.data.Data;

/**
 *
 * @author huuho
 */
public class FormMainNGTest {

	FormMain formMain;
	NhanvienDAO nhanvienDAO;

	@BeforeClass(groups = { "Validate_formNV", "AddNV", "UpdateNV", "DeleteNV" })
	public void setUpClass() throws Exception {
		formMain = new FormMain();
	}

	@AfterClass(groups = { "Validate_formNV", "AddNV", "UpdateNV", "DeleteNV" })
	public void tearDownClass() throws Exception {
		formMain = null;
	}

	@BeforeMethod(groups = { "Validate_formNV", "AddNV", "UpdateNV", "DeleteNV" })
	public void setUpMethod() throws Exception {
		nhanvienDAO = new NhanvienDAO();
	}

	@AfterMethod(groups = { "Validate_formNV", "AddNV", "UpdateNV", "DeleteNV" })
	public void tearDownMethod() throws Exception {
		nhanvienDAO = null;
	}

	@Test(groups = "Validate_formNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 1)
	public void testValidate_formNV_true(String maNV, String matKhau, String xacNhanMK, String hoTen) {
		boolean result = formMain.validate_formNV(maNV, matKhau, xacNhanMK, hoTen);
		try {
			assertTrue(result);
			System.out.println("testValidate_formNV_true successful");
		} catch (Exception e) {
			fail("fail testValidate_formNV_true");
		}
	}

	@Test(groups = "Validate_formNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 2)
	public void testValidate_formNV_false(String maNV, String matKhau, String xacNhanMK, String hoTen) {
		boolean result = formMain.validate_formNV(maNV, matKhau, xacNhanMK, hoTen);
		try {
			assertFalse(result);
			System.out.println("testValidate_formNV_false successful");
		} catch (Exception e) {
			fail("fail testValidate_formNV_false");
		}
	}

	@Test(groups = "AddNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 3)
	public void testAddNV_true(String maNV, String matKhau, String hoTen, boolean vaiTro) {
		int result = formMain.addNV(maNV, matKhau, hoTen, vaiTro);
		int expected = 1;
		try {
			assertTrue(result == expected);
			System.out.println("testAddNV_true successful");
		} catch (Exception e) {
			fail("fail testAddNV_true");
		}
	}

	@Test(groups = "AddNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 4)
	public void testAddNV_false(String maNV, String matKhau, String hoTen, boolean vaiTro) {
		int result = formMain.addNV(maNV, matKhau, hoTen, vaiTro);
		int expected = 0;
		try {
			assertTrue(result == expected);
			System.out.println("testAddNV_false successful");
		} catch (Exception e) {
			fail("fail testAddNV_false");
		}
	}

	@Test(groups = "UpdateNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 5)
	public void testUpdateNV_true(String maNV, String matKhau, String hoTen, boolean vaiTro) {
		int result = formMain.updateNV(maNV, matKhau, hoTen, vaiTro);
		int expected = 1;
		try {
			assertTrue(result == expected);
			System.out.println("testUpdateNV_true successful");
		} catch (Exception e) {
			fail("fail testUpdateNV_true");
		}
	}

	@Test(groups = "UpdateNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 6)
	public void testUpdateNV_false(String maNV, String matKhau, String hoTen, boolean vaiTro) {
		int result = formMain.updateNV(maNV, matKhau, hoTen, vaiTro);
		int expected = 0;
		try {
			assertTrue(result == expected);
			System.out.println("testUpdateNV_false successful");
		} catch (Exception e) {
			fail("fail testUpdateNV_false");
		}
	}

	@Test(groups = "DeleteNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 7)
	public void testDeleteNV_true(String maNV) {
		int result = formMain.deleteNV(maNV);
		int expected = 1;
		try {
			assertTrue(result == expected);
			System.out.println("testDeleteNV_true successful");
		} catch (Exception e) {
			fail("fail testDeleteNV_true");
		}
	}

	@Test(groups = "DeleteNV", dataProvider = "data-formNV", dataProviderClass = Data.class, priority = 8)
	public void testDeleteNV_false(String maNV) {
		int result = formMain.deleteNV(maNV);
		int expected = 0;
		try {
			assertTrue(result == expected);
			System.out.println("testDeleteNV_false successful");
		} catch (Exception e) {
			fail("fail testDeleteNV_false");
		}
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poly.com.ui;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import poly.com.DAO.NhanvienDAO;
import poly.com.MODEL.Nhanvien;
import poly.com.data.Data;

/**
 *
 * @author huuho
 */
public class FormLoginNGTest {

	NhanvienDAO nhanvienDAO;
	FormLogin formLogin;

	@BeforeClass(groups = { "SignIn", "Validate_form" })
	public void setUpClass() {
		nhanvienDAO = new NhanvienDAO();
	}

	@AfterClass(groups = { "SignIn", "Validate_form" })
	public void tearDownClass() {
		nhanvienDAO = null;
	}

	@BeforeMethod(groups = { "SignIn", "Validate_form" })
	public void setUpMethod() {
		formLogin = new FormLogin();
	}

	@AfterMethod(groups = { "SignIn", "Validate_form" })
	public void tearDownMethod() {
		formLogin = null;
	}

	@Test(groups = "Validate_form", dataProvider = "data-formLogin", dataProviderClass = Data.class, priority = 1)
	public void testValidate_form_true(String userName, String passWord) {
		boolean result = formLogin.validate_form(userName, passWord);
		try {
			assertTrue(result);
			System.out.println("testValidate_form_true successful");
		} catch (Exception e) {
			fail("fail testValidate_form_true");
		}
	}

	@Test(groups = "Validate_form", dataProvider = "data-formLogin", dataProviderClass = Data.class, priority = 2)
	public void testValidate_form_false(String userName, String passWord) {
		boolean result = formLogin.validate_form(userName, passWord);
		try {
			assertFalse(result);
			System.out.println("testValidate_form_false successful");
		} catch (Exception e) {
			fail("fail testValidate_form_false");
		}
	}

	@Test(groups = "SignIn", dataProvider = "data-formLogin", dataProviderClass = Data.class, priority = 3)
	public void testLogin_true(String userName, String passWord) {
		String expected = nhanvienDAO.selectById(userName).getMaNV();
		Nhanvien result = formLogin.login(userName, passWord);
		try {
			assertEquals(result.getMaNV(), expected);
			System.out.println("testLogin_true successful");
		} catch (Exception e) {
			fail("fail testLogin_true");
		}
	}

	@Test(groups = "SignIn", dataProvider = "data-formLogin", dataProviderClass = Data.class, priority = 4)
	public void testLogin_false(String userName, String passWord) {
		Nhanvien result = formLogin.login(userName, passWord);
		try {
			assertNull(result);
			System.out.println("testLogin_false successful");
		} catch (Exception e) {
			fail("fail testLogin_false");
		}
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poly.com.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poly.com.DAO.NhanvienDAO;
import poly.com.MODEL.Nhanvien;
import poly.com.data.Data;

/**
 *
 * @author huuho
 */
public class ScannerQRNGTest {

	ScannerQR qR;
	NhanvienDAO nhanvienDAO;

	@BeforeClass(groups = { "ReadImageQR", "CheckImage" })
	public void setUpClass() throws Exception {
		nhanvienDAO = new NhanvienDAO();
	}

	@AfterClass(groups = { "ReadImageQR", "CheckImage" })
	public void tearDownClass() throws Exception {
		nhanvienDAO = null;
	}

	@BeforeMethod(groups = { "ReadImageQR", "CheckImage" })
	public void setUpMethod() throws Exception {
		qR = new ScannerQR(null, false);
	}

	@AfterMethod(groups = { "ReadImageQR", "CheckImage" })
	public void tearDownMethod() throws Exception {
		qR = null;
		Thread.sleep(1500);
	}

	@Test(groups = "ReadImageQR", dataProvider = "data-QR", dataProviderClass = Data.class, priority = 1)
	public void testReadImageQR_true(String id, String path) throws URISyntaxException {
		File file = new File(getClass().getResource(path).toURI());
		Nhanvien result = qR.readImageQR(file);
		Nhanvien expected = nhanvienDAO.selectById(id);
		try {
			assertEquals(result.getMaNV(), expected.getMaNV());
			System.out.println("testReadImageQR_true successful");
		} catch (Exception e) {
			fail("fail testReadImageQR_true");
		}
	}

	@Test(groups = "ReadImageQR", dataProvider = "data-QR", dataProviderClass = Data.class, priority = 2)
	public void testReadImageQR_false(String path) throws URISyntaxException {
		File file = new File(getClass().getResource(path).toURI());
		Nhanvien result = qR.readImageQR(file);
		try {
			assertNull(result);
			System.out.println("testReadImageQR_false successful");
		} catch (Exception e) {
			fail("fail testReadImageQR_false");
		}
	}

	@Test(groups = "CheckImage", dataProvider = "data-QR", dataProviderClass = Data.class, priority = 3)
	public void testCheckImage_true(String id, String path) throws URISyntaxException, IOException {
		File file = new File(getClass().getResource(path).toURI());
		BufferedImage bi = ImageIO.read(file);
		Nhanvien result = qR.checkImage(bi);
		Nhanvien expected = nhanvienDAO.selectById(id);
		try {
			assertEquals(result.getMaNV(), expected.getMaNV());
			System.out.println("testCheckImage_true successful");
		} catch (Exception e) {
			fail("fail testCheckImage_true");
		}
	}

	@Test(groups = "CheckImage", dataProvider = "data-QR", dataProviderClass = Data.class, priority = 4)
	public void testCheckImage_false(String path) throws URISyntaxException, IOException {
		File file = new File(getClass().getResource(path).toURI());
		BufferedImage bi = ImageIO.read(file);
		Nhanvien result = qR.checkImage(bi);
		try {
			assertNull(result);
			System.out.println("testCheckImage_false successful");
		} catch (Exception e) {
			fail("fail testCheckImage_false");
		}
	}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.HELPER;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author huuho
 */
public class ResizeImage {

    public static BufferedImage buff(InputStream inputStream) throws IOException {
        return ImageIO.read(inputStream);
    }

    public static BufferedImage buff(URL url) throws IOException {
        return ImageIO.read(url);
    }

    public static BufferedImage buff(File file) throws IOException {
        return ImageIO.read(file);
    }

    public static Image img(JLabel button, BufferedImage bi) {
        return bi.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
    }

    public static Image img(JMenuItem mni, BufferedImage bi) {
        return bi.getScaledInstance(mni.getWidth(), mni.getHeight(), Image.SCALE_SMOOTH);
    }

    public static Image img(BufferedImage bi, int width, int height) {
        return bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}

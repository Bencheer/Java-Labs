package mainpack;

import org.imgscalr.Scalr;
import resizeimage.ResizeImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by CM on 25.10.2014.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*BufferedImage img = ImageIO.read(new File("C:\\Users\\CM\\Desktop\\0_80925_3732e180_orig.jpg"));

        System.out.println(img.getWidth());
        System.out.println(img.getHeight());

        BufferedImage thumbnail =
                Scalr.resize(img, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                        150, 100, Scalr.OP_ANTIALIAS);
        System.out.println(thumbnail);
        File newFile = new File("E:\\save.jpg");
        ImageIO.write(thumbnail, "jpg", newFile);*/
        ResizeImage img1 = new ResizeImage(args[0], args[1], 450, 400);

    }
}

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
        ResizeImage img1 = new ResizeImage(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
    }
}

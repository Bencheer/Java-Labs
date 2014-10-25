package resizeimage;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by CM on 25.10.2014.
 */
public class ResizeImage {
    public ResizeImage (String inputFilePath, String outputFilePath, Integer width, Integer height) throws IOException {
        BufferedImage img = ImageIO.read(new File(inputFilePath));
        BufferedImage image = resizeImg(img, width, height);

        File newFile = new File(outputFilePath);
        ImageIO.write(image, "jpg", newFile);
        System.out.println("Вы можете открыть файл в: " + outputFilePath);
    }

    private BufferedImage resizeImg (BufferedImage img, Integer height, Integer width) {
        BufferedImage thumbnail =
                Scalr.resize(img, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                        width, height, Scalr.OP_ANTIALIAS);

        return  thumbnail;
    }
}

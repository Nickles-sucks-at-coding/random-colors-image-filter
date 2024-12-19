import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // sets the strength
        int strenght = 60;

        File picture = new File("input\\picture.png");

        try {

            BufferedImage img = ImageIO.read(picture);

            for (int y = 0; y < img.getHeight(); y++) {

                for (int x = 0; x < img.getWidth(); x++) {

                    System.out.println(x + "      " + y);

                    Color oldRGB = new Color(img.getRGB(x, y));

                    int newRed = addRandomRGB(oldRGB.getRed(), strenght);
                    int newGreen = addRandomRGB(oldRGB.getGreen(), strenght);
                    int newBlue = addRandomRGB(oldRGB.getBlue(), strenght);

                    Color newRGB = new Color(newRed, newGreen, newBlue);

                    img.setRGB(x, y, newRGB.getRGB());
                }
            }

            File newPicture = new File("output\\new_picture.png");

            ImageIO.write(img, "png", newPicture);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int addRandomRGB(int RGB, int strength) {

        Random random = new Random();

        int randomChangeNum = random.nextInt(-strength, strength);

        RGB += randomChangeNum;

        while (RGB < 0 || RGB > 255) {

            RGB -= randomChangeNum * 2;
        }

        return RGB;
    }
}
package fontLoader;

import java.awt.*;
import java.io.InputStream;

public class FontLoader {
    public static Font jetBrainsMono, pressStart, quantico, electrolize, babelStones, agdasimaBold, agdasimaRegular, freeFonts = null;

    public static void loadFonts() {
        try {
            InputStream stream = FontLoader.class.getResourceAsStream("/fonts/JetBrainsMono-Bold.ttf");
            jetBrainsMono = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(15f);

            InputStream streamTwo = FontLoader.class.getResourceAsStream("/fonts/PressStart2P-Regular.ttf");
            pressStart = Font.createFont(Font.TRUETYPE_FONT, streamTwo).deriveFont(15f);

            InputStream streamThree = FontLoader.class.getResourceAsStream("/fonts/Quantico-Bold.ttf");
            quantico = Font.createFont(Font.TRUETYPE_FONT, streamThree).deriveFont(15f);

            InputStream streamFour = FontLoader.class.getResourceAsStream("/fonts/Electrolize-Regular.ttf");
            electrolize = Font.createFont(Font.TRUETYPE_FONT, streamFour).deriveFont(15f);

            InputStream streamFive = FontLoader.class.getResourceAsStream("/fonts/BabelStoneShapes.ttf");
            babelStones = Font.createFont(Font.TRUETYPE_FONT, streamFive).deriveFont(15f);

            InputStream streamSix = FontLoader.class.getResourceAsStream("/fonts/Agdasima-Bold.ttf");
            agdasimaBold = Font.createFont(Font.TRUETYPE_FONT, streamSix).deriveFont(15f);

            InputStream streamSeven = FontLoader.class.getResourceAsStream("/fonts/Agdasima-Regular.ttf");
            agdasimaRegular = Font.createFont(Font.TRUETYPE_FONT, streamSeven).deriveFont(15f);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

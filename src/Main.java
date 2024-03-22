import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Project W.E.N.V");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1280, 720);
            frame.setLayout(new BorderLayout());
            GraphicPanel panel = new GraphicPanel();
            panel.setDoubleBuffered(true);
            frame.add(panel);

            BufferedImage cursorImg = new BufferedImage(17, 17, BufferedImage.TYPE_INT_ARGB);

            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                    cursorImg, new Point(0, 0), "blank cursor");
            //frame.getContentPane().setCursor(blankCursor);

            frame.setVisible(true);

        });
    }
}


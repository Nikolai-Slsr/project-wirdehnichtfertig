import jdk.jshell.ExpressionSnippet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


class GraphicPanel extends JPanel {


    private boolean mousePressed = false;
    private boolean mouseOnPanel = false;
    private int width; //= getWidth();
    private int heigth; //= getHeight();

    private UpdateManager _UpdateManager;

    private JFrame frame = new JFrame();

    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private Robot robot;



    //KEYPRESSED:


    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;

    {
        try {
            robot = new Robot(ge.getDefaultScreenDevice());
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            cursorImg, new Point(0, 0), "blank cursor");
    public GraphicPanel() {
        width = 1280;
        heigth = 720;

        _UpdateManager = new UpdateManager();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                frame.getContentPane().setCursor(Cursor.getDefaultCursor());
                if (SwingUtilities.isLeftMouseButton(e)) {

                    mousePressed = true;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseOnPanel) {
                    frame.getContentPane().setCursor(blankCursor);
                }
                if (SwingUtilities.isLeftMouseButton(e)) {
                    mousePressed = false;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                frame.getContentPane().setCursor(blankCursor);
                mouseOnPanel = true;
                requestFocusInWindow();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                mouseOnPanel = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        setFocusable(true);
        requestFocusInWindow();

        //KEYINPUT
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {


                if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
                    frame.dispose();
                    System.exit(0);
                }

                if(e.getKeyChar() == 'w'){
                    wPressed = true;
                }

                if(e.getKeyChar() == 'a'){
                    aPressed = true;
                }

                if(e.getKeyChar() == 's'){
                    sPressed = true;
                }

                if(e.getKeyChar() == 'd'){
                    dPressed = true;
                }



            }
            @Override
            public void keyReleased(KeyEvent e) {


                if(e.getKeyChar() == 'w'){
                    wPressed = false;
                }

                if(e.getKeyChar() == 'a'){
                    aPressed = false;
                }

                if(e.getKeyChar() == 's'){
                    sPressed = false;
                }

                if(e.getKeyChar() == 'd'){
                    dPressed = false;
                }


            }
        });


        //RESIZE EVENT
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                width = getWidth();
                heigth = getHeight();
            }
        });



        Timer timer = new Timer(1, e -> {

            if (wPressed){_UpdateManager.wPressed();}
            if (aPressed){_UpdateManager.aPressed();}
            if (sPressed){_UpdateManager.sPressed();}
            if (dPressed){_UpdateManager.dPressed();}
            repaint();
        });
        timer.start();

    }


    public void giveFrame(JFrame frame){
        this.frame = frame;
    }



    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

    }

}

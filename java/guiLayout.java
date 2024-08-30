import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


public class guiLayout {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Random r= new Random();
    int rows = r.nextInt(20) + 1;
    int cols = r.nextInt(20) + 1;
    int r_c = rows*cols;
    Color[] colors = new Color[]{Color.RED,Color.MAGENTA,Color.BLACK,Color.GRAY,Color.ORANGE,Color.YELLOW};
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("window");
    frame.setSize(500, 500);
    frame.setVisible(true);
    frame.setLayout(new GridLayout(rows,cols,5,5));

    JButton[] buttons = new JButton[r_c];
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton(Integer.toString(i));
      frame.add(buttons[i]);
      buttons[i].setBackground(colors[r.nextInt(colors.length)]);
    }
  }
}
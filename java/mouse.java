import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class mouse {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("window");
    frame.setSize(500, 500);
    frame.setVisible(true);
    frame.setLayout(new FlowLayout());
    JTextField jtf1 = new JTextField(5);
    JTextField jtf2 = new JTextField(5);
    frame.add(jtf1);
    frame.add(jtf2);

    frame.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
        jtf1.setText(Integer.toString(e.getX()));
        jtf2.setText(Integer.toString(e.getY()));
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

    });

  }
}

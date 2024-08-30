import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class shape {
  static class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.CYAN);
      g.drawLine(200, 200, 100, 150);
      g.setColor(Color.CYAN);
      g.drawLine(100, 150, 300, 150);
      g.setColor(Color.CYAN);
      g.drawLine(300, 150, 200, 200);
      g.setColor(Color.BLACK);
      g.drawRect(20, 20, 50, 50);
    }
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("window");
    frame.setSize(500, 500);
    frame.setVisible(true);
    frame.setLayout(new CardLayout());

    MyPanel panel = new MyPanel();
    frame.add(panel);

    frame.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
        
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

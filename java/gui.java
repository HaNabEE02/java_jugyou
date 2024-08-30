import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gui {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("window");
    frame.setSize(500, 500);
    frame.setVisible(true);
    frame.setLayout(new FlowLayout());

    JLabel label1 = new JLabel("Label1");
    frame.add(label1);

    JLabel label2 = new JLabel("Label2");
    label2.setForeground(Color.RED);

    Font font = new Font("궁서 보통", Font.BOLD, 30);
    label2.setFont(font);
    frame.add(label2);
    JCheckBox chk1 = new JCheckBox("Clcik");
    JButton button1 = new JButton("Click");
    button1.addActionListener(e -> {
      JOptionPane.showMessageDialog(button1, "버튼을 눌렀습니다.");
    });
    frame.add(chk1);
    chk1.addActionListener(e -> {
      if (chk1.isSelected()) {
        JOptionPane.showMessageDialog(null, "Check ON");
      } else {
        JOptionPane.showMessageDialog(null, "Check Off");
      }
    });
    frame.add(button1);
    JButton button2 = new JButton("Click");
    button2.addActionListener(e -> JOptionPane.showMessageDialog(button2, "우지훈 시발 빸!"));
    frame.add(button2);
    JRadioButton rdo1 = new JRadioButton("Click");
    JRadioButton rdo2 = new JRadioButton("Click");
    JRadioButton rdo3 = new JRadioButton("Click");
    frame.add(rdo1);
    frame.add(rdo2);
    frame.add(rdo3);
    ButtonGroup bgr = new ButtonGroup();
    bgr.add(rdo1);
    bgr.add(rdo2);
    bgr.add(rdo3);
    JTextField jtf = new JTextField(10);
    JTextArea jta = new JTextArea(5, 10);
    JPasswordField pwdField = new JPasswordField(10);
    String[] fruits = new String[] {"우지훈", "우지훈2", "우지훈3","우지훈", "우지훈2", "우지훈3","우지훈", "우지훈2", "우지훈3"};

    JList<String> list = new JList<>(fruits);
    frame.add(new JScrollPane(list));
    frame.add(new JScrollPane(list));
    frame.add(pwdField);
    frame.add(jta);
    frame.add(new JScrollPane(jta));
    frame.add(jtf);
    /*
     * button1.addActionListener(new ActionListener() {
     * public void actionPerformed(ActionEvent e) {
     * JOptionPane.showMessageDialog(null, "버튼을 눌렀습니다.");
     * }
     * });
     */

  }
}

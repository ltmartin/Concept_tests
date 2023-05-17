import javax.swing.*;
import java.awt.*;

public class JLayeredPaneFrame extends JFrame {
    public JLayeredPaneFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50,50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.green);
        label2.setBounds(100,100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.blue);
        label3.setBounds(150,150, 200, 200);

        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0,0, 500, 500);
        jLayeredPane.add(label1, Integer.valueOf(0));
        jLayeredPane.add(label2, Integer.valueOf(2));
        jLayeredPane.add(label3, Integer.valueOf(1));


        this.add(jLayeredPane);
        this.setVisible(true);
    }
}

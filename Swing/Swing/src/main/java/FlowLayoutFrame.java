import javax.swing.*;
import java.awt.*;

public class FlowLayoutFrame extends JFrame {
    public FlowLayoutFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(250,250));
        panel1.setBackground(Color.lightGray);
        panel1.setLayout(new FlowLayout());

        for (int i = 0; i < 9; i++) {
            panel1.add(new JButton(String.valueOf(i+1)));
        }

        this.add(panel1);

        this.setVisible(true);
    }
}

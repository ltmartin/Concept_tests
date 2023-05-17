import javax.swing.*;
import java.awt.*;

public class JCheckBoxFrame extends JFrame {

    public JCheckBoxFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setLayout(new FlowLayout());

        JCheckBox checkBox = new JCheckBox("Check me");
        checkBox.setFocusable(false);
        this.add(checkBox);

        this.pack();
        this.setVisible(true);
    }
}

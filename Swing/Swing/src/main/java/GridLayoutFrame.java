import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame extends JFrame {
    public GridLayoutFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setLayout(new GridLayout(3,3, 5,5));

        for (int i = 0; i < 9; i++) {
            this.add(new JButton(String.valueOf(i+1)));
        }

        this.setVisible(true);
    }
}

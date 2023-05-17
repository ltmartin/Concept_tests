import javax.swing.*;
import java.awt.*;

public class JRadioButtonFrame extends JFrame {

    public JRadioButtonFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setLayout(new FlowLayout());

        JRadioButton bt1 = new JRadioButton("pizza");
        JRadioButton bt2 = new JRadioButton("hamburger");
        JRadioButton bt3 = new JRadioButton("pasta");

        bt1.addActionListener(e -> System.out.println(bt1.getText()));
        bt2.addActionListener(e -> System.out.println(bt2.getText()));
        bt3.addActionListener(e -> System.out.println(bt3.getText()));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(bt1);
        buttonGroup.add(bt2);
        buttonGroup.add(bt3);
        this.add(bt1);
        this.add(bt2);
        this.add(bt3);

        this.pack();
        this.setVisible(true);
    }
}

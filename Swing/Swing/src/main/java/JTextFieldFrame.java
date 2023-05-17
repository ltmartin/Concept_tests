import javax.swing.*;
import java.awt.*;

public class JTextFieldFrame extends JFrame{

    public JTextFieldFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setLayout(new FlowLayout());

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(250,40));
        tf.setFont(new Font("Consolas", Font.BOLD, 25));
        tf.setForeground(Color.white);
        tf.setBackground(Color.blue);

        JButton button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(e -> System.out.println(tf.getText()));

        this.add(tf);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }
}

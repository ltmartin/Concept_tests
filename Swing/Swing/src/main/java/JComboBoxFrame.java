import javax.swing.*;
import java.awt.*;

public class JComboBoxFrame extends JFrame {
    public JComboBoxFrame() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setLayout(new FlowLayout());

        String[] elements = {"item1", "item2", "item3"};
        JComboBox<String> comboBox = new JComboBox<>(elements);
        comboBox.addActionListener(e -> System.out.println(comboBox.getSelectedItem().toString()));

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }
}

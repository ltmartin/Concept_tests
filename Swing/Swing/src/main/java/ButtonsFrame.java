import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class ButtonsFrame extends JFrame{

    private List<JButton> buttons;
    public ButtonsFrame(){
        buttons = createButtons();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocation(200, 200);
        this.setLayout(null);
        this.setVisible(true);

        buttons.forEach(this::add);
    }

    private List<JButton> createButtons() {
        buttons = new LinkedList<>();

        JButton button1 = new JButton();
        button1.setBounds(100, 100, 200, 50);
        button1.setText("I'm a button");
        button1.setFocusable(false);
        button1.addActionListener(e -> System.out.println(((JButton)e.getSource()).getText()));
        buttons.add(button1);

        return buttons;
    }


}

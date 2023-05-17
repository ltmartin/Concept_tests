import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class BorderLayoutFrame extends JFrame {
    public BorderLayoutFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setLayout(new BorderLayout(10,10));

        List<JPanel> panels = createPanels();
        this.add(panels.get(0), BorderLayout.NORTH);
        this.add(panels.get(1), BorderLayout.WEST);
        this.add(panels.get(2), BorderLayout.EAST);
        this.add(panels.get(3), BorderLayout.SOUTH);
        this.add(panels.get(4), BorderLayout.CENTER);

        this.setVisible(true);
    }

    private List<JPanel> createPanels() {
        List<JPanel> panels = new LinkedList<>();

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();

        jPanel1.setBackground(Color.red);
        jPanel2.setBackground(Color.green);
        jPanel3.setBackground(Color.yellow);
        jPanel4.setBackground(Color.magenta);
        jPanel5.setBackground(Color.blue);

        jPanel1.setPreferredSize(new Dimension(100,100));
        jPanel2.setPreferredSize(new Dimension(50,100));
        jPanel3.setPreferredSize(new Dimension(50,100));
        jPanel4.setPreferredSize(new Dimension(100,100));
        jPanel5.setPreferredSize(new Dimension(100,100));

        panels.add(jPanel1);
        panels.add(jPanel2);
        panels.add(jPanel3);
        panels.add(jPanel4);
        panels.add(jPanel5);

        return panels;
    }
}

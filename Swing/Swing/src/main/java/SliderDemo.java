import javax.swing.*;
import java.awt.*;

public class SliderDemo {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JSlider slider;

    public SliderDemo() {
        frame = new JFrame("Slider Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        label = new JLabel();

        slider = new JSlider(0,100, 50);
        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setOrientation(SwingConstants.VERTICAL);

        slider.addChangeListener(l -> label.setText(String.valueOf(slider.getValue())));
        label.setText(String.valueOf(slider.getValue()));

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420,420);
        frame.setVisible(true);
    }
}

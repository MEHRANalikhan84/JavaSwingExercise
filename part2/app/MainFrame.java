package part2.app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ShowPanel showPanel;
    private ControlPanel controlPanel;

    public MainFrame() {
        setTitle("Image Scaler");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        showPanel = new ShowPanel();
        controlPanel = new ControlPanel(showPanel);

        add(showPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

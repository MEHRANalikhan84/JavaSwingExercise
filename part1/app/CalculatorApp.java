package part1.app;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class CalculatorApp extends JFrame {
    public CalculatorApp() {
        setTitle("Graphical Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        DisplayPanel display = new DisplayPanel();
        ButtonPanel buttons = new ButtonPanel(display);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

        setVisible(true);
    }
}

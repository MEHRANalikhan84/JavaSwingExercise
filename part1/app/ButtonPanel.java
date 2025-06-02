package part1.app;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private static final String[] BUTTONS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "b"
    };

    public ButtonPanel(DisplayPanel display) {
        setLayout(new GridLayout(5, 4, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ActionListener listener = e -> {
            String cmd = ((JButton) e.getSource()).getText();
            if ("=".equals(cmd)) {
                String expr = display.getExpression();
                String result = EvalUtil.eval(expr);
                display.setExpression(result);
            } else if ("C".equals(cmd)) {
                display.setExpression("");
            } else if ("b".equals(cmd)) {
                String expr = display.getExpression();
                if (expr.length() > 0) {
                    display.setExpression(expr.substring(0, expr.length() - 1));
                }
            } else {
                display.setExpression(display.getExpression() + cmd);
            }
        };

        for (String label : BUTTONS) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(listener);
            add(button);
        }
    }
}
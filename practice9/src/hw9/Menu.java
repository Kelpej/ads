package hw9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Menu {
    JFrame frame;
    private JPanel main;
    private JLabel maxNumber;
    private JTextField max;
    private JTextField numberOfExpressions;
    private JButton startButton;
    private JLabel expressions;

    private int maxNum;
    private int numExpr;

    public Menu() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern digits = Pattern.compile("\\d+");
                var str1 = max.getText();
                var str2 = numberOfExpressions.getText();
                if (!str1.isEmpty() && !str2.isEmpty())
                    if (str1.matches(digits.pattern()) && str2.matches(digits.pattern())) {
                        maxNum = Integer.parseInt(str1);
                        numExpr = Integer.parseInt(str2);
                    }
                Math math = new Math(numExpr, maxNum);
                math.action();
                math.buildUI();
            }
        });
    }

    private void buildUI() {
        frame = new JFrame();
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Menu().buildUI();
    }
}

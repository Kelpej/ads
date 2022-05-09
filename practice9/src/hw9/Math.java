package hw9;

import hw9.Expression;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Math {
    private record Pair(int actual, int expected){
        @Override
        public String toString() {
            return "actual= " + actual +
                    ", expected=" + expected;
        }
    }

    private JFrame frame;
    private JButton submitButton;
    private JPanel mainPanel;
    private JTextField answerField;
    private JLabel expression;

    private final ArrayList<Expression> expressions = new ArrayList<>();
    private Iterator<Expression> iterator;
    private final ArrayList<Pair> answers = new ArrayList<>();

    private int answer;
    private int expected;
    private int rightAnswers;

    Math(int exprNum, int maxNumber) {
        for (int i = 0; i < exprNum; i++) {
            expressions.add(new Expression(maxNumber));
        }
        System.out.println(expressions);
    }

    public Math() {

    }

    public void buildUI() {
        frame = new JFrame();
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        iterator = expressions.iterator();
        nextExpression();
    }

    private void nextExpression() {
        if (iterator.hasNext()) {
            Expression expr = iterator.next();
            expression.setText(expr.toString());
            expected = expr.getExpected();
            answerField.setText("");
            frame.repaint();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "The game is over!\n" +
                rightAnswers + " right answers out of " + expressions.size() + '\n');
            for (Pair pair : answers)
                System.out.println(pair);
        }
    }

    public void action() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    answer = Integer.parseInt(answerField.getText());
                    System.out.println(answer);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(mainPanel, "Only integer!");
                }

                answers.add(new Pair(answer, expected));
                if (answer == expected)
                    rightAnswers++;

                nextExpression();
            }
        });
    }
}

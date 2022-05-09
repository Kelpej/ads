package hw11;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ShowDictionary extends JFrame{
    private JScrollPane scrollPane;
    private JPanel panel = new JPanel();

    public ShowDictionary(List<String> words, List<Map<String, Integer>> freq) {
        this.setSize(new Dimension(300, 600));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        words.forEach(word -> {
            String text = word + ": " + Dictionary.findOccurrences(word, freq);
            System.out.println(text);
            JLabel label = new JLabel(text);
            label.setFont(new Font("YU Gothic UI Semilight", Font.PLAIN, 14));
            panel.add(label);
        });

        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(new Rectangle(300, 600));
        this.add(scrollPane);
        this.pack();
        this.setVisible(true);
    }
}

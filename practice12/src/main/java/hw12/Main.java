package hw12;

import pr12.FileSizeException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static javax.swing.BoxLayout.*;

public class Main extends JFrame {
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, Y_AXIS));
        panel.add(Box.createVerticalGlue());

        final JLabel label = new JLabel("Choose a text file:");
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton start = new JButton("Browse");
        start.setAlignmentX(CENTER_ALIGNMENT);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chosenFile = new JFileChooser();
                chosenFile.setMultiSelectionEnabled(true);
                int ret = chosenFile.showDialog(null, "Open");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File[] files = chosenFile.getSelectedFiles();

                    List<String> words = Arrays.stream(files)
                            .map(file -> {
                                try {
                                    return Dictionary.readFile(file);
                                } catch (FileSizeException fse) {
                                    System.err.println(fse.getMessage());
                                    return null;
                                }
                            })
                            .filter(Objects::nonNull)
                            .map(Dictionary::words)
                            .flatMap(List::stream)
                            .distinct()
                            .sorted()
                            .toList();
                    System.out.println(words);
                    writeDictionary(words);
                    List<Map<String, Integer>> freq = Arrays.stream(files)
                            .map(file -> {
                                try {
                                    return Dictionary.readFile(file);
                                } catch (FileSizeException fse) {
                                    System.err.println(fse.getMessage());
                                    return null;
                                }
                            })
                            .filter(Objects::nonNull)
                            .map(Dictionary::words)
                            .map(Dictionary::wordFrequencies)
                            .toList();

                    System.out.println(Arrays.toString(files));
                    System.out.println(Dictionary.fileNames);
                    showDictionary(words, freq);
                }
            }
        });

        panel.add(start);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);

        setPreferredSize(new Dimension(200, 100));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    void writeDictionary(List<String> words) {
        try {
            FileWriter fw = new FileWriter("./dictionary.txt");
            for (String word : words) {
                fw.write(word + '\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void showDictionary(List<String> words, List<Map<String, Integer>> freq) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var dictionary = new ShowDictionary(words, freq);
    }
}
package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame {

    public Main() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                    File file = chosenFile.getSelectedFile();
                    printFile(file.getAbsolutePath());
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
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }


    void printFile(String path) {
        if (isReadable(path)) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFrame frame = new JFrame();
            frame.setSize(800, 400);
            frame.getContentPane().setLayout(new FlowLayout());


            JPanel printPanel = new JPanel();
            printPanel.setLayout(new BoxLayout(printPanel, BoxLayout.Y_AXIS));

            printPanel.add(Box.createVerticalGlue());

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                int y = 10;
                while ((line = br.readLine()) != null) {
                    final JLabel label = new JLabel(line);
                    label.setLocation(10, y);
                    printPanel.add(label);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            printPanel.setVisible(true);
            printPanel.add(Box.createRigidArea(new Dimension(10, 10)));
            printPanel.add(Box.createVerticalGlue());
            frame.add(printPanel);

            setPreferredSize(new Dimension(260, 220));
            pack();
            setLocationRelativeTo(null);
            printPanel.setVisible(true);
            frame.setVisible(true);

        }
    }

    boolean isReadable(String path) {
        StringBuilder result = new StringBuilder();
        String toCompare = ".txt";
        for (int i = path.length() - 4; i < path.length(); i++) {
            result.append(path.charAt(i));
        }
        System.out.println(result);
        return result.toString().equals(toCompare);
    }
}
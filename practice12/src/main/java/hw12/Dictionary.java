package hw12;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import pr12.FileSizeException;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Dictionary {
    public static List<String> fileNames = new ArrayList<>();

    public static String readFile(File file) throws FileSizeException {
        long size = 0;
        try {
            size = Files.size(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (size < 150 * 1024) {
            throw new FileSizeException(file.getName() + " is not big enough.");
        }

        if (file.getName().endsWith(".docx"))
            return readDocxFile(file);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            fileNames.add(file.getName());
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            return sb.toString();
        } catch (IOException io) {
            io.printStackTrace();
            return null;
        }
    }

    public static String readDocxFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            fileNames.add(file.getName());
            XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
            StringBuilder result = new StringBuilder();

            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs)
                result.append(paragraph.getText());
            return result.toString();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> words(String input) {
        return Arrays.stream(input.toLowerCase().split("[\\n\\t\\r,.:;!?*# ]+"))
                .toList();
    }

    public static Map<String, Integer> wordFrequencies(List<String> input) {
        HashSet<String> set = new HashSet<>(input);
        Map<String, Integer> result = new TreeMap<>();
        set.forEach(s -> result.put(s, 0));
        input.forEach(s -> {
            Integer count = result.get(s);
            if (result.containsKey(s))
                result.put(s, count + 1);
        });
        return result;
    }

    public static String findOccurrences(String word, List<Map<String, Integer>> freq) {
        StringBuilder result = new StringBuilder();
        int total = 0;

        for (int i = 0; i < freq.size(); i++) {
            var map = freq.get(i);

            if (map.containsKey(word)) {
                result.append('[')
                        .append(fileNames.get(i)).append(" : ").append(map.get(word))
                        .append(']')
                        .append(' ');
                total += map.get(word);
            }
        }
        result.insert(0, total + ", ");
        return result.toString();
    }
}

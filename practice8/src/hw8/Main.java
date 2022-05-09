package hw8;

import java.io.*;
import java.nio.file.Files;

import java.util.*;

public class Main {
    private static String readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    private static List<String> words(String input) {
        return Arrays.stream(input.toLowerCase().split("[,.:;!?*# ]+"))
                .toList();
    }


    private static Map<String, Integer> wordFrequencies(String[] input) {
        HashSet<String> set = new HashSet<>(List.of(input));
        Map<String, Integer> result = new TreeMap<String, Integer>();
        set.forEach(s -> result.put(s, 0));
        Arrays.stream(input).forEach(s -> {
            Integer count = result.get(s);
            if (result.containsKey(s))
                result.put(s, count + 1);
        });
        return result;
    }
}

package hw8;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static String readFile(String path) throws IOException {
        StringBuilder string = new StringBuilder();
        Path filePath = Paths.get(path);
        BufferedReader reader = Files.newBufferedReader(filePath);

        String st;
        while ((st = reader.readLine()) != null)
            string.append(st);
        return string.toString();
    }

    private static String[] words(String input) {
        input = input.toLowerCase();
        String[] result = input.split("[,.:;!? ]+");
        Arrays.sort(result);
        return result;
    }

    private static String[] wordsSet(String[] input) {
        Set<String> result = new HashSet<String>(List.of(input));
        return result.toArray(String[]::new);
    }

    private static Map<String, Integer> wordFrequencies(String[] input, String[] set) {
        Map<String, Integer> result = new TreeMap<String, Integer>();
        Arrays.stream(set).forEach(s -> result.put(s, 0));
        Arrays.stream(input).forEach(s -> {
            Integer count = result.get(s);
            if (result.containsKey(s))
                result.put(s, count + 1);
        });
        return result;
    }

    public static void main(String[] args) {
        String input = null;
        try {
            input = readFile("src/hw8/text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(input);
        String[] words = words(input);
        System.out.println("------------");
        Map<String, Integer> freq = wordFrequencies(words, wordsSet(words));
        for (Map.Entry<String, Integer> entry : freq.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

    }
}

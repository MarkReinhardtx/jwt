package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        String file1 = Files.readString(Paths.get(filePath1));
        String file2 = Files.readString(Paths.get(filePath2));
        Map<String, Object> parsedFile1 = Parser.parse(file1);
        Map<String, Object> parsedFile2 = Parser.parse(file2);

        Set<String> keys1 = parsedFile1.keySet();
        Set<String> keysSort = new TreeSet<>(keys1);
        Set<String> keys2 = parsedFile2.keySet();
        keysSort.addAll(keys2);

        List<String> diff = new ArrayList<>();

        for (String key : keysSort) {
            Object value1 = parsedFile1.get(key);
            Object value2 = parsedFile2.get(key);
            if (value1 == null && value2 != null) {
                diff.add("  + " + key + ": " +  value2 + "\r\n");
            } else if (value1 != null && value2 == null) {
                diff.add("  - " + key + ": " +  value1 + "\r\n");
            } else if (value1.equals(value2)) {
                diff.add("    " + key + ": " +  value2 + "\r\n");
            } else {
                diff.add("  - " + key + ": " +  value1 + "\r\n");
                diff.add("  + " + key + ": " +  value2 + "\r\n");
            }
        }

        return "{\r\n" + diff.stream().collect(Collectors.joining()) + "}";
    }
}

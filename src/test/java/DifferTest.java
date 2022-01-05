import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {


    public static String getPath(String file) {
        return Paths.get("src/test/java/resources/" + file).toString();
    }

    public static String getFile(String file) throws IOException {
        Path path = Paths.get(getPath(file));
        return Files.readString(path);
    }

    @Test
    public void getDifferJsonYml() throws Exception {
        String expected = getFile("file1_file2.txt")
                .substring(0, getFile("file1_file2.txt").length() - 1);
        String result = Differ.generate(getPath("file1.json"), getPath("file2.json"));
        Assertions.assertEquals(expected, result);

        String expectedYml = getFile("file1_file2_yml.txt")
                .substring(0, getFile("file1_file2_yml.txt").length() - 1);
        String resultYml = Differ.generate(getPath("file1.yml"), getPath("file2.yml"));
        Assertions.assertEquals(expectedYml, resultYml);

        String expected2 = getFile("file1_file2_2.txt")
                .substring(0, getFile("file1_file2_2.txt").length() - 1);
        String result2 = Differ.generate(getPath("file3.json"), getPath("file4.json"));
        Assertions.assertEquals(expected2, result2);

        String expected3 = getFile("file1_file2_plain.txt")
                .substring(0, getFile("file1_file2_plain.txt").length() - 1);
        String result3 = Differ.generate(getPath("file1.json"), getPath("file2.json"), "plain");
        Assertions.assertEquals(expected3, result3);

        String expected4 = getFile("file1_file2_plain2.txt")
                .substring(0, getFile("file1_file2_plain2.txt").length() - 1);
        String result4 = Differ.generate(getPath("file3.json"), getPath("file4.json"), "plain");
        Assertions.assertEquals(expected4, result4);

        String expected5 = getFile("file1_file2_yml_json.txt")
                .substring(0, getFile("file1_file2_yml_json.txt").length() - 1);
        String result5 = Differ.generate(getPath("file3.yml"), getPath("file4.yml"), "json");
        Assertions.assertEquals(expected5, result5);
    }

}

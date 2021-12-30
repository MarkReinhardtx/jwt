import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {


    public static String getPath(String file) {
        return Paths.get("src/main/" + file).toString();
    }

    public static String getFile(String file) throws IOException {
        Path path = Paths.get(getPath(file));
        return Files.readString(path);
    }

    @Test
    public void getDifferJson() throws Exception {
        String expected = getFile("file1_file2.txt");
        String result = Differ.generate(getPath("file1.json"), getPath("file2.json"));
        Assertions.assertEquals(expected, result);

        String expectedYml = getFile("file1_file2_yml.txt");
        String resultYml = Differ.generate(getPath("file1.yml"), getPath("file2.yml"));
        Assertions.assertEquals(expectedYml, resultYml);

        String expected2 = getFile("file1_file2_2.txt");
        String result2 = Differ.generate(getPath("file3.json"), getPath("file4.json"));
        Assertions.assertEquals(expected2, result2);
    }

}

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
    public void differTestJson() throws Exception {
        String expected1 = getFile("file1_file2.txt");
        String actual1 = Differ.generate(getPath("file1.json"), getPath("file2.json"));
        Assertions.assertEquals(expected1, actual1);
    }
}

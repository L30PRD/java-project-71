/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static String expectedJson;
    private static String expectedStylish;
    private static String expectedPlain;
    private static String fileJson1;
    private static String fileJson2;
    private static String fileYml1;
    private static String fileYml2;

    @BeforeAll
    public static void init() throws IOException {
        fileJson1 = filePath("filepath1.json");
        fileJson2 = filePath("filepath2.json");
        fileYml1 = filePath("filepath1.yml");
        fileYml2 = filePath("filepath2.yml");

        String result1 = filePath("jsonTestResult.json");
        String result2 = filePath("stylishTestResult.txt");
        String result3 = filePath("plainTestResult.txt");

        expectedJson = getData(result1);
        expectedStylish = getData(result2);
        expectedPlain = getData(result3);
    }

    public static String filePath(String file) {
        return "./src/test/resources/" + file;
    }

    public static String getData(String path) throws IOException {
        return  Files.readString(Paths.get(path).toAbsolutePath().normalize());
    }

    @Test
    void jsonTest() throws Exception {

        String actual = Differ.generate(fileJson1, fileJson2, "json");
        assertEquals(expectedJson, actual);
    }

    @Test
    void stylishTest() throws Exception {

        String actual = Differ.generate(fileJson1, fileJson2, "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    void ymlTest() throws Exception {

        String actual = Differ.generate(fileYml1, fileYml2);
        assertEquals(expectedStylish, actual);
    }

    @Test
    void plainTest() throws Exception {

        String actual = Differ.generate(fileYml1, fileYml2, "plain");
        assertEquals(expectedPlain, actual);
    }
}

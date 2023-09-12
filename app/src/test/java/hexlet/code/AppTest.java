/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    final String filePath1 = "./src/test/resources/filepath1.json";
    final String filePath2 = "./src/test/resources/filepath2.json";
    final String emptyFile = "./src/test/resources/empty.json";

    @Test
    void jsonTest() throws Exception {
        String expect = "" + "[{\"status\":\"+\",\"name\":\"chars\",\"object1\":[\"a\",\"b\",\"c\",\"d\"],"
                + "\"object2\":[\"a\",\"b\",\"c\"]},{\"status\":\"-\",\"name\":\"follow\",\"object1\":false,"
                + "\"object2\":null},{\"status\":\" \",\"name\":\"host\",\"object1\":\"hexlet.io\",\"object2\":null},"
                + "{\"status\":\"-\",\"name\":\"letters\",\"object1\":[\"a\",\"b\"],\"object2\":null},"
                + "{\"status\":\"+\",\"name\":\"numbers\",\"object1\":[1,2,3,4],\"object2\":[1,2,4,5]},"
                + "{\"status\":\"-\",\"name\":\"proxy\",\"object1\":\"123.234.53.22\",\"object2\":null},"
                + "{\"status\":\"+\",\"name\":\"timeout\",\"object1\":50,\"object2\":20},"
                + "{\"status\":\"+\",\"name\":\"verbose\",\"object1\":true,\"object2\":null}]";

        String actual = Differ.generate(filePath1, filePath2, "JSON");
        assertEquals(expect, actual);
        String actual2 = Differ.generate(emptyFile, emptyFile, "JSON");
        assertEquals("[]", actual2);
    }

    @Test
    void stylishTest() throws Exception {
        String expect = "{\n  + chars: [a, b, c, d]\n  + chars: [a, b, c]\n  - follow: false"
                + "\n    host: hexlet.io\n  - letters: [a, b]\n  + numbers: [1, 2, 3, 4]\n  + numbers: [1, 2, 4, 5]"
                + "\n  - proxy: 123.234.53.22\n  + timeout: 50\n  + timeout: 20\n  + verbose: true\n}";

        String actual = Differ.generate(filePath1, filePath2, "Stylish");
        assertEquals(expect, actual);
        String actual2 = Differ.generate(emptyFile, emptyFile);
        assertEquals("{\n}", actual2);
    }

    @Test
    void testError() {
        Throwable thrown = assertThrows(Exception.class, ()
                -> Differ.generate("emptyFile.json", emptyFile, "JSON"));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void ymlTest() throws Exception {
        String expected3 = "{\n    chars1: [a, b, c]\n  + chars2: [d, e, f]\n  + chars2: false\n"
                + "  + checked: false\n  + checked: true\n  + default: null\n  + default: [value1, value2]\n"
                + "  + id: 45\n  - key1: value1\n  + key2: value2\n    numbers1: [1, 2, 3, 4]\n"
                + "  + numbers2: [2, 3, 4, 5]\n  + numbers2: [22, 33, 44, 55]\n  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n  + obj1: {nestedKey=value, isNested=true}\n  + setting1: Some value\n"
                + "  + setting1: Another value\n  + setting2: 200\n  + setting2: 300\n  + setting3: true\n"
                + "  + setting3: none\n}";

        String pathfile1 = "./src/test/resources/filepath1.yml";
        String pathfile2 = "./src/test/resources/filepath2.yml";

        String actual3 = Differ.generate(pathfile1, pathfile2);

        assertEquals(expected3, actual3);
    }
}

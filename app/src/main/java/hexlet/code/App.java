package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    String filePath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
     String filePath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]", defaultValue = "stylish")
     String format;

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println(Differ.generate(filePath1, filePath2, format));
            return 0;
        } catch (IOException e) {
            return 1;
        }
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

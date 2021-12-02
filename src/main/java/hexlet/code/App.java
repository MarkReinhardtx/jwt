package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 0.3",
        description = "Compares two configuration files and shows a difference.")

public class App {

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            required=true)
            private String required;
    @Parameters(index = "0", description = "path to first file")
    private String file1;
    @Parameters(index = "1", description = "path to second file")
    private String file2;

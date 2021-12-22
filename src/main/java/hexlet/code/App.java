package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {

    @Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            description = "output format: stylish, plain, json, no-format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish")
    private String format;

    @Override
    public final void run() {
        try {
            System.out.println(Differ.generate(filePath1, filePath2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final var commandLineRunner = new CommandLine(new App());
        commandLineRunner.execute(args);

        final String result = commandLineRunner.getExecutionResult();
        System.out.println(result);
    }
}

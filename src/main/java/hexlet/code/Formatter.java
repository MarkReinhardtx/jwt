package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String forma(String format, Map<String, Map<String, Object[]>> diff) {

        return switch (format) {
            case "plain" -> Plain.format(diff);
            case "stylish" -> Stylish.format(diff);
            default -> throw new RuntimeException();
        };
    }
}

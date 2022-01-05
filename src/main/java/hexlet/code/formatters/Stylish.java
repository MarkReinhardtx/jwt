package hexlet.code.formatters;

import java.util.Map;

public class Stylish {

    public static String format(Map<String, Map<String, Object[]>> diff) {
        String formatted = "{\n";
        for (String key : diff.keySet()) {
            Map<String, Object[]> diffValue = diff.get(key);
            if (diffValue.containsKey("add")) {
                formatted += "  + " + key + ": " + diffValue.get("add")[0] + "\n";
            } else if (diffValue.containsKey("delete")) {
                formatted += "  - " + key + ": " + diffValue.get("delete")[0] + "\n";
            } else if (diffValue.containsKey("same")) {
                formatted += "    " + key + ": " + diffValue.get("same")[0] + "\n";
            } else {
                formatted += "  - " + key + ": " + diffValue.get("changed")[0] + "\n";
                formatted += "  + " + key + ": " + diffValue.get("changed")[1] + "\n";
            }
        }
        return formatted + "}";
    }
}

package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;

public class Plain {

    public static String format(Map<String, Map<String, Object[]>> diff) {
        String formatted = "";
        for (String key : diff.keySet()) {
            Map<String, Object[]> diffValue = diff.get(key);
            if (diffValue.containsKey("same")) {
                continue;
            }

            formatted += "Property '" + key + "' was ";
            if (diffValue.containsKey("add")) {
                formatted += "added with value: " + filterValue(diffValue.get("add")[0]) + "\n";
            } else if (diffValue.containsKey("delete")) {
                formatted += "removed\n";
            } else {
                formatted += "updated. From " + filterValue(diffValue.get("changed")[0])
                        + " to " + filterValue(diffValue.get("changed")[1]) + "\n";
            }
        }

        return formatted;
    }

    private static boolean complex(Object obj) {
        return obj != null
                && (obj.getClass().isArray()
                || Map.class.isAssignableFrom(obj.getClass())
                || ArrayList.class.isAssignableFrom(obj.getClass()));
    }

    private static Object filterValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (complex(value)) {
            return "[complex value]";
        }
        return value;
    }
}

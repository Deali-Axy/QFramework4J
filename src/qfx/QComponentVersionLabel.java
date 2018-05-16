package qfx;

import java.util.HashMap;
import java.util.Map;

/*
 * name: QComponentVersionLabel
 * description: 版本标签枚举
 * date: 1/10/2018 0010 - 1:17
 */
public enum QComponentVersionLabel
{
    ALPHA, BETA, RC, RELEASE, FINAL;

    // Implementing a fromString method on an enum type
    private static final Map<String, QComponentVersionLabel> stringToEnum = new HashMap<String, QComponentVersionLabel>();
    static
    {
        // Initialize map from constant name to enum constant
        for (QComponentVersionLabel blah : values())
        {
            stringToEnum.put(blah.toString(), blah);
        }
    }

    // Returns Blah for string, or null if string is invalid
    public static QComponentVersionLabel fromString(String symbol)
    {
        return stringToEnum.get(symbol);
    }
}

package qfx.module;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dymc Key One QFramework Module
 */
public class DymcOne implements IQModule {
    private static Date _date = new Date();
    private static final String _dateFormat = "MMddHHmm";

    public static String getDymcOneTimeStr() {
        SimpleDateFormat ft = new SimpleDateFormat(_dateFormat);
        return ft.format(_date);
    }

    public static String getDymcKey(String staticKey) {
        try {
            return Hash_MD5_32(getDymcOneTimeStr() + staticKey);
        } catch (Exception ex) {
            System.out.println("获取DymcKey错误！" + ex.getMessage());
            return "";
        }
    }

    private static String Hash_MD5_32(String word) throws Exception {
        return Hash_MD5_32(word, false);
    }

    private static String Hash_MD5_32(String word, boolean upperCase) throws Exception {
        // 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(word.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        String result = new BigInteger(1, md.digest()).toString(16);
        return upperCase ? result.toUpperCase() : result.toLowerCase();
    }
}

package qfx.io;

import java.nio.file.*;

/**
 * name: QPath
 * description: Path operate
 * date: 1/10/2018 0010 - 10:00
 */
public class QPath
{
    public static String changeExtension(String path, String ext)
    {
        String result = "";
        if (hasExtension(path))
        {
            String dir = join(getDirectoryName(path), GetFileNameWithoutExtension(path));
            result = dir + "." + ext;
        } else
            result = path + "." + ext;

        return result;
    }

    public static String join(String first, String... params)
    {
        Path p = (Path) Paths.get(first, params);
        return p.toString();
    }

    public static String getDirectoryName(String param)
    {
        Path p = Paths.get(param);
        String fileName = p.getFileName().toString();
        return param.substring(0, param.indexOf(fileName));
    }

    public static String getExtension(String param)
    {
        Path p = Paths.get(param);
        String fileName = p.getFileName().toString();
        if (hasExtension(fileName))
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else
            return "";
    }

    /**
     * description: 获取路径中的文件名
    */
    public static String getFileName(String param)
    {
        Path p = Paths.get(param);
        return p.getFileName().toString();
    }


    public static String GetFileNameWithoutExtension(String param)
    {
        Path p = Paths.get(param);
        String fileName = p.getFileName().toString();
        if (hasExtension(fileName))
            return fileName.substring(0, fileName.lastIndexOf("."));
        else
            return fileName;
    }

    public static boolean hasExtension(String param)
    {
        String fileName = getFileName(param);
        return fileName.contains(".");
    }
}

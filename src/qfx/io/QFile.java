package qfx.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QFile
{
    public static boolean exists(String fileName)
    {
        Path p = Paths.get(fileName);
        return Files.exists(p);
    }

}

package qfx.io;

import qfx.QComponent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * name: QDirectory
 * description:
 * date: 1/10/2018 0010 - 9:10
 */
public class QDirectory extends QComponent
{
    /**
     * description: return bool for the existence of a dir
     */
    public static boolean exists(String dirName)
    {
        Path p = Paths.get(dirName);
        return Files.exists(p) && Files.isDirectory(p);
    }


    /**
     * description: Create a dir if it doesn't exist
     */
    public static boolean create(String dirName)
    {
        Path p = Paths.get(dirName);
        if (Files.notExists(p))
        {
            try
            {
                Files.createDirectory(p);
            } catch (Exception ex)
            {
                return false;
            }
        }
        return true;
    }
}

package qfxtest;

import qfx.QComponent;
import qfx.QComponentVersionLabel;
import qfx.io.*;
import qfx.module.DymcOne;
import qfx.util.QDateTime;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        QConsole console = new QConsole(System.in, System.out);

        TestQCom.CodeVersion.setMajor(1);
        TestQCom.CodeVersion.setMinor(2);
        TestQCom.CodeVersion.setUpdate(3);
        TestQCom.CodeVersion.setLabel(QComponentVersionLabel.FINAL);

        TestQCom.CodeVersion.setVersion(1, 2, 4, QComponentVersionLabel.BETA);

        console.writeLine(new File("").getCanonicalPath());

        console.writeLine(DymcOne.getDymcKey("123"));
        console.writeLine("版本号：" + TestQCom.CodeVersion.toString());

        console.writeLine("DymcOneTimeStr:" + QDateTime.now().toString("MMddHHmm"));

        console.writeLine(QDateTime.now().toLongTimeString());
        console.writeLine(new Date().toString());

        console.write("Please enter a dir name:");
        String dirName = console.readLine();

        String dir = QPath.join("C:", "QOS", "1", "2", "3.abc");
        console.writeLine(dir);
        Path p = Paths.get(dir);
        console.writeLine(p.getFileName().toString());
        console.writeLine(QPath.getFileName(dir));
        console.writeLine(QPath.GetFileNameWithoutExtension(dir));
        console.writeLine(QPath.getExtension(dir));
        console.writeLine(QPath.getDirectoryName(dir));
        console.writeLine(QPath.changeExtension(dir, "hello"));

        console.writeLine("Helloworld");
        console.write("Please enter your name:");
        String name = console.readLine();
        console.writeLine("Hello %s!", name);
    }
}

class TestQCom extends QComponent {

}

package qfxtest;

import qfx.QFramework;
import qfx.diagnostics.QDebug;
import qfx.io.QConsole;
import qfx.io.QStreamWriter;
import qfx.util.QMath;

public class QFrameworkTest {
    public static void main(String args[]) throws Exception {
        QConsole console = new QConsole(System.in, System.out);
        console.writeLine(QFramework.getVersion().toString());
        console.writeLine(QMath.max(0, 2, 0));
        console.writeLine(QMath.max(new double[]{-1, -2, -3, -4, -5, -6, -7, -8, -9}));

//        for (long i = 0; i < 10000000; i++) {
//            console.writeLine("%d %s 质数。", i, QMath.isPrimeNumber(i) ? "是" : "不是");
//            console.writeLine("%d %s 水仙花数。", i, QMath.isNarcissisticNumber(i) ? "是" : "不是");
//        }

        QDebug qdb = new QDebug();
        qdb.CodeLocation = "qfxtest.QFrameworkTest";
        qdb.codeFuntion = "main";
        qdb.setFormat("${date} ${time} ${content}");
        qdb.fileOutput = true;
        qdb.debug(qdb.getWorkPath());
        qdb.info(qdb.getClass().toGenericString());

        QStreamWriter qStreamWriter = new QStreamWriter("/home/da/code/java/QFramework/QFrameworkCore/QDiagnostics/test.txt");
        qStreamWriter.writeLine("helloworld3");
        qStreamWriter.write("12312312");
        qStreamWriter.write("sdwdqweqe");
        qStreamWriter.writeLine("");
        qStreamWriter.write("520");
        qStreamWriter.close();
    }
}

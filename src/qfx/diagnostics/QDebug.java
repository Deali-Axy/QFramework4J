package qfx.diagnostics;

import qfx.QComponent;
import qfx.QComponentVersion;
import qfx.QComponentVersionLabel;
import qfx.io.QDirectory;
import qfx.io.QPath;
import qfx.util.QDateTime;

import java.io.*;
import java.lang.invoke.ConstantCallSite;

/**
 * name: QDebug
 * description:
 * date: 1/12/2018 0012 - 1:48
 */
public class QDebug extends QComponent {
    /**
     * description:  QDebug默认保存日志文件的目录名
     */
    public static final String QDEBUG_DIR = "QDiagnostics";

    /**
     * description:  默认日志文件名
     */
    public static final String QDEBUG_LOG_FILE = "QDebug_Log.log";

    /**
     * description: 默认错误记录文件名
     */
    public static final String QDEBUG_ERROR_FILE = "QDebug_Error.log";

    /**
     * description: 默认应急错误日志文件
     */
    public static final String QDEBUG_CRASH_FILE = "QDebug_Crash.log";

    public QDebug() {
        CodeVersion.setVersion(1, 1, 2, QComponentVersionLabel.ALPHA);

        try {
            String runPath = new File("").getCanonicalPath();
            setWorkPath(QPath.join(runPath, "QDiagnostics"));
        } catch (Exception ex) {
            System.err.println("QDebug Init Error. " + ex.getMessage());
        }
    }

    /**
     * description: 过滤器
     */
    public QDebugLevel filter = QDebugLevel.INFO;

    private String format = "${date} ${time} ${level} ${content}";

    /**
     * 设置日志格式<br>
     * ${date}<br>
     * ${time}<br>
     * ${content}<br>
     * ${codelocation}<br>
     * ${funtion}<br>
     * ${codeversion}<br>
     * ${level}<br>
     *
     * @param format string
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * description: 控制台输出，默认打开
     */
    public boolean consoleOutput = true;

    /**
     * description: 文件输出，默认不
     */
    public boolean fileOutput = false;

    /**
     * description:  代码所在的方法
     */
    public String codeFuntion = "";

    private String _workPath = "";
    private String _logFile = "";
    private String _errorFile = "";

    /**
     * description: 设置工作目录
     */
    public void setWorkPath(String value) {
        QDirectory.create(value);
        _workPath = value;
        _logFile = QPath.join(_workPath, QDEBUG_LOG_FILE);
        _errorFile = QPath.join(_workPath, QDEBUG_ERROR_FILE);
    }

    /**
     * description: 获取工作目录
     */
    public String getWorkPath() {
        return _workPath;
    }

    public void debug(String value) {
        String output = formatProc(value, "debug");
        if (consoleOutput)
            System.out.printf("[QDB] %s\n", output);

        if (fileOutput)
            writeFile(output, _logFile);
    }

    public void info(String value) {
        String output = formatProc(value, "info");
        if (consoleOutput)
            System.out.printf("[QDB] %s\n", output);

        if (fileOutput)
            writeFile(output, _logFile);

    }

    public void warn(String value) {
        String output = formatProc(value, "warn");
        if (consoleOutput)
            System.out.printf("[QDB] %s\n", output);


        if (fileOutput)
            writeFile(output, _errorFile);

    }

    public void error(String value) {
        String output = formatProc(value, "error");
        if (consoleOutput)
            System.out.printf("[QDB] %s\n", output);


        if (fileOutput)
            writeFile(output, _errorFile);

    }

    public void fatal(String value) {
        String output = formatProc(value, "fatal");
        if (consoleOutput)
            System.out.printf("[QDB] %s\n", output);


        if (fileOutput)
            writeFile(output, _errorFile);

    }

    /**
     * Proc format output string
     *
     * @param content string
     * @param level   string
     * @return string
     */
    private String formatProc(String content, String level) {
        String temp = format;

        if (format.indexOf("${date}") >= 0)
            temp = temp.replace("${date}", QDateTime.now().toShortDateString());
        if (format.indexOf("${time}") >= 0)
            temp = temp.replace("${time}", QDateTime.now().toShortTimeString());
        if (format.indexOf("${content}") >= 0)
            temp = temp.replace("${content}", content);
        if (format.indexOf("${codelocation}") >= 0)
            temp = temp.replace("${codelocation}", CodeLocation);
        if (format.indexOf("${funtion}") >= 0)
            temp = temp.replace("${funtion}", codeFuntion);
        if (format.indexOf("${codeversion}") >= 0)
            temp = temp.replace("${codeversion}", CodeVersion.toString());
        if (format.indexOf("${level}") >= 0)
            temp = temp.replace("${level}", level);

        return temp;
    }

    private void writeFile(String value, String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(value);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            crash(e, "Can not write to QDebug file: " + filename);
        }
    }


    private void crash(Throwable value, String info) {
        System.out.printf("Ops!QDebug Crashed. ErrMsg: %s Info: %s\n", value.getMessage(), info);
    }

    /**
     * 与旧版QFxOne兼容
     *
     * @param value
     * @param level
     */
    private void log(String value, QDebugLevel level) {
        try {
            FileOutputStream fs = new FileOutputStream(_logFile, true);
            OutputStreamWriter output = new OutputStreamWriter(fs);


        } catch (Throwable e) {
            try {

            } catch (Throwable ignore) {
                crash(ignore, "QDebug 无能为力了。");
            }
        }
    }
}

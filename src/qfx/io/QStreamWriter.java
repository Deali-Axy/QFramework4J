package qfx.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

/*
 * name: QStreamWriter
 * description:
 * date: 1/12/2018 0012 - 17:24
 */
public class QStreamWriter {
    private String fileName = "";
    private BufferedWriter _bw;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public QStreamWriter(String fileName) {
        this(fileName, true);
    }

    public QStreamWriter(String fileName, boolean append) {
        this.fileName = fileName;
        try {
            FileWriter _fw = new FileWriter(fileName, append);
            _bw = new BufferedWriter(_fw);
            _bw = new BufferedWriter(_fw);
        } catch (Exception ex) {
            System.err.printf("QStreamWriter Init Error! Msg: %s \n", ex.getMessage());
        }
    }

    public void write(String value) throws Exception {
        _bw.write(value);
    }

    public void writeLine(String value) throws Exception {
        _bw.write(value);
        _bw.newLine();
    }

    public void close() {
        try {
            _bw.flush();
            _bw.close();
        } catch (Exception ex) {
            System.err.printf("QStreamWriter close Error! Msg: %s \n", ex.getMessage());
        }
    }
}

package qfx.io;

import qfx.QComponent;
import qfx.diagnostics.QDebug;

import java.io.*;

/*
 * name: QStreamReader
 * description:
 * date: 1/12/2018 0012 - 17:25
 */
public class QStreamReader extends QComponent {
    private BufferedReader _br;
    private QDebug _qdb;

    public QStreamReader() {
        this._qdb = new QDebug();

    }

    public QStreamReader(String fileName) {
        try {
            FileInputStream _fs = new FileInputStream(fileName);
            this._br = new BufferedReader(new InputStreamReader(_fs));
        } catch (FileNotFoundException e) {

        } catch (SecurityException e) {

        }
    }

    public char read() {
        try {
            return (char) this._br.read();
        } catch (IOException e) {
            return 0;
        }
    }

    public String readLine() {
        try {
            return this._br.readLine();
        } catch (IOException e) {
            return "";
        }
    }
}

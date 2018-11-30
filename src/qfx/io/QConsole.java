package qfx.io;

import qfx.QComponent;

import java.io.*;

/*
 * name: QConsole
 * description:
 * date: 1/10/2018 0010 - 10:01
 */
public class QConsole extends QComponent {
    private InputStream _in;
    private PrintStream _out;

    public QConsole(InputStream in, PrintStream out) {
        _in = in;
        _out = out;
    }

    public void write(Object msg) {
        _out.print(msg);
    }

    public void write(String msg, Object... params) {
        _out.printf(msg, params);
    }

    public void writeLine(Object msg) {
        _out.println(msg);
    }

    public void writeLine(String msg, Object... params) {
        _out.printf(msg + "\n", params);
    }

    public void printf(String msg, Object... params) {
        this.writeLine(msg, params);
    }

    public char read() {
        BufferedReader br = new BufferedReader(new InputStreamReader(_in));
        try {
            return (char) br.read();
        } catch (Exception ex) {
            writeLine("Error: %s", ex.getMessage());
            return ' ';
        }
    }

    public String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(_in));
        try {
            return br.readLine();
        } catch (Exception ex) {
            writeLine("Error: %s", ex.getMessage());
            return "";
        }
    }
}

package qfxtest.thread;

import qfx.io.QConsole;

public class RunnableDemo implements Runnable {

    private Thread t;
    private String threadname;
    private QConsole console = new QConsole(System.in, System.out);

    RunnableDemo(String name) {
        this.threadname = name;
        console.writeLine("creating %s", threadname);
    }

    @Override
    public void run() {
        console.writeLine("Running %s", threadname);
        try {
            for (int i = 0; i < 10; i++) {
                console.writeLine("Thread %s Sleep %d", threadname, i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            console.writeLine("thread %s interrupt.");
        }
        console.writeLine("thread %s exiting", threadname);
    }

    public void start() {
        console.writeLine("starting %s", threadname);
        if (t == null) {
            t = new Thread(this, threadname);
            t.start();
        }
    }

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

        RunnableDemo r3 = new RunnableDemo("thread-3");
        r3.start();
    }
}

package qfx;

public class QFramework {
    private static QComponentVersion version = new QComponentVersion(1, 1, 0, QComponentVersionLabel.ALPHA);

    private QFramework() {
        version = new QComponentVersion(1, 1, 2);
    }

    public static QComponentVersion getVersion() {
        return version;
    }
}

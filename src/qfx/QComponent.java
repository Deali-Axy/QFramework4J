package qfx;

/**
 * name: QComponent
 * description:
 * date: 1/10/2018 0010 - 1:06
 */
public class QComponent {
    /**
     * description: 组件代码版本
     */
    public static QComponentVersion CodeVersion = new QComponentVersion();

    /**
     * description: QFramework版本
     */
    public static QComponentVersion QFrameworkVersion = QFramework.getVersion();

    /**
     * description: 代码位置描述，最好包含命名空间，方便QDebug对象记录调试日志
     */
    public String CodeLocation = "";


    public static void setCodeVersion(QComponentVersion version) {
        CodeVersion.setVersion(version);
    }

    /**
     * Set Code Version
     *
     * @param major  int
     * @param minor  int
     * @param update int
     */
    public static void setCodeVersion(int major, int minor, int update) {
        CodeVersion.setVersion(major, minor, update, QComponentVersionLabel.ALPHA);
    }

    /**
     * Set code version
     *
     * @param major  int
     * @param minor  int
     * @param update int
     * @param label  QComponentVersionLabel
     */
    public static void setCodeVersion(int major, int minor, int update, QComponentVersionLabel label) {
        CodeVersion.setVersion(major, minor, update, label);
    }
}

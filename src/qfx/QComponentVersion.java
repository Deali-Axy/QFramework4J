package qfx;

/*
 * name: QComponentVersion
 * description:
 * date: 1/10/2018 0010 - 1:08
 */
public class QComponentVersion {
    /// <summary>
    /// 主版本号
    /// </summary>
    private int major = 0;

    /// <summary>
    /// 次版本号
    /// </summary>
    private int minor = 0;

    /// <summary>
    /// 版本更新号
    /// </summary>
    private int update = 0;

    private QComponentVersionLabel label = QComponentVersionLabel.ALPHA;

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public QComponentVersionLabel getLabel() {
        return label;
    }

    public void setLabel(QComponentVersionLabel label) {
        this.label = label;
    }

    public void setVersion(QComponentVersion version) {
        this.major = version.major;
        this.minor = version.minor;
        this.update = version.update;
        this.label = version.label;
    }

    public void setVersion(int major, int minor, int update) {
        this.major = major;
        this.minor = minor;
        this.update = update;
    }

    public void setVersion(int major, int minor, int update, QComponentVersionLabel label) {
        this.major = major;
        this.minor = minor;
        this.update = update;
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d %s", major, minor, update, label.toString());
    }

    public QComponentVersion() {
    }

    public QComponentVersion(int major, int minor, int update) {
        this.major = major;
        this.minor = minor;
        this.update = update;
        this.label = QComponentVersionLabel.ALPHA;
    }

    public QComponentVersion(int major, int minor, int update, QComponentVersionLabel label) {
        this.major = major;
        this.minor = minor;
        this.update = update;
        this.label = label;
    }


    /**
     * @param s_VersionStr String
     * @return QComponentVersion
     */
    public static QComponentVersion Parse(String s_VersionStr) {
        s_VersionStr = s_VersionStr.trim();

        QComponentVersion v_Ver = new QComponentVersion();
        String[] s_Vers1, s_Vers2;
        String s_Ver;

        //如果不带空格
        if (!s_VersionStr.contains(" ")) {
            v_Ver.label = QComponentVersionLabel.ALPHA;
            s_Ver = s_VersionStr;
        } else {
            s_Vers1 = s_VersionStr.split(" ");
            try {
                v_Ver.label = QComponentVersionLabel.fromString(s_Vers1[1].toUpperCase());
            } catch (Exception ex) {
                v_Ver.label = QComponentVersionLabel.ALPHA;
                //Qdb.Error("QComponentVersion.Parse(string s_VersionStr)->字符串版本Label转换为QComponentVersionLabel枚举类型失败，请检查标签字符串是否有误 ex.Message=" + ex.Message, QDebugErrorType.Fatal, "Parse");
            }
            s_Ver = s_Vers1[0];
        }

        if (!s_VersionStr.contains("."))
            return v_Ver;

        s_Vers2 = s_Ver.split(".");

        switch (s_Vers2.length) {
            case 0:
                return v_Ver;
            case 1:
                v_Ver.major = Integer.parseInt(s_Vers2[0]);
                break;
            case 2:
                v_Ver.major = Integer.parseInt(s_Vers2[0]);
                v_Ver.minor = Integer.parseInt(s_Vers2[1]);
                break;
            case 3:
                v_Ver.major = Integer.parseInt(s_Vers2[0]);
                v_Ver.minor = Integer.parseInt(s_Vers2[1]);
                v_Ver.update = Integer.parseInt(s_Vers2[2]);
                break;
        }

        return v_Ver;
    }
}

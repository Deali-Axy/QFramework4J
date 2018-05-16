package qfx.util;

import qfx.QComponent;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * name: QDateTime
 * description:
 * date: 1/12/2018 0012 - 9:51
 */
public class QDateTime extends QComponent
{
    public static QDateTime now()
    {
        return new QDateTime();
    }

    public static QDateTime parse(String format, String param)
    {
        SimpleDateFormat ft = new SimpleDateFormat(format);
        String input = param.length() == 0 ? QDateTime.now().toShortDateString() : param;
        Date t = new Date();
        try
        {
            t = ft.parse(input);
        } catch (Exception ex)
        {
        }
        return new QDateTime(t);
    }

    private Date _date = new Date();

    public QDateTime()
    {

    }

    public QDateTime(Date t)
    {
        _date = t;
    }

    @Override
    public String toString()
    {
        return _date.toString();
    }

    public String toString(String format)
    {
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(_date);
    }

    public String toShortDateString()
    {
        return this.toString("yyyy-MM-dd");
    }

    public String toLongDateString()
    {
        return this.toString("yyyy-MM-dd E");
    }

    public String toShortTimeString()
    {
        return this.toString("HH:mm:ss");
    }

    public String toLongTimeString()
    {
        return this.toString("hh:mm:ss a zzz");
    }
}

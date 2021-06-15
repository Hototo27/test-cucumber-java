package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeStamp {
    public static String get() {

        SimpleDateFormat sdfDate=new SimpleDateFormat("Y-d-m_H-M-S");
        Date now=new Date();
        String strDate=sdfDate.format(now);

        return strDate;
    }

}
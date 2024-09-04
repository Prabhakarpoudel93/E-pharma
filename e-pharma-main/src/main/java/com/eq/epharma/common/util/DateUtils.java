package com.eq.epharma.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date formatDate(Date date) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = formatter.format(date);

        Date formattedDateObj = formatter.parse(formattedDate);

        return formattedDateObj;
    }
}

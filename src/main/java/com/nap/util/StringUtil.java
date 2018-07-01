
package com.nap.util;

import java.util.Calendar;

public class StringUtil {
    
    public static String createUniqueNumber(){
        Calendar calendar = Calendar.getInstance();
        String result = calendar.get(Calendar.YEAR ) + "" + (calendar.get(Calendar.MONTH)+1)
        +"" + calendar.get(Calendar.DATE) + "" 
        +calendar.get(Calendar.HOUR_OF_DAY) + "" +
        calendar.get(Calendar.MINUTE ) + "" + 
        calendar.get(Calendar.SECOND ) + "" + calendar.get(Calendar.MILLISECOND );
        return result;
    }

}


package com.nap.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    
    public static Pattern getPattern(String regex){
        return  Pattern.compile(regex);
    }
    
    public static boolean checkPhone(String mobile){
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}";
        Pattern p = getPattern(regex);
        Matcher m = p.matcher(mobile);  
        return m.matches();
    }

}

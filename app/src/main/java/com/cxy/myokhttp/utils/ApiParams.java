/*
 * Created by Storm Zhang, Feb 13, 2014.
 */

package com.cxy.myokhttp.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ApiParams extends HashMap<String, String> {

    public ApiParams with(String key, String value) {
        put(key, value);
        return this;
    }

    public ApiParams with(String key, StringBuffer value) {
        try {
            value = new StringBuffer(URLEncoder.encode(value.toString(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        put(key, value.toString());
        return this;
    }

    public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
        return pattern.matcher(str.trim()).find();
    }

    /**
     * use value.toString()
     */
    public ApiParams with(String key, Object value) {
        String v = "";
        try {
            v = URLEncoder.encode(value.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        put(key, v);
        return this;
    }
}

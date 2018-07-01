
package com.nap.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    private JsonUtil(){};
    
    //json转对象
    public static <T> T json2Object(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    //json转列表
    public static <T> List<T> json2List(String json,Class<T> clazz){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        try {
            return objectMapper.readValue(json, javaType);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    //对象转json
    public static String bean2Json(Object obj){
        StringWriter writer = new StringWriter();
        try {
            objectMapper.writeValue(writer, obj);
            return writer.toString();
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //json转map
    @SuppressWarnings("unchecked")
    public static Map<String,Object> json2Map(String json){
        try {
            return objectMapper.readValue(json, Map.class);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    
}

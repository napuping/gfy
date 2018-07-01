
package com.nap.entity.result;

public class ResultData {

    private String code;

    private String message;

    private Object data;

    public ResultData() {
    }

    public ResultData(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public ResultData(String code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultData(Object data) {
        this.data = data;
    }

    public static ResultData build(String code, String message) {
        return new ResultData(code, message);
    }
    
    public static ResultData build(String code, Object data) {
        return new ResultData(code, null, data);
    }
    
    
    public static ResultData build(String code, String message,Object data){
        return new ResultData(code, message, data);
    }
    
    public static ResultData build(Object data) {
        return new ResultData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

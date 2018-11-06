package com.lanou.token_demo.utils;


public class ResultWrapper {

    private boolean status;
    private int code;
    private String message;
    private Object Date;

    public ResultWrapper() {

    }

    public ResultWrapper(boolean status, int code, String message, Object date) {
        this.status = status;
        this.code = code;
        this.message = message;
        Date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return Date;
    }

    public void setDate(Object date) {
        Date = date;
    }

    public static ResultWrapper success(Object date) {
        return new ResultWrapper(true, 200, "ok", date);
    }

    public static ResultWrapper error(Object date) {
        return new ResultWrapper(false, 500, "error", date);
    }
}

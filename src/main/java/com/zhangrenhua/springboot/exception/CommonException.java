package com.zhangrenhua.springboot.exception;

/**
 * @author zhangrenhua
 * @title
 * @desc
 * @date 2018/11/23
 */
public class CommonException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = -3030344392591938285L;
    
    private String code;
    
    private String msg;
    
    public CommonException(String code,String msg) {
        super(code + msg);
        this.code = code;
        this.msg = msg;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    
}

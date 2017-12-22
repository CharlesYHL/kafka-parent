package com.yhs.kafka.producer.util;

/**
 * @author Charles
 * @Title: Response
 * @Package com.yhs.kafka.producer.util
 * @Description: TODO
 * @date 2017/11/28 10:59
 */
public class Response {
    private String success;
    private String content;
    private String code;
    public Response(String success,String content,String code){
        this.success=success;
        this.content=content;
        this.code=code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

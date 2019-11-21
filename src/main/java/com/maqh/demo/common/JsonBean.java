package com.maqh.demo.common;

import lombok.Data;

/**
 * JsonBean class
 *
 * @author maqh
 * @date 2019/7/29
 */
@Data
public class JsonBean {
    private Integer code = 200;
    private String message = "success";
    private Object data;
    private boolean success;

    public JsonBean() {
    }

    public JsonBean(boolean success) {
        this.success = success;
    }

    public JsonBean(boolean success, Object o) {
        this.success = success;
        this.data = o;
    }

    public JsonBean(boolean success, ResultCode apiCode) {
        this.success = success;
        this.code = apiCode.getCode();
        this.message = apiCode.getMsg();
    }

    public JsonBean(boolean success, ResultCode apiCode, String message) {
        this.success = success;
        this.code = apiCode.getCode();
        this.message = message;
    }

    public JsonBean(boolean success, ResultCode apiCode, Object o) {
        this.success = success;
        this.data = o;
        this.code = apiCode.getCode();
        this.message = apiCode.getMsg();
    }

    public static JsonBean returnResponse() {
        return new JsonBean(true, ResultCode.SERVICE_OK);
    }

    public static JsonBean returnResponse(boolean success) {
        return new JsonBean(success);
    }

    public static JsonBean returnResponse(Object data) {
        return new JsonBean(true, data);
    }

    public static JsonBean returnResponse(boolean success, ResultCode apiCode) {
        return new JsonBean(success, apiCode);
    }

    public static JsonBean returnResponse(boolean success, ResultCode apiCode, String message) {
        return new JsonBean(success, apiCode,message);
    }


    public static JsonBean returnResponse(boolean success, ResultCode apiCode, Object data) {
        return new JsonBean(success, apiCode, data);
    }

    public void failEnum(ResultCode resultCode) {
        this.setCode(resultCode.getCode());
        this.setMessage(resultCode.getMsg());
    }

    public void success(String reason) {
        this.setCode(200);
        this.setMessage(reason);
    }
}

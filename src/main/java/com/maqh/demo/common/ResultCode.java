package com.maqh.demo.common;

/**
 * ResultCode class
 *
 * @author maqh
 * @date 2019/8/1
 */
public enum ResultCode {
    //成功返回结果
    SERVICE_OK(200,"成功！"),
    //返回失败结果
    SERVICE_ERR(201,"失败"),
    NOT_DELETE(204, "包含下级，请先删除下级后再删除该节点。"),
    PROJECT_ID_ERR(206, "项目id错误!"),

    NOT_YOU_MSG(207, "您无权修改此信息"),

    HAVE_BEEN_USED(205,"信息已被使用,不能删除!"),

    //没有数据
    NOT_MSG(205, "查询无数据"),
    //服务异常
    SERVICE_EXCEPTION(203,"服务异常");

    private String msg;
    private int code;
    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}

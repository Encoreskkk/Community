package com.bysj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ResDTO",description = "操作结果")
public class ResDTO {
    @ApiModelProperty("返回码")
    private int code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private Object data;


    public static ResDTO Succ(){
        ResDTO re = new ResDTO();
        re.setCode(200);
        re.setMsg("操作成功!");
        return re;
    }
    public static ResDTO SuccMsg(String msg){
        ResDTO re = new ResDTO();
        re.setCode(200);
        re.setMsg(msg);
        return re;
    }
    public static ResDTO ErrMsg(String msg){
        ResDTO re = new ResDTO();
        re.setCode(500);
        re.setMsg(msg);
        return re;
    }

    public static ResDTO Err(){
        ResDTO re = new ResDTO();
        re.setCode(500);
        re.setMsg("操作失败!");
        return re;
    }

    public static ResDTO Data(Object data){
        ResDTO re = new ResDTO();
        re.setCode(200);
        re.setMsg("返回成功");
        re.setData(data);
        return re;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

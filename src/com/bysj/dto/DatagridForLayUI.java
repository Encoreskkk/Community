package com.bysj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
@ApiModel(value = "DatagridForLayUI",description = "查询结果")
public class DatagridForLayUI implements java.io.Serializable {

    private static final long serialVersionUID = 4137170628914512450L;
    @ApiModelProperty("总记录数")
    private Long count = 0L;
    @ApiModelProperty("返回码")
    private int code = 200;
    @ApiModelProperty("返回信息")
    private String msg = "";
    @ApiModelProperty("返回数据")
    private List data = new ArrayList();

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}

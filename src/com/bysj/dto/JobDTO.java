package com.bysj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "JobDTO",description = "职位")
public class JobDTO {

    @ApiModelProperty("职位名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

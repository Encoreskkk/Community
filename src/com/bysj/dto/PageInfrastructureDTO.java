package com.bysj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 限制条数的DTO
 * */
@ApiModel(value = "PageInfrastructureDTO",description = "查询分页")
public class PageInfrastructureDTO {
    @ApiModelProperty("页码")
    private int curPage = 1;
    // 限制默认为-1，如果为-1不需要限制
    @ApiModelProperty("每页记录数")
    private int limit = 10;
    /**基础设施名称*/
    @ApiModelProperty("基础设施名称")
    private String infrastructureName;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getInfrastructureName() {
        return infrastructureName;
    }

    public void setInfrastructureName(String infrastructureName) {
        this.infrastructureName = infrastructureName;
    }

    /**
     * 计算开始
     * */
    public int calculateStart() {
        return limit < 0 ? -1 : (curPage - 1) * limit;
    }

    /**
     * 计算结束
     * */
    public int calculateEnd() {
        return limit < 0 ? -1 : curPage * limit;
    }

}

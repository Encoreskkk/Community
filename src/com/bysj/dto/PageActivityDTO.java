package com.bysj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *
 * 限制条数的DTO
 * */
@ApiModel(value = "PageDTO",description = "查询分页")
public class PageActivityDTO {
    @ApiModelProperty("页码")
    private int curPage = 1;
    // 限制默认为-1，如果为-1不需要限制
    @ApiModelProperty("每页记录数")
    private int limit = 10;
    @ApiModelProperty("社区活动名称")
    private String activityName;
    /**活动开始时间*/
    @ApiModelProperty("活动开始时间yyyy-mm-dd")
    private String beginTime;
    /**活动结束时间*/
    @ApiModelProperty("活动结束时间yyyy-mm-dd")
    private String endTime;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

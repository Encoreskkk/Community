package com.bysj.dto;

import java.util.Date;
import com.bysj.util.BeanUtil;
import com.bysj.model.UStaffWork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UStaffWorkDTO",description = "员工事务安排")
public class UStaffWorkDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**员工ID*/
        @ApiModelProperty("员工ID")
        private Integer staffId;
        /**事务内容*/
        @ApiModelProperty("事务内容")
        private String workContent;
        /**事务的开始时间*/
        @ApiModelProperty("事务的开始时间")
        private Date workBenginTime;
        /**事务的结束时间*/
        @ApiModelProperty("事务的结束时间")
        private Date workEndTime;
        /**员工姓名*/
        @ApiModelProperty("员工姓名")
        private String staffName;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public Integer getStaffId() {
            return this.staffId;
        }
        
        public void setStaffId(Integer staffId) {
            this.staffId = staffId;
        }
        
        public String getWorkContent() {
            return this.workContent;
        }
        
        public void setWorkContent(String workContent) {
            this.workContent = workContent;
        }
        
        public Date getWorkBenginTime() {
            return this.workBenginTime;
        }
        
        public void setWorkBenginTime(Date workBenginTime) {
            this.workBenginTime = workBenginTime;
        }
        
        public Date getWorkEndTime() {
            return this.workEndTime;
        }
        
        public void setWorkEndTime(Date workEndTime) {
            this.workEndTime = workEndTime;
        }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public UStaffWork toModel() {
            UStaffWork model = new UStaffWork();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
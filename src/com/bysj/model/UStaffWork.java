package com.bysj.model;

import java.util.Date;
import java.io.Serializable;


public class UStaffWork implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**员工ID*/
        private Integer staffId;
        /**事务内容*/
        private String workContent;
        /**事务的开始时间*/
        private Date workBenginTime;
        /**事务的结束时间*/
        private Date workEndTime;
        
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
    
}
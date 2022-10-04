package com.bysj.model;

import java.util.Date;
import java.io.Serializable;


public class UUserWork implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**业主id*/
        private Integer uId;
        /**申请内容*/
        private String content;
        /**申请备注*/
        private String memo;
        /**申请时间*/
        private Date createTime;
        /**审核状态0-未审核1-审核通过2-拒绝*/
        private Integer ifAduit;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public Integer getUId() {
            return this.uId;
        }
        
        public void setUId(Integer uId) {
            this.uId = uId;
        }
        
        public String getContent() {
            return this.content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
        
        public String getMemo() {
            return this.memo;
        }
        
        public void setMemo(String memo) {
            this.memo = memo;
        }
        
        public Date getCreateTime() {
            return this.createTime;
        }
        
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        
        public Integer getIfAduit() {
            return this.ifAduit;
        }
        
        public void setIfAduit(Integer ifAduit) {
            this.ifAduit = ifAduit;
        }
    
}
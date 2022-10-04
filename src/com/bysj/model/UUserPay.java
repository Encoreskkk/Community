package com.bysj.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;


public class UUserPay implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**业主id*/
        private Integer uId;
        /**缴费账期*/
        private Date payTime;
        /**缴费金额*/
        private BigDecimal payAmout;
        /**缴费项目*/
        private String payItem;
        
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
        
        public Date getPayTime() {
            return this.payTime;
        }
        
        public void setPayTime(Date payTime) {
            this.payTime = payTime;
        }
        
        public BigDecimal getPayAmout() {
            return this.payAmout;
        }
        
        public void setPayAmout(BigDecimal payAmout) {
            this.payAmout = payAmout;
        }
        
        public String getPayItem() {
            return this.payItem;
        }
        
        public void setPayItem(String payItem) {
            this.payItem = payItem;
        }
    
}
package com.bysj.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;


public class BGood implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**物资ID*/
        private Integer id;
        /**物资*/
        private String good;
        /**数目*/
        private Integer num;
        /**价格*/
        private BigDecimal price;
        /**采购日期*/
        private Date inDatetime;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getGood() {
            return this.good;
        }
        
        public void setGood(String good) {
            this.good = good;
        }
        
        public Integer getNum() {
            return this.num;
        }
        
        public void setNum(Integer num) {
            this.num = num;
        }
        
        public BigDecimal getPrice() {
            return this.price;
        }
        
        public void setPrice(BigDecimal price) {
            this.price = price;
        }
        
        public Date getInDatetime() {
            return this.inDatetime;
        }
        
        public void setInDatetime(Date inDatetime) {
            this.inDatetime = inDatetime;
        }
    
}
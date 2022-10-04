package com.bysj.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.bysj.model.BGood;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BGoodDTO",description = "物资")
public class BGoodDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**物资ID*/
        @ApiModelProperty("物资ID")
        private Integer id;
        /**物资*/
        @ApiModelProperty("物资")
        private String good;
        /**数目*/
        @ApiModelProperty("数目")
        private Integer num;
        /**价格*/
        @ApiModelProperty("价格")
        private BigDecimal price;
        /**采购日期*/
        @ApiModelProperty("采购日期")
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
        
        public BGood toModel() {
            BGood model = new BGood();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
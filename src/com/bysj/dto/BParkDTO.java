package com.bysj.dto;

import com.bysj.model.BPark;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BParkDTO",description = "车位")
public class BParkDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**车位ID*/
        @ApiModelProperty("车位ID")
        private Integer id;
        /**车位编码*/
        @ApiModelProperty("车位编码")
        private String parkBm;
        /**车位地址*/
        @ApiModelProperty("车位地址")
        private String parkAddress;
        /**0-空闲1-已售*/
        @ApiModelProperty("车位状态0-空闲1-已售")
        private Integer state;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getParkBm() {
            return this.parkBm;
        }
        
        public void setParkBm(String parkBm) {
            this.parkBm = parkBm;
        }
        
        public String getParkAddress() {
            return this.parkAddress;
        }
        
        public void setParkAddress(String parkAddress) {
            this.parkAddress = parkAddress;
        }
        
        public Integer getState() {
            return this.state;
        }
        
        public void setState(Integer state) {
            this.state = state;
        }
        
        public BPark toModel() {
            BPark model = new BPark();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
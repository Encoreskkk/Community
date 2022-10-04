package com.bysj.dto;

import java.math.BigDecimal;
import com.bysj.model.BService;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BServiceDTO",description = "服务项目")
public class BServiceDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**服务id*/
        @ApiModelProperty("服务id")
        private Integer id;
        /**服务*/
        @ApiModelProperty("服务")
        private String serviceName;
        /**收费标准*/
        @ApiModelProperty("收费标准")
        private BigDecimal servicePrice;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getServiceName() {
            return this.serviceName;
        }
        
        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
        
        public BigDecimal getServicePrice() {
            return this.servicePrice;
        }
        
        public void setServicePrice(BigDecimal servicePrice) {
            this.servicePrice = servicePrice;
        }
        
        public BService toModel() {
            BService model = new BService();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
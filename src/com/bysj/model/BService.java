package com.bysj.model;

import java.math.BigDecimal;
import java.io.Serializable;


public class BService implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**服务id*/
        private Integer id;
        /**服务*/
        private String serviceName;
        /**收费标准*/
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
    
}
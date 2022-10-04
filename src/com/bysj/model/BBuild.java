package com.bysj.model;

import java.io.Serializable;


public class BBuild implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**大厦id*/
        private Integer id;
        /**大厦名称*/
        private String buildName;
        /**大厦地址*/
        private String buildAddress;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getBuildName() {
            return this.buildName;
        }
        
        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }
        
        public String getBuildAddress() {
            return this.buildAddress;
        }
        
        public void setBuildAddress(String buildAddress) {
            this.buildAddress = buildAddress;
        }
    
}
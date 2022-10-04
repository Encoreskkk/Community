package com.bysj.model;

import java.math.BigDecimal;
import java.io.Serializable;


public class BRoom implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**房间id*/
        private Integer id;
        /**户号*/
        private String floorBm;
        /**说明*/
        private String floorDis;
        /**面积*/
        private BigDecimal area;
        /**大夏ID*/
        private Integer buildId;
        /**0-未入住1-已入住*/
        private Integer state;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getFloorBm() {
            return this.floorBm;
        }
        
        public void setFloorBm(String floorBm) {
            this.floorBm = floorBm;
        }
        
        public String getFloorDis() {
            return this.floorDis;
        }
        
        public void setFloorDis(String floorDis) {
            this.floorDis = floorDis;
        }
        
        public BigDecimal getArea() {
            return this.area;
        }
        
        public void setArea(BigDecimal area) {
            this.area = area;
        }
        
        public Integer getBuildId() {
            return this.buildId;
        }
        
        public void setBuildId(Integer buildId) {
            this.buildId = buildId;
        }
        
        public Integer getState() {
            return this.state;
        }
        
        public void setState(Integer state) {
            this.state = state;
        }
    
}
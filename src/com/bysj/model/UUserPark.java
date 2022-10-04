package com.bysj.model;

import java.io.Serializable;


public class UUserPark implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**业主ID*/
        private Integer uId;
        /**车位ID*/
        private Integer parkId;
        
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
        
        public Integer getParkId() {
            return this.parkId;
        }
        
        public void setParkId(Integer parkId) {
            this.parkId = parkId;
        }
    
}
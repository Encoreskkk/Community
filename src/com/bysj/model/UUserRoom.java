package com.bysj.model;

import java.io.Serializable;


public class UUserRoom implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**业主ID*/
        private Integer uId;
        /**房间ID*/
        private Integer roomId;
        /**是否已经录入门禁0-未录入1-已录入*/
        private Integer ifIn;
        
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
        
        public Integer getRoomId() {
            return this.roomId;
        }
        
        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }
        
        public Integer getIfIn() {
            return this.ifIn;
        }
        
        public void setIfIn(Integer ifIn) {
            this.ifIn = ifIn;
        }
    
}
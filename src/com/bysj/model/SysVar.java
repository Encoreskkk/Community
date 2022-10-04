package com.bysj.model;

import java.io.Serializable;


public class SysVar implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**变量名*/
        private String varName;
        /**变量值*/
        private String varVal;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getVarName() {
            return this.varName;
        }
        
        public void setVarName(String varName) {
            this.varName = varName;
        }
        
        public String getVarVal() {
            return this.varVal;
        }
        
        public void setVarVal(String varVal) {
            this.varVal = varVal;
        }
    
}
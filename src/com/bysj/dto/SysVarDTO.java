package com.bysj.dto;

import com.bysj.model.SysVar;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SysVarDTO",description = "参数")
public class SysVarDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**变量名*/
        @ApiModelProperty("变量名")
        private String varName;
        /**变量值*/
        @ApiModelProperty("变量值")
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
        
        public SysVar toModel() {
            SysVar model = new SysVar();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
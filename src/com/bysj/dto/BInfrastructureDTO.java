package com.bysj.dto;

import com.bysj.model.BInfrastructure;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BInfrastructureDTO",description = "基础设施")
public class BInfrastructureDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**基础设施id*/
        @ApiModelProperty("基础设施id")
        private Integer id;
        /**基础设施名称*/
        @ApiModelProperty("基础设施名称")
        private String infrastructureName;
        /**基础设施介绍*/
        @ApiModelProperty("基础设施介绍")
        private String infrastructureDis;
        /**基础设施展示的图片*/
        @ApiModelProperty("基础设施展示的图片")
        private String photo;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getInfrastructureName() {
            return this.infrastructureName;
        }
        
        public void setInfrastructureName(String infrastructureName) {
            this.infrastructureName = infrastructureName;
        }
        
        public String getInfrastructureDis() {
            return this.infrastructureDis;
        }
        
        public void setInfrastructureDis(String infrastructureDis) {
            this.infrastructureDis = infrastructureDis;
        }
        
        public String getPhoto() {
            return this.photo;
        }
        
        public void setPhoto(String photo) {
            this.photo = photo;
        }
        
        public BInfrastructure toModel() {
            BInfrastructure model = new BInfrastructure();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
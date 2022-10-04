package com.bysj.dto;

import com.bysj.util.BeanUtil;
import com.bysj.model.UStaff;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UStaffDTO",description = "员工档案")
public class UStaffDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**姓名*/
        @ApiModelProperty("姓名")
        private String name;
        /**电话*/
        @ApiModelProperty("电话")
        private String phone;
        /**年龄*/
        @ApiModelProperty("年龄")
        private Integer age;
        /**性别0-女1-男*/
        @ApiModelProperty("性别0-女1-男")
        private Integer sex;
        /**岗位*/
        @ApiModelProperty("岗位")
        private String post;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
        public Integer getAge() {
            return this.age;
        }
        
        public void setAge(Integer age) {
            this.age = age;
        }
        
        public Integer getSex() {
            return this.sex;
        }
        
        public void setSex(Integer sex) {
            this.sex = sex;
        }
        
        public String getPost() {
            return this.post;
        }
        
        public void setPost(String post) {
            this.post = post;
        }
        
        public UStaff toModel() {
            UStaff model = new UStaff();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
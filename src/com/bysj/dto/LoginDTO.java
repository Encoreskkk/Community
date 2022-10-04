package com.bysj.dto;

import com.bysj.model.UUser;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "LoginDTO",description = "登录信息")
public class LoginDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;

        /**用户名*/
        @ApiModelProperty("用户名")
        private String name;
        /**密码*/
        @ApiModelProperty("密码")
        private String pwd;
        
        public String getName() {
            return this.name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getPwd() {
            return this.pwd;
        }
        
        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

}
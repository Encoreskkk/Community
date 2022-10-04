package com.bysj.model;

import java.io.Serializable;


public class UUser implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        private Integer id;
        /**账号*/
        private String uname;
        /**用户名*/
        private String name;
        /**密码*/
        private String pwd;
        /**邮箱*/
        private String email;
        /**电话*/
        private String phone;
        /**身份证号码*/
        private String idCard;
        /**头像*/
        private String photo;
        /**用户类型0-业务1-管理员*/
        private Integer role;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

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
        
        public String getEmail() {
            return this.email;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
        public String getIdCard() {
            return this.idCard;
        }
        
        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
        
        public String getPhoto() {
            return this.photo;
        }
        
        public void setPhoto(String photo) {
            this.photo = photo;
        }
        
        public Integer getRole() {
            return this.role;
        }
        
        public void setRole(Integer role) {
            this.role = role;
        }
    
}
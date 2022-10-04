package com.bysj.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.bysj.util.BeanUtil;
import com.bysj.model.UUserPay;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UUserPayDTO",description = "业主缴费")
public class UUserPayDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**业主id*/
        @ApiModelProperty("业主id")
        private Integer uId;
        /**缴费账期*/
        @ApiModelProperty("缴费账期")
        private Date payTime;
        /**缴费金额*/
        @ApiModelProperty("缴费金额")
        private BigDecimal payAmout;
        /**缴费项目*/
        @ApiModelProperty("缴费项目JSON")
        private String payItem;
        /**用户名*/
        @ApiModelProperty("用户名")
        private String name;
        /**邮箱*/
        @ApiModelProperty("邮箱")
        private String email;
        /**电话*/
        @ApiModelProperty("电话")
        private String phone;
        /**身份证号码*/
        @ApiModelProperty("身份证号码")
        private String idCard;
        /**头像*/
        @ApiModelProperty("头像")
        private String photo;
        
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
        
        public Date getPayTime() {
            return this.payTime;
        }
        
        public void setPayTime(Date payTime) {
            this.payTime = payTime;
        }
        
        public BigDecimal getPayAmout() {
            return this.payAmout;
        }
        
        public void setPayAmout(BigDecimal payAmout) {
            this.payAmout = payAmout;
        }
        
        public String getPayItem() {
            return this.payItem;
        }
        
        public void setPayItem(String payItem) {
            this.payItem = payItem;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UUserPay toModel() {
            UUserPay model = new UUserPay();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
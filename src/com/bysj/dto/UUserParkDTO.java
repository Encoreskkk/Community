package com.bysj.dto;

import com.bysj.model.UUserPark;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UUserParkDTO",description = "业主车位")
public class UUserParkDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("id")
        private Integer id;
        /**业主ID*/
        @ApiModelProperty("用户id")
        private Integer uId;
        /**车位ID*/
        @ApiModelProperty("车位ID")
        private Integer parkId;
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
    /**车位编码*/
    @ApiModelProperty("车位编码")
    private String parkBm;
    /**车位地址*/
    @ApiModelProperty("车位地址")
    private String parkAddress;

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

    public String getParkBm() {
        return parkBm;
    }

    public void setParkBm(String parkBm) {
        this.parkBm = parkBm;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public UUserPark toModel() {
            UUserPark model = new UUserPark();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
package com.bysj.dto;

import com.bysj.model.UUserRoom;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "UUserRoomDTO",description = "业主户号")
public class UUserRoomDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**业主ID*/
        @ApiModelProperty("业主ID")
        private Integer uId;
        /**房间ID*/
        @ApiModelProperty("房间ID")
        private Integer roomId;
        /**是否已经录入门禁0-未录入1-已录入*/
        @ApiModelProperty("是否已经录入门禁0-未录入1-已录入")
        private Integer ifIn;
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
    /**户号*/
    @ApiModelProperty("户号")
    private String floorBm;
    /**说明*/
    @ApiModelProperty("说明")
    private String floorDis;
    /**面积*/
    @ApiModelProperty("面积")
    private BigDecimal area;
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

    public String getFloorBm() {
        return floorBm;
    }

    public void setFloorBm(String floorBm) {
        this.floorBm = floorBm;
    }

    public String getFloorDis() {
        return floorDis;
    }

    public void setFloorDis(String floorDis) {
        this.floorDis = floorDis;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public UUserRoom toModel() {
            UUserRoom model = new UUserRoom();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
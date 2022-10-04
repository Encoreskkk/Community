package com.bysj.dto;

import java.util.Date;
import com.bysj.util.BeanUtil;
import com.bysj.model.UUserWork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UUserWorkDTO",description = "业主申请")
public class UUserWorkDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主键*/
        @ApiModelProperty("主键")
        private Integer id;
        /**业主id*/
        @ApiModelProperty("业主id")
        private Integer uId;
        /**申请内容*/
        @ApiModelProperty("申请内容")
        private String content;
        /**申请备注*/
        @ApiModelProperty("申请备注")
        private String memo;
        /**申请时间*/
        @ApiModelProperty("申请时间")
        private Date createTime;
        /**审核状态0-未审核1-审核通过2-拒绝*/
        @ApiModelProperty("审核状态0-未审核1-审核通过2-拒绝")
        private Integer ifAduit;
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
        
        public String getContent() {
            return this.content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
        
        public String getMemo() {
            return this.memo;
        }
        
        public void setMemo(String memo) {
            this.memo = memo;
        }
        
        public Date getCreateTime() {
            return this.createTime;
        }
        
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        
        public Integer getIfAduit() {
            return this.ifAduit;
        }
        
        public void setIfAduit(Integer ifAduit) {
            this.ifAduit = ifAduit;
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

    public UUserWork toModel() {
            UUserWork model = new UUserWork();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
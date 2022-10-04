package com.bysj.dto;

import java.math.BigDecimal;
import com.bysj.model.BRoom;
import com.bysj.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BRoomDTO",description = "房间")
public class BRoomDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**房间id*/
        @ApiModelProperty("房间id")
        private Integer id;
        /**户号*/
        @ApiModelProperty("户号")
        private String floorBm;
        /**说明*/
        @ApiModelProperty("说明")
        private String floorDis;
        /**面积*/
        @ApiModelProperty("面积")
        private BigDecimal area;
        /**大夏ID*/
        @ApiModelProperty("大夏ID")
        private Integer buildId;
        /**0-未入住1-已入住*/
        @ApiModelProperty("房间状态0-未入住1-已入住")
        private Integer state;
        @ApiModelProperty("大夏名称")
        private String buildName;
        @ApiModelProperty("大夏地址")
        private String buildAddress;

        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getFloorBm() {
            return this.floorBm;
        }
        
        public void setFloorBm(String floorBm) {
            this.floorBm = floorBm;
        }
        
        public String getFloorDis() {
            return this.floorDis;
        }
        
        public void setFloorDis(String floorDis) {
            this.floorDis = floorDis;
        }
        
        public BigDecimal getArea() {
            return this.area;
        }
        
        public void setArea(BigDecimal area) {
            this.area = area;
        }
        
        public Integer getBuildId() {
            return this.buildId;
        }
        
        public void setBuildId(Integer buildId) {
            this.buildId = buildId;
        }
        
        public Integer getState() {
            return this.state;
        }
        
        public void setState(Integer state) {
            this.state = state;
        }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildIAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public BRoom toModel() {
            BRoom model = new BRoom();
			BeanUtil.convert(this, model);
			return model;
        }
    
}
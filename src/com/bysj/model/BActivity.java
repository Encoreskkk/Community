package com.bysj.model;

import java.util.Date;
import java.io.Serializable;


public class BActivity implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**活动ID*/
        private Integer id;
        /**社区活动名称*/
        private String activityName;
        /**活动介绍*/
        private String activityDis;
        /**活动图片*/
        private String photo;
        /**活动开始时间*/
        private Date activityBeginTime;
        /**活动结束时间*/
        private Date activityEndTime;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getActivityName() {
            return this.activityName;
        }
        
        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }
        
        public String getActivityDis() {
            return this.activityDis;
        }
        
        public void setActivityDis(String activityDis) {
            this.activityDis = activityDis;
        }
        
        public String getPhoto() {
            return this.photo;
        }
        
        public void setPhoto(String photo) {
            this.photo = photo;
        }
        
        public Date getActivityBeginTime() {
            return this.activityBeginTime;
        }
        
        public void setActivityBeginTime(Date activityBeginTime) {
            this.activityBeginTime = activityBeginTime;
        }
        
        public Date getActivityEndTime() {
            return this.activityEndTime;
        }
        
        public void setActivityEndTime(Date activityEndTime) {
            this.activityEndTime = activityEndTime;
        }
    
}
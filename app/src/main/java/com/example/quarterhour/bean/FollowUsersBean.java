package com.example.quarterhour.bean;

import java.util.List;

public class FollowUsersBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T11:06:57","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1524213155883b.jpg","latitude":null,"longitude":null,"mobile":"15811112222","money":0,"nickname":null,"password":"456789","praiseNum":null,"token":null,"uid":456,"userId":null,"username":"15811112222"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-10T00:00:00","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1524231294329t016b697d0374c17e3f.jpg","latitude":null,"longitude":null,"mobile":"18612991021","money":0,"nickname":"你好","password":"111111","praiseNum":null,"token":null,"uid":123,"userId":null,"username":"18612991021"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-17T10:26:35","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"18701451000","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":null,"uid":789,"userId":null,"username":"18701451000"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-05-08T16:09:50","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/145.jpg","latitude":null,"longitude":null,"mobile":"13522365253","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":"3E773F6367074602393ABC1B82F75A9D","uid":145,"userId":null,"username":"13522365253"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-21T16:47:36","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/146.jpg","latitude":null,"longitude":null,"mobile":"13717830672","money":0,"nickname":"昵称是一个萝卜","password":"123456","praiseNum":null,"token":"929A310F425923598C7F3495BCAAA278","uid":146,"userId":null,"username":"13717830672"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T09:19:12","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"18335525376","money":0,"nickname":null,"password":"18335525376","praiseNum":null,"token":null,"uid":235,"userId":null,"username":"18335525376"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T09:36:46","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"13833344422","money":0,"nickname":null,"password":"123321","praiseNum":null,"token":null,"uid":275,"userId":null,"username":"13833344422"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T10:21:51","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15011478731","money":0,"nickname":null,"password":"111","praiseNum":null,"token":null,"uid":355,"userId":null,"username":"15011478731"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T11:12:20","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"67","money":0,"nickname":null,"password":"67","praiseNum":null,"token":null,"uid":465,"userId":null,"username":"67"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T11:18:33","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15222323232","money":0,"nickname":null,"password":"123044","praiseNum":null,"token":null,"uid":475,"userId":null,"username":"15222323232"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-19T20:20:50","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"18210956659","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":null,"uid":956,"userId":null,"username":"18210956659"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-17T09:40:42","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15711125372","money":0,"nickname":null,"password":"444444","praiseNum":null,"token":null,"uid":785,"userId":null,"username":"15711125372"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-15T19:03:55","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15726649012","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":null,"uid":695,"userId":null,"username":"15726649012"},{"age":null,"appkey":"f33db6e05a082a88","appsecret":"3C8C84D4B6054897DEF0957A8BF32DF9","createtime":"2017-12-12T20:49:57","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13203459160","money":null,"nickname":null,"password":"CC9A08B0EB9F02AFDA07D24BF9DFB0F3","praiseNum":null,"token":null,"uid":4567,"userId":null,"username":"13203459160"},{"age":null,"appkey":"7c4cf0e9f098b445","appsecret":"BC116C710860E8C801D5665BDD8DB412","createtime":"2017-12-23T10:57:10","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13974550639","money":null,"nickname":null,"password":"BEF3C394CBAE98B95EE088B21EE3F334","praiseNum":null,"token":null,"uid":9856,"userId":null,"username":"13974550639"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-10-14T11:06:57
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/1524213155883b.jpg
         * latitude : null
         * longitude : null
         * mobile : 15811112222
         * money : 0
         * nickname : null
         * password : 456789
         * praiseNum : null
         * token : null
         * uid : 456
         * userId : null
         * username : 15811112222
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private int gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private int money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

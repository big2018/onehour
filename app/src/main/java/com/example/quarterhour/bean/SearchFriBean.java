package com.example.quarterhour.bean;

import java.util.List;

public class SearchFriBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-01T10:39:53","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15144441889441500855344482.jpeg","latitude":null,"longitude":null,"mobile":"15201392236","money":0,"nickname":"李灿灿","password":"111111","praiseNum":null,"token":"3E030858FEEED1026B1A1FB5CD5EF9ED","uid":148,"userId":null,"username":"15201392236"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-03-29T10:39:45","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1521101679406Screenshot_2018-03-10-15-20-05.png","latitude":null,"longitude":null,"mobile":"15611718821","money":0,"nickname":"李培","password":"123456","praiseNum":null,"token":"CEA5CBC6EAA5BE0B59598CCE24E8228D","uid":1072,"userId":null,"username":"15611718821"},{"age":null,"appkey":"e8ea5b1d9a2660e4","appsecret":"E605DF3ED5FF00C9C9654A4A7E6F0B4F","createtime":"2017-11-10T13:42:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15011244853","money":null,"nickname":"李大本事","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"75C622C349068A58FA71994A4210C575","uid":1277,"userId":null,"username":"15011244853"},{"age":null,"appkey":"1817526ac555f8d6","appsecret":"1103DD651AF6BD2E1EB8AB393D671019","createtime":"2018-04-25T20:19:02","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15701207385","money":null,"nickname":"李海生","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"131465DD4D2C179432F4FB677FE06C28","uid":1299,"userId":null,"username":"15701207385"},{"age":null,"appkey":"d720415dada82e08","appsecret":"D06D8C948844FF8525D9BC9DA1D52B03","createtime":"2017-12-22T16:49:59","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1512108751006e.png","latitude":null,"longitude":null,"mobile":"18810431730","money":null,"nickname":"李薇","password":"30D0BA0744A36CFD7EFF8869E8B09A0E","praiseNum":null,"token":"4860E93D56838926DD61E21884D6939D","uid":2997,"userId":null,"username":"18810431730"},{"age":null,"appkey":"3924b1a78221734d","appsecret":"62F63D515361CC43B31AD33B39D3C93F","createtime":"2017-12-11T15:31:09","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15111222211","money":null,"nickname":"李海生","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"547B1D946AE548E3B507FCD2B2956464","uid":4276,"userId":null,"username":"15111222211"},{"age":null,"appkey":"cbe79c71410cb320","appsecret":"A2D5744BD9CB67E0492163FDF6A699C5","createtime":"2017-12-26T14:12:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17610595326","money":null,"nickname":"李帅磊","password":"7792A1F7048ECB10FE716CE6FD38E884","praiseNum":null,"token":"924C782B46A91DEE2332487286C1FDEB","uid":4545,"userId":null,"username":"17610595326"},{"age":null,"appkey":"12db2513b9325a85","appsecret":"D95BC6188E8BB41F4204A0B6324FE0C1","createtime":"2018-01-14T12:25:06","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1513931189114e.png","latitude":null,"longitude":null,"mobile":"15380157667","money":null,"nickname":"李薇","password":"473344696F4685CAE5B5B3C354BC77BE","praiseNum":null,"token":"B5B012089EB37875016380E0E83D4980","uid":5422,"userId":null,"username":"15380157667"},{"age":null,"appkey":"05c46d31b10b9869","appsecret":"B57BCF04A589FEA59DD199A00D183BE6","createtime":"2018-01-09T11:03:25","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13213213213","money":null,"nickname":"你爸是李刚","password":"067F76E3A904428B9261B6DD7E899B93","praiseNum":null,"token":"9367E26EDFFA53EE710D18BDE9D973AB","uid":10813,"userId":null,"username":"13213213213"},{"age":null,"appkey":"f8177f420ed8cee9","appsecret":"48944681F9BCC1DC6E2E0052B6769C87","createtime":"2018-04-16T14:55:26","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13381036909","money":null,"nickname":"李欣晟","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"D3634503F49B2639684E7F836EA2566F","uid":12827,"userId":null,"username":"13381036909"},{"age":null,"appkey":"1e1182bf4389c527","appsecret":"937A69CD6B5B7C8A5B8FF02AB837D55D","createtime":"2018-04-07T15:12:27","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13464793595","money":null,"nickname":"李清泉","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"619B130CA240AFC26E649CCCDDBE2473","uid":12939,"userId":null,"username":"13464793595"},{"age":null,"appkey":"75eef032c2a16812","appsecret":"77887B9D4ABB810EC8E3CF51EEF46871","createtime":"2018-06-14T09:14:20","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1528936483789159.jpg","latitude":null,"longitude":null,"mobile":"13081036909","money":null,"nickname":"李欣晟","password":"7792A1F7048ECB10FE716CE6FD38E884","praiseNum":null,"token":"65B1DDAC664E0F12E48EC7ABD8D5200C","uid":15619,"userId":null,"username":"13081036909"}]
     * page : -1
     */

    private String msg;
    private String code;
    private int page;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
         * createtime : 2018-01-01T10:39:53
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/15144441889441500855344482.jpeg
         * latitude : null
         * longitude : null
         * mobile : 15201392236
         * money : 0
         * nickname : 李灿灿
         * password : 111111
         * praiseNum : null
         * token : 3E030858FEEED1026B1A1FB5CD5EF9ED
         * uid : 148
         * userId : null
         * username : 15201392236
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
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
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

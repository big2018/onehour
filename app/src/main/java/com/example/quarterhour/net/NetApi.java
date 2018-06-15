package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.bean.BdVideoBean;
import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.bean.SearchFriBean;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.UserBean;
import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;

public class NetApi {

    private NetApiService netApiService;
    private static NetApi netApi;

    private NetApi(NetApiService netApiService) {
        this.netApiService = netApiService;
    }

    public synchronized static NetApi getNetApi(NetApiService netApiService){
        if (netApi==null){
            netApi=new NetApi(netApiService);
        }
        return netApi;
    }

    public Observable<AdBean> getAd(){
        return netApiService.getAd();
    }

    public Observable<JokesBean> getJokes(){
        return netApiService.getJokes();
    }

    public Observable<WorkInfoBean> getWorkInfo(String uid,String token){
        return netApiService.getWorkInfo(uid,token);
    }

    public Observable<UserInfoBean> getUserInfo(String uid){
        return netApiService.getUserInfo(uid);
    }

    public Observable<UserVideosBean> getUserVideos(String uid){
        return netApiService.getUserVideos(uid);
    }

    public Observable<UserBean> login(String mobile,String password){
        return netApiService.login(mobile, password);
    }

    public Observable<VideosBean> getHotVideos(String token){
        return netApiService.getHotVideos(token);
    }

    public Observable<VideosBean> getNearVideos(String token){
        return netApiService.getNearVideos(token);
    }

    //获取关注用户列表
    public Observable<FollowUsersBean> getFollowUsers(String uid,String token){
        return netApiService.getFollowUsers(uid, token);
    }

    //获取收藏列表
    public Observable<CollectBean> getCollect(String uid,String token){
        return netApiService.getCollect(uid, token);
    }

    //搜索好友
    public Observable<SearchFriBean> searchFri(String keywords){
        return netApiService.searchFri(keywords);
    }

    public Observable<BaseBean> publishVideo(RequestBody uid, MultipartBody.Part videofile,MultipartBody.Part imgfile,RequestBody latitude,RequestBody longitude,RequestBody token,RequestBody source,RequestBody appVersion){
        return netApiService.publishVideo(uid, videofile, imgfile, latitude, longitude, token,source,appVersion);
    }

    public Observable<BdVideoBean> getVideos(){
        return netApiService.getVideos();
    }

    public Observable<BaseBean> publishJokes(String uid,String token,String content){
        return netApiService.publishJoke(uid, token,content);
    }

}

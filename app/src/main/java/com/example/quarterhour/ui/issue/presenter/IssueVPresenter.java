package com.example.quarterhour.ui.issue.presenter;

import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.issue.contract.IssueVContract;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class IssueVPresenter extends BasePresenter<IssueVContract.View> implements IssueVContract.Presenter{

    NetApi netApi;

    @Inject
    public IssueVPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void publishVideo(String uid, String videofile, String imgfile, String latitude, String longitude, String token,String source,String appVersion) {
        int i = videofile.lastIndexOf("/");
        String fileName = videofile.substring(i + 1);
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), new File(videofile));

        int i1 = imgfile.lastIndexOf("/");
        String fileName1 = imgfile.substring(i1 + 1);
        RequestBody file1 = RequestBody.create(MediaType.parse("application/octet-stream"), new File(imgfile));

        MediaType textType = MediaType.parse("text/plain");
        RequestBody u = RequestBody.create(textType, uid);
        RequestBody la = RequestBody.create(textType, latitude);
        RequestBody lo = RequestBody.create(textType, longitude);
        RequestBody t = RequestBody.create(textType, token);
        RequestBody s = RequestBody.create(textType, source);
        RequestBody a = RequestBody.create(textType, appVersion);

        MultipartBody.Part videof = MultipartBody.Part.createFormData("videofile", fileName, file);
        MultipartBody.Part imgf = MultipartBody.Part.createFormData("imgfile", fileName1, file1);

        netApi.publishVideo(u,videof,imgf,la,lo,t,s,a)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseBean, BaseBean>() {
                    @Override
                    public BaseBean apply(BaseBean baseBean) throws Exception {
                        return baseBean;
                    }
                }).subscribe(new Consumer<BaseBean>() {
            @Override
            public void accept(BaseBean s) throws Exception {
                if (mView != null)
                    mView.publishVideoSuccess(s);
            }
        });
    }
}

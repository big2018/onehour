package com.example.quarterhour.module;

import com.example.quarterhour.net.Api;
import com.example.quarterhour.net.MyInterceptor;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.net.NetApiService;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides
    OkHttpClient provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new MyInterceptor())
                .build();
    }

    @Provides
    NetApi provideNetApi(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        NetApiService netApiService = retrofit.create(NetApiService.class);
        return NetApi.getNetApi(netApiService);
    }

}

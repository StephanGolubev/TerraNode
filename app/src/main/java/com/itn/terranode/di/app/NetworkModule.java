package com.itn.terranode.di.app;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.deserializers.news.InformationAboutNewsDeserializer;
import com.itn.terranode.data.network.deserializers.news.NewsDeserializer;
import com.itn.terranode.data.network.deserializers.ProductsDeserializer;
import com.itn.terranode.data.network.deserializers.OfficeDeserializer;
import com.itn.terranode.data.network.deserializers.support.ChatDeserializer;
import com.itn.terranode.data.network.deserializers.support.ChatsDeserializer;
import com.itn.terranode.data.network.deserializers.support.InformationAboutMessagesDeserializer;
import com.itn.terranode.data.network.deserializers.support.SearchDeserializer;
import com.itn.terranode.data.network.deserializers.support.StructureDeserializer;
import com.itn.terranode.data.network.dtos.InformationAboutMessages;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessCreateChatResponce;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;
import com.itn.terranode.data.network.dtos.SuccessProductsResponse;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://itn.ltd";
    private static final int TIMEOUT = 30;

    @NonNull
    @Singleton
    @Provides
    NetworkRepository provideNetworkRepository(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NetworkRepository.class);
    }

    private Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(SuccessOfficeResponse.class, new OfficeDeserializer())
                .registerTypeAdapter(SuccessProductsResponse.class, new ProductsDeserializer())
                .registerTypeAdapter(SuccessNewsResponse.class, new NewsDeserializer())
//                .registerTypeAdapter(InformationAboutNews.class, new InformationAboutNewsDeserializer())
                .registerTypeAdapter(InformationAboutMessages.class, new InformationAboutMessagesDeserializer())
                .registerTypeAdapter(SuccessSearchResponce.class, new SearchDeserializer())
                .registerTypeAdapter(SuccessStructureResponce.class, new StructureDeserializer())
                .registerTypeAdapter(SuccessChatsResponce.class, new ChatsDeserializer())
                .registerTypeAdapter(SuccessCreateChatResponce.class, new ChatDeserializer())
                .create();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(createLoggingInterceptor())
                .build();
    }

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}

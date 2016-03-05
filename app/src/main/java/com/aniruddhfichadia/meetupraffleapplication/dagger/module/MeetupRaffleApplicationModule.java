package com.aniruddhfichadia.meetupraffleapplication.dagger.module;


import android.util.Log;

import com.aniruddhfichadia.meetupraffleapplication.MeetupConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@Module
public class MeetupRaffleApplicationModule
{
	@Provides
	@Singleton
	MeetupConfiguration providesMeetupConfiguration()
	{
		Log.d("bar", "MeetupConfiguration provided");

		return new MeetupConfiguration();
	}


	@Provides
	HttpLoggingInterceptor providesLoggingInterceptor()
	{
		HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();

		logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		return logInterceptor;
	}


	@Provides
	OkHttpClient.Builder provideOkHttpClientBuilder(HttpLoggingInterceptor logInterceptor)
	{
		OkHttpClient.Builder builder = new OkHttpClient.Builder();

		builder.addInterceptor(logInterceptor);

		return builder;
	}


	@Provides
	Gson providesGsonConverter()
	{
		GsonBuilder builder = new GsonBuilder();

		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>()
		{
			public Date deserialize(JsonElement json, Type typeOfT,
			                        JsonDeserializationContext context) throws JsonParseException
			{
				return new Date(json.getAsJsonPrimitive().getAsLong());
			}
		});

		return builder.create();
	}


	@Provides
	Retrofit.Builder providesRetrofitBuilder(MeetupConfiguration meetupConfiguration,
	                                         OkHttpClient.Builder okHttpClientBuilder,
	                                         Gson gson)
	{
		Retrofit.Builder builder = new Retrofit.Builder()
				.baseUrl(meetupConfiguration.endpoint)
				.client(okHttpClientBuilder.build())
				.addConverterFactory(GsonConverterFactory.create(gson));

		return builder;
	}


	@Singleton
	@Provides
	Retrofit providesRetrofit(Retrofit.Builder builder)
	{
		Log.d("bar", "retrofit provided");
		return builder.build();
	}
}

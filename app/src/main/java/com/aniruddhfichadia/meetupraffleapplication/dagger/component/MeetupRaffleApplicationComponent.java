package com.aniruddhfichadia.meetupraffleapplication.dagger.component;


import com.aniruddhfichadia.meetupraffleapplication.MeetupConfiguration;
import com.aniruddhfichadia.meetupraffleapplication.MeetupRaffleApplication;
import com.aniruddhfichadia.meetupraffleapplication.dagger.module.MeetupRaffleApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@Singleton
@Component(modules = MeetupRaffleApplicationModule.class)
public interface MeetupRaffleApplicationComponent
{
	void inject(MeetupRaffleApplication application);


	MeetupConfiguration getMeetupConfiguration();


	Retrofit getRetrofit();
}

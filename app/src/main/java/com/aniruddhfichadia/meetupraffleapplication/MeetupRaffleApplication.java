package com.aniruddhfichadia.meetupraffleapplication;


import android.app.Application;

import com.aniruddhfichadia.meetupraffleapplication.dagger.component
		.DaggerMeetupRaffleApplicationComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.component
		.MeetupRaffleApplicationComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.module.MeetupRaffleApplicationModule;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class MeetupRaffleApplication
		extends Application
{
	private static MeetupRaffleApplication instance;

	protected MeetupRaffleApplicationComponent applicationComponent;
	protected MeetupRaffleApplicationModule    applicationModule;


	public static MeetupRaffleApplication getInstance()
	{
		return instance;
	}


	@Override
	public void onCreate()
	{
		super.onCreate();

		instance = this;

		inject();
	}


	protected void inject()
	{
		applicationComponent = DaggerMeetupRaffleApplicationComponent
				.builder()
				.meetupRaffleApplicationModule(getApplicationModule())
				.build();

		applicationComponent.inject(this);
	}


	public MeetupRaffleApplicationComponent getApplicationComponent()
	{
		return applicationComponent;
	}


	public MeetupRaffleApplicationModule getApplicationModule()
	{
		if (applicationModule == null) {
			applicationModule = new MeetupRaffleApplicationModule();
		}

		return applicationModule;
	}
}

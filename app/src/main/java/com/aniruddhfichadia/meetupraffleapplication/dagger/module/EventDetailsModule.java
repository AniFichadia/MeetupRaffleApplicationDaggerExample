package com.aniruddhfichadia.meetupraffleapplication.dagger.module;


import com.aniruddhfichadia.meetupraffleapplication.fragment.EventDetailsFragment;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventDetailsPresenter;

import java.util.Random;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@Module
public class EventDetailsModule
{
	private final EventDetailsFragment fragment;


	public EventDetailsModule(EventDetailsFragment fragment)
	{
		this.fragment = fragment;
	}


	@Provides
	EventDetailsPresenter providesPresenter()
	{
		return new EventDetailsPresenter(fragment);
	}


	@Provides
	Random providesRandom()
	{
		return new Random();
	}


	@Provides
	// TODO preview commenting this out
	@Named("another")
	Random providesAnotherRandom()
	{
		return new Random();
	}
}

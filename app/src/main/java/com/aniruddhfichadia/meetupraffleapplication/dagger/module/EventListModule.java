package com.aniruddhfichadia.meetupraffleapplication.dagger.module;


import com.aniruddhfichadia.meetupraffleapplication.fragment.EventListFragment;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@Module
public class EventListModule
{
	private final EventListFragment fragment;


	public EventListModule(EventListFragment fragment)
	{
		this.fragment = fragment;
	}


	@Provides
	EventListPresenter providesPresenter()
	{
		return new EventListPresenter(fragment);
	}
}

package com.aniruddhfichadia.meetupraffleapplication.dagger.component;


import com.aniruddhfichadia.meetupraffleapplication.dagger.module.EventDetailsModule;
import com.aniruddhfichadia.meetupraffleapplication.dagger.scope.PerActivity;
import com.aniruddhfichadia.meetupraffleapplication.fragment.EventDetailsFragment;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventDetailsPresenter;

import dagger.Component;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@PerActivity
@Component(dependencies = MeetupRaffleApplicationComponent.class, modules = EventDetailsModule
		.class)
public interface EventDetailsComponent
{
	void inject(EventDetailsFragment fragment);


	void inject(EventDetailsPresenter presenter);
}

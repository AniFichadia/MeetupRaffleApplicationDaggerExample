package com.aniruddhfichadia.meetupraffleapplication.dagger.component;


import com.aniruddhfichadia.meetupraffleapplication.dagger.module.EventListModule;
import com.aniruddhfichadia.meetupraffleapplication.dagger.scope.PerActivity;
import com.aniruddhfichadia.meetupraffleapplication.fragment.EventListFragment;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventListPresenter;

import dagger.Component;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
@PerActivity
@Component(dependencies = MeetupRaffleApplicationComponent.class, modules = EventListModule.class)
public interface EventListComponent
{
	void inject(EventListFragment fragment);


	void inject(EventListPresenter presenter);
}

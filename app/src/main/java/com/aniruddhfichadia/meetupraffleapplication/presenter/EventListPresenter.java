package com.aniruddhfichadia.meetupraffleapplication.presenter;


import android.content.Intent;

import com.aniruddhfichadia.meetupraffleapplication.EventDetailsActivity;
import com.aniruddhfichadia.meetupraffleapplication.MeetupConfiguration;
import com.aniruddhfichadia.meetupraffleapplication.fragment.EventDetailsFragment;
import com.aniruddhfichadia.meetupraffleapplication.fragment.EventListFragment;
import com.aniruddhfichadia.meetupraffleapplication.network.MeetupApi;
import com.aniruddhfichadia.meetupraffleapplication.network.model.Event;

import javax.inject.Inject;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class EventListPresenter
		extends BasePresenter<EventListFragment>
{
	@Inject
	MeetupConfiguration meetupConfiguration;

	@Inject
	Retrofit retrofit;

	private Event[] events;


	public EventListPresenter(EventListFragment fragment)
	{
		super(fragment);
	}


	@Override
	public void onCreate()
	{
		super.onCreate();

		retrofit.create(MeetupApi.class)
		        .getEvents(meetupConfiguration.group, meetupConfiguration.apiKey, true, 20)
		        .enqueue(new Callback<Event[]>()
		        {
			        @Override
			        public void onResponse(Response<Event[]> response)
			        {
				        if (response.isSuccess()) {
					        events = response.body();
					        fragment.displayEvents(events);
				        } else {
					        fragment.handleError();
				        }
			        }


			        @Override
			        public void onFailure(Throwable t)
			        {
				        fragment.handleError();
			        }
		        });
	}


	public void onListItemClicked(int position)
	{
		Event event = events[position];

		Intent intent = new Intent(fragment.getContext(), EventDetailsActivity.class);
		intent.putExtra(EventDetailsFragment.KEY_EVENT_ID, event.getId());
		fragment.getContext().startActivity(intent);
	}

}

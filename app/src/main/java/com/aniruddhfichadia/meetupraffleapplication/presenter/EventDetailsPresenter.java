package com.aniruddhfichadia.meetupraffleapplication.presenter;


import com.aniruddhfichadia.meetupraffleapplication.MeetupConfiguration;
import com.aniruddhfichadia.meetupraffleapplication.fragment.EventDetailsFragment;
import com.aniruddhfichadia.meetupraffleapplication.network.MeetupApi;
import com.aniruddhfichadia.meetupraffleapplication.network.model.Rsvp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class EventDetailsPresenter
		extends BasePresenter<EventDetailsFragment>
{
	@Inject
	MeetupConfiguration meetupConfiguration;

	@Inject
	Retrofit retrofit;

	@Inject
	Random random;

	@Inject
	@Named("another")
	Random anotherRandom;

	private List<Rsvp> rsvps;


	public EventDetailsPresenter(
			EventDetailsFragment fragment)
	{
		super(fragment);
	}


	@Override
	public void onCreate()
	{
		super.onCreate();

		String eventId = fragment.getEventId();

		retrofit.create(MeetupApi.class)
		        .getRsvps(meetupConfiguration.group, eventId)
		        .enqueue(new Callback<Rsvp[]>()
		        {
			        @Override
			        public void onResponse(Response<Rsvp[]> response)
			        {
				        if (response.isSuccess()) {
					        rsvps = new ArrayList<Rsvp>();

					        Rsvp[] body = response.body();
					        for (Rsvp rsvp : body) {
						        if ("yes".equalsIgnoreCase(rsvp.getResponse())) {
							        rsvps.add(rsvp);
						        }
					        }

					        fragment.displayRsvps(rsvps);
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


	Rsvp lastWinner;


	public void pickWinner()
	{
		int winnerIndex = random.nextInt(rsvps.size());

		lastWinner = rsvps.get(winnerIndex);

		fragment.presentWinner(lastWinner, winnerIndex);
	}
}

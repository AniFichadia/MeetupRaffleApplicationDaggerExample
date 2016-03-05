package com.aniruddhfichadia.meetupraffleapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aniruddhfichadia.meetupraffleapplication.MeetupRaffleApplication;
import com.aniruddhfichadia.meetupraffleapplication.R;
import com.aniruddhfichadia.meetupraffleapplication.dagger.component.DaggerEventDetailsComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.component.EventDetailsComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.module.EventDetailsModule;
import com.aniruddhfichadia.meetupraffleapplication.network.model.Rsvp;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventDetailsPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class EventDetailsFragment
		extends BaseFragment
{
	public static final String KEY_EVENT_ID = "KEY_EVENT_ID";

	@Inject
	EventDetailsPresenter presenter;

	@Bind(android.R.id.list)
	ListView rsvpList;

	@Bind(R.id.rsvp_count)
	TextView rsvpCount;


	@Override
	void inject()
	{
		EventDetailsComponent component = DaggerEventDetailsComponent
				.builder()
				.meetupRaffleApplicationComponent(MeetupRaffleApplication.getInstance()
				                                                         .getApplicationComponent())
				.eventDetailsModule(new EventDetailsModule(this))
				.build();

		component.inject(this);
		component.inject(getPresenter());
	}


	@Override
	public EventDetailsPresenter getPresenter()
	{
		return presenter;
	}


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_event_rsvps, container, false);

		ButterKnife.bind(this, view);

		return view;
	}


	@Nullable
	public String getEventId()
	{
		String id = null;

		Bundle arguments = getArguments();
		if (arguments != null) {
			id = arguments.getString(KEY_EVENT_ID);
		}

		return id;
	}


	@OnClick(R.id.btn_pick_winner)
	public void onPickWinnerClicked()
	{
		presenter.pickWinner();
	}


	public void handleError()
	{
		Toast.makeText(getContext(), "Getting RSVPs failed", Toast.LENGTH_LONG).show();
	}


	public void displayRsvps(List<Rsvp> rsvps)
	{
		rsvpCount.setText("RSVPs: " + rsvps.size());
		Rsvp[] rsvpArr = new Rsvp[rsvps.size()];
		rsvps.toArray(rsvpArr);

		rsvpList.setAdapter(
				new ArrayAdapter<Rsvp>(getContext(), android.R.layout.simple_list_item_1, rsvpArr)
				{
					@Override
					public View getView(final int position, View convertView, ViewGroup parent)
					{
						View view = convertView;

						if (view == null) {
							view = LayoutInflater.from(getContext()).inflate(
									android.R.layout.simple_list_item_1, parent, false);
						}

						((TextView) view.findViewById(android.R.id.text1)).setText(
								getItem(position).getMember().getName());

						return view;
					}
				});
	}


	public void presentWinner(Rsvp lastWinner, int winnerIndex)
	{
		Toast.makeText(getContext(), "Random winner: " + lastWinner.getMember().getName(),
		               Toast.LENGTH_LONG).show();

		rsvpList.setSelection(winnerIndex);
	}
}

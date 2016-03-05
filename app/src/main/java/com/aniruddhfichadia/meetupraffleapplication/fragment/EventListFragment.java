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
import com.aniruddhfichadia.meetupraffleapplication.dagger.component.DaggerEventListComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.component.EventListComponent;
import com.aniruddhfichadia.meetupraffleapplication.dagger.module.EventListModule;
import com.aniruddhfichadia.meetupraffleapplication.network.model.Event;
import com.aniruddhfichadia.meetupraffleapplication.presenter.EventListPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class EventListFragment
		extends BaseFragment
{
	@Inject
	EventListPresenter presenter;

	@Bind(android.R.id.list)
	ListView eventsList;


	@Override
	void inject()
	{
		EventListComponent component = DaggerEventListComponent
				.builder()
				.meetupRaffleApplicationComponent(MeetupRaffleApplication.getInstance()
				                                                         .getApplicationComponent())
				.eventListModule(new EventListModule(this))
				.build();

		component.inject(this);
		component.inject(getPresenter());
	}


	@Override
	public EventListPresenter getPresenter()
	{
		return presenter;
	}


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_event_list, container, false);

		ButterKnife.bind(this, view);

		return view;
	}


	public void displayEvents(Event[] events)
	{
		eventsList.setAdapter(
				new ArrayAdapter<Event>(getContext(), android.R.layout.simple_list_item_1, events)
				{
					@Override
					public View getView(final int position, View convertView, ViewGroup parent)
					{
						View view = convertView;

						if (view == null) {
							view = LayoutInflater.from(getContext()).inflate(
									android.R.layout.simple_list_item_1, parent, false);
						}

						view.setOnClickListener(new View.OnClickListener()
						{
							@Override
							public void onClick(View v)
							{
								presenter.onListItemClicked(position);
							}
						});

						((TextView) view.findViewById(android.R.id.text1)).setText(
								getItem(position).getName());

						return view;
					}
				});
	}


	public void handleError()
	{
		Toast.makeText(getContext(), "Getting events failed", Toast.LENGTH_LONG).show();
	}
}

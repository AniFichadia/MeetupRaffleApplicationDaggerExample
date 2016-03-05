package com.aniruddhfichadia.meetupraffleapplication.network;


import com.aniruddhfichadia.meetupraffleapplication.network.model.Event;
import com.aniruddhfichadia.meetupraffleapplication.network.model.Rsvp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Basic Meetup API definition for Retrofit
 *
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public interface MeetupApi
{
	@GET("/{group}/events")
	Call<Event[]> getEvents(@Path("group") String group,
	                        @Query("key") String apiKey,
	                        @Query("desc") boolean descending,
	                        @Query("page") int results);


	@GET("/{group}/events/{eventId}/rsvps")
	Call<Rsvp[]> getRsvps(@Path("group") String group,
	                      @Path("eventId") String eventId);

}

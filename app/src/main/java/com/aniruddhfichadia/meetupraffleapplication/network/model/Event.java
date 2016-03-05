package com.aniruddhfichadia.meetupraffleapplication.network.model;


import java.io.Serializable;
import java.util.Date;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class Event
		implements Serializable
{

	private String id;
	private Date   created;
	private long   duration;
	private Group  group;
	private Venue  venue;
	private String name;


	public Date getCreated()
	{
		return created;
	}


	public void setCreated(Date created)
	{
		this.created = created;
	}


	public long getDuration()
	{
		return duration;
	}


	public void setDuration(long duration)
	{
		this.duration = duration;
	}


	public Group getGroup()
	{
		return group;
	}


	public void setGroup(Group group)
	{
		this.group = group;
	}


	public Venue getVenue()
	{
		return venue;
	}


	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	@Override
	public String toString()
	{
		return "Event{" +
		       "id='" + id + '\'' +
		       ", created=" + created +
		       ", duration=" + duration +
		       ", group=" + group +
		       ", venue=" + venue +
		       ", name='" + name + '\'' +
		       '}';
	}


	public class Group
			implements Serializable
	{

		private String name;
		private String id;


		public String getName()
		{
			return name;
		}


		public void setName(String name)
		{
			this.name = name;
		}


		public String getId()
		{
			return id;
		}


		public void setId(String id)
		{
			this.id = id;
		}


		@Override
		public String toString()
		{
			return "Group{" +
			       "name='" + name + '\'' +
			       ", id='" + id + '\'' +
			       '}';
		}
	}


	public class Venue
			implements Serializable
	{

		private String name;


		public String getName()
		{
			return name;
		}


		public void setName(String name)
		{
			this.name = name;
		}


		@Override
		public String toString()
		{
			return "Venue{" +
			       "name='" + name + '\'' +
			       '}';
		}
	}
}
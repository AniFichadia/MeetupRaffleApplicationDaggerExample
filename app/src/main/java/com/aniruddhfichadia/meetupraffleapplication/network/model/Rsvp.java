package com.aniruddhfichadia.meetupraffleapplication.network.model;


/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class Rsvp
{

	private Member member;

	private String response;


	public Member getMember()
	{
		return member;
	}


	public void setMember(Member member)
	{
		this.member = member;
	}


	public String getResponse()
	{
		return response;
	}


	public void setResponse(String response)
	{
		this.response = response;
	}


	public class Member
	{

		private String name;
		private String id;


		public String getId()
		{
			return id;
		}


		public void setId(String id)
		{
			this.id = id;
		}


		public String getName()
		{
			return name;
		}


		public void setName(String name)
		{
			this.name = name;
		}
	}
}
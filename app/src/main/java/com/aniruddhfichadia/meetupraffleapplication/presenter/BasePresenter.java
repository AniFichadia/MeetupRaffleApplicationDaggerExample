package com.aniruddhfichadia.meetupraffleapplication.presenter;


import android.support.annotation.CallSuper;

import com.aniruddhfichadia.meetupraffleapplication.fragment.BaseFragment;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class BasePresenter<T extends BaseFragment>
{
	protected final T fragment;


	public BasePresenter(T fragment)
	{
		this.fragment = fragment;
	}


	@CallSuper
	public void onCreate()
	{
	}
}

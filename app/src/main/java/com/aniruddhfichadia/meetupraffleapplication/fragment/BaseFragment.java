package com.aniruddhfichadia.meetupraffleapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.aniruddhfichadia.meetupraffleapplication.presenter.BasePresenter;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public abstract class BaseFragment
		extends Fragment
{
	abstract void inject();


	public abstract BasePresenter getPresenter();


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		inject();

		getPresenter().onCreate();
	}
}

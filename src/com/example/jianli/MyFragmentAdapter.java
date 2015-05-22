package com.example.jianli;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

	private List<Fragment> mFragmentList;
	
	public MyFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList) {
		super(fm);
		mFragmentList=fragmentList;
	}

	@Override
	public Fragment getItem(int arg0) {
		return mFragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}

}

package com.example.jianli;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {
	
	private List<View> mViewList;
	
	public MyPagerAdapter(List<View> viewList) {
		mViewList=viewList;
	}

	@Override
	public int getCount() {
		return mViewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	
	/**
	 * ʵ����һ��ҳ��
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mViewList.get(position));
		return mViewList.get(position);
	}
	
	/**
	 * ����һ��ҳ��
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViewList.get(position));
	}
	

}

package com.example.jianli;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements TabListener,OnPageChangeListener {
	
	private ActionBar mActionBar; 
	private ViewPager mViewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        
        //[ActionBar,Fragment是3.0以后引入的,Fragment可以引入support.v4包向下兼容低版本]
        
        //以Tab方式导航  
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
        //禁用ActionBar标题  
        mActionBar.setDisplayShowTitleEnabled(false);  
        //禁用ActionBar图标  
        mActionBar.setDisplayUseLogoEnabled(false);  
        //禁用ActionBar返回键  
        mActionBar.setDisplayShowHomeEnabled(false); 
        
        ArrayList<Fragment> mFragmentList=new ArrayList<Fragment>();
        Fragment01 mFragment1=new Fragment01();
    	Fragment02 mFragment2=new Fragment02();
        Fragment03 mFragment3=new Fragment03();
        mFragmentList.add(mFragment1);
        mFragmentList.add(mFragment2);
        mFragmentList.add(mFragment3);
        
        MyFragmentAdapter mFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        
        mViewPager.setAdapter(mFragmentAdapter);
        
        //设置ViewPager多缓存一个页面(默认1,设为2)
        mViewPager.setOffscreenPageLimit(2);  
    }


    private void init() {
    	
    	mActionBar=getActionBar();
    	
    	ArrayList<String> mTitleList=new ArrayList<String>();
        mTitleList.add("简介");
        mTitleList.add("照片");
        mTitleList.add("微博");
        for (int i = 0; i < mTitleList.size(); i++) {  
            mActionBar.addTab(mActionBar.newTab().setText(mTitleList.get(i))  
                    .setTabListener(this));  
        }
        
        
        mViewPager=(ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setOnPageChangeListener(this);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// 必须判断是否为NULL
		if(mViewPager!=null)  
        {  
           mViewPager.setCurrentItem(tab.getPosition());  
        }  
	}
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}
	@Override
	public void onPageSelected(int i) {
		//不要忘记注册监听器
		mActionBar.setSelectedNavigationItem(i);
	}
}

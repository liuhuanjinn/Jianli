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
        
        //[ActionBar,Fragment��3.0�Ժ������,Fragment��������support.v4�����¼��ݵͰ汾]
        
        //��Tab��ʽ����  
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
        //����ActionBar����  
        mActionBar.setDisplayShowTitleEnabled(false);  
        //����ActionBarͼ��  
        mActionBar.setDisplayUseLogoEnabled(false);  
        //����ActionBar���ؼ�  
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
        
        //����ViewPager�໺��һ��ҳ��(Ĭ��1,��Ϊ2)
        mViewPager.setOffscreenPageLimit(2);  
    }


    private void init() {
    	
    	mActionBar=getActionBar();
    	
    	ArrayList<String> mTitleList=new ArrayList<String>();
        mTitleList.add("���");
        mTitleList.add("��Ƭ");
        mTitleList.add("΢��");
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
		// �����ж��Ƿ�ΪNULL
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
		//��Ҫ����ע�������
		mActionBar.setSelectedNavigationItem(i);
	}
}

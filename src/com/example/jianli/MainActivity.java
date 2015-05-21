package com.example.jianli;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity implements TabListener  {
	
	private ViewPager mViewPager;
	
	private List<View> mViewList;
	
	private ActionBar mActionBar;  
    private ArrayList<ActionBar.Tab> mTabs;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mViewList=new ArrayList<View>();
        View view1 = View.inflate(this, R.layout.view01, null);
        View view2 = View.inflate(this, R.layout.view02, null);
        View view3 = View.inflate(this, R.layout.view03, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
       
        
      //取得ActionBar  
        mActionBar=getActionBar();  
        //以Tab方式导航  
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
        //禁用ActionBar标题  
        mActionBar.setDisplayShowTitleEnabled(false);  
        //禁用ActionBar图标  
        mActionBar.setDisplayUseLogoEnabled(false);  
        //禁用ActionBar返回键  
        mActionBar.setDisplayShowHomeEnabled(false);  
        //添加Tabs  
        mTabs=new ArrayList<ActionBar.Tab>();  
          
        ActionBar.Tab tab0=mActionBar.newTab();  
        tab0.setText("界面一");  
        tab0.setTabListener(this);  
        mTabs.add(tab0);  
        mActionBar.addTab(tab0);  
          
        ActionBar.Tab tab1=mActionBar.newTab();  
        tab1.setText("界面二");  
        tab1.setTabListener(this);  
        mTabs.add(tab1);  
        mActionBar.addTab(tab1);  
          
        ActionBar.Tab tab2=mActionBar.newTab();  
        tab2.setText("界面三");  
        tab2.setTabListener(this);  
        mTabs.add(tab2);  
        mActionBar.addTab(tab2); 
        
        MyPagerAdapter mPagerAdapter=new MyPagerAdapter(mViewList);
        
        mViewPager=(ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setAdapter(mPagerAdapter);
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}

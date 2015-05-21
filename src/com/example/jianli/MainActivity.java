package com.example.jianli;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
	
	private ViewPager mViewPager;
	
	private List<View> mViewList;
	private List<String> mTitleList;

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
        mTitleList=new ArrayList<String>();
        mTitleList.add("¼ò½é"	);
        mTitleList.add("Í¼Æ¬"	);
        mTitleList.add("Î¢²©"	);
        
        MyPagerAdapter mPagerAdapter=new MyPagerAdapter(mViewList,mTitleList);
        
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
}

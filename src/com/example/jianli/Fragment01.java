package com.example.jianli;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

public class Fragment01 extends Fragment {
	
	private ImageButton mImageButton;
	private TextView mTextView;
	
	private MediaPlayer mMediaPlayer;
	private boolean isPlay=false;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
        View v=inflater.inflate(R.layout.view01, container, false);
        
        mTextView=(TextView) v.findViewById(R.id.id_textview);
		mImageButton = (ImageButton) v.findViewById(R.id.id_imagebtn);
		mImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!isPlay){
					mMediaPlayer=MediaPlayer.create(getActivity(), R.raw.m);  
					mMediaPlayer.start(); 
					mMediaPlayer.setLooping(true);
					isPlay=true;
					mTextView.setText("正在播放音乐点击图片结束");
				}
				else if(isPlay){
					mMediaPlayer.stop();
					mMediaPlayer.release();
					isPlay=false;
					mTextView.setText("点击图片开始播放背景音乐");
				}
			}
		});
	    
		return v;
	}

}

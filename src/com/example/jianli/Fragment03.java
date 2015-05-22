package com.example.jianli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Fragment03 extends Fragment {
	
	private WebView mWebView;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View v=inflater.inflate(R.layout.view03, container, false);
		
		mWebView=(WebView) v.findViewById(R.id.id_webview);
		//����WebView���ԣ��ܹ�ִ��JavaScript�ű�  
		mWebView.getSettings().setJavaScriptEnabled(true);
	    //������Ҫ��ʾ����ҳ 
	    mWebView.loadUrl("http://weibo.com/yurisa123"); 
	    //����Web��ͼ 
	    mWebView.setWebViewClient(new MyWebViewClient ());
	    
		return v;
	}

}

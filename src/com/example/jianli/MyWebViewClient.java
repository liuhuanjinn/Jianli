package com.example.jianli;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
	@Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) { 
        view.loadUrl(url); 
        return true; 
    } 
}
/*WebView使用步骤:
1、在布局文件中声明WebView
2、在Activity中实例化WebView
3、调用WebView的loadUrl( )方法，设置WevView要显示的网页
4、为了让WebView能够响应超链接功能，调用setWebViewClient( )方法，设置  WebView视图
5、用WebView点链接看了很多页以后为了让WebView支持回退功能，需要覆盖Activity类的onKeyDown()方法，如果不做任何处理，点击系统回退剪键，整个浏览器会调用finish()而结束自身，而不是回退到上一页面
6、需要在AndroidManifest.xml文件中添加权限，否则出现Web page not available错误。
*/
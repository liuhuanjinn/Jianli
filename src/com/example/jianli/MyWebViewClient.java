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
/*WebViewʹ�ò���:
1���ڲ����ļ�������WebView
2����Activity��ʵ����WebView
3������WebView��loadUrl( )����������WevViewҪ��ʾ����ҳ
4��Ϊ����WebView�ܹ���Ӧ�����ӹ��ܣ�����setWebViewClient( )����������  WebView��ͼ
5����WebView�����ӿ��˺ܶ�ҳ�Ժ�Ϊ����WebView֧�ֻ��˹��ܣ���Ҫ����Activity���onKeyDown()��������������κδ������ϵͳ���˼�������������������finish()���������������ǻ��˵���һҳ��
6����Ҫ��AndroidManifest.xml�ļ������Ȩ�ޣ��������Web page not available����
*/
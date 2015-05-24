package com.example.jianli;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Fragment02 extends Fragment implements OnClickListener {

	private ImageView mImageView;
	private Button bigBtn, smallBtn;
	private Bitmap mBitmap1,mBitmap2;
	private float curWith, curHeight;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.view02, container, false);
		mImageView = (ImageView) v.findViewById(R.id.id_imageview);
		// 加载需要操作的图片
		mBitmap1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.y);
		// 获取这个图片的宽和高
		curWith = mBitmap1.getWidth();
		curHeight = mBitmap1.getHeight();
		
		bigBtn = (Button) v.findViewById(R.id.id_big);
		smallBtn = (Button) v.findViewById(R.id.id_small);
		bigBtn.setOnClickListener(this);
		smallBtn.setOnClickListener(this);

		return v;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.id_big:
			// 设置想要的大小
		    curWith=curWith*2;
		    curHeight=curHeight*2;
		    // 取得想要缩放的matrix参数,宽高放大为2倍
		    Matrix matrix = new Matrix();
		    matrix.postScale(2, 2);
		    // 得到新的图片
		    mBitmap2 = Bitmap.createBitmap(mBitmap1, 0, 0, (int)curWith/2,  
		    		(int)curHeight/2, matrix, true);  
		    showImage();
		    mBitmap1=mBitmap2;
		    
			break;
		case R.id.id_small:
			// 设置想要的大小
		    curWith=curWith/2;
		    curHeight=curHeight/2;
		    // 取得想要缩放的matrix参数,宽高放大为2倍
		    matrix = new Matrix();
		    matrix.postScale((float)0.5, (float)0.5);
		    // 得到新的图片
		    mBitmap2 = Bitmap.createBitmap(mBitmap1, 0, 0, (int)curWith*2,  
		    		(int)curHeight*2, matrix, true);  
		    showImage();
		    mBitmap1=mBitmap2;

			break;
		default:
			break;
		}
	}

	private void showImage() {
		
		BitmapDrawable bmd = new BitmapDrawable(mBitmap2);  
        mImageView.setImageDrawable(bmd);  
        mImageView.setScaleType(ScaleType.CENTER);  
		
	}

}

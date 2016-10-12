package com.ldrong.androidtoolset.utils.screen;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

public class DisplayUtil
{
	private static final String TAG = "DisplayUtil";
	// 转换dip为px
	public static int convertDipOrPx(Context context, int dip)
	{
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
	}

	// 转换px为dip
	public static int convertPxOrDip(Context context, int px)
	{
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f * (px >= 0 ? 1 : -1));
	}

	public static int sp2px(Context context, float spValue)
	{
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	public static int px2sp(Context context, float pxValue)
	{
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}


	/**
	 * 获得某个控件，绘制完的实际宽高 单位 px
	 * @param context
	 * @param view			目标控件id
	 * @param iViewInfo		获得宽高的回调接口
     */
	public void getViewInformation(Context context, final View view , final IViewInfo iViewInfo) {

		ViewTreeObserver vto = view.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				iViewInfo.viewInfo(view.getWidth(),view.getHeight());
				Log.e(TAG, "getHeight :" + view.getHeight() );
				Log.e(TAG, "getWidth :" + view.getWidth() );
			}
		});

	}

	public interface IViewInfo {
		public void viewInfo(int w, int h);
	}
}

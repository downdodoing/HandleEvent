package com.example.mvp.handleevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    public static String TAG = "MyView";

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSpec(widthMeasureSpec), measureSpec(heightMeasureSpec));
    }

    /*
    * specMode总共有三个值
    * EXACTLY：即精确值模式，当组件指定layout_height或layout_width的值时，系统默认是的模式
    * AT_MOST：即最大值模式，当layout_width或layout_height使用wrap_content时，控件的大小随内容的变化而变化，但最大值不能超过父控件的大小
    * UNSPECIFIED：view想多大就多大，一般在绘制自定义view时才使用
    * 一般情况下View类只支持EXACTLY模式。
    * */
    private int measureSpec(int measureSpec) {
        int result = 200;//当控件的layout_height或layout_width为wrap_content时显示的默认的大小
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(specSize, result);
            }
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, TAG + "  onTouchEvent");
        return super.onTouchEvent(event);
    }
}

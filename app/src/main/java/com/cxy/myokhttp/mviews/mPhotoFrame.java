package com.cxy.myokhttp.mviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hasee on 2017/6/27.
 */
public class mPhotoFrame extends View {
    private int FrameResource;
    private PorterDuffXfermode mXfermode;
    private Bitmap mSrcBitmap;
    private Bitmap mDstBitmap;
    private Bitmap mDefaultBitmap;
    private Rect mSrcRect, mDestRect;
    private PaintFlagsDrawFilter mDrawFilter;
    private String CrimpPlace;
    private Paint mBitmapPaint;
    private Context mContext;
    private int mTotalWidth;
    private int mTotalHeight;


    public mPhotoFrame(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public mPhotoFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context);
    }

    public mPhotoFrame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setDstResource(int resource){
        mSrcBitmap = ((BitmapDrawable) ContextCompat.getDrawable(mContext, resource)).getBitmap();
        postInvalidate();
    }

    public void setSrcResource(Bitmap bitmap){
        mSrcBitmap = bitmap;
        postInvalidate();
    }

    public void setSrcResource(int resource){
        FrameResource = resource;
        mDstBitmap = ((BitmapDrawable) ContextCompat.getDrawable(mContext, resource)).getBitmap();
        postInvalidate();
    }

    private void init(Context context){
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mDrawFilter = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, Paint.DITHER_FLAG);
        if(FrameResource != 0) {
            mDstBitmap = ((BitmapDrawable) ContextCompat.getDrawable(context, FrameResource)).getBitmap();
        }
        mBitmapPaint = new Paint();
        mBitmapPaint.setDither(true);
        mBitmapPaint.setFilterBitmap(true);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);// 获得控件的宽度
        int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);//获得控件的高度
        if(height > width){
            setMeasuredDimension(width, width);//设置宽和高
        }else {
            setMeasuredDimension(height, height);//设置宽和高
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTotalWidth = w;
        mTotalHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(mDrawFilter);
        canvas.drawColor(Color.TRANSPARENT);

    }
}

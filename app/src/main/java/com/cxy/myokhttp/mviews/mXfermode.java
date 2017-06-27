package com.cxy.myokhttp.mviews;

import android.content.Context;
import android.content.res.TypedArray;
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
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.cxy.myokhttp.R;

/**
 * Created by hasee on 2017/6/22.
 *
 *设计思路：保证叶子的大小一致，又不能超出屏幕之外
 * 使用正方形的内切圆，在内切圆中画矩形，只要围绕中心点旋转，
 * 都不会超出屏幕之外，设置叶子的  宽比高 = 3:4
 */

public class mXfermode extends View {

    private final int DEFAULT_RADIUS = 0;
    private PorterDuffXfermode mXfermode;
    private Bitmap mSrcBitmap;
    private Bitmap mMaskBitmap;
    private Bitmap mDefaultBitmap;
    private Rect mSrcRect, mDestRect;
    private Rect mMaskSrcRect, mMaskDestRect;
    private PaintFlagsDrawFilter mDrawFilter;
    private Context context;
    private TextPaint mTextPaint;
    private Paint mBitmapPaint, mPicPaint;
    private int mTotalWidth, mTotalHeight;
    private int mHalfWidth, mHalfHeight;
    private int RectWith, RectHeight;
    private int radius;
    private String textStr;
    private int DEFAULT_TEXTCOLOR = 0xffff0000;
    private float DEFAULT_TEXTSIZE = 14;
    private int TextColor;
    private float TextSize;

    //外环
    int LeafHight = 100;
    int Leafwight = 60;
    int rotate = 30;

    //内部图片
    public mXfermode(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public mXfermode(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.LeafAttr);//获取配置属性
        rotate = tArray.getInt(R.styleable.LeafAttr_radius,DEFAULT_RADIUS);
        textStr= tArray.getString(R.styleable.LeafAttr_tsxtStr);
        TextColor = tArray.getColor(R.styleable.LeafAttr_textColor,DEFAULT_TEXTCOLOR);
        TextSize = tArray.getDimension(R.styleable.LeafAttr_textSize,DEFAULT_TEXTSIZE);
        this.context = context;
        init();
    }

    public mXfermode(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void setLeafRotate(int rotate){
        this.rotate = rotate;
    }

    private void init(){
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mDrawFilter = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, Paint.DITHER_FLAG);
        initPaint();
        initBitmap();
    }


    private void initBitmap() {
//        mSrcBitmap  = ((BitmapDrawable) ContextCompat.getDrawable(context,R.mipmap.img_src)).getBitmap();
        mDefaultBitmap = ((BitmapDrawable) ContextCompat.getDrawable(context,R.mipmap.icon_add)).getBitmap();
        mMaskBitmap  = ((BitmapDrawable) ContextCompat.getDrawable(context,R.mipmap.rim_pic)).getBitmap();
    }

    // 初始化画笔paint
    private void initPaint() {

        mBitmapPaint = new Paint();
        // 防抖动
        mBitmapPaint.setDither(true);
        // 开启图像过滤
//        mBitmapPaint.setFilterBitmap(true);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(DEFAULT_TEXTCOLOR);
        mTextPaint.setColor(TextColor);        // 设置颜色
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(TextSize);              // 设置字体大小
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mPicPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPicPaint.setDither(true);
        mPicPaint.setColor(Color.LTGRAY);
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
        Log.d("chen", "onSizeChanged: w="+w+"h="+h);

        mTotalWidth = w;
        mTotalHeight = h;
        mHalfWidth = w/2;
        mHalfHeight = h/2;
        radius = w/2;
        mSrcRect = new Rect();
        RectWith = w * 2/5;    // 4/5*2
        RectHeight = w / 2; // 5/5*2
        mDestRect = new Rect();
        mMaskSrcRect = new Rect();
        mMaskDestRect = new Rect();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("chen", "onDraw: ");
        canvas.setDrawFilter(mDrawFilter);
        canvas.drawColor(Color.TRANSPARENT);
        /**
         * 画背景
         */
        mMaskSrcRect.set(mHalfWidth - RectWith ,mHalfHeight - RectHeight ,mHalfWidth + RectWith ,mHalfHeight + RectHeight);
        canvas.save();
        canvas .rotate(rotate, mTotalWidth/2, mTotalHeight/2);


        mMaskDestRect.set(0, 0, mMaskBitmap.getWidth(), mMaskBitmap.getHeight());
        canvas.drawBitmap(mMaskBitmap, mMaskDestRect, mMaskSrcRect,
                mBitmapPaint);

        canvas.restore();
        /*
         * 将绘制操作保存到新的图层
         */
        int sc = canvas.saveLayer(0, 0, mTotalWidth, mTotalHeight, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();

        mMaskSrcRect.set(mHalfWidth - RectWith +5 ,mHalfHeight - RectHeight  +5,mHalfWidth + RectWith  -5,mHalfHeight + RectHeight -5);
        mMaskDestRect.set(0,0,mMaskBitmap.getWidth(),mMaskBitmap.getHeight());
        // 绘制遮罩圆
        canvas .rotate(rotate, mTotalWidth/2, mTotalHeight/2);
        canvas.drawBitmap(mMaskBitmap, mMaskDestRect, mMaskSrcRect,
                mBitmapPaint);
        canvas.restore();

        // 设置图像的混合模式
        mBitmapPaint.setXfermode(mXfermode);
        if(mSrcBitmap == null){
            drawDefaultBg(canvas, mMaskSrcRect);
        }else {
            mSrcRect.set(5, 5, mSrcBitmap.getWidth() - 5, mSrcBitmap.getHeight() - 5);
            mDestRect.set(0, 0, mSrcBitmap.getWidth(), mSrcBitmap.getHeight());
            canvas.drawBitmap(mSrcBitmap, mDestRect, mSrcRect, mBitmapPaint);
        }
        mBitmapPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }

    private void drawDefaultBg(Canvas canvas,Rect defaultRect){
//        canvas.drawRect(defaultRect, mPicPaint);

        canvas.drawBitmap(mDefaultBitmap,defaultRect.centerX()-(mDefaultBitmap.getWidth()/2),defaultRect.centerY()-(mDefaultBitmap.getHeight()/2), mBitmapPaint);
        if(!TextUtils.isEmpty(textStr)) {
            canvas.drawText(textStr, defaultRect.centerX(),defaultRect.centerY()+TextSize*2,mTextPaint);
        }
    }

}

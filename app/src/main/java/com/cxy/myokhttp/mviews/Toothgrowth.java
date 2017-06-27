package com.cxy.myokhttp.mviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.cxy.myokhttp.R;

/**
 * 使用要求：关闭硬件加速
 * Created by chen on 2017/6/23.
 */
public class Toothgrowth extends View {

    private int TEXT_COLOR = 0xFF646464;
    private int ROUND_RECT_COLOR = 0xFFFF4081;
    int[] colors = new int[]{0xFFFF4081, 0xFFE7BB85, 0xFF98D4A2, 0xFF504D68,0xFF68398F};
    private PaintFlagsDrawFilter mDrawFilter;
    String[] nameStr = new String[]{"中切牙", "侧切牙","尖牙", "第一磨牙", "第二磨牙"};
    public final int TL_TOOTH_AREA_1 = 1;
    public final int TL_TOOTH_AREA_2 = 2;
    public final int TL_TOOTH_AREA_3 = 3;
    public final int TL_TOOTH_AREA_4 = 4;
    public final int TL_TOOTH_AREA_5 = 5;
    public final int TR_TOOTH_AREA_1 = 6;
    public final int TR_TOOTH_AREA_2 = 7;
    public final int TR_TOOTH_AREA_3 = 8;
    public final int TR_TOOTH_AREA_4 = 9;
    public final int TR_TOOTH_AREA_5 = 10;
    public final int BL_TOOTH_AREA_1 = 11;
    public final int BL_TOOTH_AREA_2 = 12;
    public final int BL_TOOTH_AREA_3 = 13;
    public final int BL_TOOTH_AREA_4 = 14;
    public final int BL_TOOTH_AREA_5 = 15;
    public final int BR_TOOTH_AREA_1 = 16;
    public final int BR_TOOTH_AREA_2 = 17;
    public final int BR_TOOTH_AREA_3 = 18;
    public final int BR_TOOTH_AREA_4 = 19;
    public final int BR_TOOTH_AREA_5 = 20;
    private int touchFlag = -1,  currentFlag= -1;
    Bitmap[] topLeftTooth, topRightTooth, BotLeftTooth, BotRightTooth, BotRightToothFill, BotLeftToothFill,topLeftToothFill, topRightToothFill;

    private int TotalWidth;
    private int TotalHeight;
    private int rectHight;
    private int radius;
    private float toothSize = 18;
    private float mtSize = 18;
    Rect rect4 = new Rect();
    Rect DestRect = new Rect();
    RectF rect1 = new RectF();
    RectF rect3 = new RectF();

    Region TL_TOOTH_1, TL_TOOTH_2, TL_TOOTH_3, TL_TOOTH_4, TL_TOOTH_5,
            TR_TOOTH_1, TR_TOOTH_2, TR_TOOTH_3, TR_TOOTH_4, TR_TOOTH_5,
            BL_TOOTH_1,BL_TOOTH_2,BL_TOOTH_3,BL_TOOTH_4,BL_TOOTH_5,
            BR_TOOTH_1,BR_TOOTH_2,BR_TOOTH_3,BR_TOOTH_4,BR_TOOTH_5,
            RECT_TIME_REGION;
    Region[] TL_TOOTH_ARR, TR_TOOTH_ARR, BL_TOOTH_ARR, BR_TOOTH_ARR;
    private Paint mPaint;
    private TextPaint mTextPaint;
    float[] pts = new float[]{-1, -1};
    private Matrix mMatrix;
    private boolean isSelectArea = false;
    private ToothClckListener mListener;


    public Toothgrowth(Context context) {
        super(context);
        init(context);
    }

    public Toothgrowth(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.Toothgrowth);//获取配置属性
        toothSize = tArray.getDimension(R.styleable.Toothgrowth_toothSize,18);
        mtSize= tArray.getDimension(R.styleable.Toothgrowth_middleSize, 18);
        init(context);
    }

    public Toothgrowth(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
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
        mMatrix.reset();
        TotalWidth = w;
        TotalHeight= h;
        rectHight = TotalWidth/10;
        radius = TotalWidth/3;
        mMatrix.setRotate(0,radius, radius);
    }

    private void init(Context context){
        mDrawFilter = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, Paint.DITHER_FLAG);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setStrokeWidth(1);
        mTextPaint.setSubpixelText(true);
        mTextPaint.setAntiAlias(true);

        Bitmap toothBitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_1)).getBitmap();
        Bitmap toothBitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_2)).getBitmap();
        Bitmap toothBitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_3)).getBitmap();
        Bitmap toothBitmap4 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_4)).getBitmap();
        Bitmap toothBitmap5 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_5)).getBitmap();
        Bitmap toothBitmap6 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_6)).getBitmap();
        Bitmap toothBitmap7 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_7)).getBitmap();
        Bitmap toothBitmap8 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_8)).getBitmap();
        Bitmap toothBitmap9 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_9)).getBitmap();
        Bitmap toothBitmap10 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_10)).getBitmap();
        Bitmap toothBitmap11 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_11)).getBitmap();
        Bitmap toothBitmap12 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_12)).getBitmap();
        Bitmap toothBitmap13 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_13)).getBitmap();
        Bitmap toothBitmap14 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_14)).getBitmap();
        Bitmap toothBitmap15 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_15)).getBitmap();
        Bitmap toothBitmap16 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_16)).getBitmap();
        Bitmap toothBitmap1_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_1_fill)).getBitmap();
        Bitmap toothBitmap2_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_2_fill)).getBitmap();
        Bitmap toothBitmap3_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_3_fill)).getBitmap();
        Bitmap toothBitmap4_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_4_fill)).getBitmap();
        Bitmap toothBitmap5_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_5_fill)).getBitmap();
        Bitmap toothBitmap6_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_6_fill)).getBitmap();
        Bitmap toothBitmap7_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_7_fill)).getBitmap();
        Bitmap toothBitmap8_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_8_fill)).getBitmap();
        Bitmap toothBitmap9_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_9_fill)).getBitmap();
        Bitmap toothBitmap10_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_10_fill)).getBitmap();
        Bitmap toothBitmap11_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_11_fill)).getBitmap();
        Bitmap toothBitmap12_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_12_fill)).getBitmap();
        Bitmap toothBitmap13_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_13_fill)).getBitmap();
        Bitmap toothBitmap14_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_14_fill)).getBitmap();
        Bitmap toothBitmap15_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_15_fill)).getBitmap();
        Bitmap toothBitmap16_fill = ((BitmapDrawable) ContextCompat.getDrawable(context, R.mipmap.btn_tooth_16_fill)).getBitmap();
        topLeftTooth = new Bitmap[]{toothBitmap1, toothBitmap2, toothBitmap3, toothBitmap4, toothBitmap5};
        topRightTooth = new Bitmap[]{toothBitmap6, toothBitmap7,toothBitmap8, toothBitmap9, toothBitmap10};
        BotLeftTooth = new Bitmap[]{toothBitmap11, toothBitmap13, toothBitmap3, toothBitmap14, toothBitmap16};
        BotRightTooth = new Bitmap[]{toothBitmap12, toothBitmap13,toothBitmap8, toothBitmap14, toothBitmap15};

        topLeftToothFill = new Bitmap[]{toothBitmap1_fill, toothBitmap2_fill,toothBitmap3_fill, toothBitmap4_fill, toothBitmap5_fill};
        topRightToothFill = new Bitmap[]{toothBitmap6_fill, toothBitmap7_fill, toothBitmap8_fill, toothBitmap9_fill, toothBitmap10_fill};
        BotLeftToothFill = new Bitmap[]{toothBitmap11_fill, toothBitmap13_fill,toothBitmap3_fill, toothBitmap14_fill, toothBitmap16_fill};
        BotRightToothFill = new Bitmap[]{toothBitmap12_fill, toothBitmap13_fill, toothBitmap8_fill, toothBitmap14_fill, toothBitmap15_fill};
        mMatrix = new Matrix();
        TL_TOOTH_1 =  new Region();
        TL_TOOTH_2 =  new Region();
        TL_TOOTH_3 =  new Region();
        TL_TOOTH_4 =  new Region();
        TL_TOOTH_5 =  new Region();
        TL_TOOTH_ARR = new Region[] {TL_TOOTH_1, TL_TOOTH_2, TL_TOOTH_3, TL_TOOTH_4, TL_TOOTH_5};
        TR_TOOTH_1 =  new Region();
        TR_TOOTH_2 =  new Region();
        TR_TOOTH_3 =  new Region();
        TR_TOOTH_4 =  new Region();
        TR_TOOTH_5 =  new Region();
        TR_TOOTH_ARR = new Region[] {TR_TOOTH_1, TR_TOOTH_2, TR_TOOTH_3, TR_TOOTH_4, TR_TOOTH_5};
        BL_TOOTH_1 =  new Region();
        BL_TOOTH_2 =  new Region();
        BL_TOOTH_3 =  new Region();
        BL_TOOTH_4 =  new Region();
        BL_TOOTH_5 =  new Region();
        BL_TOOTH_ARR = new Region[] {BL_TOOTH_1, BL_TOOTH_2, BL_TOOTH_3, BL_TOOTH_4, BL_TOOTH_5};
        BR_TOOTH_1 =  new Region();
        BR_TOOTH_2 =  new Region();
        BR_TOOTH_3 =  new Region();
        BR_TOOTH_4 =  new Region();
        BR_TOOTH_5 =  new Region();
        BR_TOOTH_ARR = new Region[] {BR_TOOTH_1, BR_TOOTH_2, BR_TOOTH_3, BR_TOOTH_4, BR_TOOTH_5};
        RECT_TIME_REGION = new Region();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(mDrawFilter);
        canvas.drawColor(Color.TRANSPARENT);

        drawTooth(canvas);
        drawToothName(canvas);
        drawMiddle(canvas, "6-10 月龄", "2017-08-12");
    }

    private void drawTooth(Canvas canvas){
        drawToothLT(canvas);
        drawToothRT(canvas);
        drawToothLB(canvas);
        drawToothRB(canvas);
    }
    private void drawToothName(Canvas canvas){
        drawLineTop(canvas);
        drawLineBot(canvas);
    }
    private void drawToothLT(Canvas canvas){
        rect1.set (radius *2/3, 0 , radius ,rectHight);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .rotate(-(90/4 * i + i),radius, radius);
            mPaint.setColor(colors[i%5]);
            if(isSelectArea && currentFlag == 1+i ){
                DestRect.set(0, 0, topLeftToothFill[i].getWidth(), topLeftToothFill[i].getHeight());
                canvas.drawBitmap(topLeftToothFill[i], DestRect, rect1, mPaint);
            }else {
                DestRect.set(0, 0, topLeftTooth[i].getWidth(), topLeftTooth[i].getHeight());
                canvas.drawBitmap(topLeftTooth[i], DestRect, rect1, mPaint);
            }
            mMatrix.setRotate(-(90/4 * i + i),radius, radius);
            Log.d("chen", "drawToothLT: rect1"+rect1.toString());
            mMatrix.mapRect(rect3, rect1);
            Log.d("chen", "drawToothLT: rect3"+rect3.toString());
            rect3.roundOut(rect4);
            TL_TOOTH_ARR[i].set(rect4);
            Log.d("chen", "drawToothLT: rect4"+rect4.toString());
            canvas.restore();
        }
    }
    private void drawToothRT(Canvas canvas){
        rect1.set (radius +1, 0 , radius *4/3 ,rectHight);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .rotate((90/4 * i + i), radius+1, radius);
            mPaint.setColor(colors[i%5]);
            if(isSelectArea && currentFlag == 6+i ){
                DestRect.set(0, 0, topRightToothFill[i].getWidth(), topRightToothFill[i].getHeight());
                canvas.drawBitmap(topRightToothFill[i],DestRect,rect1, mPaint);
            }else {
                DestRect.set(0, 0, topRightTooth[i].getWidth(), topRightTooth[i].getHeight());
                canvas.drawBitmap(topRightTooth[i],DestRect,rect1, mPaint);
            }

            mMatrix.setRotate((90/4 * i + i),radius+1, radius);
            mMatrix.mapRect(rect3, rect1);
            rect3.roundOut(rect4);
            TR_TOOTH_ARR[i].set(rect4);
            canvas.restore();
        }
    }
    private void drawToothLB(Canvas canvas){
        rect1.set (radius *2/3, TotalHeight - rectHight  , radius ,TotalHeight);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .rotate((90/4 * i + i), radius, TotalHeight - radius);
            mPaint.setColor(colors[i%5]);
            if(isSelectArea && currentFlag == 11+i ){
                DestRect.set(0, 0, BotLeftToothFill[i].getWidth(), BotLeftToothFill[i].getHeight());
                canvas.drawBitmap(BotLeftToothFill[i],DestRect,rect1, mPaint);
            }else {
                DestRect.set(0, 0, BotLeftTooth[i].getWidth(), BotLeftTooth[i].getHeight());
                canvas.drawBitmap(BotLeftTooth[i],DestRect,rect1, mPaint);
            }
            mMatrix.setRotate((90/4 * i + i),radius, TotalHeight - radius);
            mMatrix.mapRect(rect3, rect1);
            rect3.roundOut(rect4);
            BL_TOOTH_ARR[i].set(rect4);
            canvas.restore();
        }
    }
    private void drawToothRB(Canvas canvas){
        rect1.set (radius +1, TotalHeight - rectHight  , radius *4/3 ,TotalHeight);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .rotate(-(90/4 * i + i),radius+1, TotalHeight - radius);
            mPaint.setColor(colors[i%5]);
            if(isSelectArea && currentFlag == 16+i ){
                DestRect.set(0, 0, BotRightToothFill[i].getWidth(), BotRightToothFill[i].getHeight());
                canvas.drawBitmap(BotRightToothFill[i],DestRect,rect1, mPaint);
            }else {
                DestRect.set(0, 0, BotRightTooth[i].getWidth(), BotRightTooth[i].getHeight());
                canvas.drawBitmap(BotRightTooth[i],DestRect,rect1, mPaint);
            }
            mMatrix.setRotate(-(90/4 * i + i),radius+1, TotalHeight - radius);
            mMatrix.mapRect(rect3, rect1);
            rect3.roundOut(rect4);
            BR_TOOTH_ARR[i].set(rect4);
            canvas.restore();
        }
    }
    private void drawLineTop(Canvas canvas){
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setAntiAlias(true);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .translate(radius  * i/ 4 + 10, radius  * i/ 4 );
            mPaint.setColor(colors[i%5]);
            mTextPaint.setColor(colors[i%5]);
            mPaint.setStrokeWidth(2);
            if(i< 4) {
                canvas.drawLine(radius * 4 / 3, 10, radius * 5 / 3 , 10, mPaint);
                mTextPaint.setTextSize(toothSize);
                canvas.drawText(nameStr[i], radius * 5 / 3 + 20, 10  + toothSize / 2, mTextPaint);

            }else{
                canvas.drawLine(radius + 10, 30 + toothSize / 2, radius * 4 / 3, 30 + toothSize / 2, mPaint);
                canvas.drawText(nameStr[i], radius * 4 / 3 + 10 , 30 + toothSize / 2, mTextPaint);
            }
            canvas.restore();
        }
    }
    private void drawLineBot(Canvas canvas){
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setAntiAlias(true);
        for (int i = 0; i < 5 ; i++) {
            canvas.save();
            canvas .translate(radius  * i/ 4 - 10, TotalHeight - radius  * i/ 4 );
            mPaint.setColor(colors[i%5]);
            mTextPaint.setColor(colors[i%5]);
            mPaint.setStrokeWidth(2);
            if(i< 4) {
                canvas.drawLine(radius * 4 / 3 + 20, -10, radius * 5 / 3 +10 , -10, mPaint);
                mTextPaint.setTextSize(toothSize);
                canvas.drawText(nameStr[i], radius * 5 / 3 + 25, 10  - toothSize, mTextPaint);
            }else{
                canvas.drawLine(radius + 30, -30 - toothSize/2, radius * 4 / 3 + 20, -30 - toothSize/2, mPaint);
                canvas.drawText(nameStr[i], radius * 4 / 3 + 25 , -30 - toothSize/2, mTextPaint);
            }
            canvas.restore();
        }
    }
    private void drawMiddle(Canvas canvas, String age, String recodTime){
        if(TextUtils.isEmpty(age)){
            return;
        }
        mTextPaint.setColor(TEXT_COLOR);
        mTextPaint.setTextSize(mtSize);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(age, radius, radius * 6 / 5, mTextPaint);
        RectF rectTime = new RectF(radius/2, TotalHeight - radius * 8 / 5, radius * 3 / 2,  TotalHeight - radius * 6 / 5);
        Rect rectT = new Rect();
        rectTime.roundOut(rectT);
        RECT_TIME_REGION.set(rectT);
        if(TextUtils.isEmpty(recodTime)){
            mPaint.setColor(ROUND_RECT_COLOR);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRoundRect(rectTime, 10, 10, mPaint);
        }else{
            canvas.drawText(recodTime, radius, TotalHeight - radius *7 / 5f, mTextPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pts = new float[2];
        pts[0] = event.getX();
        pts[1] = event.getY();

        Log.e("Toothgrowth", "onTouchEvent: pts="+pts[0]+","+pts[1] );
        int x = (int) pts[0];
        int y = (int) pts[1];

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                touchFlag = getTouchedPath(x, y);
                currentFlag = touchFlag;
                isSelectArea = false;
                Log.e("Toothgrowth", "ACTION_DOWN: currentFlag="+currentFlag );
                break;
            case MotionEvent.ACTION_MOVE:
                currentFlag = getTouchedPath(x, y);
                Log.e("Toothgrowth", "ACTION_MOVE: currentFlag="+currentFlag );
                isSelectArea = false;
                break;
            case MotionEvent.ACTION_UP:
                currentFlag = getTouchedPath(x, y);
                // 如果手指按下区域和抬起区域相同且不为空，则判断点击事件
                if (currentFlag == touchFlag && currentFlag != -1/* && mListener != null*/) {
                    Log.e("Toothgrowth", "onTouchEvent: currentFlag="+currentFlag );
                    isSelectArea = true;
                    if(currentFlag == 0 && mListener != null) {
                        mListener.onToothClckLCallBack(0);
                    }
                }else {
                    touchFlag = currentFlag = -1;
                    isSelectArea = false;
                }
                Log.e("Toothgrowth", "ACTION_UP: currentFlag="+currentFlag );

                break;
            /*case MotionEvent.ACTION_CANCEL:
                touchFlag = currentFlag = TOOTH_AREA.TOOTH_AREA_OUT;
                Log.e("Toothgrowth", "ACTION_CANCEL: currentFlag="+currentFlag );

                break;*/
        }

        invalidate();
        return true;
    }

    int getTouchedPath(int x, int y) {
        if (TL_TOOTH_1.contains(x, y)) {
            return TL_TOOTH_AREA_1;
        } else if (TL_TOOTH_2.contains(x, y)) {
            return TL_TOOTH_AREA_2;
        } else if (TL_TOOTH_3.contains(x, y)) {
            return TL_TOOTH_AREA_3;
        } else if (TL_TOOTH_4.contains(x, y)) {
            return TL_TOOTH_AREA_4;
        } else if (TL_TOOTH_5.contains(x, y)) {
            return TL_TOOTH_AREA_5;
        } else if (TR_TOOTH_1.contains(x, y)) {
            return TR_TOOTH_AREA_1;
        } else if (TR_TOOTH_2.contains(x, y)) {
            return TR_TOOTH_AREA_2;
        } else if (TR_TOOTH_3.contains(x, y)) {
            return TR_TOOTH_AREA_3;
        } else if (TR_TOOTH_4.contains(x, y)) {
            return TR_TOOTH_AREA_4;
        } else if (TR_TOOTH_5.contains(x, y)) {
            return TR_TOOTH_AREA_5;
        } else if (BL_TOOTH_1.contains(x, y)) {
            return BL_TOOTH_AREA_1;
        } else if (BL_TOOTH_2.contains(x, y)) {
            return BL_TOOTH_AREA_2;
        } else if (BL_TOOTH_3.contains(x, y)) {
            return BL_TOOTH_AREA_3;
        } else if (BL_TOOTH_4.contains(x, y)) {
            return BL_TOOTH_AREA_4;
        } else if (BL_TOOTH_5.contains(x, y)) {
            return BL_TOOTH_AREA_5;
        } else if (BR_TOOTH_1.contains(x, y)) {
            return BR_TOOTH_AREA_1;
        } else if (BR_TOOTH_2.contains(x, y)) {
            return BR_TOOTH_AREA_2;
        } else if (BR_TOOTH_3.contains(x, y)) {
            return BR_TOOTH_AREA_3;
        } else if (BR_TOOTH_4.contains(x, y)) {
            return BR_TOOTH_AREA_4;
        } else if (BR_TOOTH_5.contains(x, y)) {
            return BR_TOOTH_AREA_5;
        } else if (RECT_TIME_REGION.contains(x,y)){
            return 0;
        }
        return -1;
    }

    // 点击事件监听器
    public interface ToothClckListener {
        void onToothClckLCallBack(int area);
    }
}

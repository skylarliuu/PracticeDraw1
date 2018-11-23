package com.hencoder.hencoderpracticedraw1.practice;

//import android.animation.AnimatorSet;
//import android.animation.ObjectAnimator;
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.List;

//public class Practice10HistogramView extends View {
//
//    private List<DataBean> mList;
//    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    private int mTextSize = 20;
//
//    class DataBean{
//        String name;
//        float percentage;
//
//        public DataBean(String name,float percentage){
//            this.name = name;
//            this.percentage = percentage;
//        }
//
//    }
//
//    public Practice10HistogramView(Context context) {
//        this(context,null);
//    }
//
//    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init(){
//        DataBean dataBean1 = new DataBean("Froyo",0.1f);
//        DataBean dataBean2 = new DataBean("GB",1.7f);
//        DataBean dataBean3 = new DataBean("ICS",1.6f);
//        DataBean dataBean4 = new DataBean("JB",16.7f);
//        DataBean dataBean5 = new DataBean("KitKat",29.2f);
//        DataBean dataBean6 = new DataBean("L",35.5f);
//        DataBean dataBean7 = new DataBean("M",15.2f);
//        mList = new ArrayList<>();
//        mList.add(dataBean1);
//        mList.add(dataBean2);
//        mList.add(dataBean3);
//        mList.add(dataBean4);
//        mList.add(dataBean5);
//        mList.add(dataBean6);
//        mList.add(dataBean7);
//    }
//
//    @Override
//    protected void onDraw(final Canvas canvas) {
//        super.onDraw(canvas);
////        综合练习
////        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
//
//        //直方图坐标系的长宽
//        int leftMargin = 80;
//        int rightMargin = 80;
//        final int topMargin = 40;
//        int bottomMargin = 160;
//        final float totalHeight = getHeight()- topMargin - bottomMargin;//margin top bottom
//        float totalWidth = getWidth() - leftMargin - rightMargin;//margin left right
//        //矩形间隔
//        int rectMargin = 20;
//
//        //画横竖坐标线
//        mPaint.setColor(Color.WHITE);
//        canvas.drawLine(leftMargin,topMargin,leftMargin,topMargin+totalHeight,mPaint);
//        canvas.drawLine(leftMargin,topMargin+totalHeight,leftMargin+totalWidth,topMargin+totalHeight,mPaint);
//
//        int size = mList.size();
//        //一个小矩形的宽度
//        final float rectWidth = (totalWidth - rectMargin*(size+1)) / size;
//
//        //文字坐标y，不变
//        float textY = topMargin + totalHeight;
//        mPaint.setTextSize(mTextSize);
//        for(int i=0;i<mList.size();i++){
//            DataBean dataBean = mList.get(i);
//
//            //画文字
//            mPaint.setColor(Color.WHITE);
//            Rect bound = new Rect();
//            mPaint.getTextBounds(dataBean.name, 0, dataBean.name.length(), bound);//测量文字的宽高
//            final float textX = leftMargin + rectMargin + (rectMargin + rectWidth) * i;//起始x坐标
//            //计算文字居中后的x坐标，并绘制文字
//            if(bound.width() < rectWidth){
//                canvas.drawText(dataBean.name,textX + (rectWidth/2 - bound.width()/2),textY +mTextSize,mPaint);
//            }else{//文字过长
//                canvas.drawText(dataBean.name,textX,textY + mTextSize,mPaint);
//            }
//
//            //画矩形
//            mPaint.setColor(Color.GREEN);
//            //计算矩形的top值
//            float rectHeight = topMargin + totalHeight * (1 - dataBean.percentage * 0.01f);
//            canvas.drawRect(textX,rectHeight,textX+rectWidth,topMargin+totalHeight,mPaint);
//
//        }
//    }
//
//}

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;


import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private final static String NAME = "直方图";

    private List<Data> datas;
    private Paint paint;
    private float startX;
    private float space;
    private float width;
    private float max;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Froyo", 10.0f, Color.GREEN);
        datas.add(data);
        data = new Data("ICS", 18.0f, Color.GREEN);
        datas.add(data);
        data = new Data("JB", 22.0f, Color.GREEN);
        datas.add(data);
        data = new Data("KK", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("L", 40.0f, Color.GREEN);
        datas.add(data);
        data = new Data("M", 60.0f, Color.GREEN);
        datas.add(data);
        data = new Data("N", 33.5f, Color.GREEN);
        datas.add(data);
        max = Float.MIN_VALUE;
        for (Data d : datas) {
            max = Math.max(max, d.getNumber());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.WHITE);
        paint.setTextSize(72);
        canvas.drawText(NAME, (canvas.getWidth() - paint.measureText(NAME)) / 2, canvas.getHeight() * 0.9f, paint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f); // 将画图原点移动直方图的原点位置

        width = (canvas.getWidth() * 0.8f - 100) / datas.size() * 0.8f;//小矩形宽度
        space = (canvas.getWidth() * 0.8f - 100) / datas.size() * 0.2f;//间隔宽度

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, paint);   // 画x轴
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, paint); // 画y轴

        startX = 0f;

        paint.setTextSize(36);
        paint.setStyle(Paint.Style.FILL);
        for (Data data : datas) {
            paint.setColor(data.getColor());
            canvas.drawRect(startX + space, -(data.getNumber() / max * canvas.getHeight() * 0.6f), startX + space + width, 0, paint);
            paint.setColor(Color.WHITE);
            canvas.drawText(data.getName(), startX + space + (width - paint.measureText(data.getName())) / 2, 40, paint);
            startX += width + space;
        }
    }
}

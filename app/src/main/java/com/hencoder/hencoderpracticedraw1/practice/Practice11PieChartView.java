//package com.hencoder.hencoderpracticedraw1.practice;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class Practice11PieChartView extends View {
//
//    private List<DataBean> mList;
//    private int[] mColorArr = new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.LTGRAY,Color.CYAN,Color.parseColor("#FFA569")};
//    private int maxIndex = 0;
//
//    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    private int mTextSize = 20;
//    private float leftMargin = 200f;
//    private float topMargin = 50f;
//    private float rightMargin = 800f;
//    private float bottomMargin = 650f;
//    private float move = 20f;
//    private float radius;
//
//    class DataBean{
//        String name;
//        float percentage;
//
//        public DataBean(String name,float percentage){
//            this.name = name;
//            this.percentage = percentage;
//
//        }
//
//    }
//
//    public Practice11PieChartView(Context context) {
//        this(context,null);
//    }
//
//    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//
//        //找出最大的一块
//        float maxPer = mList.get(0).percentage;
//        for(int i=0;i<mList.size();i++){
//            DataBean dataBean = mList.get(i);
//            if(maxPer < dataBean.percentage){
//                //记录最大的
//                maxPer = dataBean.percentage;
//                maxIndex = i;
//            }
//        }
//
//        radius = (rightMargin - leftMargin)/2;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
////        综合练习
////        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
//        RectF rect = new RectF(leftMargin,topMargin,rightMargin,bottomMargin);
//
//        int size = mList.size();
//        float margin = 2;
//        float total = 360 - margin * size;
//        float startAngel = 0;
//
//        for(int i =0;i<mList.size();i++){
//
//            //画扇形
//            mPaint.setColor(mColorArr[i]);
//            float angel = mList.get(i).percentage * 0.01f*total;
//            mPaint.setStyle(Paint.Style.FILL);
//            if(i == maxIndex){
//                drawBiggest(canvas,startAngel,angel);
//                //画文字
//                drawText(canvas,startAngel,angel,mList.get(i).name);
//            }else{
//                canvas.drawArc(rect,startAngel,angel,true,mPaint);
//            }
//
//
//
//
//            startAngel = startAngel + angel + margin;
//
//
//
//        }
//    }
//
//    private void drawText(Canvas canvas, float startAngel, float angel, String name) {
//        mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.STROKE);
//        float rightTextMarginLeft = rightMargin + 80;
//        float leftTextMarginRight = leftMargin - 80;
//
//        float centerAngel = startAngel + angel/2;//扇形中心点的角度
//
//        float disY = 20f;
//        float disX = (float) (Math.sin(45) * Math.cos(45) * disY);
//        Path path = new Path();
//        float centerAngelX = 0;//中心点坐标
//        float centerAngelY =0;
//
//        if(centerAngel >= 0 && centerAngel <90){//右下
//
//            path.lineTo(centerAngelX+disX,centerAngelY+disY);
//            path.lineTo(centerAngelX+disX+rightTextMarginLeft,centerAngelY-disY);
//            canvas.drawText(name,centerAngelX+disX+rightTextMarginLeft,centerAngelY-disY,mPaint);
//        }else if(centerAngel >=90 && centerAngel <180){//左下
//            path.lineTo(centerAngelX-disX,centerAngelY+disY);
//            path.lineTo(centerAngelX-disX+leftTextMarginRight,centerAngelY+disY);
//            canvas.drawText(name,centerAngelX-disX+leftTextMarginRight,centerAngelY+disY,mPaint);
//        }else if(centerAngel >=180 && centerAngel <270){//左上
//            centerAngelX = (float) (Math.cos((centerAngel-180)/360));
//            centerAngelX = centerAngelX*radius;
//            centerAngelX = leftMargin + radius - centerAngelX;//中心点坐标
//            centerAngelY = (float) (Math.sin((centerAngel-180)/360));
//            centerAngelY = centerAngelY * radius;
//            centerAngelY = topMargin + radius - centerAngelY;
//            path.moveTo(centerAngelX,centerAngelY);
//            path.lineTo(centerAngelX-disX,centerAngelY+disY);
//            path.lineTo(centerAngelX-disX+leftTextMarginRight,centerAngelY+disY);
//            canvas.drawText(name,centerAngelX-disX+leftTextMarginRight,centerAngelY+disY,mPaint);
//        }else{//右上
//            path.lineTo(centerAngelX+disX,centerAngelY-disY);
//            path.lineTo(centerAngelX+disX+rightTextMarginLeft,centerAngelY-disY);
//            canvas.drawText(name,centerAngelX+disX+rightTextMarginLeft,centerAngelY-disY,mPaint);
//        }
//
//        canvas.drawPath(path,mPaint);
//
//    }
//
//    //绘制最大的一块扇形
//    private void drawBiggest(Canvas canvas, float startAngel, float angel) {
//        float centerLine = startAngel + angel/2;
//        RectF rect = null;
//        if(centerLine == 0){//正右
//            rect = new RectF(leftMargin+move,topMargin,rightMargin+move,bottomMargin);
//        }else if(centerLine >0 && centerLine<90){//右下
//            rect = new RectF(leftMargin+move,topMargin+move,rightMargin+move,bottomMargin+move);
//        }else if(centerLine == 90){//正下
//            rect = new RectF(leftMargin,topMargin+move,rightMargin,bottomMargin+move);
//        }else if(centerLine >90 && centerLine<180){//左下
//            rect = new RectF(leftMargin-move,topMargin+move,rightMargin-move,bottomMargin+move);
//        }else if(centerLine == 180){//正左
//            rect = new RectF(leftMargin-move,topMargin,rightMargin-move,bottomMargin);
//        }else if(centerLine > 180 && centerLine <270){//上左
//            rect = new RectF(leftMargin-move,topMargin-move,rightMargin-move,bottomMargin-move);
//        }else if(centerLine == 270){//正上
//            rect = new RectF(leftMargin,topMargin-move,rightMargin,bottomMargin-move);
//        }else {//右上
//            rect = new RectF(leftMargin+move,topMargin-move,rightMargin+move,bottomMargin-move);
//        }
//        canvas.drawArc(rect,startAngel,angel,true,mPaint);
//    }
//}


package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    private float radius;
    private List<Data> datas;
    private Paint paint;
    private RectF rectF;
    private float total;
    private float max;

    float startAngle = 0f; // 开始的角度
    float sweepAngle;      // 扫过的角度
    float lineAngle;       // 当前扇形一半的角度

    float lineStartX = 0f; // 直线开始的X坐标
    float lineStartY = 0f; // 直线开始的Y坐标
    float lineEndX;        // 直线结束的X坐标
    float lineEndY;        // 直线结束的Y坐标

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        radius = 300;
        datas = new ArrayList<>();
        Data data = new Data("Gingerbread", 10.0f, Color.WHITE);
        datas.add(data);
        data = new Data("Ice Cream Sandwich", 18.0f, Color.MAGENTA);
        datas.add(data);
        data = new Data("Jelly Bean", 22.0f, Color.GRAY);
        datas.add(data);
        data = new Data("KitKat", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("Lollipop", 40.0f, Color.BLUE);
        datas.add(data);
        data = new Data("Marshmallow", 30.0f, Color.RED);
        datas.add(data);
        data = new Data("Nougat", 63.5f, Color.YELLOW);
        datas.add(data);
        total = 0.0f;
        max = Float.MIN_VALUE;
        for (Data d : datas) {
            total += d.getNumber();
            max = Math.max(max, d.getNumber());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
        paint.setTextSize(30);
        rectF = new RectF(-300, -300, 300, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);  // 将画布(0，0)坐标点移到画布的中心
        startAngle = 0f; //这句代码很重要，不然有bug
        for (Data data : datas) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(data.getColor());
            sweepAngle = data.getNumber() / total * 360f;
            lineAngle = startAngle + sweepAngle / 2;
            lineStartX = radius * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineStartY = radius * (float) Math.sin(lineAngle / 180 * Math.PI);
            lineEndX = (radius + 50) * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(lineAngle / 180 * Math.PI);
            if (data.getNumber() == max) {
                canvas.save();
                canvas.translate(lineStartX * 0.1f, lineStartY * 0.1f);
                canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
            } else {
                canvas.drawArc(rectF, startAngle, sweepAngle - 1.0f, true, paint);
            }
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (lineAngle > 90 && lineAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(), lineEndX - 50 - 10 - paint.measureText(data.getName()), lineEndY, paint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(), lineEndX + 50 + 10, lineEndY, paint);
            }
            if (data.getNumber() == max) {
                canvas.restore();
            }
            startAngle += sweepAngle;
        }
    }
}
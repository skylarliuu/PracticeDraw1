package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        int rectWidth = 400;
        int rectHeight = 200;

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(getWidth()/2-rectWidth/2,getHeight()/2-rectHeight/2,
                getWidth()/2+rectWidth/2,getHeight()/2+rectHeight/2,50,50,mPaint);
    }
}

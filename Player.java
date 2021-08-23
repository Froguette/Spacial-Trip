package froguette.code_fister.spacialtrip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Player {
    private Paint p;
    private Drawable rocket;
    public double x,y,c=160;
    public int mhp=100,hp=100;
    public Bitmap r,f;
    public Rect rect;

    public Player(Context context,int w,int h){
        this.x=w>>1;this.y=h>>1;
        p=new Paint();
        //rocket=context.getResources().getDrawable(R.drawable.rocket);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inDensity = options.inTargetDensity ;
        //
        r=BitmapFactory.decodeResource(context.getResources(), R.drawable.rocket,options);
        f=BitmapFactory.decodeResource(context.getResources(), R.drawable.fire1,options);
        rect=new Rect((int)x,(int)y,(int)(x+c),(int)(y+c));
    }

    public void draw(Canvas canvas) {

        double dx=(x-c/2),dy=(y-c/2),dw=(x+c/2),dh=(y+c/2);
        rect=new Rect((int)dx,(int)dy,(int)dw,(int)dh);
        //canvas.drawRect((float)dx,(float)dy,(float)dw,(float)dh,p);
        //rocket.setBounds(new Rect((int)dx,(int)dy,(int)dw,(int)dh));
        //rocket.draw(canvas);
        canvas.drawBitmap(r,null,rect,p);

        double hx=dx,hy=dy-(c/4);
        p.setColor(Color.rgb(200,0,0));
        canvas.drawRect((float)hx,(float)hy,(float)(hx+c),(float)(hy+c/4),p);
        p.setColor(Color.rgb(0,255,0));
        canvas.drawRect((float)hx,(float)hy,(float)(hx+(c/mhp)*hp),(float)(hy+c/4),p);

    }
    public void drawF(Canvas canvas,double I){double dx=(x-c/2),dy=(y-c/2),dw=(x+c/2),dh=(y+c/2);
        canvas.drawBitmap(f,null,new Rect((int)dx,(int)(dy+c*0.9),(int)dw,(int)(dh+c*0.9)), p);
    }
    public void update(int x,int y,boolean clkd){
        if(clkd){this.x=x;/*this.y=y;*/};
    }
}

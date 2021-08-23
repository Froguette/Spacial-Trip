package froguette.code_fister.spacialtrip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Meteor {
    public int dx,dy,w;
    public double x,y=-200,spd;
    public Paint p;
    public Bitmap m;
    //public Rect rect;
    public Meteor(Context context,int dx, int dy){
        this.dx=dx;this.dy=dy;
        x=Math.random()*dx;
        spd=2+Math.random()*10;
        w=(int)(Math.random()*200);
        p=new Paint();
        int o=(int)(Math.random()*70+50);
        p.setColor(Color.rgb(o,o,o));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inDensity = options.inTargetDensity ;
        int i=w<120?R.drawable.meteor:R.drawable.met2;
        m= BitmapFactory.decodeResource(context.getResources(),i,options);
    }

    public void update() {
        y+=spd;
    }

    public void draw(Canvas canvas) {
        //canvas.drawRect((float)x,(float)y,(float)x+w,(float)y+w,p);
        canvas.drawBitmap(m,null,new Rect((int)x,(int)y,(int)(x+w),(int)(y+w)), p);
    }

}

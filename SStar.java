package froguette.code_fister.spacialtrip;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SStar {
    private Paint p;
    public double x,y;
    private int w;
    public SStar(int dw,int dh,int y){
        this.x=Math.random()*dw;this.y=y+Math.random()*15;
        this.w=(int)(Math.random()*15);
        p=new Paint();
    }
    public void update(){
        this.y+=0.5;
    }
    public void draw(Canvas canvas){
        p.setColor(Color.rgb(255,255,255));
        canvas.drawRect((float)x,(float)y,(float)x+w,(float) y+w,p);
    }
}

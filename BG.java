package froguette.code_fister.spacialtrip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

public class BG {
    List<SStar> sstrs=new ArrayList<SStar>();
    List<Meteor> mtrs=new ArrayList<Meteor>();
    private final Player player;
    public Bttn btn=new Bttn();
    public Context context1;
    private Paint p;
    int Dw,Dh;

    public BG(Context context,int dw,int dh) {
        Dw=dw;Dh=dh;
        for(int i=0;i<dh;i+=dh/100){sstrs.add(new SStar(dw,dh,i));}
        for(int i=0;i<12;i++){mtrs.add(new Meteor(context,Dw,Dh));}
        context1=context;
        p=new Paint();
        player=new Player(context,Dw,Dh);
    }
    public void update(int x,int y,boolean clkd){
        for(int i=0;i<sstrs.size();i++){sstrs.get(i).update();if(sstrs.get(i).y>Dh){sstrs.remove(i);sstrs.add(new SStar(Dw,Dh,-20));}}
        for(int i=0;i<mtrs.size();i++){mtrs.get(i).update();if(mtrs.get(i).y>Dh){mtrs.remove(i);mtrs.add(new Meteor(context1,Dw,Dh));}}
        player.update(x,y,clkd);
        
    }
    public void draw(Canvas canvas){
        p.setColor(Color.rgb(10,0,50));
        canvas.drawRect(0,0,Dw,Dh,p);
        for(int i=0;i<sstrs.size();i++){sstrs.get(i).draw(canvas);}
        for(int i=0;i<mtrs.size();i++){mtrs.get(i).draw(canvas);}
        player.draw(canvas);
    }
}

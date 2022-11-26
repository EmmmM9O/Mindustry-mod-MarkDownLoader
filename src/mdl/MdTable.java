package mdl;

import arc.Core;
import arc.graphics.Colors;
import arc.math.Mat;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import mindustry.ui.Fonts;

import java.util.Objects;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MdTable {
    public static MdG key[]={Gs.XieTi};
    public static String k="[^*~#\\n]";
    public static Label.LabelStyle UseL=new Label.LabelStyle(Fonts.outline,Colors.get("Black"));
    public Vector<Integer> l[]=new Vector[key.length];
    public Integer useScl=1;
    public Integer now[]=new Integer[key.length];
    public void init(){
        for (var i:l){
            i=new Vector<Integer>();
        }
        for (var i:now){
            i=0;
        }
    }
    public void add(String data,Table t){
        Matcher m;
        for (var i:l){
            if(i.size()>0) i.clear();
        }
        float scl=0;int cnt=0;
        for (MdG i : key){
            m= Pattern.compile(i.i).matcher(data);

            while (m.find()){
                l[cnt].add(m.start());
                l[cnt].add(m.end());

            }
            cnt++;
        }
        m=Pattern.compile(k).matcher(data);
        for (var i : now){
            i=0;
        }
        Label.LabelStyle e=UseL;
        while (m.find()){
            cnt=0;
            for (var i:key){

                if (m.end()<l[cnt].get(now[cnt*2])&&m.start()>=l[cnt].get(now[cnt]*2)){
                    i.Run.get(t,scl,e);
                }
                t.add(m.group(cnt+1),e,scl);
                scl=useScl;
                e=UseL;
                cnt++;
            }
        }
    }
    public MdTable(){
}
}

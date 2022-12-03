package mdl;

import arc.Core;
import arc.graphics.Colors;
import arc.math.Mat;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import arc.util.*;
import mindustry.ui.Fonts;

import java.util.Objects;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MdTable {
    public static MdG key[]={Gs.ChuTi};
    public static String k="[^*~#\\n]+";
    public static Label.LabelStyle UseL=new Label.LabelStyle(Fonts.outline,Colors.get("Black"));
    public Vector<Integer>[] l=new Vector[key.length];
    public Integer useScl=1;
    public Integer[] now=new Integer[key.length];
    public void init(){
        for (var i:l){
            i=new Vector<Integer>();
        }
        for(var i=0;i<key.length;i++){
            l[i]=new Vector<Integer>();
            }
        for (var i:now){
            i=0;
        }
    }
    public void add(String data,Table t){
        

        for (var i:l){
            if(i.size()>0) i.clear();
        }
        float scl=1f;int cnt=0;
        for (MdG i : key){
            Log.info("key:");
            Log.info(i.i);
            Log.info("data:");
            Log.info(data);
            var m= Pattern.compile(i.i).matcher(data);

            while (m.find()){
                l[cnt].add(m.start());
                l[cnt].add(m.end());
                Log.info("add");
                Log.info(m.start());

            }
            cnt++;
        }
        var m=Pattern.compile(k).matcher(data);
        for(int i=0;i<key.length;i++){
            now[i]=0;
        }
        for (var i : now){
            i=0;
        }
        Label.LabelStyle e=UseL;
        while (m.find()){
            cnt=-1;
            
            for (var i:key){
                cnt++;
                if(now[cnt]*2>=l[cnt].size()) {
                    t.add(m.group(cnt),e,scl);
                    continue;
                  
                    }
                if(now[cnt]==null||l[cnt].get(now[cnt]*2)==null) {
                    t.add(m.group(cnt),e,scl);
                    continue;
                    }
                if (m.end()<l[cnt].get(now[cnt]*2+1)&&m.start()>=l[cnt].get(now[cnt]*2)){
                    Log.info("run");
                    Log.info(m.group(cnt));
                    i.Run.get(t,scl,e,m.group(cnt));
                }else if(m.end()>=l[cnt].get(now[cnt]*2+1)){
                    now[cnt]++;
                    
                  
                }
                t.add(m.group(cnt),e,scl);
            }
        }
    }
    public MdTable(){
}
}

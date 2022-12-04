package mdl;


import arc.graphics.Color;

import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import arc.util.*;
import mindustry.ui.Fonts;

import java.util.Vector;

import java.util.regex.Pattern;

public class MdTable {
    public static MdG[] key={Gs.ChuTi,Gs.XieTi,Gs.TI};
    public static String k="\\b[^~#*\\n]+\\b";
    public static Label.LabelStyle UseL=new Label.LabelStyle(Fonts.outline, Color.darkGray);
    public Vector<Integer>[] l=new Vector[key.length];

    public Integer[] now=new Integer[key.length];
    public void init(){
        for(var i=0;i<key.length;i++) {
            l[i] = new Vector<>();
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
        Label.LabelStyle e=UseL;

        var kk=0;var flag=false;

        while (m.find()){

            cnt=-1;

            

            flag=false;

            for (var i:key){

            

                cnt++;

                if(now[cnt]*2>=l[cnt].size()) {

                    

                    continue;

                  

                    }

                if(now[cnt]==null||l[cnt].get(now[cnt]*2)==null) {

                    

                    continue;

                    }

                if (m.end()<l[cnt].get(now[cnt]*2+1)&&m.start()>=l[cnt].get(now[cnt]*2)){

                    flag=true;

                    Log.info("run");

                    Log.info(m.group(kk));

                    scl=i.Run.get(t,scl,e,m.group(kk));

                    break;

                }else if(m.end()>=l[cnt].get(now[cnt]*2+1)){

                    now[cnt]++;

                 

                }

               

                if (data.length()>m.end()&&data.charAt(m.end())=='\n'){

                    t.row();
                   

                    scl=1;
                    break;

                }

            }

            if(!flag) t.add(m.group(kk),e,scl);

            kk++;

        }
            
    }
    public MdTable(){
}
}

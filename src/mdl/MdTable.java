package mdl;

import arc.graphics.Color;

import arc.scene.ui.Label;

import arc.scene.ui.layout.Table;

import arc.util.*;

import java.util.Vector;

import java.util.regex.Pattern;

public class MdTable {

    public static MdG[] key={Gs.Yy,Gs.Te,Gs.Til,Gs.ChuTi,Gs.XieTi,Gs.TI};

    public static String k="[^`>~#*\\n]+";

    public static Label.LabelStyle UseL=new Label.LabelStyle(MdFonts.OsTh, Color.black);

    public Vector<Integer>[] l=new Vector[key.length];

    public Integer[] now=new Integer[key.length];

    public void init(){

        for(var i=0;i<key.length;i++) {

            l[i] = new Vector<>();

        }

    }

    public void add(String data,Table t){

        float scl=1f;int cnt;

        Label.LabelStyle e=UseL;

        var ss=data.split("\\n");

        for (var nows : ss){

            for (var i:l){

                if(i.size()>0) i.clear();

            }

            cnt=0;

            for (MdG i : key){

                var m= Pattern.compile(i.i).matcher(nows);

                while (m.find()){

                    l[cnt].add(m.start());

                    l[cnt].add(m.end());

                    Log.info("add");
                    Log.info(m.start());
                    Log.info(m.end());

                }

                cnt++;

            }

            for(int i=0;i<key.length;i++){

                now[i]=0;

            }

            var m=Pattern.compile(k).matcher(nows);

            while (m.find()){

                e=new Label.LabelStyle(UseL);

                cnt=-1;

                String ew=m.group();

                for (var i:key){

                    cnt++;

                    if(now[cnt]*2>=l[cnt].size()) continue;

                    if(now[cnt]==null||l[cnt].get(now[cnt]*2)==null) continue;

                    if (m.end()<=l[cnt].get(now[cnt]*2+1)&&m.start()>=l[cnt].get(now[cnt]*2)){

                        var pa=i.Run.get(t,scl,new Label.LabelStyle(e),ew,nows);

                        scl=pa.first;e=new Label.LabelStyle(pa.second);
                        Log.info(scl);

                        

                    }else if(m.end()>l[cnt].get(now[cnt]*2+1)) {

                        now[cnt]++;
                        Log.info("out");

                        e=new Label.LabelStyle(UseL);

                    }
                    Log.info(now[cnt]);

                }
                

                t.add(ew,e,scl);

            }
            

            t.row();

            scl=1f;

        }

            

    }

    public MdTable(){

}

}

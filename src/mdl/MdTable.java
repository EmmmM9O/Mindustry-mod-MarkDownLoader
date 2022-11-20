package mdl;

import arc.Core;
import arc.graphics.Colors;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import mindustry.ui.Fonts;

import java.util.Stack;
import java.util.Vector;

public class MdTable {
    public Label.LabelStyle Xt=new Label.LabelStyle(Fonts.tech, Colors.get("WHITE"));
    public Label.LabelStyle Ut=new Label.LabelStyle(Fonts.outline,Colors.get("WHITE"));
    public Vector<String> arr=new Vector<>();
    public Stack<Integer> XList=new Stack<Integer>();
    public void init(Table ta){
        String now="";
        var nowt=Ut;
        float nowf=1f;int Xad=-1;
        for (String i:arr){
            nowf=1f;now="";nowt=Ut;Xad=-1;
            for (int v=0;v<i.length();v++) {

                char a = i.charAt(v);
                if (a=='*'){
                    var k=i.indexOf("*",v+1);
                    if (k!=-1){
                        Xad=k;nowt=Xt;
                    }
                    else if (v==0){
                        ta.image(Core.atlas.drawable("mdl-d"));
                    }
                    else nowt=Ut;
                }
                if (v>Xad){
                    nowt=Ut;
                }
                if (a == ' ') {
                    if (now.matches("#+")) {
                        nowf = (float) (3.3f - now.length() * 0.6f);
                    } else ta.add(now, nowf).size(0.8f);
                    now = "";
                } else now = now + a;

            }
            if (now.length()!=0) ta.add(now,nowt,nowf);
            ta.row();
        }
    }
    public void reset(String data,Table t){
        arr.clear();
        String now="";
        for(int i=0;i<data.length();i++){
            char a=data.charAt(i);
            if (a=='\n') {
                arr.add(new String(now));
                now="";
            }
            else now=now+a;
        }
        if (now.length()!=0) arr.add(now);
        init(t);
    }

    public MdTable(){
}

}

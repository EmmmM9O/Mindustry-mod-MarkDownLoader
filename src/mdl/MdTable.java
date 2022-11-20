package mdl;

import arc.scene.ui.layout.Table;

import java.util.Vector;

public class MdTable {
    public Vector<String> arr=new Vector<>();
    public void init(Table ta){
        String now="";
        float nowf=1f;
        for (String i:arr){
            nowf=1f;now="";
            for (int v=0;v<i.length();v++) {
                char a = i.charAt(v);
                if (a == ' ') {
                    if (now.matches("#+")) {
                        nowf = (float) (3.3f - now.length() * 0.3f);
                    } else ta.add(now, nowf);
                    now = "";
                } else now = now + a;

            }
            if (now.length()!=0) ta.add(now,nowf);
            ta.row();
        }
    }
    public void reset(String data,Table t){

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

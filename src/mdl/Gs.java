package mdl;


import arc.Core;
import arc.graphics.Color;

public class Gs {

    public static MdG Te=new MdG(),Yy=new MdG(),Til=new MdG(),ChuTi=new MdG(),XieTi=new MdG(),TI=new MdG();
    public static void init(){
        /*
        *test*
         */
        Yy.i="((?![^`])|^)`{1}\\b[^`\\n]+\\b`{1}((?=[^`])|$)";
        Yy.Run=(t,scl,e,s,i,from)->{
            e.background= Core.atlas.drawable("mdl-BackGround2");
            return new pair<>(scl,e);

        };
        Te.i=">+ [^>\\*~n]+";
        Te.Run=(t,scl,e,s,i,from)->{
            t.image(Core.atlas.drawable("mdl-YinYong"));
            return new pair<>(scl,e);
        };
        Til.i="#+ [^#\\n]+";
        Til.Run=(t,scl,e,s,i,from)->{
            scl=3f;var flag=false;
            for (int j=from;j>=0;j--){
                if(i.charAt(j)=='#'){
                    if(flag ) scl-=0.6f;
                    else flag=true;
                }else if (flag) break;
            }

            return new pair<>(scl,e);
        };
        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s,i,from)->{
            e.font=MdFonts.OsTh;
            return new pair<>(scl,e);

        };
        XieTi.i="((?![^~])|^)~{1}\\b[^~\\n]+\\b~{1}((?=[^~])|$)";
        XieTi.Run=(t,scl,e,s,i,from)->{
            e.font=MdFonts.OsRI;
            return new pair<>(scl,e);

        };
        TI.i="((?![^*])|^)\\*{2}\\b[^*\\n]+\\b\\*{2}((?=[^*])|$)";
        TI.Run=(t,scl,e,s,i,from)->{
            e.font=MdFonts.Smiley;
            return new pair<>(scl,e);

        };

    }

}

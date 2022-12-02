package mdl;

import arc.graphics.Color;
import arc.scene.ui.Label;
import mindustry.ui.Fonts;

public class Gs {
    public static Label.LabelStyle C=new Label.LabelStyle(Fonts.tech, Color.black);
    public static MdG ChuTi=new MdG(),XieTi=new MdG(),title=new MdG();
    public static void init(){
        ChuTi.i="(\\b|^)\\*{1}\\b[^*\\n]+\\b\\*{1}(\\b|$)";
        ChuTi.Run=(t,scl,e)->{
            t.add("ChuTiTest");
            e=C;
        };

    }

}

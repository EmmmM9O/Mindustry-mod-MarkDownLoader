package mdl;

import arc.graphics.Color;
import arc.scene.ui.Label;
import mindustry.ui.Fonts;
import arc.util.*;

public class Gs {
    public static Label.LabelStyle C=new Label.LabelStyle(Fonts.tech, Color.black);
    public static MdG ChuTi=new MdG(),XieTi=new MdG(),title=new MdG();
    public static void init(){
        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s)->{
            t.add(s,C,scl);
            e=C;

        };

    }

}

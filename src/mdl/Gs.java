package mdl;

import arc.Core;
import arc.freetype.FreeTypeFontGenerator;
import arc.freetype.FreetypeFontLoader;
import arc.graphics.Color;
import arc.graphics.g2d.Font;
import arc.scene.ui.Label;
import mindustry.ui.Fonts;
import arc.util.*;

public class Gs {
    public static Font CT;
    public static Label.LabelStyle C=new Label.LabelStyle(CT, Color.black);
    public static MdG ChuTi=new MdG(),XieTi=new MdG(),title=new MdG();
    public static void init(){

        Core.assets.load("CT", Font.class, new FreetypeFontLoader.FreeTypeFontLoaderParameter("fonts/SourceHanSansCN-Normal.ttf", new FreeTypeFontGenerator.FreeTypeFontParameter(){{
            size = 18;
        }})).loaded = f -> {
            CT= f;
        };
        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s)->{
            t.add(s,C,scl);
            e=C;

        };

    }

}

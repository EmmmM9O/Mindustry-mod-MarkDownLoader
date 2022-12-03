package mdl;

import arc.Core;
import arc.files.Fi;
import arc.files.ZipFi;
import arc.freetype.*;
import arc.freetype.FreeTypeFontGenerator.*;
import arc.graphics.Color;
import arc.graphics.g2d.Font;
import arc.scene.ui.Label;
import mindustry.Vars;
import mindustry.ui.Fonts;
import arc.util.*;

public class Gs {
    public static Font CT;
    public static Label.LabelStyle C=new Label.LabelStyle(CT, Color.black);
    public static MdG ChuTi=new MdG(),XieTi=new MdG(),title=new MdG();
    public static void init(){

        

Fi fontFi = Vars.mods.getMod(mainMod.class).root.child("fonts").child("SmileySans-Oblique.ttf");

if (!fontFi.exists()) {

        CT = Fonts.def;

        return;

}

FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFi);

FreeTypeFontParameter parameter = new FreeTypeFontParameter() {{

        size = 22;

        shadowColor = Color.darkGray;

        shadowOffsetY = 2;

        incremental = true;

}};

// final boolean[] generating = {false};

CT = generator.generateFont(parameter, new FreeTypeFontData() {

{

        markupEnabled = true;

}

});
        C=new Label.LabelStyle(CT, Color.black);
        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s)->{
            t.add(s,C,scl);
            e=C;

        };

    }

}

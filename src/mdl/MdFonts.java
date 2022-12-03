package mdl;

import arc.files.Fi;
import arc.freetype.FreeTypeFontGenerator;
import arc.graphics.Color;
import arc.graphics.g2d.Font;
import mindustry.Vars;
import mindustry.ui.Fonts;


public class MdFonts {
    public static Font Smiley;
    public static Font add(String name){

        Fi fontFi= Vars.mods.getMod(mainMod.class).root.child("fonts").child(name);
        if(!fontFi.exists()){
            return Fonts.def;
        }
        FreeTypeFontGenerator g=new FreeTypeFontGenerator(fontFi);
        FreeTypeFontGenerator.FreeTypeFontParameter p=new FreeTypeFontGenerator.FreeTypeFontParameter() {{

            size = 20;

            shadowColor = Color.black;

            shadowOffsetY = 4;

            incremental = true;

        }};
        return  g.generateFont(p, new FreeTypeFontGenerator.FreeTypeFontData() {

            {

                markupEnabled = true;

            }

        });
    }
    public static void init(){
        Smiley=add("SmileySans-Oblique.ttf");
    }
}

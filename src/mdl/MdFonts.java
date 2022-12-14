package mdl;

import arc.files.Fi;
import arc.freetype.FreeTypeFontGenerator;
import arc.graphics.Color;
import arc.graphics.g2d.Font;
import mindustry.Vars;
import mindustry.ui.Fonts;


public class MdFonts {
    public static Font Smiley,OsBlack,OsRI,OsTh;
    public static Font add(String name){

        Fi fontFi= Vars.mods.getMod(mainMod.class).root.child("fonts").child(name);
        if(!fontFi.exists()){
            return Fonts.def;
        }
        FreeTypeFontGenerator g=new FreeTypeFontGenerator(fontFi);
        FreeTypeFontGenerator.FreeTypeFontParameter p=new FreeTypeFontGenerator.FreeTypeFontParameter() {{

            size = 30;


            shadowColor = Color.darkGray;

            shadowOffsetY = 2;

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
        OsBlack=add("HarmonyOS_Sans_SC_Black.ttf");
        OsRI=add("HarmonyOS_Sans_Regular_Italic.ttf");
        OsTh=add("HarmonyOS_Sans_SC_Regular.ttf");
    }
}

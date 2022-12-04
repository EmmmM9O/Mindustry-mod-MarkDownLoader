package mdl;

import arc.graphics.Color;
import arc.scene.ui.Label;

public class MdStyle {
    public static Label.LabelStyle Smiley,OsBlack,OsRi;
    public static void init(){
        Smiley=new Label.LabelStyle(MdFonts.Smiley, Color.darkGray);
        OsBlack=new Label.LabelStyle(MdFonts.OsBlack,Color.darkGray);
        OsRi=new Label.LabelStyle(MdFonts.OsRI,Color.darkGray);
    }
}

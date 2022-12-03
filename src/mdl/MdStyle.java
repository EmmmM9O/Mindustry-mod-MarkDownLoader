package mdl;

import arc.graphics.Color;
import arc.scene.ui.Label;

public class MdStyle {
    public static Label.LabelStyle Smiley;
    public static void init(){
        Smiley=new Label.LabelStyle(MdFonts.Smiley, Color.black);

    }
}

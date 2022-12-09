package mdl;

import arc.*;
import arc.util.*;
import mindustry.content.Items;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.ui.dialogs.*;
import arc.graphics.Color;
public class mainMod extends Mod{
    public MarkBlock MarkDownMessage;
    public static Color TiColor=new Color(0x202125ff);
    public mainMod(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("modinfo");
                dialog.cont.add("still make").row();

                dialog.cont.button("@ok", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        MdFonts.init();
        MdStyle.init();
        Log.info("Loading mdl");
        Gs.init();
        MarkDownMessage=new MarkBlock("MarkDownMessage"){{
            requirements(Category.logic,ItemStack.with(Items.graphite,5));
        }
        };
    }

}

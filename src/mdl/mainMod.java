package mdl;

import arc.*;
import arc.util.*;
import mindustry.content.Items;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.ui.dialogs.*;

public class mainMod extends Mod{
    public MarkBlock MarkDownMessgae;
    public mainMod(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();

                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        Gs.init();
        Log.info("Loading mdl");
        Gs.init();
        MarkDownMessgae=new MarkBlock("MarkDownMessage"){{
            requirements(Category.logic,ItemStack.with(Items.graphite,5));
        }
        };
    }

}

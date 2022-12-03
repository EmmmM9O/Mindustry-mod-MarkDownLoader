package mdl;

import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.blocks.logic.MessageBlock;
import arc.Core;

public class MarkBlock extends MessageBlock {
    public MdTable md=new MdTable();
    public MarkBlock(String name){
        super(name);
        md.init();
    }
  
    public class MarkBuild extends MessageBuild {
        @Override
        public void buildConfiguration(Table table){
            super.buildConfiguration(table);
            table.button("show",()->{
                var ui=new BaseDialog("MarkDown");
                ui.background(Core.atlas.drawable("mdl-BackGround"));
                ui.cont.table(t -> {
                    md.add(message.toString(),t);
                });
                ui.button("@ok",ui::hide);
                ui.show();
            });
        }
    }
}

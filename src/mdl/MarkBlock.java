package mdl;

import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.blocks.logic.MessageBlock;

public class MarkBlock extends MessageBlock {
    public MarkBlock(String name){
        super(name);
    }
    public MdTable md=new MdTable();
    public class MarkBuild extends MessageBuild {
        @Override
        public void buildConfiguration(Table table){
            super.buildConfiguration(table);
            table.button("show",()->{
                var ui=new BaseDialog("MarkDown");
                ui.cont.table(t -> {
                    md.reset(message.toString(),t);
                });
                ui.button("@ok",ui::hide);
                ui.show();
            });
        }
    }
}

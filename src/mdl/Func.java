package mdl;

import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;

public interface Func {
    pair<Float,Label.LabelStyle> get(Table t, float scl, Label.LabelStyle l,String s,String i,Integer from);
}

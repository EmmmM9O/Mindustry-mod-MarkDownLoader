package mdl;

import arc.util.Nullable;

public class pair <T,T1>{
    @Nullable
    T first;
    @Nullable
    T1 second;
    public pair(T f,T1 s){
        first=f;
        second=s;
    }
    public pair(){

    }
    public pair(pair<T,T1> e){
        first=e.first;
        second=e.second;
    }
}

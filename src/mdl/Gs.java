package mdl;



public class Gs {
    public static MdG ChuTi=new MdG();
    public static void init(){
        /*
        *test*
         */


        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s)->{
            t.add(s,MdStyle.Smiley,scl);
            return scl;

        };

    }

}

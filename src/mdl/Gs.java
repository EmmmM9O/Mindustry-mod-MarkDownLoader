package mdl;



public class Gs {
    public static MdG ChuTi=new MdG(),XieTi=new MdG(),TI=new MdG();
    public static void init(){
        /*
        *test*
         */


        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s)->{
            t.add(s,MdStyle.OsBlack,scl);
            return scl;

        };
        XieTi.i="((?![^~])|^)~{1}\\b[^~\\n]+\\b~{1}((?=[^~])|$)";
        XieTi.Run=(t,scl,e,s)->{
            t.add(s,MdStyle.OsRi,scl);
            return scl;

        };
        TI.i="((?![^*])|^)\\*{2}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        TI.Run=(t,scl,e,s)->{
            t.add(s,MdStyle.Smiley,scl);
            return scl;

        };

    }

}

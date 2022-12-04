package mdl;



public class Gs {
    public static MdG Til=new MdG(),ChuTi=new MdG(),XieTi=new MdG(),TI=new MdG();
    public static void init(){
        /*
        *test*
         */
        Til.i="^#+ .+";
        Til.Run=(t,scl,e,s,i)->{
            scl=3f;
            return new pair<>((scl-(i-1)*0.6f),e);
        };
        ChuTi.i="((?![^*])|^)\\*{1}\\b[^*\\n]+\\b\\*{1}((?=[^*])|$)";
        ChuTi.Run=(t,scl,e,s,i)->{
            e.font=MdFonts.OsTh;
            return new pair<>(scl,e);

        };
        XieTi.i="((?![^~])|^)~{1}\\b[^~\\n]+\\b~{1}((?=[^~])|$)";
        XieTi.Run=(t,scl,e,s,i)->{
            e.font=MdFonts.OsRI;
            return new pair<>(scl,e);

        };
        TI.i="((?![^*])|^)\\*{2}\\b[^*\\n]+\\b\\*{2}((?=[^*])|$)";
        TI.Run=(t,scl,e,s,i)->{
            e.font=MdFonts.Smiley;
            return new pair<>(scl,e);

        };

    }

}

package com.wicket.jvm;

/**
*testGC᧤᧥㡈㽤㓶嫛⚝᧨objA✛objB↩ₜ↩嬺GC⛱᧻
*@author zzm
*/
public class ReferenceCountingGC{
    public Object instance=null;
    private static final int _1MB=1024*1024;
/**
*扨₹㒟⛧⻭㊶䤓➾₏㎞⃘⻀㢾◯䍈␔ⷧ᧨ⅴ≎厌⦷GC㡴㉦₼䦚䂔㯩㢾⚵嬺⥭㟅扖
*/
    private byte[]bigSize=new byte[2*_1MB];
    public static void testGC(){
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;
        objA=null;
        objB=null;
        //⋖幍⦷扨嫛♠䞮GC,objA✛objB㢾⚵厌嬺⥭㟅᧻
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
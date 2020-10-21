package com.wicket.jvm;

/**
*㷳ⅲ䪐䆣䯉ℕ₳䍈᧶
*1.⺈廰♾ⅴ⦷嬺GC㢅呹㒠㕾㟠ᇭ
*2.扨䱜呹㟠䤓㧉↩♹㦘₏㶰᧨⥯⃉₏₹⺈廰䤓finalize᧤᧥㡈㽤㦏⮩♹↩嬺侊兮呹┷庒䞷₏㶰
*@author zzm
*/
public class FinalizeEscapeGC{
    public static FinalizeEscapeGC SAVE_HOOK=null;
    public void isAlive(){
        System.out.println("yes,i am still alive");
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize mehtod executed᧝");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }
    public static void main(String[] args) throws Throwable{
        SAVE_HOOK=new FinalizeEscapeGC();
        //⺈廰䶻₏㶰㒟┮㕾㟠呹む
        SAVE_HOOK=null;
        System.gc();
        //⥯⃉finalize㡈㽤↧⏗儶㈗⇝᧨㓏ⅴ㤑⋫0.5䱡ⅴ䷘㈔⸒
        Thread.sleep(500);
        if(SAVE_HOOK==null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead᧶᧤");
        }
        //ₚ槱扨㹄ⅲ䪐₝ₙ槱䤓⸛⏷䦇⚛᧨⇕㢾扨㶰呹㟠☃⯀徴ℕ
        SAVE_HOOK=null;
        System.gc();
        //⥯⃉finalize㡈㽤↧⏗儶㈗⇝᧨㓏ⅴ㤑⋫0.5䱡ⅴ䷘㈔⸒
        Thread.sleep(500);
        if(SAVE_HOOK==null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead᧶᧤");
        }
    }
}
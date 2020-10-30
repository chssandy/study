package com.wicket.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MethodHandleTest
 * @description JSR-292 Method Handle 基础用法演示
 * @date 2020/10/21 17:21
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        /**无论obj最终是哪个实现类，下面这句都能正确调用到println方法
         */
        getPrintlnMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH (Object reveiver) throws Throwable {
        /*MethodType: 代表“方法类型”包含了方法的返回值methodType（）的第一个参数）和具体参数（methodType（）第二个及以后的参数*/
        MethodType mt = MethodType.methodType(void.class, String.class);
        /*lookup᧤᧥㡈㽤㧴呹ℝMethodHandles.lookup᧨扨♴䤓⇫䞷㢾⦷㖖⸩伊₼㩴㔍䶵⚗全⸩䤓㡈㽤⚜䱿ᇬ㡈㽤伊⨚᧨ㄅ₣䶵⚗庒䞷㧒棟䤓㡈㽤♴㩓*/
/*⥯⃉扨摛庒䞷䤓㢾₏₹壩㡈㽤᧨㖘䏶Java幼岏䤓屓⒨᧨㡈㽤䶻₏₹♑㟿㢾椟㆞䤓᧨ⅲ嫷年㡈㽤䤓㘴㟅劔᧨⃮☂㢾this㖖⚠䤓⺈廰᧨扨₹♑㟿ⅴⓜ㢾㟍⦷♑㟿⒦嫷₼扪嫛↯抡䤓᧨力䘿⦷㙟∪ℕbindTo᧤᧥㡈㽤㧴⸛
㒟扨ↅℚ㍔*/
        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }
}

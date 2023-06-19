package com.wicket.lombok;

/**
 * @Copyright: com.wicket
 * @ProjectName: study
 * @Package: com.wicket.lombok
 * @ClassName: Main
 * @Description:
 * @Author: CHS
 * @Date: 2023/6/19 14:42
 */
public class Main {

    public static void main(String[] args) {
        B b = new B();
        C c = new C(new A());
    }
}

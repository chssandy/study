package com.wicket.reference;

import java.lang.ref.WeakReference;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TestWeakReference
 * @description TODO
 * @date 2020/11/18 9:40
 */
public class TestWeakReference {
    public static class User{
        public int id =0;
        public String name = "";
        public User(int id,String name){
            super();
            this.id = id;
            this.name = name;
        }
        @Override
        public String toString(){
            return "User [id="+id+",name="+name+"]";
        }
    }

    public static void main(String[] args) {
        User u = new User(1,"Sandy");
//        User u2 = u;   //强引用 ，gc的时候一定不能回收
//        u = null;
//        System.out.println(u2);
//        System.gc();
//        System.out.println("After GC");
//        System.out.println(u2);

        //软引用,gc的时候，如果空间够则不回收，如果空间不够则回收

        WeakReference<User> userWeak = new WeakReference<>(u);   //弱引用，gc的时候一定回收
        u = null;
        System.out.println(userWeak.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userWeak.get());
    }
}

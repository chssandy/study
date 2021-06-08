package com.wicket.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ClassLoaderTest
 * @description TODO
 * @date 2020/10/15 17:38
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        return defineClass(name, b, 0, b.length);
                    } catch (IOException e) {
                        throw new ClassNotFoundException(name);
                    }
                }
            };
        Object obj = myLoader.loadClass("com.wicket.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.wicket.jvm.ClassLoaderTest);
        Object obj1 = ClassLoader.getSystemClassLoader().loadClass("com.wicket.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj1 instanceof com.wicket.jvm.ClassLoaderTest);
    }
}

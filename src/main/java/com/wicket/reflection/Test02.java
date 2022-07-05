package com.wicket.reflection;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Test02
 * @description 测试class的创建方式有哪几类
 * @date 2022/06/02 10:49
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);
        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println("c1.hashCode() = " + c1.hashCode());
        //方式二：forname获得
        Class c2 = Class.forName("com.wicket.reflection.Student");
        System.out.println("c2.hashCode() = " + c2.hashCode());
        //方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println("c3.hashCode() = " + c3.hashCode());
        //方式四：基本内置类型的包装类都有一个type属性
        Class c4 = Integer.TYPE;
        System.out.println("c4 = " + c4);
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "老师";
    }
}

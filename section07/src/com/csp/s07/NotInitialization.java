package com.csp.s07;

/**
 * 1. 对于静态字段, 只有直接定义这个字段的类才会被初始化. 通过子类来引用父类中定义的静态字段,只会触发父类的初始化.
 *      至于是否触发子类初始化, 虚拟机规范未做明确规定, 要看虚拟机具体实现.
 */
class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

/**
 * 常量在编译阶段会存入调用类的常量池中, 本质上并没有直接引用到定义类的类, 因此不会触发定义常量的类的初始化
 */
class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORD = "hello world";
}

public class NotInitialization {
    public static void main(String[] args) {
        //System.out.println(SuperClass.value);

        SuperClass[] sca = new SuperClass[10]; // 通过数据定义来引用类, 不会触发此类的初始化

        System.out.println(ConstClass.HELLOWORD);
    }
}

/*
SuperClass init!
123

 */

package com.csp.s08;

/**
 * 方法静态分派演示
 *
 * Human 称为变量的静态类型(Static Type)
 * Man 称为变量的实际类型(Actual Type)
 * 静态类型和实际类型在程序中都可以发生一些变化, 区别是静态类型的变化仅仅在使用时发生,
 * 变量本身的静态类型不会被改变, 并且最终的静态类型是在编译期可知的; 而实际类型变化的
 * 结果在运行期才被确定.
 */
public class StaticDispatch {
    static abstract class Human {

    }
    static class Man extends Human {

    }
    static class Woman extends Human {

    }

    public void sayHello(Human guy) {
        System.out.println("hello, guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("hello, gentleman!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}

/*
hello, guy!
hello, guy!

 */
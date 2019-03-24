package com.csp.s08;

/**
 * 方法动态分派显示
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }
    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say hello!");
        }
    }
    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("woman say hello!");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}

/*
man say hello!
woman say hello!
woman say hello!

 */

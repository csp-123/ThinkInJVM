package com.csp.s02;

/**
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try{
            oom.stackLeak();
        }catch (Throwable e) {
            System.out.println("stackLength: " + oom.stackLength);
            throw e;
        }
    }
}

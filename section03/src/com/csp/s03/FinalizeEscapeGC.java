package com.csp.s03;

/**
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救的机会最多只有一次, 因为一个对象的finalize()方法最多只会被系统自动调用一次
 *
 * finalize运行代价高昂, 不确定性大, 无法保证各个对象调用顺序.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低, 所以暂停0.5秒等待
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead");
        }

        // 对象第二次自救失败
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低, 所以暂停0.5秒等待
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead");
        }
    }
}

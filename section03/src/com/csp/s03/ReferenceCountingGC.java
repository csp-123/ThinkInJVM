package com.csp.s03;

/**
 * 测试循环引用后是否会被GC
 * -XX:+PrintGC 输出GC日志
 * -XX:+PrintGCDetails 输出GC的详细日志
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * -Xloggc:../logs/gc.log 日志文件的输出路径
 */
public class ReferenceCountingGC {

    public ReferenceCountingGC reference = null;

    private static final int _1MB = 1024 * 1024;
    // 改成员变量的意义是占点内存, 方便GC日志查看
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.reference = objB;
        objB.reference = objA;

        objA = null;
        objB = null;

        System.gc();
    }

}

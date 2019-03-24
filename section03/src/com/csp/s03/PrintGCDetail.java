package com.csp.s03;

/**
 * VM 参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * java堆大小为20M不可扩展 新生代大小10M
 */
public class PrintGCDetail {
    private static final int _1M = 1024 * 1024;

    public static void testAlloction() {
        byte[] alloction1, alloction2, alloction3, alloction4;
        alloction1 = new byte[2 * _1M];
        alloction2 = new byte[2 * _1M];
        alloction3 = new byte[2 * _1M];
        alloction4 = new byte[2 * _1M]; // 出现一次Minor GC
    }

    public static void main(String[] args) {
        testAlloction();
    }
}

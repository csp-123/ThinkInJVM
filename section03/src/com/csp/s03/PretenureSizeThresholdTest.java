package com.csp.s03;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 * -XX:PretenureSizeThreshold=3145728
 * 大于3M的对象直接进入老年代.
 * 这个参数只对Serial和ParNew两款收集器有效.
 */
public class PretenureSizeThresholdTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; // 直接分配在老年代
    }
}

package com.csp.s02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms30m -Xmx30m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {

        for (String arg : args) {
            System.out.println(arg);
        }
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}

/* output
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid6452.hprof ...
Heap dump file created [28377461 bytes in 0.098 secs]
 */
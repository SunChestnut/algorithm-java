package com.sun;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * TODO
 *
 * @author: syl
 * @date: 2019/8/9 17:33
 **/
public class TryAdd {

    private volatile int i = 0;

    private int returnTest() {
        try {
            i += 1;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i += 1;
        }
        return i;
    }


    public static void main(String[] args) {
        TryAdd test = new TryAdd();
        System.out.println(test.returnTest());
    }

}

package com.example.excel.demo.demo;

import com.example.excel.demo.thread.DealWithProductInfoExcelThread;

/**
 * @apiNote 测试类
 * @author linshanghua
 */
public class TestDemo {

    public static void main(String[] args) {
        DealWithProductInfoExcelThread thread = new DealWithProductInfoExcelThread("");
        thread.run();
    }
}

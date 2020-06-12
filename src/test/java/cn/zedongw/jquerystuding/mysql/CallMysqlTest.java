package cn.zedongw.jquerystuding.mysql;

import org.junit.Test;

import static org.junit.Assert.*;

public class CallMysqlTest {

    CallMysql cm = new CallMysql();

    @Test
    public void callProcedure() {
        cm.callProcedure();
    }

    @Test
    public void callFunction() {
        cm.callFunction();
    }
}
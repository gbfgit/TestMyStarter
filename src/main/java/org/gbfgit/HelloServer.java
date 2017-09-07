package org.gbfgit;


public class HelloServer {
    private String msg;

    public String sayHello(){
        return "hello " + msg;
    }
    public String getMsg() {
        System.out.println("return the msg value...");
        return msg;
    }

    public void setMsg(String msg) {
        System.out.println("init the msg value...");
        this.msg = msg;
    }
}

package jp03.part06;

import java.io.*;

public class UserVO01 implements Serializable{
    private int no;
    private String name;

    public UserVO01(){
    }
    public UserVO01(int no, String name){
        this.no = no;
        this.name = name;
    }

    public void setNo(int no){
        this.no = no;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getNo(){
        return no;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("UserVO [no=");
        builder.append(no);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}

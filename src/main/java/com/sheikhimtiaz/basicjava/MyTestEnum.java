package com.sheikhimtiaz.basicjava;

public enum MyTestEnum {
    ONE(1), TWO(2), THREE(3), four(4);

    private int i;

    MyTestEnum(int i){
        this.i = i;
    }

    public int code(){
        return i;
    }

}

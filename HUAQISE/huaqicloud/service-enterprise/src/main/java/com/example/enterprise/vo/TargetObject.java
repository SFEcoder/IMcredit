package com.example.enterprise.vo;

/**
 * @Author: Owen
 * @Date: 2020/10/28 15:58
 * @Description:
 */
public class TargetObject {

    public TargetObject(Double[] array){
        this.array = array;
    }

    Double[] array;

    public Double[] getArray(){
        return array;
    }
}

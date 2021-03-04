package com.example.enterprise.vo;

import com.example.enterprise.po.Enterprise;

/**
 * @Author: Owen
 * @Date: 2020/10/28 13:33
 * @Description:
 */
public class EnterpriseTarget {

    public EnterpriseTarget(Double[] div, Double[] fin){
        this.div = div;
        this.fin = fin;
    }

    /**
     * 两化数组
     * */
    private Double[] div;

    /**
     * 财务数组
     * */
    private Double[] fin;

    public Double[] getDiv(){
        return div;
    }
    public Double[] getFin(){
        return fin;
    }
}

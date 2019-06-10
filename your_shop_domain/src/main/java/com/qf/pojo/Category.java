package com.qf.pojo;

import lombok.Data;

@Data
public class Category {
    int c_id;
    String c_name;
    String c_core;
    int c_parentid;

    @Override
    public String toString() {
        return "Category{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_core='" + c_core + '\'' +
                ", c_parentid=" + c_parentid +
                '}';
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_core() {
        return c_core;
    }

    public void setC_core(String c_core) {
        this.c_core = c_core;
    }

    public int getC_parentid() {
        return c_parentid;
    }

    public void setC_parentid(int c_parentid) {
        this.c_parentid = c_parentid;
    }

    //
}

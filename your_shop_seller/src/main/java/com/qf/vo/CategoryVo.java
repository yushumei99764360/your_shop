package com.qf.vo;

public class CategoryVo {
    int fatherId;
    String fatherName;
    int childId;
    String childName;

    @Override
    public String toString() {
        return "CategoryVo{" +
                "fatherId=" + fatherId +
                ", fatherName='" + fatherName + '\'' +
                ", childId=" + childId +
                ", childName='" + childName + '\'' +
                '}';
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}

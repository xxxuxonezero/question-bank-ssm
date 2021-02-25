package com.onezero.entity.nowcoder;

import java.util.List;

public class SchoolArea {
    private String area;
    private List<SchoolItem> schools;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<SchoolItem> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolItem> schools) {
        this.schools = schools;
    }
}

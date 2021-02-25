package com.onezero.entity.nowcoder;

import java.util.List;

public class Schools {
    private List<String> regions;
    private List<SchoolArea> schools;

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public List<SchoolArea> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolArea> schools) {
        this.schools = schools;
    }
}

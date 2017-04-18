package sample.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by regga on 16/04/2017.
 */
public abstract class Staff {
    private String idSTaff;
    private String name;
    private String surName;
    private List<Skill> skillList = new ArrayList<Skill>();
    private String contractType;
    private Map<String, String> availabilityDays;

    public String getIdSTaff() {
        return idSTaff;
    }

    public void setIdSTaff(String idSTaff) {
        this.idSTaff = idSTaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Map<String, String> getAvailabilityDays() {
        return availabilityDays;
    }

    public void setAvailabilityDays(Map<String, String> availabilityDays) {
        this.availabilityDays = availabilityDays;
    }
}

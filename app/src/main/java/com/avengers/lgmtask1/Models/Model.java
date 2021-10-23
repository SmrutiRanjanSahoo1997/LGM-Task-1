package com.avengers.lgmtask1.Models;

public class Model {
    public static final String KEY_STATE_CODE="statecode";
    public static final String KEY_DISTRICT_DATA="districtData";
    public static final String KEY_ACTIVE="active";
    public static final String KEY_CONFIRMED="confirmed";
    public static final String KEY_MIGRATED_OTHERS="migratedother";
    public static final String KEY_DECEASED="deceased";
    public static final String KEY_RECOVERED="recovered";
    public static final String KEY_NOTES="notes";
    public static final String KEY_DELTA="delta";


    String stateName;
    String stateCode;
    String districtName;
    String notes;
    int active;
    int confirmed;
    int migratedOther;
    int deceased;
    int recovered;

    public Delta delta;

    public Model() {
        delta= new Delta();
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getMigratedOther() {
        return migratedOther;
    }

    public void setMigratedOther(int migratedOther) {
        this.migratedOther = migratedOther;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public static class Delta{
        int confirmed;
        int deceased;
        int recovered;


        public int getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(int confirmed) {
            this.confirmed = confirmed;
        }

        public int getDeceased() {
            return deceased;
        }

        public void setDeceased(int deceased) {
            this.deceased = deceased;
        }

        public int getRecovered() {
            return recovered;
        }

        public void setRecovered(int recovered) {
            this.recovered = recovered;
        }

    }
}

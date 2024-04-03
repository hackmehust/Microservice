package com.thangnh28.microservices.limitsservice.bean;

public class Limits {
    private int minium;
    private int maxium;

    public Limits() {
    }

    public Limits(int minium, int maxium) {
        this.minium = minium;
        this.maxium = maxium;
    }

    public int getMinium() {
        return minium;
    }

    public void setMinium(int minium) {
        this.minium = minium;
    }

    public int getMaxium() {
        return maxium;
    }

    public void setMaxium(int maxium) {
        this.maxium = maxium;
    }
}

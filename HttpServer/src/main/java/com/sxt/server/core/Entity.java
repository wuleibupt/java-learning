package com.sxt.server.core;

public class Entity {
    private String name;
    private String clz;
    public Entity() {
        // TODO Auto-generated constructor stub
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClz() {
        return clz;
    }
    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", clz='" + clz + '\'' +
                '}';
    }
}

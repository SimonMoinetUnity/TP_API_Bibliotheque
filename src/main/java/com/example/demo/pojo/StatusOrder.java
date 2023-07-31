package com.example.demo.pojo;

public enum StatusOrder {
	
	STATUS1("status1", 1),

    STATUS2("status2", 2),

    STATUS3("status3", 3);

 

    private final String value;

    private final Integer intValue;

 

    private StatusOrder(String value, Integer intValue) {

        this.value = value;

        this.intValue = intValue;

    }

 

    public String getValue() {

        return value;

    }

 

    public int getIntValue() {

        return intValue;

    }

}

package com.jocata.warranty_system.util;

public enum CarType {
    Personal("Personal"),
    Commercial("Commercial"),
    UsedPersonal("Used Personal"),
    UsedCommercial("Used Commercial");

    private final String value;

    CarType(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }

    public static CarType fromString(String value) {
        for (CarType type : CarType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: "+value);
    }


}

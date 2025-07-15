package com.jocata.warranty_system.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CarTypeNameConverter implements AttributeConverter<CarType, String> {

    @Override
    public String convertToDatabaseColumn(CarType attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public CarType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : CarType.fromString(dbData);
    }
}
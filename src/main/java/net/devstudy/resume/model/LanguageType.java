package net.devstudy.resume.model;

import net.devstudy.resume.entity.Language;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

public enum LanguageType {

    ALL,
    SPOKEN,
    WRITING;

    public String getDbValue(){
        return name().toLowerCase();
    }

    public LanguageType getReverseType(){
        if (this==SPOKEN){
            return WRITING;
        }
        else if (this==WRITING){
            return SPOKEN;
        }
        else {
            throw new IllegalArgumentException(this+ "does not have reverse type");
        }
    }


    @Convert
    public static class PersistJPAConverter implements AttributeConverter<LanguageType,String>{
        @Override
        public String convertToDatabaseColumn(LanguageType attribute) {
            return attribute.getDbValue();
        }

        @Override
        public LanguageType convertToEntityAttribute(String dbData) {
            return LanguageType.valueOf(dbData.toUpperCase());
        }
    }


}

package com.rrokullia.pluscomputers.mosque.model.takvimi;

import java.io.IOException;
import java.io.Serializable;

public enum Muaji implements Serializable {
    APRIL, AUGUST, DEZEMBER, FEBRUAR, JANUAR, JULI, JUNI, MAI, MRZ, NOVEMBER, OKTOBER, SEPTEMBER;

    public String toValue() {
        switch (this) {
            case APRIL:
                return "April";
            case AUGUST:
                return "August";
            case DEZEMBER:
                return "Dezember";
            case FEBRUAR:
                return "Februar";
            case JANUAR:
                return "Januar";
            case JULI:
                return "Juli";
            case JUNI:
                return "Juni";
            case MAI:
                return "Mai";
            case MRZ:
                return "M\u00e4rz";
            case NOVEMBER:
                return "November";
            case OKTOBER:
                return "Oktober";
            case SEPTEMBER:
                return "September";
        }
        return null;
    }

    public static Muaji forValue(String value) throws IOException {
        if (value.equals("April")) return APRIL;
        if (value.equals("August")) return AUGUST;
        if (value.equals("Dezember")) return DEZEMBER;
        if (value.equals("Februar")) return FEBRUAR;
        if (value.equals("Januar")) return JANUAR;
        if (value.equals("Juli")) return JULI;
        if (value.equals("Juni")) return JUNI;
        if (value.equals("Mai")) return MAI;
        if (value.equals("M\u00e4rz")) return MRZ;
        if (value.equals("November")) return NOVEMBER;
        if (value.equals("Oktober")) return OKTOBER;
        if (value.equals("September")) return SEPTEMBER;
        throw new IOException("Cannot deserialize Muaji");
    }
}
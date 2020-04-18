package com.rrokullia.pluscomputers.mosque.model.takvimi;

import java.io.IOException;
import java.io.Serializable;

public enum Dita implements Serializable {
    DI, DO, FR, MI, MO, SA, SO;

    public String toValue() {
        switch (this) {
            case DI:
                return "Di";
            case DO:
                return "Do";
            case FR:
                return "Fr";
            case MI:
                return "Mi";
            case MO:
                return "Mo";
            case SA:
                return "Sa";
            case SO:
                return "So";
        }
        return null;
    }

    public static Dita forValue(String value) throws IOException {
        if (value.equals("Di")) return DI;
        if (value.equals("Do")) return DO;
        if (value.equals("Fr")) return FR;
        if (value.equals("Mi")) return MI;
        if (value.equals("Mo")) return MO;
        if (value.equals("Sa")) return SA;
        if (value.equals("So")) return SO;
        throw new IOException("Cannot deserialize Dita");
    }
}
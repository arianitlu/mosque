package com.rrokullia.pluscomputers.mosque.model.takvimi;

import java.util.List;
import java.io.Serializable;

public class Welcome implements Serializable {
    private List<Namazi> namazi;

    public List<Namazi> getNamazi() {
        return namazi;
    }

    public void setNamazi(List<Namazi> value) {
        this.namazi = value;
    }

    @Override
    public String toString() {
        return "Welcome{" +
                "namazi=" + namazi +
                '}';
    }
}

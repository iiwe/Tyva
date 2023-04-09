package com.example.tyva;

import com.yandex.mapkit.geometry.Point;

public class PoIData {

    private String name;
    private Point coords;


    public PoIData(String name, Point coords) {
        this.name = name;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoords() {
        return coords;
    }

    public void setCoords(Point coords) {
        this.coords = coords;
    }
}

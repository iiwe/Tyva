package com.example.tyva;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;


public class PoIData implements Parcelable {
//для добавления подробного описания достопримечательнсти:
    //1) Добавить поле в PoIData
    //2) Сделать ему get и set
    //3) Добавить его в writeToParcel и в createFromParcel
    //4) Модифицировать activity_poi_full - добавить туда текстовое поле для полного описания
    // Сами описания хранить в виде массива String в Map.java - аналогично словарю
    private String name, description;
    private Point coords;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public PoIData(String name, Point coords, int foto) {
        this.name = name;
        this.coords = coords;
        this.foto = foto;
    }
    public PoIData(String name, Point coords, String description){
        this.name = name;
        this.coords = coords;
        this.description = description;
    }

    public PoIData(String name, Point coords, int foto, String description){
        this.name = name;
        this.coords = coords;
        this.foto = foto;
        this.description = description;
    }

    @Override
    public String toString(){
        return "Name = " + name;
    }

    private int foto;
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
    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}
    public Point getCoords() {
        return coords;
    }

    public void setCoords(Point coords) {
        this.coords = coords;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        if (coords != null) {
            parcel.writeDouble(coords.getLatitude());
            parcel.writeDouble(coords.getLongitude());
        }
        parcel.writeInt(foto);
        parcel.writeString(description);
    }
    public static final Creator<PoIData> CREATOR = new Creator<PoIData>() {
        @Override
        public PoIData createFromParcel(Parcel parcel) {
            String name = parcel.readString();
            double x = parcel.readDouble();
            double y = parcel.readDouble();
            int foto = parcel.readInt();
            String descr = parcel.readString();
            return new PoIData(name, new Point(x, y), foto, descr);
        }

        @Override
        public PoIData[] newArray(int i) {
            return new PoIData[i];
        }
    };

}

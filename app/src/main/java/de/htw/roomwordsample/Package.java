package de.htw.roomwordsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "package_table")
public class Package{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "trackingNumber")
    private String trackingNumber;

    public int getColor() {
        return color;
    }

    public boolean getVisibility() {
        return visibility;
    }

    private int color;
    private boolean visibility;
    public Package(@NonNull String trackingNumber, @NonNull int color, @NonNull boolean visibility) {
        this.trackingNumber = trackingNumber;
        this.color = color;
        this.visibility = visibility;
    }

    public String getTrackingNumber(){return this.trackingNumber;}

    public boolean equals(Package p){
        return this.getTrackingNumber().equals(p.getTrackingNumber());
    }
}

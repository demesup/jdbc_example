package org.example.utils;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class Trip {
    private int trip_id;
    private String name;
    private String city;
    private float per_diem;
    private LocalDate date_first;
    private LocalDate date_last;

    public Trip(int trip_id,String name, String city, float per_diem) {
        this.trip_id = trip_id;
        this.name = name;
        this.city = city;
        this.per_diem = per_diem;
    }
}

package br.com.rodrigo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingModel implements Serializable{

    private final Integer id;
    private final String reserveName;
    @JsonSerialize(using = ToStringSerializer.class)
    private final LocalDate checkIn;
    @JsonSerialize(using = ToStringSerializer.class)
    private final LocalDate checkOut;
    private final int numberGuests;

    @JsonCreator
    public BookingModel(@JsonProperty("id") Integer id, @JsonProperty("reserveName")String reserveName, @JsonProperty("checkIn") LocalDate checkIn, @JsonProperty("checkOut") LocalDate checkOut, @JsonProperty("numberGuests")  int numberGuests) {
        this.id = id;
        this.reserveName = reserveName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberGuests = numberGuests;
    }

    public Integer getId() {
        return id;
    }



    public String getReserveName() {
        return reserveName;
    }



    public LocalDate getCheckIn() {
        return checkIn;
    }



    public LocalDate getCheckOut() {
        return checkOut;
    }


    public int getNumberGuests() {
        return numberGuests;
    }
}

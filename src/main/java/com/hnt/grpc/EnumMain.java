package com.hnt.grpc;

import example.enumeration.EnumSimple;
import example.enumeration.EnumSimple.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Enum example");
        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(345);
        builder.setDayOfWeek(EnumSimple.DayOfWeek.MONDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }
}

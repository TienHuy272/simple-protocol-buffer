package com.hnt.grpc;


import example.complex.ComplexMessageOuterClass.DummyMessage;
import example.complex.ComplexMessageOuterClass.ComplexMessage;

import java.util.List;


public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex example");


        ComplexMessage complexMessage = ComplexMessage.newBuilder()
                .setOneDummy(newDummyMessage(10, "messi"))
                .addMultipleDummy(newDummyMessage(7, "ronaldo"))
                .addMultipleDummy(newDummyMessage(11, "neymar"))
                .build();

        System.out.println(complexMessage);
    }

    public static DummyMessage newDummyMessage(Integer id , String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();
        return builder.setName(name).setId(id).build();
    }
}

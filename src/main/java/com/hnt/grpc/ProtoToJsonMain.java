package com.hnt.grpc;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.List;

public class ProtoToJsonMain {
    public static void main(String[] args) {
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        builder.setId(95)
                .setIsSimple(true)
                .setName("Simple Message");

        builder.addAllSampleList(List.of(1,2,3));
        try {
            //proto to JSON
            String jsonString = JsonFormat.printer()
                    .print(builder);
            System.out.println("Proto to JSON--------------- \n" +jsonString);

            //JSON to proto
            Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
            JsonFormat.parser().ignoringUnknownFields()
                    .merge(jsonString, builder2);
            System.out.println("JSON to Proto--------------- \n" +builder2);


        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}

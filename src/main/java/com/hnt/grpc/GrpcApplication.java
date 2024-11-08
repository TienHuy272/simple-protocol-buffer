package com.hnt.grpc;

import example.simple.Simple.SimpleMessage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) {
		System.out.println("App Started !!!");
		SimpleMessage.Builder builder = SimpleMessage.newBuilder();
		builder.setId(95)
				.setIsSimple(true)
				.setName("Simple Message");

		builder.addAllSampleList(List.of(1,2,3));
		System.out.println(builder);
		SimpleMessage simpleMessage = builder.build();

		// write the protocol buffers binary to file
        try {
            FileOutputStream fo = new FileOutputStream("simple_message.bin");
			simpleMessage.writeTo(fo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream("simple_message.bin");
			SimpleMessage messageFromFile = SimpleMessage.parseFrom(fis);
			System.out.println("Message from file : \n" + messageFromFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

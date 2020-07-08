/*
    @Author: Bhaskar S
    @Blog:   https://www.polarsparc.com
    @Date:   04 Jul 2020
*/

package com.polarsparc.protobuf3;

import com.google.protobuf.InvalidProtocolBufferException;

import com.polarsparc.protobuf3.simple.CustomerOuterClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializeCustomerTest {
    public static void main(String[] args) {
        String fname = "/tmp/customer.bin";

        byte[] data = null;
        try {
            data = Files.readAllBytes(Paths.get(fname));
        }
        catch (IOException ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        CustomerOuterClass.Customer customer = null;
        try {
            if (data != null) {
                customer = CustomerOuterClass.Customer.parseFrom(data);
            }
        }
        catch (InvalidProtocolBufferException ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        System.out.printf("Customer deserialized: %s\n", customer);
    }
}

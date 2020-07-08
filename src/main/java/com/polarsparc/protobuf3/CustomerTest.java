/*
    @Author: Bhaskar S
    @Blog:   https://www.polarsparc.com
    @Date:   04 Jul 2020
*/

package com.polarsparc.protobuf3;

import com.google.protobuf.InvalidProtocolBufferException;

import com.polarsparc.protobuf3.simple.CustomerOuterClass.Customer;

public class CustomerTest {
    public static void main(String[] args) {
        Customer.Builder builder = Customer.newBuilder();

        builder.setFirstName("Bugs")
                .setLastName("Bunny")
                .setEmailId("bugs.b@carrot.co")
                .addPhoneNo("100-100-1000")
                .addPhoneNo("100-100-1005");

        Customer customer = builder.build();

        System.out.printf("Customer fields: %s\n", customer.getAllFields());
        System.out.printf("Customer data size: %d\n", customer.getSerializedSize());
        System.out.printf("Customer: %s\n", customer);

        byte[] data = customer.toByteArray();

        Customer customer2 = null;
        try {
            customer2 = Customer.parseFrom(data);
        }
        catch (InvalidProtocolBufferException ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        System.out.printf("Customer deserialized: %s\n", customer2);
    }
}

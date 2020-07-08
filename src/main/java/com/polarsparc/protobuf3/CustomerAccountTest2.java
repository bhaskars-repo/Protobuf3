/*
    @Author: Bhaskar S
    @Blog:   https://www.polarsparc.com
    @Date:   04 Jul 2020
*/

package com.polarsparc.protobuf3;

import com.google.protobuf.InvalidProtocolBufferException;

import com.polarsparc.protobuf3.modular.*;

import java.util.Arrays;

public class CustomerAccountTest2 {
    public static void main(String[] args) {
        PhoneNumber2 phoneNo1 = PhoneNumber2.newBuilder()
                .setNumber("100-100-1000")
                .setType(PhoneType2.PT_MOBILE)
                .build();

        PhoneNumber2 phoneNo2 = PhoneNumber2.newBuilder()
                .setNumber("100-100-1005")
                .setType(PhoneType2.PT_WORK)
                .build();

        Customer2 customer = Customer2.newBuilder()
                .setFirstName("Bugs")
                .setLastName("Bunny")
                .setEmailId("bugs.b@looney.us")
                .addAllPhoneNo(Arrays.asList(phoneNo1, phoneNo2))
                .build();

        Account2 account = Account2.newBuilder()
                .setAcctNo("12345")
                .setAcctType(AccountType2.AT_SAVINGS)
                .setCustomer(customer)
                .build();

        System.out.printf("Account fields: %s\n", account.getAllFields());
        System.out.printf("Account data size: %d\n", account.getSerializedSize());
        System.out.printf("Account: %s\n", account);

        byte[] data = account.toByteArray();

        Account2 account2 = null;
        try {
            account2 = Account2.parseFrom(data);
        }
        catch (InvalidProtocolBufferException ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        System.out.printf("Account deserialized: %s\n", account2);
    }
}

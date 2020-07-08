/*
    @Author: Bhaskar S
    @Blog:   https://www.polarsparc.com
    @Date:   04 Jul 2020
*/

package com.polarsparc.protobuf3;

import com.google.protobuf.InvalidProtocolBufferException;

import com.polarsparc.protobuf3.complex.CustomerAccount.Account;
import com.polarsparc.protobuf3.complex.CustomerAccount.AccountType;
import com.polarsparc.protobuf3.complex.CustomerAccount.Customer;

public class CustomerAccountTest {
    public static void main(String[] args) {
        Customer customer = Customer.newBuilder()
                .setFirstName("Bugs")
                .setLastName("Bunny")
                .setEmailId("bugs.b@carrot.co")
                .addPhoneNo("100-100-1000")
                .addPhoneNo("100-100-1005")
                .build();

        Account account = Account.newBuilder()
                .setAcctNo("12345")
                .setAcctType(AccountType.CA_BROKERAGE)
                .setCustomer(customer)
                .build();

        System.out.printf("Account fields: %s\n", account.getAllFields());
        System.out.printf("Account data size: %d\n", account.getSerializedSize());
        System.out.printf("Account: %s\n", account);

        byte[] data = account.toByteArray();

        Account account2 = null;
        try {
            account2 = Account.parseFrom(data);
        }
        catch (InvalidProtocolBufferException ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        System.out.printf("Account deserialized: %s\n", account2);
    }
}

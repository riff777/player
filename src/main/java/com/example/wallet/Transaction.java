package com.example.wallet;

import lombok.Data;

@Data
public class Transaction {
    String username;
    Integer transaction_id;
    Double balance_change;
}
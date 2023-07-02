package com.example.klarna;

public class Transaction {
    private String email;
    private String Id;
    private int amount;
    private boolean status;

    public Transaction(){}
    public Transaction(String email, String id, int amount) {
        this.email = email;
        Id = id;
        this.amount = amount;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return Id;
    }
    public int getAmount() {
        return amount;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}

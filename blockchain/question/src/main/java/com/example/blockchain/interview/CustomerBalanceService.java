package com.example.blockchain.interview;

import java.util.HashMap;
import java.util.Map;

enum Token {
    USD, EUR, BTC, ETH;
}

/**
 * Message/Event received from the upstream LedgerService,
 * for any change in the balance of any token for any customer
 * Balance Increases if getChange() > 0
 * Balance Decreases if getChange() < 0
 */
interface LedgerServiceUpdate {
    long getCustomerId();
    Token getToken();
    double getChange();
}

/**
 * A callback provided to the LedgerService; LedgerService call this to notify CustomerBalanceService
 * whenever there is a change in the balance of a customer for any token
 *
 * TODO implement this
 */
interface LedgerServiceUpdateCallback {
    // Ledger call this method whenever it need to notify CustomerBalanceService
    void onBalanceUpdate(LedgerServiceUpdate update);
}

/**
 * Service to subscribe for updates in the balances of all customers
 * (provided)
 */
interface LedgerService {
    void subscribe(LedgerServiceUpdateCallback callback);
}

/**
 * A callback provided to the CustomerBalanceService, to be called
 * whenever there is a change in the balance of a token for the subscribed customer
 */
interface CustomerBalanceUpdateCallback {
    // Call this method to notify a specific customer
    void onBalanceUpdate(CustomerBalanceUpdate update);
}

/**
 * Message/Event sent to the downstream customer balance subscription, whenever
 * the balance for a token for that customer changes
 */
class CustomerBalanceUpdate {

    private final Token token;
    private double balance;
    private double change;

    public CustomerBalanceUpdate(Token token, double balance, double change) {
        this.token = token;
        this.balance = balance;
        this.change = change;
    }

    public Token getToken() {
        return token;
    }

    public double getBalance() {
        return balance;
    }

    public double getChange() {
        return change;
    }
}

/**
 * A Service used by customers to get notifications of changes
 * to their own specific balances, for each {@link Token}
 * (implement)
 */


   
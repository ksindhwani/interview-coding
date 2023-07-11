package com.example.blockchain.interview;

/**
 *The idea of this coding challenge, is to implement CustomerBalanceService and it must be able to:
- subscribe to upstream balance change notifications from the LedgerService
- keep an accumulated running balance for each customer
- accept subsription from multiple instances of the Customer service
- send downstream balance update notifications to subscribed customers.
Steps:
1. Subscribe to balance changes for all customers by providing a LedgerServiceUpdateCallback
   to the LedgerService instance received on the constructor.
2. Update internal data-structure to hold balances for each customer when the
   LedgerServiceUpdateCallback::onBalanceUpdate method is called.
3. If that customer has a registered callback provided via the CustomerBalanceService::subscribe
   method, call the CustomerBalanceUpdateCallback::onBalanceUpdate method with an instance of
   CustomerBalanceUpdate.
Instructions:
- Assume that the LedgerService and Customer interfaces will be implemented by someone else;
- these services communicates via callbacks for simplicity.
- Your implementaion Has to be thread-safe, memory efficient, GC friendly and cpu friendly. 
- Use the language you prefer, you can read documentation
- Starting balance of a user is 0
- share your screen while coding, and share your code at the end.
- If you want to change the API contracts discuss it with your interviewer
- Send your code to the interviewer at the end of the interview.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

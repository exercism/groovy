class BankAccount {
    boolean isOpen=false;
    int balance=0;

    // You cannot do any operations before you open the account.
    // An account opens with a balance of 0
    // You can reopen an account
    synchronized void open(){         
        isOpen=true;
        balance=0;
    } 

    // you cannot do any operations after you close the account
    synchronized void close() { 
        checkOpen();
        balance=0;
        isOpen=false;
    }

    // this should increment the balance
    // you cannot deposit into a closed account
    // you cannot deposit a negative amount 
    synchronized void deposit(int amount) {
        checkOpen();
        if(amount<=0)
            throw new Exception("Amount must be greater than 0")
        balance+=amount;        
    }

    synchronized void withdraw(int amount) {
        checkOpen();
        if(amount<=0)
            throw new Exception("Amount must be greater than 0")
        if(amount>balance)
            throw new Exception("You cannot withdraw more than your balance")
        balance -= amount;
    }
    synchronized int getBalance(){
        checkOpen();
        return balance
    }

    void checkOpen() {
        if(!isOpen)
            throw new Exception("Account must be open")
    }
}
@Grab('org.spockframework:spock-core:1.0-groovy-2.4')

import spock.lang.Specification

class TwoFerSpec extends Specification {

    def newlyOpenedAccountHasEmptyBalance() {
        setup:
            BankAccount account=new BankAccount()

        when:
            account.open()

        then:
            account.getBalance()==0
    }
    
    def canDepositMoney() {
        setup:
            BankAccount account=new BankAccount()

        when:
            account.open()
            account.deposit(10)
        then:
            account.getBalance()==10
    }

    def canDepositMoneySequentially()  {
        setup:
            BankAccount bankAccount=new BankAccount()

        when:
            bankAccount.open();

            bankAccount.deposit(5);
            bankAccount.deposit(23);

        then:
            bankAccount.getBalance()==28;
    }

     def canWithdrawMoney() {
        setup:
            BankAccount bankAccount=new BankAccount()

        when:         
            bankAccount.open();
            bankAccount.deposit(10);

            bankAccount.withdraw(5);

        then:
            bankAccount.getBalance() == 5;
    }

    public void canWithdrawMoneySequentially()  {
        setup:
            BankAccount bankAccount=new BankAccount()

        when:         
            bankAccount.open();
            bankAccount.deposit(23);

            bankAccount.withdraw(10);
            bankAccount.withdraw(13);

        then:
            bankAccount.getBalance() == 0;
    }

    def cannotWithdrawMoneyFromEmptyAccount() {
        setup:
            BankAccount bankAccount=new BankAccount()

        when:         
            bankAccount.withdraw(5);
        then:
            thrown(BankAccountInvalidActionException)    
    }

    def cannotWithdrawMoreMoneyThanYouHave() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(6);
            bankAccount.withdraw(7);
        then:
            thrown(BankAccountInvalidActionException)           
    }

    def cannotDepositNegativeAmount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(-1);

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def cannotWithdrawNegativeAmount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(105);
            bankAccount.withdraw(-5);

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def cannotGetBalanceOfClosedAccount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(10);
            bankAccount.close();
            bankAccount.getBalance();

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def cannotDepositMoneyIntoClosedAccount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.close();
            bankAccount.deposit(5);

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def cannotWithdrawMoneyFromClosedAccount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(20);
            bankAccount.close();
            bankAccount.withdraw(5);

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def bankAccountIsClosedBeforeItIsOpened() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.getBalance();

        then:
            thrown(BankAccountInvalidActionException)                   
    }

    def canAdjustBalanceConcurrently() {
        setup:
            BankAccount bankAccount=new BankAccount();
        when:
            bankAccount.open();
            bankAccount.deposit(1000);
            for (int i = 0; i < 10; i++) {
                adjustBalanceConcurrently(bankAccount);
            }
        
        then:
            bankAccount.getBalance() == 1000
    }

    void adjustBalanceConcurrently(BankAccount bankAccount) {
        Random random = new Random();

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(
                { 
                        try {
                            bankAccount.deposit(5);
                            Thread.sleep(random.nextInt(10));
                            bankAccount.withdraw(5);
                        } catch (BankAccountInvalidActionException e) {
                            fail("Exception should not be thrown: " + e.getMessage());
                        } catch (InterruptedException ignored) {
                        }
                }
            );
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
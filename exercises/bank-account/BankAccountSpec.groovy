@Grab('org.spockframework:spock-core:1.0-groovy-2.4')

import spock.lang.Specification

class BankAccountSpec extends Specification {

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
            thrown(Exception)    
    }

    def cannotWithdrawMoreMoneyThanYouHave() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(6);
            bankAccount.withdraw(7);
        then:
            thrown(Exception)           
    }

    def cannotDepositNegativeAmount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(-1);

        then:
            thrown(Exception)                   
    }

    def cannotWithdrawNegativeAmount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.deposit(105);
            bankAccount.withdraw(-5);

        then:
            thrown(Exception)                   
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
            thrown(Exception)                   
    }

    def cannotDepositMoneyIntoClosedAccount() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.open();
            bankAccount.close();
            bankAccount.deposit(5);

        then:
            thrown(Exception)                   
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
            thrown(Exception)                   
    }

    def bankAccountIsClosedBeforeItIsOpened() {
        setup:
            BankAccount bankAccount=new BankAccount()
        when:
            bankAccount.getBalance();

        then:
            thrown(Exception)                   
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

        List<Thread> threads = new ArrayList<Thread>();
        (1..1000).each {
            threads.add( new Thread(
                { 
                        try {
                            bankAccount.deposit(5);
                            Thread.sleep(random.nextInt(10));
                            bankAccount.withdraw(5);
                        } catch (InterruptedException ignored) {
                        } catch (Exception e) {
                            fail("Exception should not be thrown: " + e.getMessage());
                        } 
                }
            ));
        }
        threads.each { it.start() }

        threads.each { it.join() }
    }
}
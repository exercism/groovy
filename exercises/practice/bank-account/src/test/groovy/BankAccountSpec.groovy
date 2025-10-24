import spock.lang.*

class BankAccountSpec extends Specification {

    def "Newly opened account has zero balance"() {
        setup:
        BankAccount account = new BankAccount()

        when:
        account.open()

        then:
        account.getBalance() == 0
    }

    @Ignore
    def "Single deposit"() {
        setup:
        BankAccount account = new BankAccount()

        when:
        account.open()
        account.deposit(100)

        then:
        account.getBalance() == 100
    }

    @Ignore
    def "Multiple deposit"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(100)
        bankAccount.deposit(50)

        then:
        bankAccount.getBalance() == 150
    }

    @Ignore
    def "Withdraw once"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(100)
        bankAccount.withdraw(75)

        then:
        bankAccount.getBalance() == 25
    }

    @Ignore
    def "Withdraw twice"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(100)
        bankAccount.withdraw(80)
        bankAccount.withdraw(20)

        then:
        bankAccount.getBalance() == 0
    }

    @Ignore
    def "Can do multiple operations sequentially"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(100)
        bankAccount.deposit(110)
        bankAccount.withdraw(200)
        bankAccount.deposit(60)
        bankAccount.withdraw(50)

        then:
        bankAccount.getBalance() == 20
    }

    @Ignore
    def "Cannot check balance of closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.close()
        bankAccount.getBalance()

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot deposit into closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.close()
        bankAccount.deposit(50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot deposit into unopened account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.deposit(50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot withdraw from closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.close()
        bankAccount.withdraw(50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot close an account that was not opened"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.close()

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot open an already opened account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.open()

        then:
        thrown(Exception)
    }

    @Ignore
    def "Reopened account does not retain balance"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(50)
        bankAccount.close()
        bankAccount.open()

        then:
        bankAccount.getBalance() == 0
    }

    @Ignore
    def "Cannot withdraw more than deposited"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(25)
        bankAccount.withdraw(50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot withdraw negative"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(100)
        bankAccount.withdraw(-50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot deposit negative"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(-50)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Can handle concurrent transactions"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(1000)
        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently(bankAccount)
        }

        then:
        bankAccount.getBalance() == 1000
    }

    void adjustBalanceConcurrently(BankAccount bankAccount) {
        Random random = new Random()

        List<Thread> threads = new ArrayList<Thread>()
        (1..1000).each {
            threads.add(new Thread(
                    {
                        try {
                            bankAccount.deposit(5)
                            Thread.sleep(random.nextInt(10))
                            bankAccount.withdraw(5)
                        } catch (InterruptedException ignored) {
                        } catch (Exception e) {
                            fail("Exception should not be thrown: ${e.getMessage()}")
                        }
                    }
            ))
        }
        threads.each { it.start() }

        threads.each { it.join() }
    }
}

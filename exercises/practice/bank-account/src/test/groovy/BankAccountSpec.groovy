import spock.lang.*

class BankAccountSpec extends Specification {

    def "Newly opened account has empty balance"() {
        setup:
        BankAccount account = new BankAccount()

        when:
        account.open()

        then:
        account.getBalance() == 0
    }

    @Ignore
    def "Can deposit money"() {
        setup:
        BankAccount account = new BankAccount()

        when:
        account.open()
        account.deposit(10)

        then:
        account.getBalance() == 10
    }

    @Ignore
    def "Can deposit money sequentially"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(5)
        bankAccount.deposit(23)

        then:
        bankAccount.getBalance() == 28
    }

    @Ignore
    def "Can withdraw money"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(10)
        bankAccount.withdraw(5)

        then:
        bankAccount.getBalance() == 5
    }

    @Ignore
    def "Can withdraw money sequentially"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(23)
        bankAccount.withdraw(10)
        bankAccount.withdraw(13)

        then:
        bankAccount.getBalance() == 0
    }

    @Ignore
    def "Cannot withdraw money from empty account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.withdraw(5)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot withdraw more money than you have"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(6)
        bankAccount.withdraw(7)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot deposit negative amount"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(-1)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot withdraw negative amount"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(105)
        bankAccount.withdraw(-5)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot get balance of closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(10)
        bankAccount.close()
        bankAccount.getBalance()

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot deposit money into closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.close()
        bankAccount.deposit(5)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Cannot withdraw money from closed account"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.open()
        bankAccount.deposit(20)
        bankAccount.close()
        bankAccount.withdraw(5)

        then:
        thrown(Exception)
    }

    @Ignore
    def "Bank account is closed before it is opened"() {
        setup:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.getBalance()

        then:
        thrown(Exception)
    }

    @Ignore
    def "Can adjust balance concurrently"() {
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
import spock.lang.*

class CommandLineInterfaceSpec extends Specification {
    def "Can get help on CLI usage, using short notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'-h'})

        expect:
        options.help() == true
    }

    def "Can get help on CLI usage, using long notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'--help'})

        expect:
        options.help() == true
    }

    def "Can set path to canonical-data.json file, using short notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'-i', 'C:\\Users\\Foo\\canonical-data.json'})

        expect:
        options.canonical_data() == 'C:\\Users\\Foo\\canonical-data.json'
    }

    def "Can set path to canonical-data.json file, using long notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'--canonical-data=C:\\Users\\Foo\\canonical-data.json'})

        expect:
        options.canonical_data() == 'C:\\Users\\Foo\\canonical-data.json'
    }

    def "Can set repository directory, using short notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'-d', 'C:\\Users\\Foo\\Groovy'})

        expect:
        options.repository_directory() == 'C:\\Users\\Foo\\Groovy'
    }

    def "Can set repository directory, using long notation."() {
        given:
        ICommandLineInterface options = new CommandLineInterface().parse(new String[]{'--repository-directory=C:\\Users\\Foo\\Groovy'})

        expect:
        options.repository_directory() == 'C:\\Users\\Foo\\Groovy'
    }
}

import groovy.cli.picocli.CliBuilder

class CommandLineInterface {
    CliBuilder builder

    CommandLineInterface() {
        this.builder = new CliBuilder()
    }

    ICommandLineInterface parse(String[] args) {
        this.builder.parseFromSpec(ICommandLineInterface, args)
    }

    void showUsage() {
        this.builder.usage()
    }
}
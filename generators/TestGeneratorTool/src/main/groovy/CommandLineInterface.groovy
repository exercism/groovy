import groovy.cli.picocli.CliBuilder

class CommandLineInterface {
    CliBuilder builder

    CommandLineInterface() {
        builder = new CliBuilder()
    }

    ICommandLineInterface parse(String[] args) {
        builder.parseFromSpec ICommandLineInterface, args
    }

    void showUsage() {
        builder.usage()
    }
}
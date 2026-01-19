import groovy.cli.picocli.CliBuilder

/**
 * Command-line arguments parser.
 */
class CommandLineInterface {
    CliBuilder builder

    /**
     * Initialize command-line arguments parser.
     */
    CommandLineInterface() {
        builder = new CliBuilder()
    }

    /**
     * Parse command-line arguments.
     * @param args An array of command-line arguments to parse.
     * @return Parsed arguments.
     */
    ICommandLineInterface parse(String[] args) {
        builder.parseFromSpec ICommandLineInterface, args
    }

    /**
     * Show program usage.
     */
    void showUsage() {
        builder.usage()
    }
}
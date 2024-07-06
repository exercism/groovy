static void main(String[] args) {
    CommandLineInterface commandLineInterface = new CommandLineInterface()
    ICommandLineInterface options = commandLineInterface.parse args

    if (options.help()) {
        commandLineInterface.showUsage()
        return
    }

    String canonical_data = options.canonical_data()
    if (canonical_data == null) {
        println 'Path to canonical-data.json not set.'
        return
    }

    String repository_directory = options.repository_directory()
    if (repository_directory == null) {
        println 'Path to repository directory not set.'
        return
    }

    println 'Success!'
}

import groovy.cli.Option

/**
 * Command-line interface.
 */
interface ICommandLineInterface {
    @Option(shortName = 'h', description = 'Display usage.')
    Boolean help()

    @Option(shortName = 'i', longName = 'canonical-data', description = 'Set path to canonical-data.json file.')
    String canonical_data()

    @Option(shortName = 'd', longName = 'repository-directory', description = 'Set path to repository directory.')
    String repository_directory()
}
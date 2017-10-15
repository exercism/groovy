import java.nio.file.Files
import java.nio.file.Paths

final String MAIN_BUILD_DIR = args[0]

def exerciseDir = new File("${MAIN_BUILD_DIR}${File.separator}exercises")

Map<String, String> exercises = new HashMap<>()


exerciseDir.eachDir {
    exercises.put(this.toCamelCase(it.name), it.path)
}

exercises.each {k, v ->
    println("Creating build for exercise '$k' in '$v' directory")
    this.prepareExerciseSubProjectBuild(k, v, MAIN_BUILD_DIR)
}

void prepareExerciseSubProjectBuild(String exerciseName, String pathToExerciseDirectory, String mainBuildDir) {
    String sep = File.separator
    String srcDirRelative = "${sep}src${sep}main${sep}groovy"
    String testDirRelative = "${sep}src${sep}test${sep}groovy"

    // 1. Create src/main/groovy directory
    new File(pathToExerciseDirectory + srcDirRelative).mkdirs()
    // 2. Create src/test/groovy directory
    new File(pathToExerciseDirectory + testDirRelative).mkdirs()
    // 3. Copy Example solution to src/main/groovy
    Files.copy(
            Paths.get("${pathToExerciseDirectory}${sep}Example.groovy"),
            Paths.get("${pathToExerciseDirectory}${srcDirRelative}${sep}${exerciseName}.groovy")
    )
    // 4. Copy Spec file to src/test/groovy
    Files.copy(
            Paths.get("${pathToExerciseDirectory}${sep}${exerciseName}Spec.groovy"),
            Paths.get("${pathToExerciseDirectory}${testDirRelative}${sep}${exerciseName}Spec.groovy")
    )
    // 5. Remove unwanted statements from Spec
    String pathToSpec = "${pathToExerciseDirectory}${testDirRelative}${sep}${exerciseName}Spec.groovy"
    new File(pathToSpec).text = new File(pathToSpec).text.replaceAll(/@Grab.*/,'').replace('@Ignore', '')
    // 6. Create empty 'build.gradle'
    new File("${pathToExerciseDirectory}${sep}build.gradle").createNewFile()
    // 7. Add exercise build to settings.gradle in main build
    new File("${mainBuildDir}${sep}settings.gradle")
            .append("include 'exercises/${this.toKebabCase(exerciseName)}'\n")
}


String toCamelCase(String str) {
    return str.tokenize('-')*.toLowerCase()*.capitalize().join('')
}

String toKebabCase(String str) {
    result = ''
    str.each {
        if (( it == it.toUpperCase() && str[0] != it )) {
            result += '-'
        }
        result += it.toLowerCase()
    }
    return result
}


// Tests
void testToCamelCase() {
    assert this.toCamelCase('nth-prime') == 'NthPrime'
    assert this.toCamelCase('difference-of-squares') == 'DifferenceOfSquares'
    assert this.toCamelCase('grains') == 'Grains'
}

void testToKebabCase() {
    assert this.toKebabCase('NthPrime') == 'nth-prime'
    assert this.toKebabCase('DifferenceOfSquares') == 'difference-of-squares'
    assert this.toKebabCase('Grains') == 'grains'
}
import spock.lang.*

class DndCharacterSpec extends Specification {
    // ability modifier
    def "ability modifier for score 3 is -4"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(3) == -4
    }

    @Ignore
    def "ability modifier for score 4 is -3"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(4) == -3
    }

    @Ignore
    def "ability modifier for score 5 is -3"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(5) == -3
    }

    @Ignore
    def "ability modifier for score 6 is -2"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(6) == -2
    }

    @Ignore
    def "ability modifier for score 7 is -2"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(7) == -2
    }

    @Ignore
    def "ability modifier for score 8 is -1"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(8) == -1
    }

    @Ignore
    def "ability modifier for score 9 is -1"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(9) == -1
    }

    @Ignore
    def "ability modifier for score 10 is 0"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(10) == 0
    }

    @Ignore
    def "ability modifier for score 11 is 0"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(11) == 0
    }

    @Ignore
    def "ability modifier for score 12 is +1"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(12) == 1
    }

    @Ignore
    def "ability modifier for score 13 is +1"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(13) == 1
    }

    @Ignore
    def "ability modifier for score 14 is +2"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(14) == 2
    }

    @Ignore
    def "ability modifier for score 15 is +2"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(15) == 2
    }

    @Ignore
    def "ability modifier for score 16 is +3"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(16) == 3
    }

    @Ignore
    def "ability modifier for score 17 is +3"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(17) == 3
    }

    @Ignore
    def "ability modifier for score 18 is +4"() {
        given:
        def character = new DndCharacter()

        expect:
        character.modifier(18) == 4
    }

    // random ability values
    void inRange(value) {
        assert value >= 3
        assert value <= 18
    }

    @Ignore
    def "random ability is within range"() {
        given:
        def character = new DndCharacter()
        def a = character.ability()

        expect:
        inRange(a)
    }

    @Ignore
    def "random character is valid"() {
        given:
        def character = new DndCharacter()

        expect:
        inRange(character.strength)
        inRange(character.dexterity)
        inRange(character.constitution)
        inRange(character.intelligence)
        inRange(character.wisdom)
        inRange(character.charisma)
        character.hitpoints == 10 + character.modifier(character.constitution)
    }

    @Ignore
    def "each ability is only calculated once"() {
        given:
        def character = new DndCharacter()
        def strength = character.strength
        def strengthAgain = character.strength

        expect:
        strength == strengthAgain
    }
}

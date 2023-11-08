import java.util.Random

class DndCharacter {
    private final characteristics
    private final rand

    DndCharacter() {
        this.rand = new Random()
        this.characteristics = [:]
        for (c in ['strength', 'dexterity', 'constitution', 'intelligence', 'wisdom', 'charisma']) {
            this.characteristics.put(c, ability())
        }
        this.characteristics.put('hitpoints', 10 + modifier(this.constitution))
    }

    // pseudo-property read-only access
    def getProperty(String property) { characteristics.get(property) }

    // roll four 6-sided dice, sum the three largest
    def ability() {
        def sum = 0
        def min = 6
        for (int i = 1; i <= 4; i++) {
            def d = this.rand.nextInt(6) + 1
            sum += d
            min = Math.min(min, d)
        }
        return sum - min
    }

    def modifier(Integer val) { Math.floor((val - 10) / 2) }
}

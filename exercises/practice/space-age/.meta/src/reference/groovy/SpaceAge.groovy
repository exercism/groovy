class SpaceAge {

    private final static TIMES = [
            "Earth"  : 31557600,
            "Mercury": 7600543.81,
            "Venus"  : 19411026.17,
            "Mars"   : 59359776.78,
            "Jupiter": 374222565.14,
            "Saturn" : 928792569.65,
            "Uranus" : 2652994591.73,
            "Neptune": 5196280668.35
    ]

    static double age(String planet, int seconds) {
        (seconds / TIMES[planet]).round(2)
    }
}
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {

    static add(LocalDate date) {
        date.atTime(0, 0).plusSeconds(10**9)
    }

    static add(LocalDateTime date) {
        date.plusSeconds(10**9)
    }

}

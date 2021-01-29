import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {

    static final Integer GIGASECOND = 1_000_000_000

    static add(LocalDate date) {
        add(date.atStartOfDay())
    }

    static add(LocalDateTime date) {
        date.plusSeconds(GIGASECOND)
    }

}

import groovy.time.TimeCategory

class Gigasecond {

    static Date from(Date date) {
        use ( TimeCategory ) { date + (10**9).seconds }
    }

}

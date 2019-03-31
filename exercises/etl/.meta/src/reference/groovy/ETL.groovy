class ETL {

    static transform(Map<String, List<String>> input) {
        input.inject([:]) { map, id, values ->
            values.forEach { map.put(it.toLowerCase(), id as int) }
            return map
        }
    }
}
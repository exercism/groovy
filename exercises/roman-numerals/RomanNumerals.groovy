class RomanNumerals {
  def RomanNumerals() {
    Integer.metaClass.getRoman = {->
        // RETURN the roman representation of an Integer here
    }
  }
}

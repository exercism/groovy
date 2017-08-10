class Roman {
  def Roman() {
    Integer.metaClass.getRoman = {->
        // RETURN the roman representation of an Integer here
    }
  }
}

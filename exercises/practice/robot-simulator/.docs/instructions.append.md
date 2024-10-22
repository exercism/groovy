# ignore

## Properties and fields in Groovy

In this exercise, you might have noticed that the stub defines getters, like `getX()`, but the tests access the value directly as `.x`. This is due to how Groovy defines properties. Let’s break it down:

- A **field** is a member of a class, interface, or trait used to **store data**.
- A **property** is an **externally visible** feature of a class.

Key Points about Groovy Properties:
- Groovy automatically generates getters and setters for non-private fields (or only a getter if the field is marked as `final`).
- Properties can be accessed by name (as in this exercise's test) and will call the getter or setter transparently.
- By convention, Groovy will recognize properties even if there is no backing field, provided there are getters or setters.

In this exercise, we’ve only specified the required getters (and hence properties as per above) to enforce proper implementation. You're free to decide which fields (and their types) are most suitable for your solution.

If you want to explore the topic of fields and properties further, please refer to [Chapter 3.3. Fields and Properties](https://www.groovy-lang.org/objectorientation.html#_fields_and_properties) in the Groovy documentation.
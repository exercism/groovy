@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class TriangleSpec extends Specification {

    def 'returns true if the triangle is equilateral'() {
        expect: 'true if all sides are equal'
        Triangle.isEquilateral(2, 2, 2)

        and: 'false if any side is unequal'
        !Triangle.isEquilateral(2, 3, 2)

        and: 'false if no sides are equal'
        !Triangle.isEquilateral(5, 4, 6)
        
        and: 'all zero sides are illegal, so the triangle is not equilateral' 
        !Triangle.isEquilateral(0, 0, 0)
    } 

    def 'returns true if the triangle is isosceles'() {
        expect: 'true if last two sides are equal'
        Triangle.isIsosceles(3, 4, 4)

        and: 'true if first two sides are equal'
        Triangle.isIsosceles(4, 4, 3)

        and: 'true if first and last sides are equal'
        Triangle.isIsosceles(4, 3, 4)

        and: 'equilateral triangles are also isosceles'
        Triangle.isIsosceles(4, 4, 4)

        and: 'false if no sides are equal'
        !Triangle.isIsosceles(2, 3, 4)

        and: 'sides that violate triangle inequality are not isosceles, even if two sides are equal'
        !Triangle.isIsosceles(1, 1, 3)
    }

    def 'returns true if the triangle is scalene'() {
        expect: 'true if no sides are equal'
        Triangle.isScalene(5, 4, 6)

        and: 'false if all sides are equal'
        !Triangle.isScalene(4, 4, 4)

        and: 'false if two sides are equal'
        !Triangle.isScalene(4, 4, 3)

        and: 'sides that violate triangle inequality are not scalene, even if they are all different'
        !Triangle.isScalene(7, 3, 2)
    }

    @Ignore
    def 'sides may be non-integral'() {
        expect: 'equilateral triangle sides may be non-integral'
        Triangle.isEquilateral(0.5, 0.5, 0.5)

        and: 'isosceles triangle sides may be non-integral'
        Triangle.isIsosceles(0.5, 0.4, 0.5)

        and: 'scalene triangle sides may be non-integral'
        Triangle.isScalene(0.5, 0.4, 0.6)
    }

}

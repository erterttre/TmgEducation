package Lesson06;

import java.lang.annotation.Annotation;

public class PlanetMassCalculator{

    public void calk (PlanetData planetData){
        double v = 3.14*planetData.radius;
        Annotation annotation = PlanetData.class.getAnnotation(Planet.class);
        Planet p = (Planet) annotation;
        double m = v*p.density();
        System.out.println("Earth mass="+m);
    }
}

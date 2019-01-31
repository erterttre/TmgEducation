package Lesson06;

@Planet(name = "Earth",density = 5.51)
public class PlanetData {
    double radius=6371;
    /*
    Class aClass = PlanetData.class;
        Annotation[] annotation = aClass.getAnnotations();
        for (Annotation annotation1:annotation) {
            if(annotation1 instanceof Planet) {
                Planet field = (Planet) annotation1;
                System.out.println("name: " + field.name());
                System.out.println("density: " + field.density());
            }
        }
     */
}

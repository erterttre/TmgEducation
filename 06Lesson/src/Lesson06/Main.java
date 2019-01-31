package Lesson06;

public class Main {
    public static void main(String[] args){
        PlanetData planetData = new PlanetData();
        PlanetMassCalculator planetMassCalculator = new PlanetMassCalculator();
        planetMassCalculator.calk(planetData);
    }
}

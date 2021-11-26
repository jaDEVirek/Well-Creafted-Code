package immutability;

import java.util.HashMap;
import java.util.Objects;

public class FlyweightPattern {

    private static final HashMap<String, Circle> circleMap = new HashMap();

    public static void main(String[] args) {
    }

    //FLyweight pattern using  null pointer
    public static Shape getCircle(String color){
        if (!circleMap.containsKey(color)) {
            circleMap.put(color, new Circle(color));
            System.out.println("Creating circle of color : " + color);
        }
        return circleMap.get(color);
    }

    public static Shape getCircleUsingCompose(String color) {
        return circleMap.computeIfAbsent(color, col-> {
            return new Circle(color);
        });

    }
}


class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}

interface Shape {
    void draw();
}

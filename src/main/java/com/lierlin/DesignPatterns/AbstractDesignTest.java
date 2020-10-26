package com.lierlin.DesignPatterns;


import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class AbstractDesignTest {
    public static void main(String[] args) {
        AbstractDesign abstractDesign = FactoryProducer.getAbstractDesign("Color");
        Color color1 = abstractDesign.getColor("Red");
        color1.draw();
    }

}

interface Color {
    void draw();
}

interface Shape {
    void shape();
}

@Slf4j
class Circle implements Shape {
    @Override
    public void shape() {
        log.debug("this is a Circle");
    }
}

@Slf4j
class Rectangle implements Shape {
    @Override
    public void shape() {
        log.debug("this is a Rectangle");
    }
}

@Slf4j
class Square implements Shape {
    @Override
    public void shape() {
        log.debug("this is a Square");
    }
}

@Slf4j
class Red implements Color {

    @Override
    public void draw() {
        log.debug("this is a red");
    }
}

@Slf4j
class Green implements Color {

    @Override
    public void draw() {
        log.debug("this is a Green");
    }
}

@Slf4j
class Blue implements Color {

    @Override
    public void draw() {
        log.debug("this is a Blue");
    }
}

abstract class AbstractDesign {
    public abstract Color getColor(String Color);

    public abstract Shape getShape(String Shape);
}

class ColorFactory extends AbstractDesign {


    @Override
    public Color getColor(String Color) {
        if (Color.equalsIgnoreCase("") && Color == null) {
            return null;
        }
        if (Color.equalsIgnoreCase("Red")) {
            return new Red();
        }
        if (Color.equalsIgnoreCase("Blue")) {
            return new Blue();
        }
        if (Color.equalsIgnoreCase("Green")) {
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String Shape) {
        return null;
    }
}
class ShapeFactory extends AbstractDesign{
    @Override
    public Color getColor(String Color) {
        return null;
    }

    @Override
    public Shape getShape(String Shape) {
        if (Shape == null && Shape.equalsIgnoreCase("")){
            return null;
        }
        if (Shape.equalsIgnoreCase("Circle")){return new Circle();}
        if (Shape.equalsIgnoreCase("Rectangle")){return new Rectangle();}
        if (Shape.equalsIgnoreCase("Square")){return new Square();}
        return null;
    }
}

class FactoryProducer {
    public static AbstractDesign getAbstractDesign(String chose) {
        if (chose.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        }
        if (chose.equalsIgnoreCase("Shape")) {
            return new ShapeFactory();
        }
        return null;
    }
}
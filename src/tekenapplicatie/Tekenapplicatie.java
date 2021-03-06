/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tekenapplicatie;
import drawing.database.DatabaseMediator;
import drawing.domain.*;
import drawing.serialization.*;
import java.io.File;
/**
 *
 * @author Rupture13
 */
public class Tekenapplicatie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestScript1();
        //TestScript2();
    }
    
    public static void TestScript1() {
        //Dit is een eigen verzonnen testscript om het een en ander mee te testen
        //Dit testscript werkt nu 100% :)
        Drawing dr = new Drawing("Masterpiece4", new Point(0, 0), drawing.domain.Color.BLUE, null);
        
        Oval ov = new Oval(new Point(2, 3), 12, 768, 3, Color.BLUE, dr);
        Point[] polyPoints = {new Point(1, 2), new Point(3, 4), new Point(2, 3)};
        Polygon po = new Polygon(polyPoints, 0, Color.BLUE, dr);
        PaintedText txt = new PaintedText(new Point(42, 42), 36, 6, "Ik ben een text", "Arial", Color.BLACK, dr);
        
        dr.addDrawingItem(ov);
        dr.addDrawingItem(po);
        dr.addDrawingItem(txt);
        
        System.out.println(dr.toString());
        
        dr.removeDrawingItem(po);
        
        System.out.println(dr.toString());
        
        System.out.println("And now for something completely different!");
        
        Oval ov2 = new Oval(new Point(42, 13), 1920, 1080, 1, Color.RED, dr);
        System.out.println(ov2.toString());
        
//        dr.addDrawingItem(ov2);
//        dr.editDrawingItem(ov2, new Point(24, 48), ov2.getColor(), ov2.getHeight(), ov2.getWidth(), ov2.getWeight());
//        System.out.println(dr.toString());
        ov2.editItem(new Point(24, 48), ov2.getColor(), ov2.getHeight(), ov2.getWidth(), ov2.getWeight());
        System.out.println(ov2.toString());
        
        ov2.editItem(new Point(12, 36), ov2.getColor(), 9, ov2.getWidth(), 2);
        System.out.println(ov2.toString());
        
        ov2.revertChange();
        System.out.println(ov2.toString());
        
        ov2.revertChange();
        System.out.println(ov2.toString());
        
        dr.editDrawingItem(ov, new Point(3, 4), Color.BLUE, 1024, 768, 3);
        
        System.out.println("\n" + dr.toString());
        
//        SerializationMediator sm = new SerializationMediator();
//        sm.save(dr);
//        Drawing dr2 = sm.load("Masterpiece");
//        if (dr2 != null) {
//            System.out.println("PostSerializing\n" + dr2.toString());
//        }
        
        DatabaseMediator dm = new DatabaseMediator();
        //dm.save(dr);
        Drawing dr3 = dm.load("Masterpiece4");
        if (dr3 != null) {
            System.out.println("PostDatabasing\n" + dr3.toString());
        }
        
        System.out.println("TestRecursie");
        dr.addDrawingItem(dr3);
        dr3.setName("Lolwat");
        System.out.println(dr.toString());
        dr3.setName("Hehe");
        System.out.println(dr.toString());
        dr3.revertChange();
        System.out.println(dr.toString());
        
        
    }
    
    public static void TestScript2() {
        //Dit is het testscript zoals in de opdracht beschreven
        Drawing dr = new Drawing("TestDrawing", new Point(0, 0), drawing.domain.Color.BLUE, null);
        
        Oval ov = new Oval(new Point(5, 2), 12, 768, 3, Color.BLUE, dr);
        
        Point[] polyPoints = {new Point(1, 2), new Point(3, 4), new Point(2, 3)};
        Polygon po = new Polygon(polyPoints, 0, Color.RED, dr);
        
        PaintedText txt = new PaintedText(new Point(1, 5), 36, 6, "Ik ben een text", "Arial", Color.BLACK, dr);
        
        Image img = new Image(new Point(42, 13), 30, 60, new File("C:\\Users\\gebruiker\\Desktop\\spacerun concept.jpg"), Color.GREEN, dr);
        
        dr.addDrawingItem(ov);
        dr.addDrawingItem(po);
        dr.addDrawingItem(txt);
        dr.addDrawingItem(img);
        
        System.out.println("Voor sorteren:");
        System.out.println(dr.toString());
        
        dr.sortDrawingItemsByDistanceToOrigin();
        
        System.out.println("\nNa sorteren:");
        System.out.println(dr.toString());
        
        
    }
    
    
}

import org.uplift.drawings.Shape;
import org.uplift.drawings.shapes.Circle;
import org.uplift.drawings.shapes.Rectangle;
import org.uplift.drawings.shapes.Triangle;

public class Main {
    public static void main(String[] args) {

        Shape s= new Rectangle();
        System.out.println(s.drawShape());
        Shape c= new Circle();
        System.out.println(c.drawShape());
        Shape t= new Triangle();
        System.out.println(t.drawShape());

        /*s.drawShape();
        //Shape c= new Circle();

        c.drawShape();
        Shape t= new Triangle();
        t.drawShape();
*/

    }
}
import sourceFile.FractalGenerator;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    public int numIterations(double x, double y) {
        int it = 0;
        double re = 0;
        double im = 0;
        while (it < MAX_ITERATIONS && re * re + im * im < 4) {
            double zrealUpdated = re * re - im * im + x;
            double zimaginaryUpdated = 2 * Math.abs(re) * Math.abs(im) + y;
            re = zrealUpdated;
            im = zimaginaryUpdated;
            it += 1;
        }
        if (it == MAX_ITERATIONS) {
            return -1;
        }
        return it;
    }

    @Override
    public String toString() {
        return "Burning Ship";
    }
}

package alibaba.passedPuzzle.models;

/**
 * Created by runpeng.chen on 5/9/17.
 */
public class Point implements IPoint{

    private final double x;
    private final double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }
}

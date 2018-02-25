package alibaba.passedPuzzle.models;

public class Line implements ILine {

    private final IPoint a;
    private final IPoint b;

    public Line(IPoint a, IPoint b) {
        if (a.x() < b.x()) {
            this.a = a;
            this.b = b;
        } else {
            this.a = b;
            this.b = a;
        }
    }

    public boolean intersected(ILine l2) {
        if (l2.slope() == slope()) {
            if (intersect() != l2.intersect()) {
                return false;
            } else {
                if (l2.a().x() > this.b().x() || l2.b().x() < this.a().x()) {
                    return false;
                }
            }
        }
        double meet_x = 0;
        if (l2.slope() == Double.POSITIVE_INFINITY) {
            meet_x = l2.a().x();
            double meet_y = meet_x * this.slope() + this.intersect();
            return insideLine(meet_y, this.a().y(), this.b().y());
        } else if (this.slope() == Double.POSITIVE_INFINITY) {
            meet_x = this.a().x();
            double meet_y = meet_x * l2.slope() + l2.intersect();
            return insideLine(meet_y, l2.a().y(), l2.b().y());
        }
        meet_x = (l2.intersect() - this.intersect()) / (this.slope() - l2.slope());
        return ((insideLine(meet_x, l2.a().x(), l2.b().x())) &&
                insideLine(meet_x, this.a().x(), this.b().x()));
    }

    private boolean insideLine(double target, double a, double b) {
        double mid = (a + b) / 2;
        return Math.abs(mid - target) <= Math.abs(mid - a) ? true : false;
    }

    @Override
    public IPoint a() {
        return this.a;
    }

    @Override
    public IPoint b() {
        return this.b;
    }

    @Override
    public double slope() {
        if (a.x() == b.x()) return Double.POSITIVE_INFINITY;
        return (a.y() - b.y()) / (a.x() - b.x());
    }

    @Override
    public double intersect() {
        if (a.x() == b.x()) return Double.POSITIVE_INFINITY;
        return (a.x() * b.y() - b.x() * a.y()) / (a.x() - b.x());
    }


}
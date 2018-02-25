package alibaba.passedPuzzle.models;

public interface ILine {
    boolean intersected(ILine a);

    IPoint a();

    IPoint b();

    double slope();

    double intersect();
}
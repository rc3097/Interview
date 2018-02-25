package alibaba.passedPuzzle.models;

import java.util.ArrayList;

/**
 * Created by runpeng.chen on 5/14/17.
 */
public class GroupLine implements ILine {
    private GroupLine parent;
    private ILine origin;

    public GroupLine parent() {
        return parent;
    }

    public GroupLine(ILine line) {
        this.origin = line;
        this.parent = this;
    }

    public void union(GroupLine line) {
        GroupLine aRoot = line;
        ArrayList<GroupLine> childlist = new ArrayList<>();
        while (aRoot.parent() != aRoot) {
            childlist.add(aRoot);
            aRoot = aRoot.parent();
        }
        GroupLine bRoot = this;
        while (bRoot.parent() != bRoot) {
            childlist.add(bRoot);
            bRoot = bRoot.parent();
        }
        bRoot.setParent(aRoot);
        for (GroupLine child:childlist) {
            child.setParent(aRoot);
        }
    }

    public void setParent(GroupLine line) {
        this.parent = line;
    }

    @Override
    public boolean intersected(ILine a) {
        return origin.intersected(a);
    }

    @Override
    public IPoint a() {
        return origin.a();
    }

    @Override
    public IPoint b() {
        return origin.b();
    }

    @Override
    public double slope() {
        return origin.slope();
    }

    @Override
    public double intersect() {
        return origin.intersect();
    }

    public String toString() {
        return String.format("(%s, %s) -> (%s, %s)", a().x(), a().y(), b().x(), b().y());
    }
}

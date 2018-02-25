package alibaba.passedPuzzle;

import alibaba.passedPuzzle.models.GroupLine;
import alibaba.passedPuzzle.models.ILine;
import alibaba.passedPuzzle.models.IPoint;
import alibaba.passedPuzzle.models.Line;
import alibaba.passedPuzzle.models.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by runpeng.chen on 5/10/17.
 */
public class Puzzle {

    private final List<ILine> lines;
    private final int n;
    private final int m;

    public Puzzle(List<ILine> lines, int n, int m) {
        this.lines = new ArrayList<ILine>(lines);
        this.n = n;
        this.m = m;
    }

    public boolean passed() {
        IPoint leftTop = new Point(0, m);
        IPoint rightTop = new Point(n, m);
        IPoint rightBottom = new Point(n, 0);
        IPoint leftBottom = new Point(0, 0);
        GroupLine leftLine = new GroupLine(new Line(leftBottom, leftTop));
        GroupLine topLine = new GroupLine(new Line(leftTop, rightTop));
        GroupLine rightLine = new GroupLine(new Line(rightBottom, rightTop));
        GroupLine bottomLine = new GroupLine(new Line(leftBottom, rightBottom));

        List<GroupLine> groupLines = new ArrayList<>();
        for (ILine line : this.lines) {
            groupLines.add(new GroupLine(line));
        }
        groupLines.add(leftLine);
        groupLines.add(topLine);
        groupLines.add(rightLine);
        groupLines.add(bottomLine);

        for (int i = 0; i < groupLines.size(); i++) {
            GroupLine aLine = groupLines.get(i);
            System.out.println(aLine);
            for (int j = i + 1; j < groupLines.size(); j++) {
                GroupLine bLine = groupLines.get(j);
                if (aLine.parent() == bLine.parent()) continue;
                if ((aLine == leftLine && bLine == bottomLine) || (aLine == bottomLine && bLine == leftLine) ||
                        (aLine == topLine && bLine == rightLine) || (aLine == rightLine && bLine == topLine)) continue;
                System.out.println(bLine);
                if (aLine.intersected(bLine)) {
                    bLine.union(aLine);
                }
            }
        }

        if (leftLine.parent() == rightLine.parent() || topLine.parent() == bottomLine.parent()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<ILine> lines = new ArrayList<>();
        Puzzle empty_puzzle = new Puzzle(lines, 10, 10);
        System.out.println(empty_puzzle.passed());

        lines.add(new Line(new Point(1, -1), new Point(1, 20)));
        Puzzle cutted_puzzule = new Puzzle(lines, 10, 15);
        System.out.println(cutted_puzzule.passed());

    }
}



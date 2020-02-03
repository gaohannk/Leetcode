package company.weride.oa;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class ConvexHull {
    private Point[] points;
    private int N;
    private Point[] outPoint;
    private Point minPoint;

    public ConvexHull(int N, Point[] points) {
        this.N = N;
        this.points = points;
    }

    public int getLeastyPoint() {//返回纵坐标最小的点的索引；
        int minyindex = 0;
        for (int i = 1; i < N; i++) {
            if (points[minyindex].y > points[i].y) {
                minyindex = i;
                minPoint = points[i];
            }
        }

        return minyindex;
    }

    public double AngleTwoPoints(Point point) {//和点P0点的连线与横轴的夹角，即P0Pi向量和（0，1）向量夹角余弦值
        int yleast = getLeastyPoint();
        if (point.x == points[yleast].x && point.y == points[yleast].y)
            return 0;
        else
            return (Math.acos((point.x - points[yleast].x) / (Math.sqrt(Math.pow(point.x - points[yleast].x, 2) + Math.pow(point.y - points[yleast].y, 2)))) * 180);
    }

    class AngleComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) { //值大于0，说明o1离P0得角度大,o2就排在前面
            return (int) (AngleTwoPoints(o1) - AngleTwoPoints(o2));
        }
    }

    public void sort() {
        Arrays.sort(points, new AngleComparator());
    }

    public Point[] OutPoint() {
        Stack<Point> stack = new Stack<>();
        int size = 0;
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < N; ) {
            Point a, b;
            Iterator<Point> iterator = stack.iterator();
            b = iterator.next();
            a = iterator.next();//
            if (ccw(a, b, points[i]) > 0 || stack.size() == 2) {
                stack.push(points[i]);
                i++;
            } else {
                stack.pop();
            }
        }
        size = stack.size();
        outPoint = new Point[size];
        for (int j = 0; j < size; j++) {//栈最底部是原点，需除去；
            outPoint[size - 1 - j] = stack.pop();
        }
        return outPoint;
    }

    public static int ccw(Point a, Point b, Point c) {
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area < 0)
            return -1;
        else if (area > 0)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int N = 8;
        Point[] points = new Point[N];
        points[0] = new Point(1, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(0, -1);
        points[3] = new Point(-1, 0);
        points[4] = new Point(2, 0);
        points[5] = new Point(0, 2);
        points[6] = new Point(0, -2);
        points[7] = new Point(-2, 0);

        Point[] outPoint;

        ConvexHull convexhull = new ConvexHull(N, points);
        convexhull.sort();
        outPoint = convexhull.OutPoint();
        print(outPoint);
    }

    public static void print(Point[] points) {
        for (Point p : points) {
            System.out.println(p.toString());
        }
    }
}

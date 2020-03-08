package company.qualtric;

public class Cube implements Comparable<Cube>{
    public int height;
    public int width;
    public int length;

    public void rotateLeftRrRight() {
        int temp = length;
        length = height;
        height = temp;
    }

    public void rotateFrontRrBack() {
        int temp = width;
        width = height;
        height = temp;
    }

    public int size() {
        return height * width * length;
    }

    @Override
    public int compareTo(Cube o) {
        return 0;
    }
}

package company.oracle.phone;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // B is right of A
        if(rec1[2] <= rec2[0]){
            return false;
        }
        // B is up of A
        if(rec1[3] <= rec2[1]){
            return false;
        }
        // B is left of A
        if(rec1[0] >= rec2[2]){
            return false;
        }
        // B is down of A
        if(rec1[1] >= rec2[3]){
            return false;
        }
        return true;
    }

}

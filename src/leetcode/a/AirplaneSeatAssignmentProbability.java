package leetcode.a;

/**
 *
 *
 */
/*
//     1,2,3,4
// -------------
//     1,2,3,4
//     3,2,4,1
//     3,2,1,4
//     2,1,3,4
//     2,3,1,4
//     2,3,4,1
//     2,4,3,1
//     4,2,3,1
//    P= 4/8
//     1,2,3
//     ------
//     1,2,3
//     2,1,3
//     2,3,1
//     3,2,1
//      P= 2/4
//     1,2
// -----------
//     1,2
//     2,1

//     1
// ---------
//     1

 */
public class AirplaneSeatAssignmentProbability {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)
            return 1;
        else
            return 0.5;
    }
}

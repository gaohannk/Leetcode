package leetcode.algo.t;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class TrafficLightControlledIntersection {
    class TrafficLight {

        private int curRoadId;
        private Map<Integer, Semaphore> map;

        public TrafficLight() {
            map = new HashMap<>();
            curRoadId = 1;
            map.put(1, new Semaphore(1));
            map.put(2, new Semaphore(1));
        }

        public void carArrived(
                int carId,           // ID of the car
                int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                int direction,       // Direction of the car
                Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
                Runnable crossCar    // Use crossCar.run() to make car cross the intersection
        ) throws InterruptedException {
            if (roadId == curRoadId) {
                map.get(roadId).acquire();
                if (roadId == curRoadId) {
                    curRoadId = roadId;
                    crossCar.run();
                    map.get(roadId).release();
                }
            } else {
                int otherRoadId = otherRoad(roadId);
                map.get(otherRoadId).acquire();
                turnGreen.run();
                curRoadId = roadId;
                crossCar.run();
                map.get(otherRoadId).release();
                map.get(roadId).release();
            }

        }

        private int otherRoad(int road) {
            return road == 1 ? 2 : 1;
        }
    }
}
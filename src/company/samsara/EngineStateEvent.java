package company.samsara;
/*
        # Create a class EngineStateEvent that models the state of the engine at a given time.
        # The class should store the engine state and a timestamp.
        #
        # There are three potential engine states
        # driving - engine is on and moving
        # off - engine is off
        # idle - engine is on and not moving
        #
        # This class must include a means of printing an EngineStateEvent as a string

# Create a class AlertProcessor.
        #
        # AlertsProcessor should have a method processEvent,
        # which will process one event at a time out of a stream of events.
        # The stream of events will be strictly time-ordered, and the timestamps
        # will increase monotonically. All events will be for a single vehicle.
        #
        # processEvent will print "ALERT!" if the engine state changes to idle,
        # and print "RESOLVED" when the engine state exits the idle state.
        #
        # processEvent may be called multiple times in a row for the same state,
        # but should print a message only on state changes.
*/
public class EngineStateEvent {

    public boolean printed;
    // driving 1
    // off 0
    // idle = -1
    int preState  = 0;
    int curState = 0;
    long timeStamp = 0;

    public void printState(){
        switch (curState){
            case -1:
                System.out.println("IDLE");
            case 1:
                System.out.println("DRIVING");
            case 0:
                System.out.println("OFF");
        }
    }

}


package company.samsara;

public class AlertProcessor {
    EngineStateEvent engineStateEvent;
    final static int minIdlePeriod = 5000;

    public AlertProcessor(EngineStateEvent engineStateEvent) {
        this.engineStateEvent = engineStateEvent;
    }

    public void processEvent(){
        if(engineStateEvent.curState == -1 && engineStateEvent.preState != -1){
            if( engineStateEvent.timeStamp + minIdlePeriod > System.currentTimeMillis()){
                return;
            }
            if(!engineStateEvent.printed){
                System.out.println("ALERT");
                this.engineStateEvent.printed = true;
                changeState(-1, System.currentTimeMillis());
            }else{
                return;
            }

        } else if(engineStateEvent.curState == -1 && engineStateEvent.preState == -1){
            System.out.println("RESOLVED");
        }
    }

    private void changeState(int state, long timestamp) {
        if(this.engineStateEvent.timeStamp > timestamp){
            return;
        }
        this.engineStateEvent.printed = false;
        this.engineStateEvent.preState = this.engineStateEvent.curState;
        this.engineStateEvent.curState = state;
        this.engineStateEvent.timeStamp = timestamp;
    }
}
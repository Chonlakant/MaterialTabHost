package net.yanzm.mth.sample.event;


public class LoadYouTubeEvent {

    public RespondEvent respondEvent;

    public LoadYouTubeEvent(RespondEvent respondEvent) {

        this.respondEvent = respondEvent;
    }
}

package model;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ReadingRoom {

    private Semaphore semaphore;
    private static Logger logger = Logger.getLogger(ReadingRoom.class);
    private static final int MAX_SEATS_COUNT = 2;

    public ReadingRoom() {
        this(MAX_SEATS_COUNT);
    }

    public ReadingRoom(int maxSeatsCount) {
        this.semaphore = new Semaphore(maxSeatsCount, true);
    }

    public void takeSeat(Visitor visitor) {
        try {
            semaphore.acquire();
            logger.info("Visitor " + visitor.getVisitorID() + " take a seat in Reading room.");
        } catch (InterruptedException e) {
            logger.error("No available seats in Reading Room.");
        }
    }

    public void leaveSeat(Visitor visitor) {
        logger.info("Visitor " + visitor.getVisitorID() + " is leaving room.");
        semaphore.release();
    }
}

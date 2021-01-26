package clase3.tt;

public class Timer {
    private long start;

    private long stop;
    public Timer() {
       reset();
    }

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        if (start > 0)
            stop = System.currentTimeMillis();
    }

    public long elapsedTime() {
        if (start == 0) return 0;
        else if (stop == 0) stop();
        return stop - start;
    }

    public void reset() {
        start = 0;
        stop = 0;
    }
}

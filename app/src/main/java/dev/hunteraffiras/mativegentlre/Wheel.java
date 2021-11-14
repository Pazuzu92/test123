package dev.hunteraffiras.mativegentlre;

public class Wheel extends Thread {
    interface SpinListener {
        void newImage(int img);
    }

    private static final int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};


    public int currentIndex;
    private final SpinListener spinListener;
    private final long frameDuration;
    private final long startIn;
    private boolean isStarted;

    public Wheel(SpinListener spinListener, long frameDuration, long startIn) {
        this.spinListener = spinListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;
    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == images.length) {
            currentIndex = 0;
        }
    }


    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (isStarted) {
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextImg();
            if (spinListener != null) {
                spinListener.newImage(images[currentIndex]);

            }
        }

    }

    public void stopSpin() {
        isStarted = false;
    }
}

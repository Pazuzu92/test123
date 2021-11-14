package dev.hunteraffiras.mativegentlre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView winCount, bet;
    private ImageView slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9,
            slot10, slot11, slot12, slot13, slot14, slot15;
    private Wheel wheel1, wheel2, wheel3, wheel4, wheel5, wheel6, wheel7, wheel8, wheel9, wheel10,
            wheel11, wheel12, wheel13, wheel14, wheel15;
    private boolean isStarted;
    private int money = 150, betCount = 1;
    private static final long START_TIME_IN_MILLIS = 5000;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        slot1 = findViewById(R.id.slot1);
        slot10 = findViewById(R.id.slot10);
        slot2 = findViewById(R.id.slot2);
        slot11 = findViewById(R.id.slot11);
        slot3 = findViewById(R.id.slot3);
        slot12 = findViewById(R.id.slot12);
        slot4 = findViewById(R.id.slot4);
        slot13 = findViewById(R.id.slot13);
        slot5 = findViewById(R.id.slot5);
        slot14 = findViewById(R.id.slot14);
        slot6 = findViewById(R.id.slot6);
        slot15 = findViewById(R.id.slot15);
        slot7 = findViewById(R.id.slot7);
        slot8 = findViewById(R.id.slot8);
        slot9 = findViewById(R.id.slot9);
        winCount = findViewById(R.id.money_count);
        ImageView btnSpin = findViewById(R.id.start_btn);
        winCount.setText(money + "");
        ImageView btnPlus = findViewById(R.id.plus_btn);
        ImageView btnMinus = findViewById(R.id.minus_btn);
        bet = findViewById(R.id.bet);
        bet.setText(betCount + "");
        checkTable();

        btnPlus.setOnClickListener(view -> {
            if (betCount == 10 || betCount < 1000) {
                betCount *= 10;
                bet.setText(betCount + "");
            }
        });

        btnMinus.setOnClickListener(view -> {
            if (betCount > 1) {
                betCount /= 10;
                bet.setText(betCount + "");
            }
        });

        btnSpin.setOnClickListener(view -> {
            if (isStarted) {


                wheel1.stopSpin();
                wheel2.stopSpin();
                wheel3.stopSpin();
                wheel4.stopSpin();
                wheel5.stopSpin();
                wheel6.stopSpin();
                wheel7.stopSpin();
                wheel8.stopSpin();
                wheel9.stopSpin();
                wheel10.stopSpin();
                wheel11.stopSpin();
                wheel12.stopSpin();
                wheel13.stopSpin();
                wheel14.stopSpin();
                wheel15.stopSpin();

                if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex &&
                        wheel3.currentIndex == wheel4.currentIndex && wheel4.currentIndex == wheel5.currentIndex &&
                        wheel5.currentIndex == wheel6.currentIndex) {
                    money = (money + 1000)*betCount;
                    winCount.setText(money + "");
                } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                        || wheel1.currentIndex == wheel3.currentIndex) {
                    money = (money + 50)*betCount;
                    winCount.setText(money + "");
                } else {
                    money -= 50;
                    if (money == 0) {
                        money = 100;
                        winCount.setText(money + "");
                    }
                    winCount.setText(money + "");
                }


                isStarted = false;

            } else {

                wheel1 = new Wheel(img -> runOnUiThread(() -> slot1.setImageResource(img)), 200, randomLong(0, 200));
                wheel1.start();

                wheel2 = new Wheel(img -> runOnUiThread(() -> slot2.setImageResource(img)), 200, randomLong(150, 1000));
                wheel2.start();

                wheel3 = new Wheel(img -> runOnUiThread(() -> slot3.setImageResource(img)), 200, randomLong(150, 1000));
                wheel3.start();

                wheel4 = new Wheel(img -> runOnUiThread(() -> slot4.setImageResource(img)), 200, randomLong(150, 1000));
                wheel4.start();

                wheel5 = new Wheel(img -> runOnUiThread(() -> slot5.setImageResource(img)), 200, randomLong(150, 1000));
                wheel5.start();

                wheel6 = new Wheel(img -> runOnUiThread(() -> slot6.setImageResource(img)), 200, randomLong(150, 1000));
                wheel6.start();

                wheel7 = new Wheel(img -> runOnUiThread(() -> slot7.setImageResource(img)), 200, randomLong(150, 1000));
                wheel7.start();

                wheel8 = new Wheel(img -> runOnUiThread(() -> slot8.setImageResource(img)), 200, randomLong(150, 1000));
                wheel8.start();

                wheel9 = new Wheel(img -> runOnUiThread(() -> slot9.setImageResource(img)), 200, randomLong(150, 1000));
                wheel9.start();

                wheel10 = new Wheel(img -> runOnUiThread(() -> slot10.setImageResource(img)), 200, randomLong(150, 1000));
                wheel10.start();
                wheel11 = new Wheel(img -> runOnUiThread(() -> slot11.setImageResource(img)), 200, randomLong(150, 300));
                wheel11.start();
                wheel12 = new Wheel(img -> runOnUiThread(() -> slot12.setImageResource(img)), 200, randomLong(250, 350));
                wheel12.start();
                wheel13 = new Wheel(img -> runOnUiThread(() -> slot13.setImageResource(img)), 200, randomLong(350, 400));
                wheel13.start();
                wheel14 = new Wheel(img -> runOnUiThread(() -> slot14.setImageResource(img)), 200, randomLong(450, 500));
                wheel14.start();
                wheel15 = new Wheel(img -> runOnUiThread(() -> slot15.setImageResource(img)), 200, randomLong(500, 550));
                wheel15.start();


                /*new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        timeLeftInMillis = millisUntilFinished;
                        updateCountDownText();
                    }

                    @Override
                    public void onFinish() {
                        clickTimer.setVisibility(View.INVISIBLE);
                        view.setClickable(true);
                        isStarted = true;
                    }
                }.start();*/
                isStarted = true;
            }
        });
    }

    private void checkTable(){
        for (int i = 0; i < 10; i++) {
            int price = i*i^2;
            System.out.println(price);
        }
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

    }

    //делаю изменения

    //yerghesrhg
}
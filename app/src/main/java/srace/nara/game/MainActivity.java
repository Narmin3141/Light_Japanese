package srace.nara.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    private long backPressedTime;
    private Toast backToast;
    //private boolean music = false;
    Random random = new Random(); private int lastAngle = 0;
    ThirdType_kat thirdType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //кнопка Начать - начало
        final Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }//конец конструкции (чтобы игра не вылетала)
            }
        });
        //кнопка Начать - конец
        //диалоговое окно правил - начало
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//убрать заоловок
        dialog.setContentView(R.layout.dialog_rules);//путь к макету диалога
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));//прозрачный фон диалогового окна
        //Кнопка Продолжить - начадо
        Button btncontinuoe = (Button) dialog.findViewById(R.id.buttoncontinuoe);
        btncontinuoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диаологовое окно
            }
        });
        //Кнопка Продолжить - конец
        //диалоговое окно правил - конец
        //обработка правил - начало
        final ImageView rules = (ImageView) findViewById(R.id.rules);//достаём кнопку правил
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dialog.show();
            }
        });
        //обработка правил - конец
        //создаём колесо формуны
        final ImageView fortune = (ImageView) findViewById(R.id.main_img_circle); // достаём изображение

        Button buttonRotate = (Button) findViewById(R.id.buttonRotate);
        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int angle = random.nextInt(3600) + 360; //генерация рандомного угла
               // int angle = 240;
                    float pivotX = fortune.getWidth() / 2;
                    float pivotY = fortune.getHeight() / 2;
                    final Animation animation = new RotateAnimation(lastAngle, angle, pivotX, pivotY);
                    lastAngle = angle;
                    animation.setDuration(2500);
                    animation.setFillAfter(true);
                    fortune.startAnimation(animation);
                     if (angle>360){
                    int s = angle/360;
                    angle=angle-s*360;}
                    if (angle<=120){
                        buttonStart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, ThirdType.class);
                                startActivity(intent);
                            }
                        });
                    }
                if ((angle>120) && (angle<=240)){
                    buttonStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, GameLevels.class);
                            startActivity(intent);
                        }
                    });
                }
                if ((angle>240) && (angle<360)){
                    buttonStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, SecondType.class);
                            startActivity(intent);
                        }
                    });
                }

            }
        });
//создаём колесо фортуны

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //добавление музыки - начало
       // startService(new Intent(this, MyService.class));

        //добавление музыки - конец
    }
    //обработка настройки музыки - начало
  /*  public void onClickMusic(View v){
        ImageButton music_set = (ImageButton) findViewById(R.id.music_set);
        if (music == true) {
        stopService(new Intent(this, MyService.class));
        music_set.setImageResource(R.drawable.music_off);
        music = false;} else {
            startService(new Intent(this,MyService.class));
            music_set.setImageResource(R.drawable.music_on); music = true;
        }
    }*/
    //обработка настройки музыки - конец

    //Обработка системной кнопки "назад" начало
    @Override
    public void onBackPressed(){
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), R.string.toast_vihod, Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();

      //  stopService(new Intent(this, MyService.class));//остановка музыки при выходе
    }
    //Обработка системной кнопки "назад" конец

}

package srace.nara.game;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Level1_secondtype extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft;//переменная для левой картинки + текст
    public int numRight;
    public int numText;//рандомное число для текста
    Array array = new Array();//новый объект из класса Array
    Random random = new Random();
    public int count = 0;//счетчик правильных ответов
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //Реклама - конец
//Закрытие рекламы на крестик начало
        //Закрытие рекламы на крестик конец

        //создаём переменнй. text_levels
        //TextView text_levels = (TextView) findViewById(R.id.text_levels);
        //text_levels.setText(R.string.level1);//установили текст
        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        //код скругляющий углы
        //img_left.setClipToOutline(true); //не действует для мин версии моего проекта
final ImageView background = (ImageView) findViewById(R.id.background);
background.setImageResource(R.drawable.asia5);
        final TextView random_text = (TextView) findViewById(R.id.random_text); //путь к тексту (рандомному)
        //развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //развернуть игру на весь экран - конец
        //_____________________________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//убрать заоловок
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету диалога
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));//прозрачный фон
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть кнопкой назад
//интересный факт - начало
        TextView textdescriptionEnd = (TextView) dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.levelEndThirdType);
        //интересный факт - конец
        //кнопка, которая закрывает диалоговое окно начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия кнопки - начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level1_secondtype.this, GameLevels.class); //создали намерение для перехода
                    startActivity(intent); //старт намерение
                    finish();//закрыть этот класс
                    //вернуться назад к выбору уровня - конец
                } catch (Exception e) {
                }
                dialogEnd.dismiss();//закрытие диалогового окна
            }
            //обработка нажатия кнопки - конец
        });
        //кнопка, которая закрывает диалоговое окно конец
        //Кнопка Продолжить - начадо
        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        Intent intent = new Intent(Level1_secondtype.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {//кода не будет
                    }

                    dialogEnd.dismiss();//закрываем диаологовое окно

            }
        });

        //Кнопка Продолжить - конец

        //_____________________________________________

        //Кнопка "Назад" - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        Intent intent = new Intent(Level1_secondtype.this, MainActivity.class);//создали намерение
                        startActivity(intent);//старт намерения
                        finish();//закрывть этот класс
                    } catch (Exception e) {
                    }

            }
        });
//Кнопка "Назад" - конец

        //массив для прогресса игры- начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,

        };
        //массив для прогресса игры- конец
        //подключение анимации - начало
        final Animation a = AnimationUtils.loadAnimation(Level1_secondtype.this,R.anim.alpha_1);
        //подключение анимации - конец
        numLeft = random.nextInt(14);//генерация числа от 0 до 9 для левой
        img_left.setImageResource(array.secondtype_images[numLeft]);//достаем из массива картинку
        numRight = random.nextInt(14);//для правой
        //чтобы числа не повторялись
        while (numLeft == numRight){
            numRight = random.nextInt(14);//заново генерируем
        }
        //чтобы числа не повторялись
        img_right.setImageResource(array.secondtype_images[numRight]);//достаём картинку для правой картинки
        numText = random.nextInt(14);//генерация числа от 0 до 9 для текста
        while ((numText != numLeft) && (numText != numRight))
        {
            numText = random.nextInt(14);//заново генерируем
        }
        random_text.setText(array.secondtype_texts[numText]);
        img_left.setBackgroundResource(R.drawable.style_pink);
        img_right.setBackgroundResource(R.drawable.style_pink);
        random_text.setBackgroundResource(R.drawable.style_pink);
        //нажатие на ЛЕВУЮ картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){

                    //если палец на экране
                    img_right.setEnabled(false);//против одновременного нажатия
                    if(numLeft == numText){
                        img_left.setBackgroundResource(R.drawable.style_points_green);
                    } else {
                        img_left.setBackgroundResource(R.drawable.style_red);
                    }//если палец на экране - конец
                } else if(event.getAction() == MotionEvent.ACTION_UP){
                    img_left.setBackgroundResource(R.drawable.style_pink);
                    //если палец убран - начало
                    if(numLeft == numText){
                        if (count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом - начало
                        for(int i=0; i< 20; i++){
                             TextView tv = findViewById(progress[i]);
                             tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец
                        //определяем правильные ответы и закрашиваем в зелёный - начало
                        for(int i =0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зелёный - конец
                    } else {//если левая - неверный ответ - начало
                        if (count>0){
                            if (count == 1){ count = 0;
                        } else {count = count - 2;}
                        }

                        //закрашиваем прогресс серым цветом - начало
                        for(int i=0; i< 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец
                        //определяем правильные ответы и закрашиваем в зелёный - начало
                        for(int i =0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зелёный - конец
                    }
                    //если палец убран - конец
                    if (count==20){
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();//показать диалоговое окно
                    } else{
                        numLeft = random.nextInt(14);//генерация числа от 0 до 9 для левой
                        img_left.setImageResource(array.secondtype_images[numLeft]);//достаем из массива картинку
                        img_left.startAnimation(a);
                        numRight = random.nextInt(14);//для правой
                        //чтобы числа не повторялись
                        while (numLeft == numRight){
                            numRight = random.nextInt(14);//заново генерируем
                        }
                        //чтобы числа не повторялись
                        img_right.setImageResource(array.secondtype_images[numRight]);//достаём картинку для правой картинки
                        img_right.startAnimation(a);
                        numText = random.nextInt(14);//генерация числа от 0 до 9 для текста
                        while ((numText != numLeft) && (numText != numRight))
                        {
                            numText = random.nextInt(14);//заново генерируем
                        }
                        random_text.setText(array.secondtype_texts[numText]);
                        img_right.setEnabled(true);//обратно включаем правую картинку
                    }
                }
                return true;
            }
        });
        //нажатие на ЛЕВУЮ картинку - конец

        //нажатие на ПРАВУЮ картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){

                    //если палец на экране
                    img_left.setEnabled(false);//против одновременного нажатия
                    if(numRight == numText){
                        img_right.setBackgroundResource(R.drawable.style_points_green);
                    } else {
                        img_right.setBackgroundResource(R.drawable.style_red);
                    }//если палец на экране - конец
                } else if(event.getAction() == MotionEvent.ACTION_UP){
                    img_right.setBackgroundResource(R.drawable.style_pink);
                    //если палец убран - начало
                    if(numRight == numText){
                        if (count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом - начало
                        for(int i=0; i< 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец
                        //определяем правильные ответы и закрашиваем в зелёный - начало
                        for(int i =0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зелёный - конец
                    } else {//если правая - неверный ответ - начало
                        if (count>0){
                            if (count == 1){ count = 0;
                            } else {count = count - 2;}
                        }

                        //закрашиваем прогресс серым цветом - начало
                        for(int i=0; i< 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец
                        //определяем правильные ответы и закрашиваем в зелёный - начало
                        for(int i =0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зелёный - конец
                    }
                    //если палец убран - конец
                    if (count==20){
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    } else{
                        numLeft = random.nextInt(14);//генерация числа от 0 до 9 для левой
                        img_left.setImageResource(array.secondtype_images[numLeft]);//достаем из массива картинку
                        img_left.startAnimation(a);
                        numRight = random.nextInt(14);//для правой
                        //чтобы числа не повторялись
                        while (numLeft == numRight){
                            numRight = random.nextInt(14);//заново генерируем
                        }
                        //чтобы числа не повторялись
                        img_right.setImageResource(array.secondtype_images[numRight]);//достаём картинку для правой картинки
                        img_right.startAnimation(a);
                        numText = random.nextInt(14);//генерация числа от 0 до 9 для текста
                        while ((numText != numLeft) && (numText != numRight))
                        {
                            numText = random.nextInt(14);//заново генерируем
                        }
                        random_text.setText(array.secondtype_texts[numText]);
                        img_left.setEnabled(true);//обратно включаем левую картинку
                    }
                }
                return true;
            }
        });
        //нажатие на ПРАВУЮ картинку - конец
    }
    //Системная кнопка назад - начало
    @Override
    public void onBackPressed () {

            try {
                Intent intent = new Intent(Level1_secondtype.this, MainActivity.class);//создали намерение
                startActivity(intent);//старт намерения
                finish();//закрывть этот класс
            } catch (Exception e) {
            }

    }
    //Системная кнопка назад - конец
}
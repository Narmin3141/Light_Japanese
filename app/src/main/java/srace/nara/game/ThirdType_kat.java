package srace.nara.game;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.ByteArrayInputStream;
import java.util.Random;

public class ThirdType_kat extends AppCompatActivity {
    Dialog dialog;
    private long pressedTime2;
    public Toast toast1;
    public int numOfPic;
    public int pic_1;
    public int pic_2;
    public int pic_3;
    public int pic_4;
    public int count = 0;//счетчик правильных ответов
    Array array = new Array();//новый объект из класса Array
    Random random = new Random();
    SharedPreferences sPref1;
    public TextView counter_record1;
    final String SAVED_TEXT1 = "saved_text1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_type);


        final SharedPreferences save = getSharedPreferences("Save1",MODE_PRIVATE);
        final int point1 = save.getInt("point1",0);

        //достаем кнопки с вариантами ответов - начало
        final TextView pic1= (TextView) findViewById(R.id.pic1);
        final TextView pic2= (TextView) findViewById(R.id.pic2);
        final TextView pic3= (TextView) findViewById(R.id.pic3);
        final TextView pic4= (TextView) findViewById(R.id.pic4);
        counter_record1 = (TextView) findViewById(R.id.counter_record);
        counter_record1.setBackgroundResource(R.drawable.style_pink);
        final ImageButton clearing = (ImageButton) findViewById(R.id.clearing);
        final TextView counter = (TextView) findViewById(R.id.counter);
        counter.setBackgroundResource(R.drawable.style_pink);

        //сгенерировали спускающуюся картинку - начало
        final ImageView falling_pic = (ImageView) findViewById(R.id.falling_pic);
        final Animation falling = AnimationUtils.loadAnimation(this,R.anim.alpha);
        numOfPic = random.nextInt(48);
        falling_pic.setImageResource(array.thirdtype_kat_images[numOfPic]);
        falling_pic.startAnimation(falling);
        //сгенерировали спускающуюся картинку - конец
        //генерация для вариантов ответа - начало
        pic_1 = random.nextInt(48); pic_2 = random.nextInt(48);
        while (pic_1 == pic_2) {pic_2 = random.nextInt(48);} pic_3 = random.nextInt(48);
        while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(48);}
        pic_4 = random.nextInt(48);
        while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(48);}
        //генерация для вариантов ответа - конец
        while ((numOfPic != pic_1) &&  (numOfPic != pic_2) && (numOfPic != pic_3) && (numOfPic != pic_4)){
            //генерация для вариантов ответа - начало
            pic_1 = random.nextInt(48); pic_2 = random.nextInt(48);
            while (pic_1 == pic_2) {pic_2 = random.nextInt(48);} pic_3 = random.nextInt(48);
            while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(48);}
            pic_4 = random.nextInt(48);
            while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(48);}
            //генерация для вариантов ответа - конец
        }
        //достали тесты для вариантов - начало
        pic1.setText(array.thirdtype_kat_texts[pic_1]);
        pic2.setText(array.thirdtype_kat_texts[pic_2]);
        pic3.setText(array.thirdtype_kat_texts[pic_3]);
        pic4.setText(array.thirdtype_kat_texts[pic_4]);
        //достали тесты для вариантов - конец
        //меняем стиль - начало
        pic1.setBackgroundResource(R.drawable.style_pink);
        pic2.setBackgroundResource(R.drawable.style_pink);
        pic3.setBackgroundResource(R.drawable.style_pink);
        pic4.setBackgroundResource(R.drawable.style_pink);
        //меняем стиль - конец
        //создаём диалоговое окно - начало
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//убрать заоловок
        dialog.setContentView(R.layout.record);//путь к макету диалога
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));//прозрачный фон
        dialog.setCancelable(false); //окно нельзя закрыть кнопкой назад
        //кнопка, которая закрывает диалоговое окно начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //обработка нажатия кнопки - начало
                    try {
                        //вернуться назад к выбору уровня - начало
                        Intent intent = new Intent(ThirdType_kat.this, MainActivity.class); //создали намерение для перехода
                        startActivity(intent); //старт намерение
                        finish();//закрыть этот класс
                        //вернуться назад к выбору уровня - конец
                    } catch (Exception e) {
                    }
                    dialog.dismiss();//закрытие диалогового окна

            }
            //обработка нажатия кнопки - конец
        });
        //Кнопка Продолжить - начадо
        Button btncontinuoe = (Button) dialog.findViewById(R.id.buttoncontinuoe);
        btncontinuoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ThirdType_kat.this, ThirdType.class); //создали намерение для перехода
                    startActivity(intent); //старт намерение
                    finish();//закрыть этот класс
                    dialog.dismiss();//закрываем диаологовое окно
                    loadText();
                }

        });
        //Кнопка Продолжить - конец
        final TextView score = (TextView) dialog.findViewById(R.id.score_num);
        final  TextView score_text = (TextView) dialog.findViewById(R.id.score);
        if (point1==0) {
            saveText();
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("point1",1);
            editor.commit();
        }
        loadText();
        CharSequence a1 = counter_record1.getText();
       final int[] k1 = {Integer.parseInt((String) a1)};
        clearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressedTime2+2000>System.currentTimeMillis()) {
                    k1[0] = 0;
                    counter_record1.setText(array.numbers[k1[0]]);
                } else {
                    toast1 = Toast.makeText(getBaseContext(), R.string.toast_trash, Toast.LENGTH_SHORT);
                    toast1.show();
                }
                pressedTime2 = System.currentTimeMillis();
            }
        });

        //создаём диалоговое окно - конец
        pic1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    pic2.setEnabled(false);
                    pic3.setEnabled(false);
                    pic4.setEnabled(false);
                    if ((pic_1==numOfPic) && (falling.hasEnded() == false)){
                        pic1.setBackgroundResource(R.drawable.style_points_green);
                        count++;
                        score.setText(""+count);
                        if ((count>=10) && (count<20)){ falling.setDuration(9900); }
                        if ((count>=20) && (count<30)){ falling.setDuration(9800); }
                        if ((count>=30)&& (count<40)){ falling.setDuration(9700); }
                        if ((count>=40) && (count<50)){ falling.setDuration(9600); }
                        if ((count>=50)&& (count<60)) {falling.setDuration(9500); }
                        if ((count>=60) && (count<70)){ falling.setDuration(9400); }
                        if ((count>=70)&&(count<80)){ falling.setDuration(9300); }
                        if ((count>=80)&& (count<90)){ falling.setDuration(9100); }
                        if ((count>=90)&& (count<100)){ falling.setDuration(8900); }
                        if ((count>=100)&& (count<110)){ falling.setDuration(7000); }
                        if ((count>=110)&& (count<120)){ falling.setDuration(6500); }
                        if ((count>=120)&& (count<140)){ falling.setDuration(6400); }
                        if ((count>=140)&& (count<150)){ falling.setDuration(6300); }
                        if (count>=150){ falling.setDuration(2500); }
                        if (count==200) {
                            score_text.setText(R.string.pozdrav);
                            dialog.show();}
                        counter.setText(""+count);
                        if (count > k1[0]) {
                            k1[0] = count;
                        }
                        //counter_record1.setText(array.numbers[k1[0]]);
                        counter_record1.setText(""+k1[0]);
                        saveText();

                    } else {pic1.setBackgroundResource(R.drawable.style_red); dialog.show();saveText();
                    }

                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    pic1.setBackgroundResource(R.drawable.style_pink);
                    if ((pic_1==numOfPic) && (falling.hasEnded() == false)){
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_kat_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        //генерация для вариантов ответа - начало
                        pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                        while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                        while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                        pic_4 = random.nextInt(72);
                        while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                        //генерация для вариантов ответа - конец
                        while ((numOfPic != pic_1) &&  (numOfPic != pic_2) && (numOfPic != pic_3) && (numOfPic != pic_4)){
                            //генерация для вариантов ответа - начало
                            pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                            while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                            while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                            pic_4 = random.nextInt(72);
                            while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                            //генерация для вариантов ответа - конец
                        }
                        //достали тесты для вариантов - начало
                        pic1.setText(array.thirdtype_kat_texts[pic_1]);
                        pic2.setText(array.thirdtype_kat_texts[pic_2]);
                        pic3.setText(array.thirdtype_kat_texts[pic_3]);
                        pic4.setText(array.thirdtype_kat_texts[pic_4]);
                        //достали тесты для вариантов - конец
                        pic2.setEnabled(true);
                        pic3.setEnabled(true);
                        pic4.setEnabled(true);

                    }
                }

                return true;
            }
        });
        pic2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    pic1.setEnabled(false);
                    pic3.setEnabled(false);
                    pic4.setEnabled(false);

                    if ((pic_2==numOfPic) && (falling.hasEnded() == false)) {
                        pic2.setBackgroundResource(R.drawable.style_points_green);
                        count++;
                        score.setText(""+count);
                        if ((count>=10) && (count<20)){ falling.setDuration(9900); }
                        if ((count>=20) && (count<30)){ falling.setDuration(9800); }
                        if ((count>=30)&& (count<40)){ falling.setDuration(9700); }
                        if ((count>=40) && (count<50)){ falling.setDuration(9600); }
                        if ((count>=50)&& (count<60)) {falling.setDuration(9500); }
                        if ((count>=60) && (count<70)){ falling.setDuration(9400); }
                        if ((count>=70)&&(count<80)){ falling.setDuration(9300); }
                        if ((count>=80)&& (count<90)){ falling.setDuration(9100); }
                        if ((count>=90)&& (count<100)){ falling.setDuration(8900); }
                        if ((count>=100)&& (count<110)){ falling.setDuration(7000); }
                        if ((count>=110)&& (count<120)){ falling.setDuration(6500); }
                        if ((count>=120)&& (count<140)){ falling.setDuration(6400); }
                        if ((count>=140)&& (count<150)){ falling.setDuration(6300); }
                        if (count>=150){ falling.setDuration(2500); }
                        if (count==200) {
                            score_text.setText(R.string.pozdrav);
                            dialog.show();}
                        counter.setText(""+count);
                        if (count > k1[0]) {
                            k1[0] = count;
                        }
                        //counter_record1.setText(array.numbers[k1[0]]);
                        counter_record1.setText(""+k1[0]);
                        saveText();
                    } else {pic2.setBackgroundResource(R.drawable.style_red);dialog.show();saveText();
                    }

                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    pic2.setBackgroundResource(R.drawable.style_pink);
                    if ((pic_2==numOfPic) && (falling.hasEnded() == false)) {
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_kat_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        //генерация для вариантов ответа - начало
                        pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                        while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                        while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                        pic_4 = random.nextInt(72);
                        while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                        //генерация для вариантов ответа - конец
                        while ((numOfPic != pic_1) &&  (numOfPic != pic_2) && (numOfPic != pic_3) && (numOfPic != pic_4)){
                            //генерация для вариантов ответа - начало
                            pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                            while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                            while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                            pic_4 = random.nextInt(72);
                            while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                            //генерация для вариантов ответа - конец
                        }
                        //достали тесты для вариантов - начало
                        pic1.setText(array.thirdtype_kat_texts[pic_1]);
                        pic2.setText(array.thirdtype_kat_texts[pic_2]);
                        pic3.setText(array.thirdtype_kat_texts[pic_3]);
                        pic4.setText(array.thirdtype_kat_texts[pic_4]);
                        //достали тесты для вариантов - конец
                        pic1.setEnabled(true);
                        pic3.setEnabled(true);
                        pic4.setEnabled(true);
                    }
                }
                return true;
            }
        });
        pic3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    pic1.setEnabled(false);
                    pic2.setEnabled(false);
                    pic4.setEnabled(false);

                    if ((pic_3==numOfPic) && (falling.hasEnded() == false)) {
                        pic3.setBackgroundResource(R.drawable.style_points_green);
                        count++;score.setText(""+count);
                        if ((count>=10) && (count<20)){ falling.setDuration(9900); }
                        if ((count>=20) && (count<30)){ falling.setDuration(9800); }
                        if ((count>=30)&& (count<40)){ falling.setDuration(9700); }
                        if ((count>=40) && (count<50)){ falling.setDuration(9600); }
                        if ((count>=50)&& (count<60)) {falling.setDuration(9500); }
                        if ((count>=60) && (count<70)){ falling.setDuration(9400); }
                        if ((count>=70)&&(count<80)){ falling.setDuration(9300); }
                        if ((count>=80)&& (count<90)){ falling.setDuration(9100); }
                        if ((count>=90)&& (count<100)){ falling.setDuration(8900); }
                        if ((count>=100)&& (count<110)){ falling.setDuration(7000); }
                        if ((count>=110)&& (count<120)){ falling.setDuration(6500); }
                        if ((count>=120)&& (count<140)){ falling.setDuration(6400); }
                        if ((count>=140)&& (count<150)){ falling.setDuration(6300); }
                        if (count>=150){ falling.setDuration(2500); }
                        if (count==200) {
                            score_text.setText(R.string.pozdrav);
                            dialog.show();}
                        counter.setText(""+count);
                        if (count > k1[0]) {
                            k1[0] = count;
                        }
                        //counter_record1.setText(array.numbers[k1[0]]);
                        counter_record1.setText(""+k1[0]);
                        saveText();
                    } else {pic3.setBackgroundResource(R.drawable.style_red);dialog.show();saveText();
                    }


                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    pic3.setBackgroundResource(R.drawable.style_pink);

                    if ((pic_3==numOfPic) && (falling.hasEnded() == false)){
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_kat_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        //генерация для вариантов ответа - начало
                        pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                        while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                        while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                        pic_4 = random.nextInt(72);
                        while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                        //генерация для вариантов ответа - конец
                        while ((numOfPic != pic_1) &&  (numOfPic != pic_2) && (numOfPic != pic_3) && (numOfPic != pic_4)){
                            //генерация для вариантов ответа - начало
                            pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                            while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                            while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                            pic_4 = random.nextInt(72);
                            while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                            //генерация для вариантов ответа - конец
                        }
                        //достали тесты для вариантов - начало
                        pic1.setText(array.thirdtype_kat_texts[pic_1]);
                        pic2.setText(array.thirdtype_kat_texts[pic_2]);
                        pic3.setText(array.thirdtype_kat_texts[pic_3]);
                        pic4.setText(array.thirdtype_kat_texts[pic_4]);
                        //достали тесты для вариантов - конец
                        pic1.setEnabled(true);
                        pic2.setEnabled(true);
                        pic4.setEnabled(true);
                    }
                }
                return true;
            }
        });

        pic4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    pic1.setEnabled(false);
                    pic2.setEnabled(false);
                    pic3.setEnabled(false);

                    if ((pic_4==numOfPic) && (falling.hasEnded() == false)) {
                        pic4.setBackgroundResource(R.drawable.style_points_green);
                        count++;score.setText(""+count);
                        if ((count>=10) && (count<20)){ falling.setDuration(9900); }
                        if ((count>=20) && (count<30)){ falling.setDuration(9800); }
                        if ((count>=30)&& (count<40)){ falling.setDuration(9700); }
                        if ((count>=40) && (count<50)){ falling.setDuration(9600); }
                        if ((count>=50)&& (count<60)) {falling.setDuration(9500); }
                        if ((count>=60) && (count<70)){ falling.setDuration(9400); }
                        if ((count>=70)&&(count<80)){ falling.setDuration(9300); }
                        if ((count>=80)&& (count<90)){ falling.setDuration(9100); }
                        if ((count>=90)&& (count<100)){ falling.setDuration(8900); }
                        if ((count>=100)&& (count<110)){ falling.setDuration(7000); }
                        if ((count>=110)&& (count<120)){ falling.setDuration(6500); }
                        if ((count>=120)&& (count<140)){ falling.setDuration(6400); }
                        if ((count>=140)&& (count<150)){ falling.setDuration(6300); }
                        if (count>=150){ falling.setDuration(2500); }
                        if (count==200) {
                            score_text.setText(R.string.pozdrav);
                            dialog.show();}
                        counter.setText(""+count);
                        if (count > k1[0]) {
                            k1[0] = count;
                        }
                       // counter_record1.setText(array.numbers[k1[0]]);
                        counter_record1.setText(""+k1[0]);
                        saveText();
                    } else {pic4.setBackgroundResource(R.drawable.style_red);dialog.show();saveText();
                    }


                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    pic4.setBackgroundResource(R.drawable.style_pink);
                    if ((pic_4==numOfPic) && (falling.hasEnded() == false)){
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        numOfPic = random.nextInt(72);
                        falling_pic.setImageResource(array.thirdtype_kat_images[numOfPic]);
                        falling_pic.startAnimation(falling);
                        //сгенерировали спускающуюся картинку - конец
                        //генерация для вариантов ответа - начало
                        pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                        while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                        while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                        pic_4 = random.nextInt(72);
                        while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                        //генерация для вариантов ответа - конец
                        while ((numOfPic != pic_1) &&  (numOfPic != pic_2) && (numOfPic != pic_3) && (numOfPic != pic_4)){
                            //генерация для вариантов ответа - начало
                            pic_1 = random.nextInt(72); pic_2 = random.nextInt(72);
                            while (pic_1 == pic_2) {pic_2 = random.nextInt(72);} pic_3 = random.nextInt(72);
                            while ((pic_1 == pic_3) || (pic_2 == pic_3)){pic_3 = random.nextInt(72);}
                            pic_4 = random.nextInt(72);
                            while ((pic_1 == pic_4) || (pic_2 == pic_4) || (pic_3 == pic_4)){pic_4 = random.nextInt(72);}
                            //генерация для вариантов ответа - конец
                        }
                        //достали тесты для вариантов - начало
                        pic1.setText(array.thirdtype_kat_texts[pic_1]);
                        pic2.setText(array.thirdtype_kat_texts[pic_2]);
                        pic3.setText(array.thirdtype_kat_texts[pic_3]);
                        pic4.setText(array.thirdtype_kat_texts[pic_4]);
                        //достали тесты для вариантов - конец
                        pic1.setEnabled(true);
                        pic2.setEnabled(true);
                        pic3.setEnabled(true);
                    }
                }
                return true;
            }
        });
        /*Button button_back1 = (Button)findViewById(R.id.button_back);
        button_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ThirdType_kat.this, ThirdType.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });*/
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

 public  void saveText(){
        sPref1 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref1.edit();
        ed.putString(SAVED_TEXT1,counter_record1.getText().toString());
        ed.commit();
    }
    public  void loadText(){
        sPref1 = getPreferences(MODE_PRIVATE);
        String savedText = sPref1.getString(SAVED_TEXT1," ");
        counter_record1.setText(savedText);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
    //Системная кнопка назад - начало
    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(ThirdType_kat.this, ThirdType.class);//создали намерение
            startActivity(intent);//старт намерения
            finish();//закрывть этот класс
        } catch (Exception e) { }
    }
    //Системная кнопка назад - конец
}
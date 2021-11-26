package srace.nara.game;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

import java.util.Random;

public class Level20 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    public int num1;//переменная для левой картинки + текст
    public int num2;  public int num3;  public int num4;
    public int num5;  public int num6;
    public int numText;//рандомное число для текста
    Array array = new Array();//новый объект из класса Array
    Random random = new Random();
    public int count = 0;//счетчик правильных ответов
    public int range = 0;//порядок нажатия
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_1);
        //создаём переменнй. text_levels
        TextView text_levels = (TextView) findViewById(R.id.text_levels);
        text_levels.setText(R.string.level20);//установили текст

        final ImageView img1_line4 = (ImageView) findViewById(R.id.img1_line4);
        final ImageView img2_line4 = (ImageView) findViewById(R.id.img2_line4);
        final ImageView img3_line4 = (ImageView) findViewById(R.id.img3_line4);
        final ImageView img4_line4 = (ImageView) findViewById(R.id.img4_line4);
        final ImageView img1_line5 = (ImageView) findViewById(R.id.img1_line5);
        final ImageView img2_line5 = (ImageView) findViewById(R.id.img2_line5);
        final ImageView img1_line6 = (ImageView) findViewById(R.id.img1_line6);
        final ImageView img2_line6 = (ImageView) findViewById(R.id.img2_line6);
        final ImageView img3_line6 = (ImageView) findViewById(R.id.img3_line6);
        final ImageView img4_line6 = (ImageView) findViewById(R.id.img4_line6);

        //код скругляющий углы
        //img_left.setClipToOutline(true); //не действует для мин версии моего проекта

        final  TextView text_points = (TextView) findViewById(R.id.text_points);
        //развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран - конец
        //вызов диалогового окна в начале игры
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//убрать заоловок
        dialog.setContentView(R.layout.previewdialog_1);//путь к макету диалога
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
                    Intent intent = new Intent(Level20.this, GameLevels.class); //создали намерение для перехода
                    startActivity(intent); //старт намерение
                    finish();//закрыть этот класс
                    //вернуться назад к выбору уровня - конец
                } catch (Exception e) {
                }
                //dialog.dismiss();//закрытие диалогового окна
            }
            //обработка нажатия кнопки - конец
        });
        //кнопка, которая закрывает диалоговое окно конец
        TextView texdescriptionEnd_1 = (TextView) dialog.findViewById(R.id.textdescriptionEnd_1);
        texdescriptionEnd_1.setText(R.string.check_your_knowledge_20);
        //Кнопка Продолжить - начадо
        Button btncontinuoe = (Button) dialog.findViewById(R.id.buttoncontinuoe_1);
        btncontinuoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диаологовое окно
            }
        });
        //Кнопка Продолжить - конец
        dialog.show();//показать диалоговое окно
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
        final TextView textdescriptionEnd = (TextView) dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.level20End);
        //интересный факт - конец
        //кнопка, которая закрывает диалоговое окно начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия кнопки - начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level20.this, GameLevels.class); //создали намерение для перехода
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
                    Intent intent = new Intent(Level20.this, Level21.class);
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
                    Intent intent = new Intent(Level20.this, GameLevels.class);//создали намерение
                    startActivity(intent);//старт намерения
                    finish();//закрывть этот класс
                } catch (Exception e) {
                }
            }
        });
//Кнопка "Назад" - конец

        final int[] texts = {
               R.id.random_text1, R.id.random_text2, R.id.random_text3,R.id.random_text4,
                R.id.random_text5,

        };
        for(int i=0;i<5;i++){TextView tv = findViewById(texts[i]);
            tv.setText(array.texts20[i]);}
        //подключение анимации - начало
        final Animation a = AnimationUtils.loadAnimation(Level20.this, R.anim.alpha_1);
        //подключение анимации - конец
        //генерация чисел - начало
        num1 = random.nextInt(5); num2 = random.nextInt(5);
        while (num1 == num2) {num2 = random.nextInt(5);} num3 = random.nextInt(5);
        while ((num1 == num3) || (num2 == num3)){num3 = random.nextInt(5);}
        num4 = random.nextInt(5);
        while ((num1 == num4) || (num2 == num4) || (num3 == num4)){num4 = random.nextInt(5);}
        num5 = random.nextInt(5);
        while ((num1 == num5) || (num2 == num5) || (num3 == num5)||(num4 == num5))
        {num5 = random.nextInt(5);}
        //генерация чисел - конец
        //img1_line4.setVisibility(View.INVISIBLE);
        img2_line4.setImageResource(array.images20[num1]);img2_line4.startAnimation(a);
        img3_line4.setImageResource(array.images20[num2]);
        //img4_line4.setVisibility(View.INVISIBLE);
        img1_line5.setImageResource(array.images20[num3]);
        img2_line5.setImageResource(array.images20[num4]);
        //img1_line6.setVisibility(View.INVISIBLE);
        //img2_line6.setImageResource(array.images9[num5]);
        img3_line6.setImageResource(array.images20[num5]);
        //img4_line6.setVisibility(View.INVISIBLE);

        //обработка нажатия на первую кнопку - начало
        img2_line4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if /*((range == 0) && */(num1==range) {
                        img2_line4.setBackgroundResource(R.drawable.style_points_green);

                        range+=1; count+=1;
                        if (count == 1) {text_points.setText(R.string.point1);} if (count == 2) {text_points.setText(R.string.point2);}
                        if (count == 3) {text_points.setText(R.string.point3);} if (count == 4) {text_points.setText(R.string.point4);}
                        if (count == 5) {text_points.setText(R.string.point5);
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level",1);
                            if (level > 20) {
                                /**/
                            } else {
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level",21);
                                editor.commit();
                            }
                        dialogEnd.show();}

                    } else {img2_line4.setBackgroundResource(R.drawable.style_red);
                        textdescriptionEnd.setText(R.string.error);
                        //Кнопка Продолжить - начадо
                        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
                        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(Level20.this, Level20.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {//кода не будет
                                }

                                dialogEnd.dismiss();//закрываем диаологовое окно
                            }
                        });

                        //Кнопка Продолжить - конец
                        dialogEnd.show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    //if (num1==range) {//range+=1; count+=1;
                        for(int i =0; i<range;i++){
                            TextView tv = findViewById(texts[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //range+=1; count+=1;
                    //} //else {//img1_line4.setImageResource(R.drawable.img_false);
                        //img1_line4.setImageResource(array.images9[num1]);
                    }


                return true;
            }
        });
//обработка нажатия на первую кнопку - конец
        //обработка нажатия на вторую кнопку - начало
        img3_line4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if/*(range == 1) && */(num2==range) {
                    img3_line4.setBackgroundResource(R.drawable.style_points_green);
                    range+=1;count+=1;
                        if (count == 1) {text_points.setText(R.string.point1);} if (count == 2) {text_points.setText(R.string.point2);}
                        if (count == 3) {text_points.setText(R.string.point3);} if (count == 4) {text_points.setText(R.string.point4);}
                        if (count == 5) {text_points.setText(R.string.point5); dialogEnd.show();}
                    }
                    else {img3_line4.setBackgroundResource(R.drawable.style_red);
                        textdescriptionEnd.setText(R.string.error);
                        //Кнопка Продолжить - начадо
                        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
                        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(Level20.this, Level20.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {//кода не будет
                                }

                                dialogEnd.dismiss();//закрываем диаологовое окно
                            }
                        });

                        //Кнопка Продолжить - конец
                        dialogEnd.show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                       // img2_line4.setBackgroundResource(R.drawable.style_points_green);
                       // range+=1;count+=1;
                        //закрашиваем текст - начало
                        //if(num2 == range){range+=1; count+=1;
                            //закрашиваем текст - начало
                            for(int i =0; i<range;i++){
                                TextView tv = findViewById(texts[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            } //закрашиваем текст - конец
                        //}

                    //else {//img2_line4.setBackgroundResource(R.drawable.style_red);
                    //img2_line4.setImageResource(array.images9[num2]);}
                }
                return true;
            }
        });
//обработка нажатия на вторую кнопку - конец
        //обработка нажатия на третью кнопку - начало
        img1_line5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if/*((range == 2) && */(num3==range) {
                        img1_line5.setBackgroundResource(R.drawable.style_points_green);
                        range+=1; count+=1;
                        if (count == 1) {text_points.setText(R.string.point1);} if (count == 2) {text_points.setText(R.string.point2);}
                        if (count == 3) {text_points.setText(R.string.point3);} if (count == 4) {text_points.setText(R.string.point4);}
                        if (count == 5) {text_points.setText(R.string.point5);
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level",1);
                            if (level > 20) {
                                /**/
                            } else {
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level",21);
                                editor.commit();
                            }
                        dialogEnd.show();}
                    }
                    else {img1_line5.setBackgroundResource(R.drawable.style_red);
                        textdescriptionEnd.setText(R.string.error);
                        //Кнопка Продолжить - начадо
                        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
                        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(Level20.this, Level20.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {//кода не будет
                                }

                                dialogEnd.dismiss();//закрываем диаологовое окно
                            }
                        });

                        //Кнопка Продолжить - конец
                        dialogEnd.show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    //img1_line5.setImageResource(array.images9[num3]);
                    //закрашиваем текст - начало
                    //if(num3 == range){
                        //закрашиваем текст - начало
                        for(int i =0; i<range;i++){
                            TextView tv = findViewById(texts[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } //закрашиваем текст - конец
                    //}

                }
                return true;
            }
        });
//обработка нажатия на третью кнопку - конец

        //обработка нажатия на четвертую кнопку - начало
        img2_line5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if/*((range == 3) && */(num4==range){
                        img2_line5.setBackgroundResource(R.drawable.style_points_green);
                        range+=1; count+=1;
                        if (count == 1) {text_points.setText(R.string.point1);} if (count == 2) {text_points.setText(R.string.point2);}
                        if (count == 3) {text_points.setText(R.string.point3);} if (count == 4) {text_points.setText(R.string.point4);}
                        if (count == 5) {text_points.setText(R.string.point5);
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level",1);
                            if (level > 20) {
                                /**/
                            } else {
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level",21);
                                editor.commit();
                            }
                        dialogEnd.show();}
                    }
                    else {img2_line5.setBackgroundResource(R.drawable.style_red);
                        textdescriptionEnd.setText(R.string.error);
                        //Кнопка Продолжить - начадо
                        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
                        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(Level20.this, Level20.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {//кода не будет
                                }

                                dialogEnd.dismiss();//закрываем диаологовое окно
                            }
                        });

                        //Кнопка Продолжить - конец
                        dialogEnd.show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //img2_line5.setImageResource(array.images9[num4]);
                    //закрашиваем текст - начало
                    //if(num4 == range){ //range+=1; count+=1;
                        //закрашиваем текст - начало
                        for(int i =0; i<range;i++){
                            TextView tv = findViewById(texts[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } //закрашиваем текст - конец
                    //}
                }
                return true;
            }
        });
//обработка нажатия на четвертую кнопку - конец

        //обработка нажатия на шестую кнопку - начало
        img3_line6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if/*((range == 5) && */(num5==range) {
                        img3_line6.setBackgroundResource(R.drawable.style_points_green);
                        range+=1; count+=1;
                        if (count == 1) {text_points.setText(R.string.point1);} if (count == 2) {text_points.setText(R.string.point2);}
                        if (count == 3) {text_points.setText(R.string.point3);} if (count == 4) {text_points.setText(R.string.point4);}
                        if (count == 5) {text_points.setText(R.string.point5);
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level",1);
                            if (level > 20) {
                                /**/
                            } else {
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level",21);
                                editor.commit();
                            }
                        dialogEnd.show();}
                    }
                    else {img3_line6.setBackgroundResource(R.drawable.style_red);
                        textdescriptionEnd.setText(R.string.error);
                        //Кнопка Продолжить - начадо
                        Button btncontinuoe2 = (Button) dialogEnd.findViewById(R.id.buttoncontinuoe);
                        btncontinuoe2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(Level20.this, Level20.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {//кода не будет
                                }

                                dialogEnd.dismiss();//закрываем диаологовое окно
                            }
                        });

                        //Кнопка Продолжить - конец
                        dialogEnd.show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    //img2_line6.setImageResource(array.images9[num6]);
                    //if(num6 == range){// range+=1; count+=1;
                    //закрашиваем текст - начало
                    for(int i =0; i<range;i++){
                        TextView tv = findViewById(texts[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    } //закрашиваем текст - конец
                  //      }
                }

                return true;
            }
        });
//обработка нажатия на третью шестую - конец
    }
    //Системная кнопка назад - начало
    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(Level20.this, GameLevels.class);//создали намерение
            startActivity(intent);//старт намерения
            finish();//закрывть этот класс
        } catch (Exception e) {}
    }
    //Системная кнопка назад - конец
}
package srace.nara.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameLevels extends AppCompatActivity {
    private AdView adView;
    private long pressedTime;
    public Toast toast1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

//        MobileAds.initialize(this,"ca-app-pub-1839230922064436~5118552087");
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

final SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
final int level = save.getInt("Level",1);
        final int[] x = {
                R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10,
                R.id.textView11,R.id.textView12,R.id.textView13,R.id.textView14,R.id.textView15,
                R.id.textView16,R.id.textView17,R.id.textView18,R.id.textView19,R.id.textView20,
                R.id.textView21,R.id.textView22,R.id.textView23,R.id.textView24,R.id.textView25,
                R.id.textView26,R.id.textView27,R.id.textView28,R.id.textView29,R.id.textView30,
        };
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
Button clearing_1 = (Button) findViewById(R.id.clearing_1);
clearing_1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(pressedTime + 2000 > System.currentTimeMillis()){
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("Level",1);
        editor.commit();
        for(int i=1;i<level;i++) {
            TextView tv = findViewById(x[i]);
            tv.setText("X");
        }
        }
        else {
            toast1 = Toast.makeText(getBaseContext(),R.string.toast_trash, Toast.LENGTH_SHORT);
            toast1.show();
        }
        pressedTime = System.currentTimeMillis();

    }
});

        //кнопка для перехода на 1-й уровень - начало
        TextView textView1 =  (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
if (level >=1) {
    Intent intent = new Intent(GameLevels.this, Level1.class);
    startActivity(intent);
    finish();
} else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 1-й уровень - конец
        //кнопка для перехода на 2-й уровень - начало
        TextView textView2 =  (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }
                    else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 2-й уровень - конец
        //кнопка для перехода на 3-й уровень - начало
        TextView textView3 =  (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 3-й уровень - конец
        //кнопка для перехода на 4-й уровень - начало
        TextView textView4 =  (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=4) {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 4-й уровень - конец
        //кнопка для перехода на 5-й уровень - начало
        TextView textView5 =  (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=5) {
                        Intent intent = new Intent(GameLevels.this, Level5.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 5-й уровень - конец
        //кнопка для перехода на 6-й уровень - начало
        TextView textView6 =  (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=6) {
                        Intent intent = new Intent(GameLevels.this, Level6.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 6-й уровень - конец
        //кнопка для перехода на 7-й уровень - начало
        TextView textView7 =  (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=7) {
                        Intent intent = new Intent(GameLevels.this, Level7.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 7-й уровень - конец
        //кнопка для перехода на 8-й уровень - начало
        TextView textView8 =  (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=8) {
                    Intent intent = new Intent(GameLevels.this, Level8.class);
                    startActivity(intent);
                    finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 8-й уровень - конец
        //кнопка для перехода на 9-й уровень - начало
        TextView textView9 =  (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=9) {
                        Intent intent = new Intent(GameLevels.this, Level9.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 9-й уровень - конец
        //кнопка для перехода на 10-й уровень - начало
        TextView textView10 =  (TextView)findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=10) {
                        Intent intent = new Intent(GameLevels.this, Level10.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 10-й уровень - конец
        //кнопка для перехода на 11-й уровень - начало
        TextView textView11 =  (TextView)findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=11) {
                        Intent intent = new Intent(GameLevels.this, Level11.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 11-й уровень - конец
        //кнопка для перехода на 12-й уровень - начало
        TextView textView12 =  (TextView)findViewById(R.id.textView12);
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=12) {
                        Intent intent = new Intent(GameLevels.this, Level12.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 12-й уровень - конец

        //кнопка для перехода на 13-й уровень - начало
        TextView textView13 =  (TextView)findViewById(R.id.textView13);
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=13) {
                        Intent intent = new Intent(GameLevels.this, Level13.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 13-й уровень - конец
        //кнопка для перехода на 14-й уровень - начало
        TextView textView14 =  (TextView)findViewById(R.id.textView14);
        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=14) {
                        Intent intent = new Intent(GameLevels.this, Level14.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 14-й уровень - конец
        //кнопка для перехода на 15-й уровень - начало
        TextView textView15 =  (TextView)findViewById(R.id.textView15);
        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=15) {
                        Intent intent = new Intent(GameLevels.this, Level15.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 15-й уровень - конец
        //кнопка для перехода на 16-й уровень - начало
        TextView textView16 =  (TextView)findViewById(R.id.textView16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=16) {
                        Intent intent = new Intent(GameLevels.this, Level16.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 16-й уровень - конец
        //кнопка для перехода на 17-й уровень - начало
        TextView textView17 =  (TextView)findViewById(R.id.textView17);
        textView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=17) {
                        Intent intent = new Intent(GameLevels.this, Level17.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 17-й уровень - конец
//кнопка для перехода на 18-й уровень - начало
        TextView textView18 =  (TextView)findViewById(R.id.textView18);
        textView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=18) {
                        Intent intent = new Intent(GameLevels.this, Level18.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 18-й уровень - конец
        //кнопка для перехода на 19-й уровень - начало
        TextView textView19 =  (TextView)findViewById(R.id.textView19);
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=19) {
                        Intent intent = new Intent(GameLevels.this, Level19.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 19-й уровень - конец
        //кнопка для перехода на 20-й уровень - начало
        TextView textView20 =  (TextView)findViewById(R.id.textView20);
        textView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=20) {
                        Intent intent = new Intent(GameLevels.this, Level20.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 20-й уровень - конец
        //кнопка для перехода на 21-й уровень - начало
        TextView textView21 =  (TextView)findViewById(R.id.textView21);
        textView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=21) {
                        Intent intent = new Intent(GameLevels.this, Level21.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 21-й уровень - конец
        //кнопка для перехода на 22-й уровень - начало
        TextView textView22 =  (TextView)findViewById(R.id.textView22);
        textView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=22) {
                        Intent intent = new Intent(GameLevels.this, Level22.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 22-й уровень - конец
        //кнопка для перехода на 23-й уровень - начало
        TextView textView23 =  (TextView)findViewById(R.id.textView23);
        textView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=23) {
                        Intent intent = new Intent(GameLevels.this, Level23.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 23-й уровень - конец
        //кнопка для перехода на 24-й уровень - начало
        TextView textView24 =  (TextView)findViewById(R.id.textView24);
        textView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=24) {
                        Intent intent = new Intent(GameLevels.this, Level24.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 24-й уровень - конец
        //кнопка для перехода на 25-й уровень - начало
        TextView textView25 =  (TextView)findViewById(R.id.textView25);
        textView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=25) {
                        Intent intent = new Intent(GameLevels.this, Level25.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 25-й уровень - конец
        //кнопка для перехода на 26-й уровень - начало
        TextView textView26 =  (TextView)findViewById(R.id.textView26);
        textView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=26) {
                        Intent intent = new Intent(GameLevels.this, Level26.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 26-й уровень - конец
        //кнопка для перехода на 27-й уровень - начало
        TextView textView27 =  (TextView)findViewById(R.id.textView27);
        textView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=27) {
                        Intent intent = new Intent(GameLevels.this, Level27.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 27-й уровень - конец
        //кнопка для перехода на 28-й уровень - начало
        TextView textView28 =  (TextView)findViewById(R.id.textView28);
        textView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=28) {
                        Intent intent = new Intent(GameLevels.this, Level28.class);
                        startActivity(intent);
                        finish();
                    }else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 28-й уровень - конец
        //кнопка для перехода на 29-й уровень - начало
        TextView textView29 =  (TextView)findViewById(R.id.textView29);
        textView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=29) {
                        Intent intent = new Intent(GameLevels.this, Level29.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 29-й уровень - конец
        //кнопка для перехода на 30-й уровень - начало
        TextView textView30 =  (TextView)findViewById(R.id.textView30);
        textView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >=30) {
                        Intent intent = new Intent(GameLevels.this, Level30.class);
                        startActivity(intent);
                        finish();
                    } else {}
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на 30-й уровень - конец


    for(int i=1;i<level;i++) {
        TextView tv = findViewById(x[i]);
        tv.setText("" + (i+1));
    }
    }
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e){

        }
    }
}

package srace.nara.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdType extends AppCompatActivity {
Toast toast3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_type_choose);
        toast3 = Toast.makeText(getBaseContext(), "Выберите азбуку", Toast.LENGTH_SHORT);

        final ImageView katakana = (ImageView) findViewById(R.id.katakana);
        final ImageView hiragana = (ImageView) findViewById(R.id.hiragana);
        katakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdType.this, ThirdType_kat.class); //создали намерение для перехода
                startActivity(intent); //старт намерение
                finish();//закрыть этот класс
            }
        });
        hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdType.this, ThirdType_hir.class); //создали намерение для перехода
                startActivity(intent); //старт намерение
                finish();//закрыть этот класс
            }
        });
    }
}

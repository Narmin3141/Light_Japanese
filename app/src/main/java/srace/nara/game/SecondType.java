package srace.nara.game;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class SecondType extends AppCompatActivity{
 Array array = new Array();
int count=1; int k=0;
private Toast toast1, toast2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_type);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toast1 = Toast.makeText(getBaseContext(),R.string.toast_press, Toast.LENGTH_SHORT);
        toast2 = Toast.makeText(getBaseContext(), R.string.toast_ready, Toast.LENGTH_SHORT);
        toast1.show();
       final ImageView numbers = (ImageView) findViewById(R.id.numbers);
       final TextView text_numbers = (TextView) findViewById(R.id.text_numbers);
       final TextView text_chislo = (TextView) findViewById(R.id.text_chislo);
       final Button start_second_type_Button = (Button) findViewById(R.id.start_second_type_Button);

        numbers.setImageResource(array.secondtype_images[0]);
        numbers.setBackgroundResource(R.drawable.style_pink);
        text_numbers.setText(array.secondtype_texts[0]);
        text_numbers.setBackgroundResource(R.drawable.style_pink);
        text_chislo.setText(array.numbers[0]);
        text_chislo.setBackgroundResource(R.drawable.style_pink);
        numbers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if ((count>10) && (count<=13)) {
            text_chislo.setText(array.numbers_1000[k]);
            numbers.setImageResource(array.secondtype_images[count]);
            text_numbers.setText(array.secondtype_texts[count]);
            k++;
            count++;
            if (count == 13) {count=0; k=0;toast2.show();}
        } else {
        numbers.setImageResource(array.secondtype_images[count]);
        text_numbers.setText(array.secondtype_texts[count]);
        text_chislo.setText(array.numbers[count]);
        count++;

        }
    }
});
start_second_type_Button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SecondType.this, Level1_secondtype.class);
        startActivity(intent);
    }
});
    }

}
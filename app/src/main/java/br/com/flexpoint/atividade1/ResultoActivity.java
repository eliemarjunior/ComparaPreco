package br.com.flexpoint.atividade1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultoActivity extends AppCompatActivity {
    private TextView txtRes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulto);

        this.txtRes = (TextView) findViewById(R.id.txtResult);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.getInt("SMelhor") == 0){
                txtRes.setText("As opções tem o mesmo custo pelo ML.");
            }else {
                txtRes.setText("A " + extras.getInt("SMelhor") + "ª opção está compensando mais porque está " + extras.getFloat("SPerc") + "% mais barata!");
            }
        }
    }
}

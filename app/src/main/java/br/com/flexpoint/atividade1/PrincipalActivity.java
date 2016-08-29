package br.com.flexpoint.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class PrincipalActivity extends AppCompatActivity {
    private Button btnCalc;
    private EditText iptP1;
    private EditText iptP2;
    private EditText iptM1;
    private EditText iptM2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.btnCalc = (Button) findViewById(R.id.btnCalculate);
        this.iptP1 = (EditText) findViewById(R.id.iptPrice1);
        this.iptP2 = (EditText) findViewById(R.id.iptPrice2);
        this.iptM1 = (EditText) findViewById(R.id.iptMl1);
        this.iptM2 = (EditText) findViewById(R.id.iptMl2);

        this.btnCalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    float p1 = Float.parseFloat(iptP1.getText().toString().replace(',','.'));
                    float p2 = Float.parseFloat(iptP2.getText().toString().replace(',','.'));

                    int m1 = Integer.parseInt(iptM1.getText().toString());
                    int m2 = Integer.parseInt(iptM2.getText().toString());

                    float ppml1 = p1/m1;
                    float ppml2 = p2/m2;

                    Intent IntentResult = new Intent(PrincipalActivity.this, ResultoActivity.class);

                    if(ppml1 < ppml2){
                        IntentResult.putExtra("SMelhor",1);
                        IntentResult.putExtra("SPerc",(((ppml2-ppml1)*100)/ppml1));
                    }else if(ppml1 > ppml2){
                        IntentResult.putExtra("SMelhor",2);
                        IntentResult.putExtra("SPerc",(((ppml1-ppml2)*100)/ppml2));
                    }else{
                        IntentResult.putExtra("SMelhor",0);
                        IntentResult.putExtra("SPerc",0);
                    }
                    startActivity(IntentResult);
                }catch(Exception e){
                    Toast.makeText(PrincipalActivity.this,"Erro na conversão dos dados. Digite o valor em reais usando ponto como separador e ml em inteiro",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

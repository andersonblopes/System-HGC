package br.com.k19.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
        initButton();
    }

    private void initSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.cidades);
        if(spinner == null){
            return;
        }
        ArrayList<String> cidades = new ArrayList<>();
        cidades.add("Fortaleza-CE");
        cidades.add("João Pessoa-PB");
        cidades.add("São Paulo-SP");
        cidades.add("Natal-RN");
        cidades.add("Mossoró-RN");
        cidades.add("Salvador-BA");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, cidades);
        spinner.setAdapter(adapter);
    }

    private void initButton() {
        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText email = (EditText) findViewById(R.id.email);
        final Spinner cidades = (Spinner) findViewById(R.id.cidades);
        final CheckBox noticias = (CheckBox) findViewById(R.id.noticias);
        final RadioGroup sexo = (RadioGroup) findViewById(R.id.sexo);
        Button button = (Button) findViewById(R.id.cadastrar);
        if(button == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Nome: " + nome.getEditableText().toString() + "\n");
                builder.append("Email: " + email.getEditableText().toString() + "\n");
                builder.append("Cidade: " + cidades.getSelectedItem() + "\n");
                String temp = null;
                if(noticias.isChecked()){
                    temp = "Sim";
                } else{
                    temp= "Não";
                }
                builder.append("Receber notícia? " + temp + "\n");
                RadioButton sexoSelecionado = (RadioButton) findViewById(sexo.getCheckedRadioButtonId());
                builder.append("Sexo: " + sexoSelecionado.getText());
                Toast toast = Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
        }

}

package com.rinndp.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonSubstract = findViewById(R.id.buttonSubstract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonNegative = findViewById(R.id.buttonNegative);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonResult = findViewById(R.id.buttonResult);
        Button buttonBackspace = findViewById(R.id.buttonBackspace);
        Button buttonC = findViewById(R.id.buttonC);


        ArrayList <Button> arrayListButtons = new ArrayList<>();
        arrayListButtons.add(button0);
        arrayListButtons.add(button1);
        arrayListButtons.add(button2);
        arrayListButtons.add(button3);
        arrayListButtons.add(button4);
        arrayListButtons.add(button5);
        arrayListButtons.add(button6);
        arrayListButtons.add(button7);
        arrayListButtons.add(button8);
        arrayListButtons.add(button9);
        arrayListButtons.add(buttonNegative);
        arrayListButtons.add(buttonDot);
        arrayListButtons.add(buttonResult);

        TextView pantalla = findViewById(R.id.screen);
        TextView pantallaArriba = findViewById(R.id.screen2);
        pantalla.setText(null);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText(null);
                pantallaArriba.setText(null);
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pantallaTexto = pantalla.getText().toString();
                pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " + ");
                pantalla.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                pantallaArriba.setText(pantallaArriba.getText().toString()+""+ pantallaTexto+ " * ");
                pantalla.setText(null);
            }
        });

        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                pantallaArriba.setText(pantallaArriba.getText().toString()+""+ pantallaTexto+ " - ");
                pantalla.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                pantallaArriba.setText(pantallaArriba.getText().toString()+""+ pantallaTexto+ " / ");
                pantalla.setText(null);
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Con el ScriptEngineManager
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Javascript");
                try {
                    Object resultado = scriptEngine.eval(pantallaArriba.getText().toString());
                    pantallaArriba.setText(null);
                    pantalla.setText(""+resultado);
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }

            }
        });



        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delimitator = "";
                String textoAcumulado = "";
                String [] pantallaCharAdd = pantalla.getText().toString().split(delimitator);
                for (int i = 0; i < pantallaCharAdd.length - 1; i++) {
                    String caracter = pantallaCharAdd[i];
                    textoAcumulado += caracter;
                    pantalla.setText(textoAcumulado);

                }

                if (pantallaCharAdd.length == 1) {
                    pantalla.setText("");
                }
            }
        });

        for (Button button: arrayListButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoPantalla = pantalla.getText().toString();
                    textoPantalla += button.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            });
        }
    }
}
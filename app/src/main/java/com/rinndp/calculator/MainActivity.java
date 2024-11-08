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
import com.udojava.evalex.Expression;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
        Button buttonOpenBracket = findViewById(R.id.buttonOpenBracket);
        Button buttonCloseBracket = findViewById(R.id.buttonCloseBracket);


        ArrayList <Button> arrayListButtons = new ArrayList<>();
        arrayListButtons.add(button1);
        arrayListButtons.add(button2);
        arrayListButtons.add(button3);
        arrayListButtons.add(button4);
        arrayListButtons.add(button5);
        arrayListButtons.add(button6);
        arrayListButtons.add(button7);
        arrayListButtons.add(button8);
        arrayListButtons.add(button9);




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
                String pantallaTextoArriba = pantallaArriba.getText().toString();
                if (!pantallaTextoArriba.isEmpty()) {
                    if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                        pantallaArriba.setText(null);
                    }
                }

                if (!pantallaTexto.isEmpty()) {
                    char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                    if (lastChar != '-' && lastChar != '+') {
                        pantallaArriba.setText(pantallaTextoArriba + "" + pantallaTexto + " + ");
                    }
                    pantalla.setText(null);
                } else if (pantallaTextoArriba.isEmpty()){
                    pantalla.setText("+ ");
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                String pantallaTextoArriba = pantallaArriba.getText().toString();

                if (!pantallaTextoArriba.isEmpty()) {
                    if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                        pantallaArriba.setText(null);
                    }
                }

                if (!pantallaTexto.isEmpty()) {
                    char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                    if (lastChar != '/' && lastChar != '*') {
                        pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " * ");
                    }
                    pantalla.setText(null);
                }
            }
        });

        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                String pantallaTextoArriba = pantallaArriba.getText().toString();

                if (!pantallaTextoArriba.isEmpty()) {
                    if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                        pantallaArriba.setText(null);
                    }
                }
                if (!pantallaTexto.isEmpty()) {
                    char lastChar = pantallaTexto.charAt(pantallaTexto.length()-1);
                    if (lastChar != '-' && lastChar != '+') {
                        pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " - ");
                    }
                    pantalla.setText(null);
                } else if (pantallaTextoArriba.isEmpty()){
                    pantalla.setText("- ");
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                String pantallaTextoArriba = pantallaArriba.getText().toString();

                if (!pantallaTextoArriba.isEmpty()) {
                    if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                        pantallaArriba.setText(null);
                    }
                }
                if (!pantallaTexto.isEmpty()) {
                    char lastChar = pantallaTexto.charAt(pantallaTexto.length()-1);
                    if (lastChar != '/' && lastChar != '*' ) {
                        pantallaArriba.setText(pantallaArriba.getText().toString()+""+ pantallaTexto+ " / ");
                    } if (pantallaArriba.getText().toString().charAt(pantallaArriba.getText().toString().length() - 1) == ')')
                        pantallaArriba.setText(pantallaArriba.getText().toString()+" / ");

                    pantalla.setText(null);
                    }
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pantalla.getText().toString().isEmpty()) {
                    pantalla.setText("0");
                }
                String operacion = pantallaArriba.getText().toString() + pantalla.getText().toString();
                try {
                    Expression expression = new Expression(operacion);
                    double resultado = expression.eval().doubleValue();

                    DecimalFormat decimalFormat;
                    if (Math.abs(resultado) < 1e6) {
                        decimalFormat = new DecimalFormat("#,###.##");
                    } else {
                        decimalFormat = new DecimalFormat("0.#####E0");
                    }

                    String resultadoFormateado = decimalFormat.format(resultado);
                    pantallaArriba.setText(pantallaArriba.getText().toString() + pantalla.getText().toString() +" =");
                    pantalla.setText(resultadoFormateado);
                } catch (Exception e) {
                    pantallaArriba.setText("Error:");
                    pantalla.setText("k e lo kepuziste");
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


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = pantalla.getText().toString();
                if (!textoPantalla.isEmpty()) {
                    textoPantalla += button0.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = pantalla.getText().toString();
                if (!textoPantalla.isEmpty() && textoPantalla.charAt(textoPantalla.length() - 1) != '.') {
                    textoPantalla += buttonDot.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            }
        });
        buttonOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                pantallaTexto += buttonOpenBracket.getText().toString();
                pantalla.setText(pantallaTexto);

                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                        if (!pantallaTexto.isEmpty()) {
                            if (lastChar != '-' && lastChar != '+') {
                                pantalla.setText(pantallaTexto+ " + ");
                            }
                        }
                    }
                });

                buttonSubstract.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                        if (!pantallaTexto.isEmpty()) {
                            if (lastChar != '-' && lastChar != '+') {
                                pantalla.setText(pantallaTexto+ " - ");
                            }
                        }
                    }
                });

                buttonMultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                        if (!pantallaTexto.isEmpty()) {
                            if (lastChar != '*' && lastChar != '/') {
                                pantalla.setText(pantallaTexto+ " * ");
                            }
                        }
                    }
                });

                buttonDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                        if (!pantallaTexto.isEmpty()) {
                            if (lastChar != '*' && lastChar != '/') {
                                pantalla.setText(pantallaTexto+ " / ");
                            }
                        }
                    }
                });
            }
        });

        buttonCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaTexto = pantalla.getText().toString();
                pantalla.setText(pantallaTexto+")");

                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        String pantallaTextoArriba = pantallaArriba.getText().toString();
                        if (!pantallaTextoArriba.isEmpty()) {
                            if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                                pantallaArriba.setText(null);
                            }
                        }

                        if (!pantallaTexto.isEmpty()) {
                            char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                            if (lastChar != '-' && lastChar != '+') {
                                pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " + ");
                            }
                            pantalla.setText(null);
                        } else if (pantallaTextoArriba.isEmpty()){
                            pantalla.setText("+ ");
                        }
                    }
                });

                buttonMultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        String pantallaTextoArriba = pantallaArriba.getText().toString();

                        if (!pantallaTextoArriba.isEmpty()) {
                            if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                                pantallaArriba.setText(null);
                            }
                        }

                        if (!pantallaTexto.isEmpty()) {
                            char lastChar = pantallaTexto.charAt(pantallaTexto.length() - 1);
                            if (lastChar != '/' && lastChar != '*') {
                                pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " * ");
                            }
                            pantalla.setText(null);
                        }
                    }
                });

                buttonSubstract.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        String pantallaTextoArriba = pantallaArriba.getText().toString();

                        if (!pantallaTextoArriba.isEmpty()) {
                            if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                                pantallaArriba.setText(null);
                            }
                        }
                        if (!pantallaTexto.isEmpty()) {
                            char lastChar = pantallaTexto.charAt(pantallaTexto.length()-1);
                            if (lastChar != '-' && lastChar != '+') {
                                pantallaArriba.setText(pantallaArriba.getText().toString() + "" + pantallaTexto + " - ");
                            }
                            pantalla.setText(null);
                        } else if (pantallaTextoArriba.isEmpty()){
                            pantalla.setText("- ");
                        }
                    }
                });

                buttonDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pantallaTexto = pantalla.getText().toString();
                        String pantallaTextoArriba = pantallaArriba.getText().toString();

                        if (!pantallaTextoArriba.isEmpty()) {
                            if (pantallaTextoArriba.charAt(pantallaArriba.length() - 1) == '=') {
                                pantallaArriba.setText(null);
                            }
                        }
                        if (!pantallaTexto.isEmpty()) {
                            char lastChar = pantallaTexto.charAt(pantallaTexto.length()-1);
                            if (lastChar != '/' && lastChar != '*' ) {
                                pantallaArriba.setText(pantallaArriba.getText().toString()+""+ pantallaTexto+ " / ");
                            } if (pantallaArriba.getText().toString().charAt(pantallaArriba.getText().toString().length() - 1) == ')')
                                pantallaArriba.setText(pantallaArriba.getText().toString()+" / ");

                            pantalla.setText(null);
                        }
                    }
                });
            }
        });


        for (Button button: arrayListButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!pantallaArriba.getText().toString().isEmpty()) {
                        if (pantallaArriba.getText().toString().charAt(pantallaArriba.length() - 1) == '=') {
                            pantallaArriba.setText(null);
                        }
                    }
                    String textoPantalla = pantalla.getText().toString();
                    textoPantalla += button.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            });
        }
    }
}
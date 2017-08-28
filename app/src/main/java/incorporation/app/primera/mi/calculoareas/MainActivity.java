package incorporation.app.primera.mi.calculoareas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    private RadioGroup Radio_selfigura;
    private RadioButton Radio_circulo, Radio_cuadro, Radio_cubo, Radio_triangulo;
    private Button Boton_calculo;
    private EditText Edit_hint_lado, Edit_hint_radio, Edit_hint_base, Edit_hint_altura, Edit_hint_ladito;
    private ImageView Imagen_hint_circulo, Imagen_hint_cuadro, Imagen_hint_cubo, Imagen_hint_triangulo;
    private TextView Text_perimetro, Text_area, Text_volumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting all
        Radio_selfigura = (RadioGroup) findViewById(R.id.selfigura);
        Radio_circulo = (RadioButton) findViewById(R.id.radio_circulo);
        Radio_cuadro = (RadioButton) findViewById(R.id.radio_cuadrado);
        Radio_cubo = (RadioButton) findViewById(R.id.radio_cubo);
        Radio_triangulo = (RadioButton) findViewById(R.id.radio_triangulo);
        Boton_calculo = (Button) findViewById(R.id.calculoso);
        Edit_hint_lado = (EditText) findViewById(R.id.lado);
        Edit_hint_radio = (EditText) findViewById(R.id.radioso);
        Edit_hint_altura = (EditText) findViewById(R.id.altura);
        Edit_hint_base = (EditText) findViewById(R.id.base);
        Edit_hint_ladito = (EditText) findViewById(R.id.ladito);
        Imagen_hint_circulo = (ImageView) findViewById(R.id.circulohint);
        Imagen_hint_cuadro = (ImageView) findViewById(R.id.cuadradohint);
        Imagen_hint_cubo = (ImageView) findViewById(R.id.cubohint);
        Imagen_hint_triangulo = (ImageView) findViewById(R.id.triangulohint);
        Text_perimetro = (TextView) findViewById(R.id.perimetroresp);
        Text_area = (TextView) findViewById(R.id.arearesp);
        Text_volumen = (TextView) findViewById(R.id.volumenresp);
        /*//codigo adicional para que el chulito funcione
        EventoTeclado teclado =new EventoTeclado();
        Edit_hint_lado.setOnEditorActionListener(teclado);//poner los edittext a la escucha
        Edit_hint_radio.setOnEditorActionListener(teclado);
        Edit_hint_lado_1.setOnEditorActionListener(teclado);
        Edit_hint_lado_2.setOnEditorActionListener(teclado);
        Edit_hint_base.setOnEditorActionListener(teclado);
        Edit_hint_ladito.setOnEditorActionListener(teclado);
        */


        //como el circulo esta seleccionado por defecto iniciemoslo con las caracteristicas del circulo
        Edit_hint_lado.setVisibility(View.GONE);
        Edit_hint_radio.setVisibility(View.VISIBLE);
        Edit_hint_base.setVisibility(View.GONE);
        Edit_hint_altura.setVisibility(View.GONE);
        Edit_hint_ladito.setVisibility(View.GONE);
        Imagen_hint_cuadro.setVisibility(View.GONE);
        Imagen_hint_circulo.setVisibility(View.VISIBLE);
        Imagen_hint_triangulo.setVisibility(View.GONE);
        Imagen_hint_cubo.setVisibility(View.GONE);

        Boton_calculo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                //dos lineas para que el teclado se baje solito cuando damos calcular
                InputMethodManager MiTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //almacemar dentro de Miteclado el dispositivo qu e usamos para introducir la informacion(teclado)
                MiTeclado.hideSoftInputFromWindow(Edit_hint_lado.getWindowToken(), 0);
                MiTeclado.hideSoftInputFromWindow(Edit_hint_radio.getWindowToken(), 0);
                MiTeclado.hideSoftInputFromWindow(Edit_hint_altura.getWindowToken(), 0);
                MiTeclado.hideSoftInputFromWindow(Edit_hint_base.getWindowToken(), 0);
                MiTeclado.hideSoftInputFromWindow(Edit_hint_ladito.getWindowToken(), 0);

                Double lado = 0.0, radio = 0.0, altura = 0.0, base = 0.0, ladocubo = 0.0, perimetro = 0.0, area = 0.0, volumen = 0.0, semiperimetro = 0.0;
                int id = Radio_selfigura.getCheckedRadioButtonId();
                int selecfigura = 0;
                if (id == R.id.radio_circulo) {
                    selecfigura = 1;
                } else if (id == R.id.radio_triangulo) {
                    selecfigura = 2;
                } else if (id == R.id.radio_cubo) {
                    selecfigura = 3;
                }
//--------------------------------------------------------------------------------------------------
                if (selecfigura == 0) {
                    if (Edit_hint_lado.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Faltan campos por llenar!!", Toast.LENGTH_SHORT).show();
                    } else {
                        lado = Double.parseDouble(Edit_hint_lado.getText().toString());
                        perimetro = 4 * lado;
                        area = Math.pow(lado, 2);

                        Text_perimetro.setText(String.valueOf(perimetro));
                        Text_area.setText(String.valueOf(area));
                        Text_volumen.setText("No Found");
                    }

                } else if (selecfigura == 1) {

                    if (Edit_hint_radio.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Faltan campos por llenar!!", Toast.LENGTH_SHORT).show();

                    } else {
                        radio = Double.parseDouble(Edit_hint_radio.getText().toString());
                        perimetro = 6.283 * radio;    //3.1415926536
                        area = 3.141 * Math.pow(radio, 2);

                        Text_perimetro.setText(String.valueOf(perimetro));
                        Text_area.setText(String.valueOf(area));
                        Text_volumen.setText("No Found");
                    }

                } else if (selecfigura == 2) {
                    if (Edit_hint_base.getText().toString().equals("") && Edit_hint_altura.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Faltan campos por llenar!!", Toast.LENGTH_SHORT).show();
                    } else {
                        base = Double.parseDouble(Edit_hint_base.getText().toString());
                        altura = Double.parseDouble(Edit_hint_altura.getText().toString());
                        perimetro = base + altura + Math.sqrt(Math.pow(base,2)+Math.pow(altura,2));
                        area = (base * altura)/2;

                        Text_perimetro.setText(String.valueOf(perimetro));
                        Text_area.setText(String.valueOf(area));
                        Text_volumen.setText("No Found");
                    }

                } else if (selecfigura == 3) {
                    if (Edit_hint_ladito.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Faltan campos por llenar!!", Toast.LENGTH_SHORT).show();

                    } else {
                        ladocubo = Double.parseDouble(Edit_hint_ladito.getText().toString());
                        perimetro = 12 * ladocubo;
                        area = 6 * Math.pow(ladocubo, 2);
                        volumen = Math.pow(ladocubo, 3);

                        Text_perimetro.setText(String.valueOf(perimetro));
                        Text_area.setText(String.valueOf(area));
                        Text_volumen.setText(String.valueOf(volumen));
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Error cabron!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
/*
    class EventoTeclado implements TextView.OnEditorActionListener{


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if (actionId == EditorInfo.IME_ACTION_DONE) {  //si se a ocultado el teclado porque le e dado al ok
                limpiar(null);
            }

            return false;
        }
    }
*/

    public void limpiar(View view) {

        Edit_hint_lado.setText("");
        Edit_hint_radio.setText("");
        Edit_hint_base.setText("");
        Edit_hint_altura.setText("");
        Edit_hint_ladito.setText("");
        Text_perimetro.setText("");
        Text_area.setText("");
        Text_volumen.setText("");

        switch (view.getId()) {

            case R.id.radio_cuadrado:

                if (((RadioButton) view).isChecked()) {
                    Edit_hint_lado.setVisibility(View.VISIBLE);
                    Edit_hint_radio.setVisibility(View.GONE);
                    Edit_hint_base.setVisibility(View.GONE);
                    Edit_hint_altura.setVisibility(View.GONE);
                    Edit_hint_ladito.setVisibility(View.GONE);
                    Imagen_hint_cuadro.setVisibility(View.VISIBLE);
                    Imagen_hint_circulo.setVisibility(View.GONE);
                    Imagen_hint_triangulo.setVisibility(View.GONE);
                    Imagen_hint_cubo.setVisibility(View.GONE);
                }
                break;

            case R.id.radio_circulo:

                if (((RadioButton) view).isChecked()) {
                    Edit_hint_lado.setVisibility(View.GONE);
                    Edit_hint_radio.setVisibility(View.VISIBLE);
                    Edit_hint_base.setVisibility(View.GONE);
                    Edit_hint_altura.setVisibility(View.GONE);
                    Edit_hint_ladito.setVisibility(View.GONE);
                    Imagen_hint_cuadro.setVisibility(View.GONE);
                    Imagen_hint_circulo.setVisibility(View.VISIBLE);
                    Imagen_hint_triangulo.setVisibility(View.GONE);
                    Imagen_hint_cubo.setVisibility(View.GONE);
                }
                break;

            case R.id.radio_triangulo:

                if (((RadioButton) view).isChecked()) {
                    Edit_hint_lado.setVisibility(View.GONE);
                    Edit_hint_radio.setVisibility(View.GONE);
                    Edit_hint_base.setVisibility(View.VISIBLE);
                    Edit_hint_altura.setVisibility(View.VISIBLE);
                    Edit_hint_ladito.setVisibility(View.GONE);
                    Imagen_hint_cuadro.setVisibility(View.GONE);
                    Imagen_hint_circulo.setVisibility(View.GONE);
                    Imagen_hint_triangulo.setVisibility(View.VISIBLE);
                    Imagen_hint_cubo.setVisibility(View.GONE);
                }
                break;

            case R.id.radio_cubo:

                if (((RadioButton) view).isChecked()) {
                    Edit_hint_lado.setVisibility(View.GONE);
                    Edit_hint_radio.setVisibility(View.GONE);
                    Edit_hint_base.setVisibility(View.GONE);
                    Edit_hint_altura.setVisibility(View.GONE);
                    Edit_hint_ladito.setVisibility(View.VISIBLE);
                    Imagen_hint_cuadro.setVisibility(View.GONE);
                    Imagen_hint_circulo.setVisibility(View.GONE);
                    Imagen_hint_triangulo.setVisibility(View.GONE);
                    Imagen_hint_cubo.setVisibility(View.VISIBLE);
                }
                break;
        }

    }


}

package com.example.conversordemonedasi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Ejemplo de conversor de monedas. Se dispondrá de una entrada de texto para introducir el valor a
 * convertir, otra caja de texto donde se mostrará el resultado de la conversión,
 * una lista desplegable (Spinner) para seleccionar la divisa origen, una lista desplegable (Spinner)
 * para seleccionar la divisa destino, y un botón desde el que se iniciará la conversión.
 *
 * Restricciones funcionales:
 *
 * - El botón de conversión está activo si se ha finalizado la conversión anterior, hay un valor a
 *   convertir y se ha seleccionado divisa origen y destino. La divisa origen y destino deben
 *   ser distintas.
 * - Al cambiar de divisa origen o destino se borra el resultado de la conversión anterior.
 */
public class MainActivity extends AppCompatActivity {
    private EditText etValor;
    private Spinner spUnidadOrigen;
    private Spinner spUnidadDestino;
    private TextView tvResul;
    ArrayList<Moneda> Dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etValor=findViewById(R.id.etPrimerValor);
        this.spUnidadOrigen=findViewById(R.id.spin1);
        this.spUnidadDestino=findViewById(R.id.spin2);
        this.tvResul= findViewById(R.id.tvResul);
        this.Dinero= rellenarListaMonedas();

        this.etValor.setText("1");
    }

    /**
     * Rellan la lista con las distintas divisas
     * @return ArrayList<Moneda> Devuelve la lista con las divisas disponibles
     */
    private ArrayList<Moneda> rellenarListaMonedas(){
        ArrayList<Moneda> Resul=new ArrayList<Moneda>();
        Resul.add(new Moneda("Euro €",(float)1));
        Resul.add(new Moneda("Dolar $", (float)1.10181));
        Resul.add(new Moneda("Libra £", (float)0.857531));
        Resul.add(new Moneda("Yen ¥", (float)119.758));
        return Resul;
    }

    /**
     * Método de evento para el botón convertir divisas
     * @param view Origen del evento
     */
    public void convertir(View view){
        if(etValor.getText().equals(""))
            etValor.setText("1");
        this.tvResul.setText(String.valueOf((Float.valueOf(etValor.getText().toString())
                /obtenerValor(this.spUnidadOrigen))*obtenerValor(this.spUnidadDestino)));
    }

    /**
     * Se utiliza para obtener el elemento seleccionado en cada Spinner
     * @param spin Lista con la divisa origen o destino
     * @return float Con el valor de la divisa seleccionada
     */
    private float obtenerValor(Spinner spin){
        for(int i=0;i<this.Dinero.size();i++)
            if (spin.getSelectedItem().toString().equals(this.Dinero.get(i).getNombre()))
                return this.Dinero.get(i).getValor();
         return -1;
    }
}
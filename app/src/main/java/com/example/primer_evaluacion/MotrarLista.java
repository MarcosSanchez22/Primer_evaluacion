package com.example.primer_evaluacion;

import static com.example.primer_evaluacion.MainActivity.lstPublicaciones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.primer_evaluacion.clases.Publicacion;

public class MotrarLista extends AppCompatActivity {

    ListView lsvPublicaciones;
    Context context = this;
    private int selectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motrar_lista);

        lsvPublicaciones =  findViewById(R.id.lsvPublicacion);

        ArrayAdapter<Publicacion> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lstPublicaciones);

        lsvPublicaciones.setAdapter(arrayAdapter);

        lsvPublicaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position; // Almacena la posición seleccionada
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Opciones");
                builder.setItems(new CharSequence[]{"Editar", "Eliminar"}, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // Agrega aquí la lógica para editar el elemento seleccionado

                                break;
                            case 1:
                                // Agrega aquí la lógica para eliminar el elemento seleccionado
                                eliminarPublicacion(selectedPosition);
                                arrayAdapter.notifyDataSetChanged(); // Actualiza la vista para reflejar el cambio
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    // Implementa la lógica para eliminar el elemento seleccionado
    private void eliminarPublicacion(int selectedPosition) {
        if (selectedPosition >= 0 && selectedPosition < lstPublicaciones.size()) {
            lstPublicaciones.remove(selectedPosition);
            Toast.makeText(MotrarLista.this, "Publicacion eliminada en la posición " + selectedPosition, Toast.LENGTH_SHORT).show();
        }
    }
}
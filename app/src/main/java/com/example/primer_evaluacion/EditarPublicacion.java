package com.example.primer_evaluacion;

import static com.example.primer_evaluacion.MainActivity.lstPublicaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primer_evaluacion.clases.Publicacion;

public class EditarPublicacion extends AppCompatActivity {

    EditText edtcodigoPublicacion, edttituloPublicacion, edtanioPublicacion;
    Button btnGuardar;
    int position;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_publicacion);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        edtcodigoPublicacion = findViewById(R.id.edtCodigo);
        edttituloPublicacion = findViewById(R.id.edtTitulo);
        edtanioPublicacion = findViewById(R.id.edtAnioPublicacion);
        btnGuardar = findViewById(R.id.btnProcesar);

        Publicacion publicacionEditar = (Publicacion) getIntent().getSerializableExtra("persona");
        position = getIntent().getIntExtra("position", -1);

        if (publicacionEditar != null) {
            edtcodigoPublicacion.setText(publicacionEditar.getCodigoPublicacion());
            edttituloPublicacion.setText(publicacionEditar.getTituloPublicacion());
            edtanioPublicacion.setText(String.valueOf(publicacionEditar.getAnioPublicacion()));
        }

        btnGuardar.setOnClickListener(view -> {
            // Obtener los datos editados por el usuario
            String codigo = edtcodigoPublicacion.getText().toString();
            String titulo = edttituloPublicacion.getText().toString();
            int anio = Integer.parseInt(edtanioPublicacion.getText().toString());


            // Actualizar la persona en la lista
            Publicacion publicacionActualizada = new Publicacion(publicacionEditar.getTipoPublicacion()) {
                @Override
                public int getTipoPublicacion() {
                    return 0;
                }
            };
            lstPublicaciones.set(position, publicacionActualizada);

            // Notificar que se han guardado los cambios
            Toast.makeText(EditarPublicacion.this, "Cambios guardados", Toast.LENGTH_SHORT).show();

            // Regresar a MostrarListaActivity
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
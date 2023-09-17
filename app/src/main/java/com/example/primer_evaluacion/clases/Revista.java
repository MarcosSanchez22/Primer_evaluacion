package com.example.primer_evaluacion.clases;

public class Revista extends Publicacion {
    private int numeroRevista;

    public Revista() {
        super(publicacionEditar.getTipoPublicacion());
    }

    public Revista(int codigoPublicacion,
                   String tituloPublicacion,
                   int anioPublicacion,
                   int numeroRevista) {
        super(codigoPublicacion,
                tituloPublicacion,
                anioPublicacion);
        this.numeroRevista = numeroRevista;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    @Override
    public int getTipoPublicacion() {
        return 2;
    }

}

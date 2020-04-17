package com.ESDP.x00136319;


import java.util.ArrayList;

abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        documentos = new ArrayList<>();
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }

    public void addDocumento(Documento d){
        //JEJE
    }
    public void removeDocumento(String nombreDocumentoRemover){
        //JEJE
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract String toString();
}

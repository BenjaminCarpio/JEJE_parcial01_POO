package com.BECQx00205619;
public class PlazaFija extends Empleado {
    private int extension;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Tipo contrato: PlazaFija {" +
                "Nombre: '" + nombre + '\'' +
                ", Puesto: '" + puesto + '\'' +
                ", Salario: $" + salario +
                ", Documentos: " + documentos.toString() +
                ", Extension: " + extension +
                " }\n";
    }
}

package com.ESDP.x00136319;

import java.util.ArrayList;

public class ServicioProfesional extends Empleado{
    private int mesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public String toString() {

        return "Tipo contrato: ServicioProfecional {" +
                "Nombre: '" + nombre + '\'' +
                ", Puesto: '" + puesto + '\'' +
                ", Salario: $" + salario +
                ", Documentos: " + documentos.toString() +
                ", DuracionContrato: " + mesesContrato + " meses" +
                " }\n";
    }
}

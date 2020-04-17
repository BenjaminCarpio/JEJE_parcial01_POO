package com.ESDP.x00136319;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        planilla = new ArrayList<>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado Persona) {
        planilla.add(Persona);

    }

    public void quitEmpleado(String nombreDespedir) {
        if (planilla == null) {
            System.out.println("No hay empleados en la planilla");
        }else{
            Empleado aux = null;
            for (Empleado nombre : planilla) {
                if(nombre.getNombre().equalsIgnoreCase(nombreDespedir)) ;
                aux = nombre;
            }
            planilla.remove(aux);
        }
    }
}
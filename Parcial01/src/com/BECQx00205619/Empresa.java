package com.BECQx00205619;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scan =  new Scanner(System.in);
        int contador = 0;
        String opcion = "";
        if (planilla == null) {
            System.out.println("No hay empleados en la planilla");
        } else {
            Empleado aux = null;
            for (Empleado nombre : planilla) {
                if (nombre.getNombre().equalsIgnoreCase(nombreDespedir)) {
                    aux = nombre;
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.println("El empleado " + nombreDespedir + " no se encuentra en la planilla");
            } else if (contador == 1) {
                planilla.remove(aux);
                System.out.println("El empleado ha sido despedido, volviendo al menu....\n");
            } else if (contador > 1) {
                System.out.println("Hay mas de 1 empleado con ese nombre, favor especifique cual empleado de nombre" + nombreDespedir + " es quien desea eliminar.");
                for (Empleado nombre : planilla) {
                    if (nombre.getNombre().equalsIgnoreCase(nombreDespedir)) {
                        System.out.println(nombre + "\n Es este el empleado que desea eliminar? (S/N)");
                        opcion = scan.nextLine();
                        if(opcion.equalsIgnoreCase("s")) {
                            aux = nombre;
                            planilla.remove(aux);
                            System.out.println("El empleado ha sido despedido, volviendo al menu....\n");
                            break;
                        }else
                            System.out.println("\nBuscando siguiente empleado....\n");
                        }
                    }
                }
            }
        }
    }
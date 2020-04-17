package com.ESDP.x00136319;

//Benjamin Carpio 00205619
//Eduardo Dominguez 00136319
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Empresa empresa = new Empresa("JEJE Company");

    public static void main(String[] args) throws InvalidOptionInMenu {
        String MenuPrincipal = "1) Agregar empleado\n" +
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n" +
                "6) Salir\n";

        boolean continuar = true;
        do {
            System.out.println(MenuPrincipal);
            int opc = scan.nextInt();
            scan.nextLine();
            switch (opc) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    despedirEmpleado();
                    break;
                case 3:
                    System.out.println("Mostrando plantilla de la empresa: \n");
                    System.out.println(empresa.getPlanilla());
                    break;
                case 4:
                case 5:
                case 6:
                    System.out.println("Saliendo del programa.....");
                    continuar = false;
                    break;
                default:
                    throw new IllegalStateException("Opcion elegida: " + opc + "No se encuentra entre las opciones validas");
            }
        } while (continuar);

    }

    public static void agregarEmpleado() throws InvalidOptionInMenu {
        String nombre, puesto;
        double salario;
        int mesesContrato, extension, opcion;

        System.out.println("Ingrese los datos del empleado a continuacion:");
        System.out.println("1. Contratar un Servicio Profesional\n2. Contratar una plaza fija\n3. Regresar");
            opcion = scan.nextInt(); scan.nextLine();

        System.out.print("Nombre:");
            nombre = scan.nextLine();
        System.out.print("Puesto:");
            puesto = scan.nextLine();
        System.out.print("Indique el salario que se le otorgara al empleado:");
            salario = scan.nextDouble();    scan.nextLine();

        try {
            if (opcion == 1) {
                System.out.print("Indique la duracion del contrato en meses:");
                    mesesContrato = scan.nextInt(); scan.nextLine();
                empresa.addEmpleado(new ServicioProfesional(nombre, puesto, salario, mesesContrato));
            } else if (opcion == 2) {
                System.out.print("Indique la extension del telefono:");
                    extension = scan.nextInt(); scan.nextLine();
                empresa.addEmpleado(new PlazaFija(nombre, puesto, salario, extension));
            } else if(opcion == 3){
                return;
            }else{
                throw new InvalidOptionInMenu("\nOpcion invalida, intente nuevamente");
            }
        }catch (InvalidOptionInMenu e){
            System.out.println("\nLa opcion ingresada no es valida.\n");
            return;
        }
    }

    public static void despedirEmpleado(){
        String nombre, op1;

        System.out.println("Desea ver la planilla antes de proceder con el despido del empleado? S/N ");
        op1 = scan.nextLine();

        if(op1.equalsIgnoreCase("S")){
            System.out.println("Mostrando plantilla de la empresa: \n");
            System.out.println(empresa.getPlanilla());

            System.out.println("Ingrese el nombre del empleado a despedir");
            nombre = scan.nextLine();
            empresa.quitEmpleado(nombre);

        }else if(op1.equalsIgnoreCase("N")){
            System.out.println("Ingrese el nombre del empleado a despedir");
            nombre = scan.nextLine();
            empresa.quitEmpleado(nombre);
        }else
            System.out.println("Ingrese opcion valida");
    }
 }

package com.ESDP.x00136319;

//Benjamin Carpio 00205619
//Eduardo Dominguez 00136319
import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Empresa company = new Empresa("JEJE Company");


    public static void main(String[] args) throws InvalidOptionInMenu {
        String MenuPrincipal = "1) Agregar empleado\n" +
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n" +
                "6) Salir\n";

        boolean continuar = true;
        do {
            //int opc = Integer.parseInt(JOptionPane.showInputDialog(null, MenuPrincipal));
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
                    //JOptionPane.showMessageDialog(null, "Mostrando planilla de la empresa:" );

                    System.out.println("Mostrando planilla de la empresa: \n");
                    //JOptionPane.showMessageDialog(null, company.getPlanilla());
                    System.out.println(company.getPlanilla());
                    break;
                case 4:
                    ConsultarSueldo();
                    break;
                case 5:
                    System.out.println(CalculadoraImpuestos.mostrarTotales());
                    break;
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
        Empleado employee = null;
        Documento document = null;
        String nombre, puesto, nombreDocumento, numeroDocumento;
        double salario;
        boolean continuar = true;
        int mesesContrato, extension, opcion, cantDocumentos;

        System.out.println("Ingrese los datos del empleado a continuacion:");
        System.out.println("1. Contratar un Servicio Profesional\n2. Contratar una plaza fija\n3. Regresar");
        opcion = scan.nextInt(); scan.nextLine();


        try {
            if (opcion == 1) {
                System.out.print("Nombre:");
                nombre = scan.nextLine();
                System.out.print("Puesto:");
                puesto = scan.nextLine();
                System.out.print("Indique el salario que se le otorgara al empleado:");
                salario = scan.nextDouble();    scan.nextLine();
                System.out.print("Indique la duracion del contrato en meses:");
                    mesesContrato = scan.nextInt(); scan.nextLine();
                    employee =new ServicioProfesional(nombre,puesto,salario,mesesContrato);
                System.out.println("Cuantos documentos desea agregar? (Minimo 1)");
                do {
                    cantDocumentos = scan.nextInt(); scan.nextLine();
                    if (cantDocumentos < 1) {
                        System.out.println("Minimo 1 documento");
                    } else if(cantDocumentos >= 1) {
                        for(int i = 0; i< cantDocumentos; i++ ){
                            System.out.print("Ingrese el nombre del documento:\n");
                            nombreDocumento = scan.nextLine();
                            System.out.print("Ingrese el numero del documento:\n");
                            numeroDocumento = scan.nextLine();
                            document = new Documento(nombreDocumento, numeroDocumento);
                            employee.addDocumento(document);
                        }
                        continuar = false;
                    }
                }while(continuar);
                    company.addEmpleado(employee);
            } else if (opcion == 2) {
                System.out.print("Nombre:");
                nombre = scan.nextLine();
                System.out.print("Puesto:");
                puesto = scan.nextLine();
                System.out.print("Indique el salario que se le otorgara al empleado:");
                salario = scan.nextDouble();    scan.nextLine();
                System.out.print("Indique la extension del telefono:");
                    extension = scan.nextInt(); scan.nextLine();
                employee =new PlazaFija(nombre,puesto,salario,extension);
                System.out.println("Cuantos documentos desea agregar? (Minimo 1)");
                do {
                    cantDocumentos = scan.nextInt(); scan.nextLine();
                    if (cantDocumentos < 1) {
                        System.out.println("Minimo 1 documento");
                    } else if(cantDocumentos >= 1) {
                        for(int i = 0; i< cantDocumentos; i++ ){
                            System.out.print("Ingrese el nombre del documento:\n");
                            nombreDocumento = scan.nextLine();
                            System.out.print("Ingrese el numero del documento:\n");
                            numeroDocumento = scan.nextLine();
                            document = new Documento(nombreDocumento, numeroDocumento);
                            employee.addDocumento(document);
                        }
                        continuar = false;
                    }
                }while(continuar);
                    company.addEmpleado(employee);
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
            System.out.println(company.getPlanilla());

            System.out.println("Ingrese el nombre del empleado a despedir");
            nombre = scan.nextLine();
            company.quitEmpleado(nombre);

        }else if(op1.equalsIgnoreCase("N")){
            System.out.println("Ingrese el nombre del empleado a despedir");
            nombre = scan.nextLine();
            company.quitEmpleado(nombre);
        }else
            System.out.println("Ingrese opcion valida");
    }

    public static void ConsultarSueldo(){
        String nombreCalcular= " ", opcion;
        System.out.println("Calcular sueldo del empleado\n");
        int contador = 0;

        //Mostramos lista para posteriormente que ingrese el nombre del empleado al que se le calculara el sueldo
        System.out.println("Mostrando plantilla de la empresa: \n");
        System.out.println(company.getPlanilla());
        //POR SI SON 2 CON MISMO NOMBRE
        System.out.println("Escriba el nombre del empleado al cual quiere calcular su sueldo liquido");
        nombreCalcular = scan.nextLine();

        if (company.getPlanilla() == null) {
            System.out.println("No hay empleados en la planilla");
        } else {
            Empleado aux = null;
            for (Empleado nombre : company.getPlanilla() ) {
                if (nombre.getNombre().equalsIgnoreCase(nombreCalcular)) {
                    aux = nombre;
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.println("El empleado " + nombreCalcular + " no se encuentra en la planilla");
            } else if (contador == 1) {
                System.out.print("Sueldo final: $");
                System.out.println(CalculadoraImpuestos.calcularPago(aux));
                System.out.println("Se ha pagado correctamente, volviendo al menu....\n");

            } else if (contador > 1) {
                System.out.println("Hay mas de 1 empleado con ese nombre, favor especifique cual empleado de nombre" + nombreCalcular + " escogera.");
                for (Empleado nombre : company.getPlanilla() ) {
                    if (nombre.getNombre().equalsIgnoreCase(nombreCalcular)) {
                        System.out.println(nombre + "\n Es este el empleado que quiere escoger? (S/N)");
                        opcion = scan.nextLine();
                        if(opcion.equalsIgnoreCase("s")) {
                            aux = nombre;
                            System.out.print("Sueldo final: $");
                            System.out.println(CalculadoraImpuestos.calcularPago(aux));
                            System.out.println("Se ha pagado correctamente, volviendo al menu....\n");
                            break;
                        }else
                            System.out.println("\nBuscando siguiente empleado....\n");
                    }
                }
            }
        }
    }
 }

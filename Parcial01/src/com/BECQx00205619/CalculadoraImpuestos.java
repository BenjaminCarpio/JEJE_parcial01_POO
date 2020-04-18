package com.ESDP.x00136319;

public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos() { }


    public static double calcularPago(Empleado Persona){
        double pagofinal = 0;

        if(Persona instanceof PlazaFija){
            //Calcula los totales
            totalAFP += Persona.getSalario() * 0.0625;
            totalISSS += Persona.getSalario() * 0.03;
            //Calcula los impuestos
            double AFP = Persona.getSalario() * 0.0625;
            double ISSS = Persona.getSalario() * 0.03;
            //Saca el restante
            double restante = Persona.getSalario() - AFP - ISSS;

            //Calcular la renta con base al restante
            double renta = 0;
            if(restante >= 0.01 && restante <= 472.00) //Rango A
                totalRenta += 0;
            else if(restante >= 472.01 && restante <= 895.24){ //Rango B
                totalRenta += 0.1*(restante - 472) + 17.67;
                renta = 0.1*(restante - 472) + 17.67;
            }
            else if(restante >= 895.25 && restante <= 2038.10){ //Rango C
                totalRenta += 0.2*(restante - 895.24) + 60;
                renta = 0.2*(restante - 895.24) + 60;
            }
            else if(restante >= 2038.11){ //Rango D
                totalRenta += 0.3*(restante - 2038.10) + 288.57;
                renta = 0.3*(restante - 2038.10) + 288.57;
            }
            pagofinal = restante - renta;

        }else if(Persona instanceof ServicioProfesional){
            //Calcula total Renta
            totalRenta += Persona.getSalario() * 0.1;
            //Calcula el impuesto
            double renta = Persona.getSalario() * 0.1;
            //Retorna el salario del empleado
            pagofinal = Persona.getSalario() - renta;

        }
        return pagofinal;
    }

    public static String mostrarTotales(){
        System.out.println("Mostrando Totales:5\n");
      return "Total renta: $"+ totalRenta +
              "\nTotal ISSS: $"+ totalISSS +
              "\nTotal AFP: $" + totalAFP+"\n";
    }
}

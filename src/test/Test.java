package test;

import java.time.LocalDate;

import modelos.SistemaEstacionamiento;

public class Test {

	public static void main(String[] args) {
		SistemaEstacionamiento sistema = new SistemaEstacionamiento();
		// 1) Agregar e imprimir los vehículos
        System.out.println("1)");
        try {
            sistema.agregarVehiculo("AAA111", "Auto", 11111111);
            sistema.agregarVehiculo("AAA222", "Auto", 22222222);
            sistema.agregarVehiculo("CCC333", "Camioneta", 33333333);
            sistema.agregarVehiculo("CCC444", "Camioneta", 44444444); //
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        System.out.println(sistema.getLstVehiculos());
        
     // 2) Agregar e imprimir los lugares
        System.out.println("2)");
        try {
            sistema.agregarLugar(1, 100);
            sistema.agregarLugar(1, 101);
            sistema.agregarLugar(1, 102);
            sistema.agregarLugar(1, 103);
            sistema.agregarLugar(2, 200);
            sistema.agregarLugar(2, 201);
            sistema.agregarLugar(2, 202);
            sistema.agregarLugar(2, 203);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sistema.getLstLugares());
        
     // 3) Agregar e imprimir ocupaciones
        System.out.println("3)");
        try {
            sistema.agregarOcupacion(
                sistema.traerLugar(1, 102),
                sistema.traerVehiculo("AAA111"),
                LocalDate.of(2025, 8, 29)
            );
            sistema.agregarOcupacion(
                sistema.traerLugar(2, 201),
                sistema.traerVehiculo("CCC444"),
                LocalDate.of(2025, 9, 3)
            );
            sistema.agregarOcupacion(
                sistema.traerLugar(1, 100),
                sistema.traerVehiculo("AAA222"),
                LocalDate.of(2025, 9, 12)
            );
            sistema.agregarOcupacion(
                sistema.traerLugar(2, 203),
                sistema.traerVehiculo("CCC444"),
                LocalDate.of(2025, 9, 14)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sistema.getLstOcupacion());
       			
     // 4) Marcar salidas de vehículos
        System.out.println("4)");
        boolean salida1 = sistema.marcarSalida(
            sistema.traerVehiculo("AAA111"),
            LocalDate.of(2025, 9, 2)
        );
        System.out.println("Salida AAA111 marcada: " + salida1);

        boolean salida2 = sistema.marcarSalida(
            sistema.traerVehiculo("CCC444"),
            LocalDate.of(2025, 9, 15)
        );
        System.out.println("Salida CCC444 marcada: " + salida2);

        
        System.out.println(sistema.getLstOcupacion());
        
     // 5) traer e imprimir las Ocupaciones que hayan ingresado entre 2025-09-01 y 2025-09-12
        System.out.println("5)");
        System.out.println(
            sistema.traerOcupacionesPorFechaIngreso(
                LocalDate.of(2025, 9, 1),
                LocalDate.of(2025, 9, 12)
            )
        );
        
        // 6) traer e imprimir los vehículos que se encuentran estacionados actualmente (sin fecha de salida)
        System.out.println("6)");
        System.out.println(sistema.traerVehiculosEstacionadosActuales());

        // 7) traer e imprimir las Ocupaciones de vehículos del tipo "Camioneta"
        System.out.println("7)");
        System.out.println(sistema.traerOcupacionesPorTipoVehiculo("Camioneta"));

        // 8) intentar agregar el siguiente vehículo
        System.out.println("8)");
        try {
            sistema.agregarVehiculo("CCC333", "Camioneta", 3333333);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sistema.getLstVehiculos());

        // 9) intentar agregar la siguiente Ocupación
        System.out.println("9)");
        try {
            sistema.agregarOcupacion(
                sistema.traerLugar(1, 100),
                sistema.traerVehiculo("AAA222"),
                LocalDate.of(2025, 9, 12)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sistema.getLstOcupacion());
    }

	}



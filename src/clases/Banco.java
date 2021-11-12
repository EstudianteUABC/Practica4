package clases;

import java.util.LinkedList; //Se importa la clase lista enlazada
import clases.Cuenta;
import clases.Entrada;

public class Banco {
	
	//Lista enlazada, se usa para almacenar las cuentas
	private LinkedList<Cuenta> cuentas = new LinkedList<Cuenta>();
	
	
	//crea una nueva cuenta
	public void crearCuenta(){
		String nombre = Entrada.cadena( "Ingrese su nombre completo: " );
		int saldo = Entrada.entero( "Ingrese su saldo inicial: " );
		
		String pin = Entrada.cadena( "Ingrese su pin de 4 caracteres: " );
		
		//verifica que el pin tenga 4 caracteres
		while( pin.length() != 4 ) {
			System.out.println( "El pin no tiene 4 caracteres, intente de nuevo." );
			pin = Entrada.cadena( "Ingrese su pin de 4 caracteres: " );
		}
		
		Cuenta nuevaCuenta = new Cuenta( nombre, saldo, pin ); //se crea un objeto temporal con los datos de la nueva cuenta
		cuentas.add( nuevaCuenta ); //se agrega la cuenta a la lista enlazada
	}
	
	//imprime una lista de las cuentas disponibles
	public void imprimirCuentas() {
		for( int i = 0; i < cuentas.size(); i++ ) {
			System.out.println( ( i + 1 ) + ": " + cuentas.get(i).getNombre() );
		}
	}
	
	//accede a una cuenta en especifico
	public void accederCuenta() {
		imprimirCuentas();
		int noCuenta = Entrada.entero( "Ingrese el numero de cuenta: " );
		
		noCuenta -= 1; //resta 1 para empezar a buscar desde el elemento 0
		
		//verifica que se ingrese un numer de cuenta valido
		while( noCuenta < 0 || noCuenta >= cuentas.size() ) {
			System.out.println( "Numero de cuenta invalido, intente de nuevo." );
			noCuenta = Entrada.entero( "Ingrese el numero de cuenta: " );
		}
		
		String pin = Entrada.cadena( "Ingrese el pin: " );
		
		//si se ingresa un pin valido se muestran las opciones diponibles
		if( pin.equals( cuentas.get( noCuenta ).getPin() ) ) {
			boolean flag = true;
			
			do {
				System.out.println("\n1) Consultar cantidad:" );
				System.out.println("2) Depositar:" );
				System.out.println("3) Retirar:" );
				System.out.println("4) Salir:" );
				
				int opcion = Entrada.entero( "Seleccione una opcion: " );
				
				switch( opcion ) {
					case 1: //consulta saldo
						System.out.println( "Su saldo es: " + cuentas.get( noCuenta ).getSaldo() );
						break;
					
					case 2: //deposita una cantidad
						System.out.println( "Su saldo es: " + cuentas.get( noCuenta ).getSaldo() );
						
						int deposito = Entrada.entero( "Ingrese cantidad a depositar: " );
						cuentas.get( noCuenta ).depositar( deposito );
						
						System.out.println( "Su nuevo saldo es: " + cuentas.get( noCuenta ).getSaldo() );
						break;
						
					case 3: //retira una cantidad
						System.out.println( "Su saldo es: " + cuentas.get( noCuenta ).getSaldo() );
						
						int retiro = Entrada.entero( "Ingrese cantidad a retirar: " );
						cuentas.get( noCuenta ).retirar( retiro );
						
						System.out.println( "Su nuevo saldo es: " + cuentas.get( noCuenta ).getSaldo() );
						break;
						
					case 4: //sale de las opciones
						flag = false;
						break;	
				}
			}while( flag );
		}
		
		else {
			System.out.println( "Pin incorrecto." );
		}
	}
	
	//Elimina la cuenta seleccionada
	public void eliminarCuenta() {
		imprimirCuentas();
		int noCuenta = Entrada.entero( "Ingrese el numero de cuenta: " );
		
		noCuenta -= 1; //resta 1 para empezar a buscar desde el elemento 0
		
		//verifica que se ingrese un numer de cuenta valido
		while( noCuenta < 0 || noCuenta >= cuentas.size() ) {
			System.out.println( "Numero de cuenta invalido, intente de nuevo." );
			noCuenta = Entrada.entero( "Ingrese el numero de cuenta: " );
		}
		
		cuentas.remove( noCuenta );
		
		System.out.println( "Se elimino la cuenta" );
	}
}

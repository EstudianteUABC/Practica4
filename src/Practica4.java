import clases.Entrada;
import clases.Banco;

public class Practica4 {
	public static void main(String[] args) {
		
		Banco miBanco = new Banco(); //objeto de la clase banco
		
		boolean flag = true; //verifica la continuacion del ciclo
		
		do {
			System.out.println("\n1) Crear cuenta." );
			System.out.println("2) Acceder a una cuenta." );
			System.out.println("3) Ver cuentas existentes." );
			System.out.println("4) Eliminar cuenta." );
			System.out.println("5) Salir." );
			
			//menu de opciones
			int opcion = Entrada.entero( "Seleccione una opcion: " );
			
			switch( opcion ) {
				case 1: 
					miBanco.crearCuenta();
					break;
				
				case 2:
					miBanco.accederCuenta();
					break;
					
				case 3: 
					miBanco.imprimirCuentas();
					break;
					
				case 4:
					miBanco.eliminarCuenta();
					break;	
					
				case 5:
					flag = false;
					break;
			}
		}while( flag );
	}
}

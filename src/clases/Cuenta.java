package clases;

public class Cuenta {
	private String nombre;
	private int saldo;
	private String pin;
	
	//constructor predeterminado
	public Cuenta(){
		nombre = "";
		saldo = 0;
		pin = "";
	}
	
	//constructor con parametros
	public Cuenta( String nombre, int saldo, String pin ) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.pin = pin;
	}
	
	//establece el nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//establece el saldo
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	//establece el pin
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	//obtiene el nombre
	public String getNombre() {
		return nombre;
	}
	
	//obtiene el saldo
	public int getSaldo() {
		return saldo;
	}
	
	//obtiene el pin
	public String getPin() {
		return pin;
	}
	
	//retira una cantidad de dinero
	public void retirar( int cantidad ) {
		if( saldo - cantidad < 0 )
			System.out.println( "Cuidado! \nNo tiene esa cantidad de dinero en su cuenta!");
		
		else
			saldo -= cantidad;  //se actualiza el saldo
	}
	
	public void depositar( int cantidad ) {
		saldo += cantidad;
	}
}

import java.util.Random;
public class CuentaBancaria{
    
    private String nombre;
    private double saldoCuentaCorriente;
    private double saldoAhorros;
    private static int numeroCuentas=0;
    private static double cantidadTotalDinero;
    private String numeroDeCuenta;
    
    //definiendo el constructor 
    public CuentaBancaria(String nombre){
        this.nombre = nombre;
        this.numeroDeCuenta = generadorCuentas();
        this.saldoCuentaCorriente = 0.0;
        this.saldoAhorros = 0.0;
        this.cantidadTotalDinero = 0.0; 
        numeroCuentas++;
    }
    //definiendo los getters 
    public String getNombre(){
        return this.nombre;
    } 

    public double getSaldoCuentaCorriente(){
        return this.saldoCuentaCorriente;
    }

    public double getSaldoAhorros(){
        return this.saldoAhorros;
    }

    public String getNumeroDeCuenta(){
        return this.numeroDeCuenta;
    }
    //definiendo los setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setSaldoCuentaCorriente(double saldoCuentaCorriente){
        this.saldoCuentaCorriente = saldoCuentaCorriente;
    }

    public void setSaldoAhorros(double saldoAhorros){
        this.saldoAhorros = saldoAhorros;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }

    // definiendo un metodo privado para generar un cuenta de 10 digitos 
    private String generadorCuentas(){
        String cuenta="";
        String numeros[]={"0","1","2","3","4","5","6","7","8","9"};
        Random indice = new Random();
        
        for(int i = 0; i<10; i++){
            int ind = indice.nextInt(10);
            cuenta = cuenta + numeros[ind];
        }
        return cuenta;
    }
    //definiendo el metodo depositar cuenta corriente->1 y cuenta de ahorros->2
    public double depositarDinero( double monto , int tipoCuenta){
        if( tipoCuenta == 1){
            saldoCuentaCorriente += monto;
            cantidadTotalDinero = saldoCuentaCorriente + saldoAhorros;  
        }
        else{
            saldoAhorros += monto;
            cantidadTotalDinero = saldoCuentaCorriente + saldoAhorros;
        }
        return cantidadTotalDinero;
    }

    //definiendo el metodo retirar 
    public double retirarDinero( double monto, int tipoCuenta){
        
        if( tipoCuenta == 1){
            if( saldoCuentaCorriente > 0){
                this.saldoCuentaCorriente -= monto;
                this.cantidadTotalDinero = this.saldoCuentaCorriente + this.saldoAhorros;
            }
            else{
                System.out.println("Saldo insuficiente en la cuenta corriente, no puedes retirar");
            }
        }   
        else{
            if(saldoAhorros > 0){
                this.saldoCuentaCorriente -= monto;
                this.cantidadTotalDinero = this.saldoCuentaCorriente + this.saldoAhorros;
            }
            else {
                System.out.println("Saldo insuficiente en la cuenta de ahorros, no se puede retirar");
            }
        }
        return cantidadTotalDinero;
    }

    //Definiendo el metodo de dinero total 
    public String mostrarDinero(){
        return "Nombre del cliente: " + this.nombre + "\n"+
               "saldo Cuenta Corriente : " + this.saldoCuentaCorriente + "\n"+
               "Saldo Cuenta Ahorros : " + this.saldoAhorros;
    }
}
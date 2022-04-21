public class TestCuentaBancaria{
    public static void main(String args[]){
        //definiendo las cuentas bancarias 
        CuentaBancaria cuenta1 = new CuentaBancaria("Alexander");
        CuentaBancaria cuenta2 = new CuentaBancaria("Carlos");

        //aplicamos el metodo depositar 

        cuenta1.depositarDinero(200.0,1);
        cuenta1.retirarDinero(200.0,2);
        cuenta1.mostrarDinero();
        System.out.println(cuenta1.mostrarDinero());
        System.out.println("Numero de cuenta: " + cuenta1.getNumeroDeCuenta());
        System.out.println(cuenta2.mostrarDinero());
        System.out.println("Numero de cuenta: " + cuenta2.getNumeroDeCuenta());
            }
}
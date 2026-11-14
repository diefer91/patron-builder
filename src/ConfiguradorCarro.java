public class ConfiguradorCarro implements IConfiguradorCarro {

    //Necesitamos crear estas variables debido al requerimiento de inmutabilidad
    //de las variables del objeto Carro. Si ese no fuera un requerimiento, podríamos declarar
    //directamente una variable de tipo Carro, e ir configurando sus propiedades en cada uno de los
    //métodos respectivos declarados aquí. Sin embargo debido a que las propiedades de Carro son
    //privadas, no lo podemos hacer, el único lugar donde podemos configurar dichas propiedades es
    //en su constructor
    private Carro.TipoCarroceria carroceria;
    private Carro.Pintura pintura;
    private Carro.Motor motor;
    private Carro.Rin rin;
    private boolean tieneGPS = false;

    public ConfiguradorCarro() {
    }

    @Override
    public void configurarPintura(Carro.Pintura pintura) {
        this.pintura = pintura;
    }

    @Override
    public void configurarRin(Carro.Rin rin) {
        this.rin = rin;
    }

    @Override
    public void configurarMotor(Carro.Motor motor) {
        this.motor = motor;
    }

    @Override
    public void agregarGPS(boolean agregar) {
        this.tieneGPS = agregar; }

    @Override
    public void configurarCarroceria(Carro.TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public void resetearConfiguracion() {
        this.carroceria = null;
        this.pintura = null;
        this.motor = null;
        this.rin = null;
        this.tieneGPS = false;
    }

    @Override
    public Carro confirmarCarro() {
        return new Carro(this.carroceria, this.pintura, this.motor, this.rin, this.tieneGPS);
    }
}

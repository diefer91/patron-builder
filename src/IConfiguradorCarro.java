/*Imagina que estás desarrollando una aplicación para una compañía automotriz que permite
a los clientes personalizar y ordenar un automóvil. Un objeto Automóvil puede tener muchas
configuraciones opcionales: tipo de motor, color, llantas, sistema de sonido, interiores,
techo solar, navegación GPS, etc.
 */

public interface IConfiguradorCarro {

    void configurarCarroceria(Carro.TipoCarroceria carroceria);
    void configurarPintura(Carro.Pintura pintura);
    void configurarRin(Carro.Rin rin);
    void configurarMotor(Carro.Motor motor);
    void agregarGPS(boolean agregar);
    void resetearConfiguracion();
    Carro confirmarCarro();
}

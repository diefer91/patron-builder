public class Main {
     static void main(String[] args) {

         //El cliente ingresa a la plataforma de configuración del carro, mediante la cuál puede
         //acceder a configuraciones predeterminadas, o puede usar el configurador personalizado
         //para configurar el carro a su gusto
         PlataformaConfiguracion plataformaConfiguracion = new PlataformaConfiguracion(new ConfiguradorCarro());

         //El cliente selecciona las tres configuraciones ya predeterminadas
         //(tiene dinero de sobra para gastar!)
         Carro carroEconomico = plataformaConfiguracion.configurarCarroEconomico();
         Carro carroGamaMedia = plataformaConfiguracion.configurarCarroGamaMedia();
         Carro carroGamaAlta = plataformaConfiguracion.configurarCarroGamaAlta();

         System.out.println("El usuario configuró un carro económico: " + carroEconomico);
         System.out.println("El usuario configuró un carro gama media: " + carroGamaMedia);
         System.out.println("El usuario configuró un carro gama alta: " + carroGamaAlta);

         //El cliente configura un carro adicional usando el configurador personalizado
         ConfiguradorCarro configuradorPersonalizado = plataformaConfiguracion.configuradorPersonalizado();
         configuradorPersonalizado.configurarPintura(Carro.Pintura.AZUL_SIMPLE);
         configuradorPersonalizado.configurarRin(Carro.Rin.R20);
         configuradorPersonalizado.configurarMotor(Carro.Motor.V12);
         configuradorPersonalizado.agregarGPS(true);
         configuradorPersonalizado.configurarCarroceria(Carro.TipoCarroceria.HASHBACK);
         Carro carroPersonalizado = configuradorPersonalizado.confirmarCarro();
         System.out.println("El usuario configuró un carro personalizado: " + carroPersonalizado);

         //El usuario no puede modificar las variables del carro (Ya que fueron declaradas como private) lo cuál cumple con el requisito de
         //"una vez creado el objeto, las variables no se pueden modificar"
         //carroPersonalizado.motor = Carro.Motor.V6; Esta línea produce error
         //Lo único que podemos hacer una vez creado el objeto es acceder a sus variables a través de los respectivos getters
         carroPersonalizado.getMotor();
         carroEconomico.getPintura();
     }
}

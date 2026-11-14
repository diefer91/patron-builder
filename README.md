# Patrón Builder: configurador de carro

Este es un proyecto básico en Java para practicar el patrón Builder. La idea es configurar algunas características del carro (Como si estuviéramos en una página web configurando un carro que queremos comprar),escogiendo el motor, la pintura, la carrocería, los rines y si tiene GPS.

También hay tres configuraciones ya definidas: económico, gama media y gama alta. Además, se puede crear un carro personalizado.

## Contenido del proyecto

- **Carro.java:** representa el carro y guarda sus características. Sus atributos son privados y finales, por lo que no se pueden cambiar después de crear el objeto. Los valores se consultan por medio de getters.
- **IConfiguradorCarro.java:** interfaz con los métodos necesarios para configurar un carro.
- **ConfiguradorCarro.java:** implementa la interfaz anterior. Guarda las opciones elegidas y crea el carro con el método `confirmarCarro()`. También permite borrar la configuración con `resetearConfiguracion()`.
- **PlataformaConfiguracion.java:** usa el configurador para crear los carros económico, de gama media y de gama alta. También entrega un configurador para hacer un carro personalizado.
- **Main.java:** contiene un ejemplo de uso. Crea los diferentes carros y muestra sus características por consola.

## Idea principal

Primero se escogen las características en el configurador. Después, `confirmarCarro()` crea el objeto `Carro` con esos valores. Así se separa la configuración del carro de la clase que representa el carro.

Para probar el proyecto, se puede abrir en IntelliJ IDEA y ejecutar la clase `Main`.

## Diagrama de clase

```mermaid
classDiagram

    class Motor {
        <<enumeration>>
        V6
        V8
        V12
    }

    class Pintura {
        <<enumeration>>
        ROJO_ULTRA
        AZUL_SIMPLE
        NEGRO_PERLADO
    }

    class TipoCarroceria {
        <<enumeration>>
        SEDAN
        HASHBACK
    }

    class Rin {
        <<enumeration>>
        R16
        R18
        R20
    }
    
    class Carro {
        <<Producto>>
        ~Carro(TipoCarroceria,Pintura,Motor,Rin,boolean)
        -TipoCarroceria carroceria
        -Pintura pintura
        -Motor motor
        -Rin rin
        -boolean tieneGPS
        +getCarroceria() TipoCarroceria
        +getPintura() Pintura
        +getMotor() Motor
        +getRin() Rin
        +tieneGPS() boolean
    }

    class ConfiguradorCarro {
        <<ConcreteBuilder>>
        -TipoCarroceria carroceria
        -Pintura pintura
        -Motor motor
        -Rin rin
        -boolean tieneGPS = false
        +configurarCarroceria(TipoCarroceria) void
        +configurarPintura(Pintura) void
        +configurarRin(Rin) void
        +configurarMotor(Motor) void
        +agregarGPS(boolean) void
        +resetearConfiguracion() void
        +confirmarCarro() Carro
        
    }

    class IConfiguradorCarro {
        <<interface>>
        +configurarCarroceria(TipoCarroceria) void
        +configurarPintura(Pintura) void
        +configurarRin(Rin) void
        +configurarMotor(Motor) void
        +agregarGPS(boolean) void
        +resetearConfiguracion() void
        +confirmarCarro() Carro
    }

    class PlataformaConfiguracion {
        <<Director>>
        -ConfiguradorCarro configurador
        +PlataformaConfiguracion(ConfiguradorCarro)
        +configurarCarroEconomico() Carro
        +configurarCarroGamaMedia() Carro
        +configurarCarroGamaAlta() Carro
        +configuradorPersonalizado() ConfiguradorCarro
    }
    
    class Main {
        <<Cliente>>
        +main(String[] args)$ void
        
    }

    Carro --> Motor
    Carro --> Pintura
    Carro --> TipoCarroceria 
    Carro --> Rin
    
    ConfiguradorCarro ..|> IConfiguradorCarro 
    ConfiguradorCarro ..> Carro 
    PlataformaConfiguracion o-- ConfiguradorCarro : crea
    
    Main ..> ConfiguradorCarro
    Main ..> PlataformaConfiguracion


```
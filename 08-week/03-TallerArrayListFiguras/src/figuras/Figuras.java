package figuras;

// Clase abstracta base para todas las figuras
abstract class Figura {
    String color;

    public Figura(String color) {
        this.color = color;
    }
    // Metodos abstractos ya que daca figura debe implementar su propio calculo
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public void mostrarInformacion() {
        System.out.println("El color de la figura es: " + color);// este metodo imprime informacion comun
    }
}

// Clase Circulo
class Circulo extends Figura {
    double radio;

    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio; // constructor que incializa radio y al constructor de la figura
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }                                       //implementacion de calculos y de imprimir la informacion

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("El radio del circulo es: " + radio);
        System.out.println("El area del circulo es: " + calcularArea());
        System.out.println("El perimetro del circulo es: " + calcularPerimetro());
        System.out.println("__________________________________________________________: ");

    }
}

// Clase Rectangulo
class Rectangulo extends Figura {
    double base;
    double altura;

    public Rectangulo(double base, double altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("La base del rectangulo es: " + base + "y tiene una altura de: " + altura);
        System.out.println("El area es de : " + calcularArea());
        System.out.println("Tiene un perímetro: " + calcularPerimetro());
        System.out.println("__________________________________________________________: ");


    }
}

// Clase Triangulo
class Triangulo extends Figura {
    double lado1;
    double lado2;
    double lado3;

    public Triangulo(double lado1, double lado2, double lado3, String color) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("los lados del triangulo son: " +"lado 1 "+ lado1 + ", " +"lado 2 "+ lado2 + ", " +"lado 3 "+ lado3);
        System.out.println("Tiene un area de: " + calcularArea());
        System.out.println("su perimetro vale: " + calcularPerimetro());
        System.out.println("__________________________________________________________: ");

    }
}


package Clases;
public class EnlaceWeb extends MiniTarea{
  String nombre;
  String enlace;
  public EnlaceWeb(String nombre, String enlace){
    this.nombre=nombre;
    this.enlace=enlace;
  }
  public void print(){
    System.out.println("Nombre: "+ nombre);
    System.out.println("Enlace: "+ enlace);
  }

    public String toString() {
       return String.format("Nombre: %s\nEnlace: %s\n",nombre,enlace);
    }
}
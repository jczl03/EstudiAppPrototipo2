package Main;

import java.time.*;
import Clases.*;
import Estructuras.*;
import java.util.Scanner;
import Modelo.*;
public class Main {
   private static final  ArregloDinamico<Asignatura> asignaturas=new ArregloDinamico<Asignatura>();
   private static final AVLTree<Tarea> tareas=new AVLTree<Tarea>();
   private static final ArregloDinamico<Mazo> mazos=new ArregloDinamico<Mazo>();
   private static final ColaPriori<FlashCard> colaFlashCards=new ColaPriori<FlashCard>();
   private static final ColaPriori<Tarea> colaTareas=new ColaPriori<Tarea>();
    public static ArregloDinamico<Asignatura> asignaturas() {
        return asignaturas;
    }

    public static AVLTree<Tarea> tareas() {
        return tareas;
    }
    
    public static void verTareas(){
        tareas.preOrderPrint(tareas.getRoot());
    }

    public static ArregloDinamico<Mazo> mazos() {
        return mazos;
    }
   
  public static void main(String[] args) {
    ModeloPrototipo1.menu();
  }

    public static ColaPriori<FlashCard> colaFlashCards() {
        return colaFlashCards;
    }
   
 
}
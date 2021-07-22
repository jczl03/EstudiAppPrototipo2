/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Apunte;
import Clases.Asignatura;
import Clases.EnlaceWeb;
import Clases.FlashCard;
import Clases.Instruccion;
import Clases.Mazo;
import Clases.Recordatorio;
import Clases.Tarea;
import Estructuras.NodeListaEnlazada;
import Estructuras.NodoAVL;
import Main.Main;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author jczam
 */
public class ModeloPrototipo1 {
    private static final Scanner input=new Scanner(System.in);
     public static void crearAsignatura(){
      try{
          String nombre;
        int id;
        int creditos;
        int importancia;
        System.out.println("______________________");
        System.out.println("Ingrese nombre de la asignatura");
        nombre=input.nextLine();
        System.out.println("Ingrese id de la asignatura");
        id=input.nextInt();
        System.out.println("Ingrese creditos de la asignatura");
        creditos=input.nextInt();
        System.out.println("Ingrese importancia de la asignatura (1-10)");
        importancia=input.nextInt();
        input.nextLine();
        Asignatura asignaturaNueva=new Asignatura(nombre,id,creditos,importancia);
        
        Main.asignaturas().Push(asignaturaNueva);
        System.out.println("La asignatura ha sido creada correctamente");
        
      }catch(Exception e){
        System.out.println("Ha ocurrido un error");
      }
      System.out.println("______________________");
      
  }
  public static void crearTarea(){
      try{
        String nombre;
        int id;
        int asignatura;
        LocalDate fecha;
        LocalTime hora=null;
        int importancia;
        System.out.println("______________________");
        System.out.println("Ingrese nombre de la tarea");
        nombre=input.nextLine();
        System.out.println("Ingrese id de la tarea");
        id=input.nextInt();
        System.out.println("Ingrese id de la asignatura");
        asignatura=input.nextInt();
        input.nextLine();
        System.out.println("Ingrese fecha de entrega de la tarea (aaaa-mm-dd)");
        fecha=LocalDate.parse(input.nextLine());
        System.out.println("Ingrese hora de entrega de la tarea (hh:mm)");
        String a=input.nextLine();
        if(!a.equals("")){
            hora=LocalTime.parse(a);
        }
        
        System.out.println("Ingrese la importancia de la tarea (1-10)");
        importancia=input.nextInt();
        input.nextLine();
        Tarea nuevaTarea=new Tarea(nombre,id,asignatura,fecha,hora,importancia);
        menuAnadirMiniTareas(nuevaTarea);
        Main.tareas().insert(nuevaTarea);
      }catch(Exception e){
          System.out.println("Ha ocurrido un error");
      }
      System.out.println("______________________");
    
        
      
  }
  public static void menuAnadirMiniTareas(Tarea tarea){
      boolean condicion=true;
      while(condicion){
        System.out.println("Seleccione el tipo de minitarea que desea añadir a la tarea "+tarea.getNombre());
        System.out.println("0.Cancelar");
        System.out.println("1.Apunte");
        System.out.println("2.Enlace Web");
        System.out.println("3.Instruccion");
        System.out.println("4.Recordatorio");
        System.out.println();  
        int opcion=input.nextInt();
        input.nextLine();
        switch(opcion){
          case 0->{
              condicion=false;
          }
          case 1 -> crearApunte(tarea);
          case 2 -> crearEnlaceWeb(tarea);
          case 3 -> crearInstruccion(tarea);
          case 4 -> crearRecordatorio(tarea);
          default -> System.out.println("Ingrese una opción valida por favor");            
          }
      }
      
      
  }
  public static void crearApunte(Tarea tarea){
      String nombre;
      String apunte;
      System.out.println("Ingrese el nombre del apunte");
      nombre=input.nextLine();
      System.out.println("Ingrese el cuerpo apunte");
      apunte=input.nextLine();
      Apunte nuevoApunte=new Apunte(nombre,apunte);
      tarea.addMiniTarea(nuevoApunte);
      
  }
  public static void crearEnlaceWeb(Tarea tarea){
      String nombre;
      String enlace;
      System.out.println("Ingrese el nombre del enlace web");
      nombre=input.nextLine();
      System.out.println("Ingrese el enlace ");
      enlace=input.nextLine();
      EnlaceWeb nuevoEnlace=new EnlaceWeb(nombre,enlace);
      tarea.addMiniTarea(nuevoEnlace);
  }
  public static void crearInstruccion(Tarea tarea){
      String instruccion ;
      System.out.println("Ingrese la instruccion");
      instruccion=input.nextLine();
      Instruccion nuevaInstruccion=new Instruccion(instruccion);
      tarea.addMiniTarea(nuevaInstruccion);
  }
  public static void crearRecordatorio(Tarea tarea){
      LocalDate fecha;
      LocalTime hora;
      String nombre;
      String descripcion;
      System.out.println("Ingrese el nombre del recordatorio");
      nombre=input.nextLine();
      System.out.println("Ingrese la fecha del recordatorio");
      fecha=LocalDate.parse(input.nextLine());
      System.out.println("Ingrese la hora del recordatorio");
      hora=LocalTime.parse(input.nextLine());
      System.out.println("Ingrese la descripcion del recordatorio");
      descripcion=input.nextLine();
      Recordatorio nuevoRecordatorio=new Recordatorio(fecha,hora,nombre,descripcion);
      tarea.addMiniTarea(nuevoRecordatorio);
  }
 /* public static void menuVerTareas(){
     System.out.println("______________________");
     System.out.println("Ingresa un número para ver las tareas de:");
     System.out.println("0.Todas las Asignaturas");
     for(int i=0;i<Main.asignaturas().size();i++){
         System.out.println((i+1)+"."+Main.asignaturas().Get(i).getNombre());
     }
     int id=input.nextInt();
     input.nextLine();
     if(id==0){
         verTareas();
     }else if(id>=0 && id<=Main.asignaturas().size()){
         id--;
         verTareas(id);
     }
     System.out.println("______________________");
     
     
  }
  public static void verTareas(){
      
      
  }*/
  public static void verTareas(){
      if(Main.tareas().empty()){
          System.out.println("No hay tareas");
      }else{
          Main.tareas().preOrderPrint(Main.tareas().getRoot());
      }
      
  }
    /*public static void eliminarTarea(){
      try{
            int tarea;
            if(Main.tareas().size()==0){
                System.out.println("No hay tareas");
            }else{

                for(int i=0;i<Main.tareas().size();i++){
                    System.out.println(i+"."+Main.tareas().Get(i).getNombre());
                }
                tarea=input.nextInt();
                input.nextLine();
                Main.tareas().remove(tarea);
            }
      }catch(Exception e){
          System.out.println("Ha ocurrido un error");
      }
      
  }
  public static void eliminarTarea(int id){
      if(Main.tareas().size()==0){
          System.out.println("No hay tareas");
      }else{
          int tarea;
          boolean vacio=true;
          for(int i=0;i<Main.tareas().size();i++){
              if(Main.tareas().Get(i).getAsignatura()==id){
                  System.out.println(i+"."+Main.tareas().Get(i).getNombre());
                  vacio=false;
              }
              
          }
          if(vacio){
            System.out.println("No hay tareas de esta asignatura");
          }else{
            tarea=input.nextInt();
            input.nextLine();
        //    Main.tareas().Remove(tarea);}
      }
  }
  
  public static void menuEliminarTareas(){
     System.out.println("______________________");
     System.out.println("Ingresa un número para eliminar una tarea de:");
     System.out.println("0.Todas las Asignaturas");
     for(int i=1;i<Main.asignaturas().size();i++){
         System.out.printf("%d. %s\n",i,Main.asignaturas().Get(i).getNombre());
     }
     int id=input.nextInt();
     input.nextLine();
     if(id==0){
         eliminarTarea();
     }else{
         eliminarTarea(id);
     }
     System.out.println("______________________");
     
     
  }*/
  public static void eliminarTarea(Tarea tareaEliminar){
      if(Main.tareas().empty()){
          System.out.println("No hay tareas");
      }else{
          int tarea;
          boolean vacio=true;
          NodoAVL<Tarea> aux=Main.tareas().Find(Main.tareas().getRoot(), tareaEliminar);
          if(aux.getKey().compareTo(tareaEliminar)!=0){
            System.out.println("La tarea descrita no existe");
          }else{
            Main.tareas().remove( tareaEliminar);
            }
        }
  }
 /* public static void eliminarTarea(Tarea tareaEliminar){
      if(!Main.tareas().empty()){
          System.out.println("No hay tareas");
      }else{
          int tarea;
          boolean vacio=true;
          NodoAVL<Tarea> aux=Main.tareas().Find(Main.tareas().getRoot(), tareaEliminar);
      }
  }*/
  
    public static void menuBorrarTarea(){
        
     try{
        String nombre;
        int id;
        int asignatura;
        LocalDate fecha;
        LocalTime hora=null;
        int importancia;
     System.out.println("______________________");
     System.out.println("Ingresa la información de la tarea para eliminarla:");
     Tarea tareaAEliminar;
     System.out.println("______________________");
        System.out.println("Ingrese nombre de la tarea");
        nombre=input.nextLine();
        System.out.println("Ingrese id de la tarea");
        id=input.nextInt();
        System.out.println("Ingrese id de la asignatura");
        asignatura=input.nextInt();
        input.nextLine();
        System.out.println("Ingrese fecha de entrega de la tarea (aaaa-mm-dd)");
        fecha=LocalDate.parse(input.nextLine());
        System.out.println("Ingrese hora de entrega de la tarea (hh:mm)");
        String a=input.nextLine();
        if(!a.equals("")){
            hora=LocalTime.parse(a);
        }
        
        System.out.println("Ingrese la importancia de la tarea (1-10)");
        importancia=input.nextInt();
        input.nextLine();
        tareaAEliminar=new Tarea(nombre,id,asignatura,fecha,hora,importancia);
        eliminarTarea(tareaAEliminar);
      }catch(Exception e){
          System.out.println("Ha ocurrido un error, intentalo nuevamente");
      }
     System.out.println("______________________");
     
     
    }
  public static void crearMazo(){
      System.out.println("Ingrese nombre del mazo:");
      
      String nombre;
      nombre=input.nextLine();
      Mazo mazo=new Mazo(nombre);
      anadirFlashCard(mazo);
      Main.mazos().Push(mazo);
      
  }
  public static void anadirFlashCard(Mazo mazo){
      int opcion=-1;
      String pregunta,respuesta;
      do{
          System.out.println("______");
          System.out.println("Ingresa los datos de la FlashCard a agregar al mazo");
          System.out.println("Pregunta");
          pregunta=input.nextLine();
          System.out.println("Respuesta");
          respuesta=input.nextLine();
          FlashCard flashCard=new FlashCard(pregunta,respuesta);
          mazo.add(flashCard);
          System.out.println("______");
          System.out.println("Para dejar de añadir FlashCards al mazo, digite 0, de lo contrario, digite cualquier otro entero");
          opcion=input.nextInt();
          input.nextLine();
      }while(opcion!=0);
  }
  public static void MenuEstudiarFlashCard(){
      if(Main.mazos().size()==0){
          System.out.println("No hay mazos.");
      }else{
          int opcion;
          System.out.println("Escoja una opción por favor:");
          System.out.println("0.Estudiar todos los mazos");
          for(int i=0;i<Main.mazos().size();i++){
              System.out.println((i+1)+"."+Main.mazos().Get(i).getNombre());
          }
          opcion=input.nextInt();
          input.nextLine();
          if(opcion==0){
              for(int i=0;i<Main.mazos().size();i++){
                  Main.mazos().Get(i).estudiar();
              }
          }else{
              opcion--;
              if(opcion>=0 && opcion<Main.mazos().size()){
                  Main.mazos().Get(opcion).estudiar();
              }else{
                  System.out.println("Ingrese una opción válida");
              }
          }
          
      }
  }
  public static void MenuVerFlashCard(){
      if(Main.mazos().size()==0){
          System.out.println("No hay mazos.");
      }else{
          int opcion;
          System.out.println("Escoja una opción por favor:");
          System.out.println("0.Ver todos los mazos");
          for(int i=0;i<Main.mazos().size();i++){
              System.out.println((i+1)+"."+Main.mazos().Get(i).getNombre());
          }
          opcion=input.nextInt();
          input.nextLine();
          if(opcion==0){
              for(int i=0;i<Main.mazos().size();i++){
                  verMazo(Main.mazos().Get(i));
              }
          }else{
              opcion--;
              if(opcion>=0 && opcion<Main.mazos().size()){
                  verMazo(Main.mazos().Get(opcion));
              }else{
                  System.out.println("Ingrese una opción válida");
              }
          }
          
      }
  }
  public static void verMazo(Mazo mazo){
      NodeListaEnlazada<FlashCard> flashCard = mazo.getLista().getHead();
      System.out.println("______________");
      if(flashCard==null){
          System.out.println("No hay FlashCards en el Mazo");
      }else{
          while(flashCard!=null) {
            Main.colaFlashCards().Insert(flashCard.getKey().getPriority(), flashCard.getKey());
            flashCard=flashCard.getNext();
        }
          while(!Main.colaFlashCards().Empty()){
              Main.colaFlashCards().getMax().print();
              System.out.println("Presione cualquier tecla para continuar");
              String a=input.nextLine();
              Main.colaFlashCards().ExtractMax();
          }
        System.out.println("______________");
      }
        
        
      ;
  }
  public static void menu(){
    int opcion=-1;
    while(opcion!=0){
        System.out.println("Bienvenido a ESTUDIAPP, elige una de las siguientes funcionalidades:");
        System.out.println("______________________");
        System.out.println("0.Cerrar programa");
        System.out.println("1.Crear asignatura");
        System.out.println("2.Crear Tarea");
        System.out.println("3.Ver tareas");
        System.out.println("4.Eliminar Tarea");
        System.out.println("5.Crear Mazo");
        System.out.println("6.Repasar Con FlashCard");
        System.out.println("7.Estudiar Con FlashCard");
        opcion=input.nextInt();
        input.nextLine();
        switch(opcion){
            case 0 -> System.out.println("Hasta la proxima ;)");
            case 1 -> crearAsignatura();
            case 2 -> crearTarea();
            case 3 -> verTareas();
            case 4 -> menuBorrarTarea();
            case 5 -> crearMazo();
            case 6 -> MenuVerFlashCard();
            case 7 -> MenuEstudiarFlashCard();
            default -> System.out.println("Ingrese una opción valida por favor");            
        }
        
    }
    
  }
  /*
  public static void prueba1(int N){ //Crear un mazo con N flashcards
      long Tinicio,Tfinal,T;
      System.out.println("Inicio algoritmo");
      
      Mazo mazo=new Mazo("Mazo de "+N+"Preguntas");
      FlashCard carta;
      for(int i=0;i<N;i++){
        carta=new FlashCard("P"+N,"R"+N);
        mazo.add(carta);
      }
      
      Tinicio= System.currentTimeMillis();
      mazo.printPrueba();
      Tfinal=System.currentTimeMillis();
      T=Tfinal-Tinicio;
      //System.out.printf("Inicio: %d Final: %d",Tinicio,Tfinal);
      System.out.println("Tiempo de ejecución: "+T);
  }
  public static void prueba2(int N){ //Almacenar N mazos en Arreglos Dinámicos- También se podría hacer ocn Asignaturas
      long Tinicio,Tfinal,T;
      System.out.println("Inicio algoritmo");
      Tinicio= System.currentTimeMillis();
      Mazo mazo;
      FlashCard carta;
      for(int i=0;i<N;i++){
        mazo=new Mazo("Mazo "+N);
        carta=new FlashCard("P"+N,"R"+N);
        mazo.add(carta);
        Main.mazos().Push(mazo);
      }
      Tfinal=System.currentTimeMillis();
      T=Tfinal-Tinicio;
      //System.out.printf("Inicio: %d Final: %d",Tinicio,Tfinal);
      System.out.println("Tiempo de ejecución: "+T);
  }
  public static void prueba3(int N){ //Agregar N datos a una arraydinámico en orden.
      long Tinicio,Tfinal,T;
      System.out.println("Inicio algoritmo");
      Tinicio= System.currentTimeMillis();
      LocalTime currentHora=LocalTime.parse("00:00");
      LocalTime mediaNoche=LocalTime.parse("23:58");
      LocalDate currentTime=LocalDate.parse("1000-01-01");
      Tarea tarea;
      for(int i=0;i<N;i++){
        tarea=new Tarea("T"+i, i%100, 5, currentTime, currentHora, 8);
      //  anadirTarea(tarea);
        currentHora=currentHora.plusMinutes(1);
        if(currentHora.isAfter(mediaNoche)){
            currentTime=currentTime.plusDays(1);
        }
        
      }
      Tfinal=System.currentTimeMillis();
      T=Tfinal-Tinicio;
      System.out.println("Tiempo de ejecución: "+T);
  }*/
   public static void prueba1(int N){ //Agregar N datos a una arbolAVL 
      long Tinicio,Tfinal,T;
      System.out.println("Inicio algoritmo");
      Tinicio= System.currentTimeMillis();
      LocalTime currentHora=LocalTime.parse("00:00");
      LocalTime mediaNoche=LocalTime.parse("23:58");
      LocalDate currentTime=LocalDate.parse("1000-01-01");
      Tarea tarea;
      for(int i=0;i<N;i++){
        tarea=new Tarea("T"+i, i%100, 5, currentTime, currentHora, 8);
        Main.tareas().insert(tarea);
        currentHora=currentHora.plusMinutes(1);
        if(currentHora.isAfter(mediaNoche)){
            currentTime=currentTime.plusDays(1);
        }
        
      }
      Tfinal=System.currentTimeMillis();
      T=Tfinal-Tinicio;
      System.out.println("Tiempo de ejecución: "+T);
  }
     private static void prueba2(int N) {
	// TODO Auto-generated method stub
    	 long Tinicio,Tfinal,T;
         System.out.println("Inicio algoritmo");
         Tinicio= System.currentTimeMillis();
         FlashCard flashcard;
         for(int i=0;i<N;i++){
           flashcard=new FlashCard("1+"+i," "+(i+1),i);
           Main.colaFlashCards().Insert(i, flashcard);
           
         }
         Tfinal=System.currentTimeMillis();
         T=Tfinal-Tinicio;
         System.out.println("Tiempo de ejecuciÃ³n: "+T);
	
    }
}
        
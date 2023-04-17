package co.edu.unbosque.view;

import java.util.Scanner;

public class View {
    private Scanner sc;
    public View(){
        sc = new Scanner(System.in);
    }
    //Start of menu's section//
    /**
     * Displays to the user a console view of the main menu with 7 options, returning the selected one
     * @return
     */
    public int showMainMenu(){
        System.out.print("ARBOL:\n" +
                "1. Insertar dato\n" +
                "2. Eliminar dato\n" +
                "3. Buscar dato\n" +
                "4. Eliminar arbol\n" +
                "5. Mostrar arbol\n" +
                "6. Tamaño arbol\n" +
                "7. Salir\n" +
                ">");
        return Integer.parseInt(sc.nextLine());
    }
    /**
     * Shows the user a simple console menu with 3 options to see witch showing configuration would the user need
     * @return
     */
    public int showShowTreeMenu(){
        System.out.print("MOSTRAR ARBOL\n" +
                "1. En orden\n" +
                "2. PreOrden\n" +
                "3. PosOrden\n" +
                "4. Volver\n" +
                ">");
        return Integer.parseInt(sc.nextLine());
    }
    /**
     * Displays a simple console menu to know either if the user wants to add the data with or without recursion
     * @return
     */
    public int showInsertMenuMenu(){
        System.out.print("INSERTAR\n" +
                "1. Con recursividad\n" +
                "2. Sin recursividad\n" +
                "3. Volver\n" +
                ">");

        return Integer.parseInt(sc.nextLine());
    }
    //End of menu's section//

    //Start of user interaction section
    public void showMessage(String message){
        System.out.println(message);
    }
    public void showMessage(int message){
        System.out.println(message);
    }
    /**
     * Capture the Integer value user gave in console with a simple Java Scanner
     * @param message
     * @return
     */
    public int readInt(String message){
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }
    /**
     * Capture the String value user gave in console with a simple Java Scanner
     * @param message
     * @return
     */
    public String readString(String message){
        System.out.print(message);
        return sc.nextLine();
    }
    //End of user interaction section
}

package co.edu.unbosque.controller;

import co.edu.unbosque.model.Node;
import co.edu.unbosque.model.Tree;
import co.edu.unbosque.view.View;

public class Controller{
    private Tree tree;
    private View view;

    /**
     * The constructor of this class does all the treatment of the user interaction with the software mostly with switch statements
     */
    public Controller(){
        view = new View();
        tree = new Tree();
        int mainRes;
        do{
            mainRes = view.showMainMenu();
            switch (mainRes){
                case 1:
                    //Insert data
                    int dataToInsert = view.readInt("Ingrese el valor a agregar: ");
                    int insertRes;
                    insertRes = view.showInsertMenuMenu();
                    switch (insertRes){
                        case 1:
                            //Recursively
                            tree.insertDataByRecursion(dataToInsert);
                            break;
                        case 2:
                            //Non-recursively
                            tree.insertWithoutRecursion(dataToInsert);
                            break;
                        case 3:
                            //Exit
                            break;
                        default:
                            //Err
                            view.showMessage("Error: Debe elejir una opcion");
                            break;
                    }
                    break;
                case 2:
                    //Delete data
                    boolean isDeleted = tree.delete(view.readInt("Ingrese el valor a eliminar: "));
                    if(!isDeleted){
                        view.showMessage("El nodo no fue encontrado");
                    }
                    break;
                case 3:
                    //Search data
                    int targetToSearchData = view.readInt("Ingrese el valor a buscar: ");
                    Node searchedNode = tree.searchNode(tree.getRoot(), targetToSearchData);
                    if(searchedNode == null)
                        view.showMessage("El nodo no existe en el arbol");
                    else
                        view.showMessage("El nodo si existe en el arbol");

                    break;
                case 4:
                    //Delete tree
                    boolean deleted = tree.deleteTree();
                    if(deleted)
                        view.showMessage("Eliminado exitosamente");
                    else
                        view.showMessage("No hay nada que eliminar");

                    break;
                case 5:
                    //Show tree
                    if(tree.isEmpty()){
                        view.showMessage("No hay datos");
                    }else {
                        int showTreeRes = view.showShowTreeMenu();
                        switch (showTreeRes) {
                            case 1:
                                //InOrder
                                tree.showTreeInOrder(tree.getRoot());
                                System.out.println();
                                break;
                            case 2:
                                //PreOrder
                                tree.showTreePreOrder(tree.getRoot());
                                System.out.println();
                                break;
                            case 3:
                                //PosOrder
                                tree.showTreePosOrder(tree.getRoot());
                                System.out.println();
                                break;
                            case 4:
                                //Err
                                view.showMessage("Error: Debe elegir una opcion valida");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 6:
                    //Tree size
                    int treeSize = tree.getTreeSize(tree.getRoot());
                    view.showMessage("La altura actual del arbol es " + treeSize + " niveles");
                    break;
                case 7:
                    //Exit
                    view.showMessage("Gracias por usar este software, saliendo...");
                    break;
                default:
                    //Err
                    view.showMessage("Opcion incorrecta, intente de nuevo");
                    break;
            }
        }while(mainRes != 7);
    }
}

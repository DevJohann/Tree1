package co.edu.unbosque.model;

public class Tree {
    private Node root;
    /**
     * Constructor
     */
    public Tree(){
        root = null;
    }
    //Insert by recursion section//
    public void insertDataByRecursion(int data){
        if(this.root == null){
            this.root = new Node(data);
            //System.out.println("Insertado " + data +" en la raíz");
        }else{
            //System.out.println("Is empty: " + this.isEmpty());
            this.insertDataByRecursion(this.root, data);
        }
    }

    /**
     * Uses recursion to add a node to the BST
     * @param fat
     * @param data
     */
    public void insertDataByRecursion(Node fat, int data){
        //System.out.println(data + "mayor que " + fat.getData() + "? " + (data > fat.getData()));
        if(data > fat.getData()){
            if (fat.getDer() == null){
                fat.setDer(new Node(data));
                System.out.println("Insertado a la derecha");
            }
            else{
                this.insertDataByRecursion(fat.getDer(), data);
            }
        }else{
            if(fat.getIzq() == null){
                fat.setIzq(new Node(data));
                System.out.println("Insertado a la izquierda");
            }else{
                this.insertDataByRecursion(fat.getIzq(), data);
            }
        }
    }
    //End of Insert by recursion section//

    //Start of Insert without recursion section//

    /**
     * Adds a node to the BST using loops instead of recursion
     * @param data
     */
    public void insertWithoutRecursion(int data){
        if (this.root == null) {
            this.root = new Node(data);
            System.out.println("Insertado en la raíz");
        }else{
            Node aux = this.root;
            Node last = null;
            while (aux != null){
                last = aux;
                if(data < aux.getData()){
                    aux = aux.getIzq();
                }else{
                    aux = aux.getDer();
                }
            }
            if(last.getData() > data){
                last.setIzq(new Node(data));
                System.out.println("Insertado a la izquierda");
            }else{
                last.setDer(new Node(data));
                System.out.println("Insertado a la derecha");
            }
        }
    }
    //End of Insert without recursion section//

    //Start of delete data section//
    private void delete(Node target){
        this.delete(target, target.getData());
    }


    public boolean delete(int data){
        if(searchNode(this.root, data) == null){
            return false;
        }else{
            this.delete(root, data);
            return true;
        }
    }

    /**
     * Deletes a node recursively from the BST with the given target data
     * @param target
     * @param data
     * @return
     */
    private Node delete(Node target, int data){
        if(target == null){
            return target;
        }
        if(data > target.getData()){
            target.setDer(delete(target.getDer(), data));
        }else if(data < target.getData()){
            target.setIzq(delete(target.getIzq(), data));
        }else{
            if(target.getDer() == null && target.getIzq() == null){
                target = null;
            }else if(target.getDer() != null){
                target.setData(sucesor(target));
                target.setDer(delete(target.getDer(), target.getData()));
            }else if(target.getIzq() != null){
                target.setData(predecesor(target));
                target.setIzq(delete(target.getIzq(), target.getData()));
            }
        }
        return target;
    }

    /**
     * Retrieve the new data that will be set to the right replacement node
     * @param target
     * @return
     */
    private int sucesor(Node target){
        target = target.getDer();
        while(target.getIzq() != null){
            target = target.getIzq();
        }
        return target.getData();
    }
    /**
     * Retrieve the new data that will be set to the left replacement node
     * @param target
     * @return
     */
    private int predecesor(Node target){
        target = target.getIzq();
        while(target.getDer() != null){
            target = target.getDer();
        }
        return target.getData();
    }
    //End of delete data section//

    //Start of search node section//

    /**
     * Search a node recursively from the BST, returning null if it's no coincidence
     * @param target
     * @param data
     * @return
     */
    public Node searchNode(Node target, int data){
        if(target == null){
            return null;
        }
        if(target.getData() == data){
            return target;
        }else if(data < target.getData()){
            return searchNode(target.getIzq(), data);
        }else{
            return searchNode(target.getDer(), data);
        }
    }
    //End of search node section//

    //Start of show tree section//
    public void showTreeInOrder(Node node){
        if(node != null){
            showTreeInOrder(node.getIzq());
            System.out.print(node.getData() + " - ");
            showTreeInOrder(node.getDer());
        }
    }
    public void showTreePreOrder(Node node){
        if(node != null){
            System.out.print(node.getData() + " - ");
            showTreePreOrder(node.getIzq());
            showTreePreOrder(node.getDer());
        }
    }
    public void showTreePosOrder(Node node){
        if(node != null){
            showTreePreOrder(node.getIzq());
            showTreePreOrder(node.getDer());
            System.out.println(node.getData());
        }
    }
    //End of show tree section//

    //Start of tree high section//

    /**
     * Calculates the height of the BST by going through the levels and adding 1 by 1 recursively
     * @param node
     * @return
     */
    public int getTreeSize(Node node){
        if(node == null){
            return 0;
        }else{
            int leftData = getTreeSize(node.getIzq());
            int rightData = getTreeSize(node.getDer());

            if(leftData > rightData){
                return leftData + 1;
            }else{
                return rightData + 1;
            }
        }
    }

    //End of tree high section//

    //Start of various methods section//
    public boolean isEmpty(){
        return (root == null) ? true : false;
    }

    /**
     * Simply sets the root node to null, losing all the BST data
     * @return
     */
    public boolean deleteTree(){
        if(this.root == null)
            return false;
        else {
            this.root = null;
            return true;
        }
    }
    //End of various methods section//

    //Start of getters and setters section//

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //End of getters and setters section//
}

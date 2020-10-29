package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {

        Store notebook=new Store("notebook");

        notebook.store(100);
        System.out.println(notebook.getProduct()+": "+notebook.getStock());

        Store tablet=new Store("tablet");

        tablet.store(50);
        System.out.println(tablet.getProduct()+": "+tablet.getStock());

        notebook.dispatch(10);
        tablet.dispatch(20);
        notebook.store(15);
        tablet.store(5);

        System.out.println(notebook.getProduct()+": "+notebook.getStock());

        System.out.println(tablet.getProduct()+": "+tablet.getStock());
    }
}

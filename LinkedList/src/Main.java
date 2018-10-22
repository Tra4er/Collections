public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(5);
        list.append(6);
        list.prepend(9);
        list.makeLoop();
        if (list.isLoop()) {
            System.out.println("Fixing Loop");
            list.fixLoop();
        }
        System.out.println(list.isLoop());
        System.out.println(list);
    }
}

class Computer{
    public int i;public void construct(){
        System.out.println("Комп'ютер "+i+" зібрано");
    }
}
public class Notebook extends Computer{
    public void construct(){
        System.out.println("Ноутбук "+i+" зібрано");
    }
    public static void main(String[] args) {
        Notebook n = new Notebook();
        n.construct();
    }
}
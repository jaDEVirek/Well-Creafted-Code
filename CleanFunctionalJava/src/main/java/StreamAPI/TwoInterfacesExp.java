package StreamAPI;

public class TwoInterfacesExp implements IFirst,ISecond {

    public static void main(String[] args) {

    }
    @Override public void displaySomeText() {
        IFirst.super.displaySomeText();
    }
}


interface  IFirst{
     default void displaySomeText(){
         System.out.println("From First!");
    };
    default void notNeedOverride(){
        System.out.println("From First - but not need !");
    }
}

interface  ISecond{
    default void displaySomeText(){
        System.out.println("From Second!");
    }
    static void displaySomeText(int  val){

    }
}

 class MyDataImpl implements MyData {

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null;
    }

    public static void main(String[] args){
        MyDataImpl obj = new MyDataImpl();
        obj.print("1");
        final boolean abc = obj.isNull("abc");
        final boolean aNull = MyData.isNull("this!");
    }
}

interface MyData {

    default void print(String str) {
        if (!isNull(str)) // this will be called from MyData interface, if static method will be default
            // then isNull will be called from object
            System.out.println("MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null || ("".equals(str));
    }
}

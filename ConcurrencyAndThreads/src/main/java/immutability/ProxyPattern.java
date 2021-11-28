package immutability;

public class ProxyPattern {

    public static void main(String[] args) throws InterruptedException {
        final ProxyOrder telewizor = new ProxyOrder(new Order(1, "Telewizor", true));
        final ProxyOrder pecet = new ProxyOrder(new Order(2, "Pecet", false));
        pecet.processOrder();
        Thread.sleep(5000);
        telewizor.processOrder();
    }
}

interface IOrder {
    void processOrder();
}

class Order implements IOrder {
    private int id;
    private String itemName;
    private boolean isPremium;

    public Order(int id, String itemName, boolean isPremium) {
        this.id = id;
        this.itemName = itemName;
        this.isPremium = isPremium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override public void processOrder() {
        System.out.println("Zamówienie ma status premium, zostało przyjęte ! ");
        System.out.println(this);
    }

    @Override public String toString() {
        return "Order{" + "id=" +
                id +
                ", itemName='" +
                itemName +
                '\'' +
                ", isPremium=" +
                isPremium +
                '}';
    }
}

class ProxyOrder implements IOrder{
    private final Order order;

    public ProxyOrder(Order order) {
        this.order = order;
    }

    @Override public void processOrder() {
        if(!order.isPremium()){
            System.out.println("Zamówienie musi być premium żeby zostało wykonane");
        }else{
            order.processOrder();
            System.out.println("Order proceed !");
        }
    }
}

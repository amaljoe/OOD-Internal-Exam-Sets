import java.util.ArrayList;

public class DiscountBill extends GroceryBill{
    boolean preferred;

    DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
    }

    public int getDiscountCount() {
        if(!preferred) {
            return 0;
        }
        int count = 0;
        for(Item item : items) {
            if(item.discount != 0) {
                count++;
            }
        }
        return count;
    }

    public double getDiscountAmount() {
        if(!preferred) {
            return 0;
        }
        double discount = 0;
        for(Item item : items) {
            discount += item.discount;
        }
        return discount;
    }

    public double getDiscountPercent() {
        if(!preferred) {
            return 0;
        }
        double percent = getDiscountAmount() / getTotal();
        return percent;
    }

    @Override
    public double getTotal() {
        return super.getTotal() - getDiscountAmount();
    }

    @Override
    public void printReceipt() {
        super.printReceipt();
        System.out.println("No. of items discounted:\t" + getDiscountCount());
        System.out.println("Discount Amount:\t" + getDiscountAmount());
        System.out.println("Discount Percent:\t" + getDiscountPercent());
    }

    public static void main(String[] args) {
        Employee clerk = new Employee("Sera");
        DiscountBill groceryBill = new DiscountBill(clerk, true);
        Item milk = new Item("Milk", 30, 10);
        Item egg = new Item("Egg", 10, 2);
        Item bread = new Item("Bread", 50, 0);
        groceryBill.addItem(milk);
        groceryBill.addItem(egg);
        groceryBill.addItem(bread);
        groceryBill.printReceipt();
    }
}

class GroceryBill {
    Employee clerk;
    ArrayList<Item> items = new ArrayList<Item>();

    GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public double getTotal() {
        double total = 0;
        for(Item item : items) {
            total += item.price;
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("Clerk:\t" + clerk.name);
        for(Item item : items) {
            System.out.println(item.name + "\t" + item.price);
        }
        System.out.println("Total:\t" + getTotal());
    }
}

class Item {
    String name;
    double price;
    double discount;

    Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}
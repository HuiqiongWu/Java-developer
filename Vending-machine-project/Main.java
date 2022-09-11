public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");
        
        Item[][] items = new Item[][] {
            {new Item("Coke", 3.75, 5), new Item("Pure water", 2.36, 3), new Item("Orange juice", 4.99, 8)},
            {new Item("Soda water", 4.78, 9), new Item("Apple juice", 4.99, 9), new Item("Tea", 3.59, 5)},
            {new Item("Rio", 5.75, 5), new Item("Beer", 6.88, 3), new Item("Pineapple juice", 4.89,9)}
        };
        

        Vending_machine vending_machine = new Vending_machine (items);

        System.out.println(vending_machine);

        while (true) {
            System.out.print("Pick a row: ");
            int row = scan.nextInt();
            System.out.print("Pick a column in the row: ");
            int column = scan.nextInt();

            boolean sold = machine.dispense(row, column);
            System.out.println("\n" + vending_machine);

            if (sold == true) {
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");
            } else {
                System.out.print("Sorry, we're out of this item. Press 1 to purchase another: ");
            }
            if (scan.nextInt() != 1) {
                break;
            }
        }

    scan.close();

    }
}

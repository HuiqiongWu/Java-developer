public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Item[][] items = new Item[][] {
            {new Item("Coke", 3.75, 5), new Item("Pure water", 2.36, 3), new Item("Orange juice", 4.99, 8)},
            {new Item("Soda water", 4.78, 9), new Item("Apple juice", 4.99, 9), new Item("Tea", 3.59, 5)},
            {new Item("Rio", 5.75, 5), new Item("Beer", 6.88, 3), new Item("Pineapple juice", 4.89,9)}
        };
        

        Vending_machine vending_machine = new Vending_machine (items);

        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
        System.out.print("Welcome! Enter the type of beverage you're looking for: ");
        String name = scan.nextLine();     

        int[] index = vending_machine.search(name);

        row_index = index[0];
        col_index = index[1];

        switch (index) {

            case 404: System.out.println("Feel free to browse through our collection of beverage.\n");
            System.out.println(vending_machine);
            break;

            default: scan.nextLine();
            String decision = scan.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                vending_machine.sell(row_index, col_index);
            }

        }

    scan.close();

    }
}

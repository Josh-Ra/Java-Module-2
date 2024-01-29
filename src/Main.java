import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Are you ready?");
        String use = scanner.next();
        scanner.nextLine();
        if (!(Objects.equals(use, "yes")) || use.equals("Yes") || use.equals("y") || use.equals("Y")){
            System.exit(0);
        }
        boolean active = true;
        System.out.println("Please enter a name: ");
        String owner = scanner.nextLine();
        ToDoList ownertodolist = new ToDoList(owner);
        while (active){
            if (ownertodolist.getTodo().length > 1){
                String[] todolist = ownertodolist.getTodo();
                System.out.println("To Do: ");
                for (int i = 1; i < todolist.length; i++) {
                    System.out.println(i + "." + todolist[i]);
                }
            }
            if (ownertodolist.getDone().length > 1){
                String[] donelist = ownertodolist.getDone();
                System.out.println("Task finished:");
                for (int i = 1; i < donelist.length; i++) {
                    System.out.println(donelist[i]);
                }
            }
            System.out.println("Welcome, " + ownertodolist.getOwner() + " your options are: ");
            System.out.println("1.Rename\n2.add to ToDoList\n3.mark as done\n4.Quit");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println(System.lineSeparator().repeat(50));
            switch (option){
                case 1:
                    ownertodolist.renameOwner();
                    break;
                case 2:
                    ownertodolist.addToDo();
                    break;
                case 3:
                    ownertodolist.markDone();
                    break;
                case 4:
                    active = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
}
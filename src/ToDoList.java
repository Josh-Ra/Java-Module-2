import java.util.ArrayList;
import java.util.Arrays;

public class ToDoList {
    private String owner;
    private String[] todo;
    private String[] done;

    public ToDoList(String owner){
        this.owner = owner;
        this.todo = new String[] {""};
        this.done = new String[] {""};
    }

    public String getOwner() {
        return owner;
    }

    public void renameOwner() {
        System.out.println("Enter your new name: ");
        this.owner = Main.scanner.nextLine();
    }

    public String[] getTodo() {
        return todo;
    }

    public void addToDo() {
        System.out.println("Please enter the task: ");
        String item = Main.scanner.nextLine();
        String[] newarray = new String[this.todo.length + 1];
        System.arraycopy(this.todo, 0, newarray, 0, this.todo.length);
        newarray[this.todo.length] = item;
        this.todo = newarray;
        System.out.println("Task added!");
    }

    public String[] getDone() {
        return done;
    }

    public void markDone() {
        System.out.println("Enter the number of the item completed: ");
        int index = Main.scanner.nextInt();
        if (index > this.todo.length - 1){
            System.out.println("Option not valid");
        }else {
            String[] newarray = new String[this.done.length + 1];
            System.arraycopy(this.done, 0, newarray, 0, this.done.length);
            newarray[this.done.length] = this.todo[index];
            this.done = newarray;

            this.removeFromTodo(this.todo[index]);
            System.out.println("Task marked as done!");
        }

    }

    public void removeFromTodo(String item){
        ArrayList<String> todolist = new ArrayList<>(Arrays.asList(this.todo));
        todolist.remove(item);
        //The code below creates an array with 0 elements which will allow the to array function to return an array with just enough space for all the elements
        this.todo = todolist.toArray(new String[0]);
    }
}
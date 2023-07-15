import java.util.Scanner;

public class Main {
    public static String[] model = new String[5];
    public static  java.util.Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan TodoList
     */
    public static void showTodoList(){

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++){

            var todo = model[i];
            var nomor = i + 1;

            if(todo != null) {
                System.out.println(nomor + ". " + todo);
            }
        }
    }


    /**
     * Menambahkan TodoList
     */
    public static void addTodoList(String todo){

//        Cek apakah model penuh?
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
//                model masih ada yang kosong
                isFull = false;
                break;
            }
        }
//        jika penuh maka resize model menjadi 2 kali lipat
        if (isFull){

            String[] temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

//        Tambahkan data ke array yang NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }


    /**
     * Menghapus TodoList
     */
    public static boolean removeTodoList(int number){



        if ((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     *
     * Input TodoList
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = input.nextLine();
        return data;
    }


    /**
     * View Menampilkan TodoList
     */
    public static void viewShowTodoList(){

        while (true){

            showTodoList();

            System.out.println(" ");
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            String input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                System.out.println("anda keluar dari program");
                break;
            } else {
                System.out.println("permintaan tidak dimengerti");
            }
        }

    }

    /**
     * View Menambahkan TodoList
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x untuk batal)");
        if (todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    /**
     * View Menghapus TodoList
     */
    public static void viewRemoveTodoList(){

        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x untuk batal)");
        if (number.equals("x")){
            //batal
        } else {
          boolean success =  removeTodoList(Integer.valueOf(number));

          if (!success){
              System.out.println("Gagal menghapus Todo " + number);
          }
        }
    }
}
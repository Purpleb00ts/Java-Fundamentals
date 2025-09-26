import java.util.Scanner;
public class Language {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String language = sc.nextLine();

        switch(language){
            case "English": System.out.println("England, USA"); break;
            case "Spanish": System.out.println("Spain, Mexico, Argentina"); break;
            case "other": System.out.println("Unknown"); break;
            default: System.out.println("Error"); break;
        }

    }
}

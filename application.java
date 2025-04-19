
package javaproject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class application {
    int selection;
    int deleteIndex;
    int commentIndex;
    int editIndex;
    String editedContent;
    String goBack;
    ArrayList<Information> info = initiateInfoList();
    Scanner scanner = new Scanner(System.in);

    public void runApplication(boolean isAdmin){ 
        int choice;
        
        //selection of function
        //differrentiate what user and admin function can be use
        do { 
            System.out.println("----------------------------------------");
            System.out.println("1. View Climate Information");
            System.out.println("2. Enter comment for Climate Information");
            System.out.println("3. Early Warning");
            if (isAdmin == true) {
                System.out.println("4. Add Climate Information");
                System.out.println("5. Edit Climate Information");
                System.out.println("6. Delete Climate Information");
            }
            System.out.println("7. Exit Site");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("----------------------------------------");

            //method calling according to the selection of function
            switch(choice) {
                case 1:
                    viewInfo();
                    break;
                case 2:
                    userCommentSection();
                    break;
                case 3:
                    earlyWarningInfo();
                    break;
                case 4:
                    addInfo();                    
                    break;
                case 5:
                    editInfo();
                    break;
                case 6:
                    deleteInfo();
                    break;
                case 7:
                    System.out.println("Exiting the Climate Education Site.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7); 
        System.out.println("----------------------------------------");
    }
    
    //method to run viewInfo 
    private void viewInfo(){
        do{ //selection of information provided
            System.out.println("----------------------------------------");
            System.out.println("1.Improve Education");
            System.out.println("2.Awareness-Raising");
            System.out.println("3.Human And Institutional Capacity On Climate Change Mitigation");
            System.out.println("4.Adaptation");
            System.out.println("5.Impact Reduction");
            System.out.println("6.Added Information");
            System.out.println("7.Back to Main Page");
            System.out.println("----------------------------------------");
            System.out.println("Enter you selection of information");
            selection = scanner.nextInt();
            scanner.nextLine();
            //information retrieva/ based on selection of information provided
            switch(selection){
                case 1:
                    System.out.println("Improve Education");
                    System.out.println(info.get(1));
                    returns();               
                    break;
                case 2:
                    System.out.println("Awareness-Raising");
                    System.out.println(info.get(2));
                    returns();
                    break;
                case 3:
                    System.out.println("Human And Institutional Capacity On Climate Change Mitigation");
                    System.out.println(info.get(3));
                    returns();
                    break;
                case 4:
                    System.out.println("Adaptation");
                    System.out.println(info.get(4));
                    returns();
                    break;
                case 5:
                    System.out.println("Impact Reduction");
                    System.out.println(info.get(5));
                    returns();
                    break;
                case 6:
                    System.out.println("Added information");
                    for (int i=6;i<info.size();i++) {
                        System.out.println(info.get(i));}
                    returns();
                    break;
                case 7:
                    System.out.println("Back to Main Page");
                    break;
                default: System.out.println("Invalid selection");           
                }
            }while(selection != 7);   
        System.out.println("----------------------------------------");
        }
    
    //method to run userCommentSection
    //user input comment and its stored at related information field 
    private void userCommentSection(){
        System.out.println("Enter selection of content to comment");
        commentIndex = scanner.nextInt();
        scanner.nextLine();
        if(commentIndex >= 0 && commentIndex <= info.size()){
            System.out.println("Enter your comment:");
            String commentInfo = scanner.nextLine();
            Information currentInfo = info.get(commentIndex); 
            currentInfo.setComment(commentInfo);
            System.out.println("Comment successfully shared");
        }
         else{
            System.out.println("invalid index. No content edited");
        }
        returns();
    }
    
    //method to run earlyWarningInfo
    //this provide information on incoming weather and what you should do 
    private void earlyWarningInfo(){
        String[] weather = {"Sunny","Rainy","Snowy","Typhoon"};
        Random random = new Random();
        int weatherIndex = random.nextInt(weather.length);
        String earlyWarning = weather[weatherIndex];
        
        switch (earlyWarning) {
            case "Sunny":
                System.out.println("Today is going to be sunny");
                System.out.println("Remember to drink more water");
                break;
            case "Rainy":
                System.out.println("Today is going to be a rainy day");
                System.out.println("Prepare an umbrella or jacket before you go out");
                break;
            case "Snowy":
                System.out.println("Today is going to be a snowy day");
                System.out.println("Remember to keep warm and wear something thick");
                break;
            case "Typhoon":
                System.out.println("Today is going to be a typhoon");
                System.out.println("Stay indoors and be safe");
                break;
            default:
                break;
        }
        scanner.nextLine();
        returns();
    }
    
    //method to run addInfo
    //this allow admin to add new information into the site 
    private void addInfo(){
        System.out.println("Enter information to add");
        scanner.nextLine();
        String content = scanner.nextLine();
        info.add(new Information(content));
        returns();
    }
    
    //method to run editInfo
    //this allows admin to edit information at specific information type 
    private void editInfo(){
        System.out.println("Enter the selection of content to edit");
        editIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new content");
        editedContent = scanner.nextLine();            
        if(editIndex >= 0 && editIndex <= info.size()){
            Information infoEdit = info.get(editIndex); 
            infoEdit.setContent(editedContent);
            System.out.println("Content successfully edited");
        }
        else{
            System.out.println("invalid selection. No content edited");
        }
        returns();
    }
    
    //method to run deleteInfo
    //this allow admin to delete specific information type
    private void deleteInfo(){
        System.out.println("Enter the selection of content to delete");
        deleteIndex = scanner.nextInt();
        scanner.nextLine();
        if(deleteIndex >= 0 && deleteIndex <= info.size()){
            info.set(deleteIndex,new Information("")); 
            System.out.println("Content successfully deleted");
        }
        else{
            System.out.println("invalid selection. No content deleted");
        }
        returns();
    }
    
    //method to run returns
    //this provide to return function to the previous page
    private void returns(){
        while(true){
            System.out.println("Enter 'G' to return to previous page");
            goBack = scanner.nextLine().toUpperCase();
            if (goBack.equals("G")){
                System.out.println("Returning to the previous page");
                break;
            }
            else{
                System.out.println("Invalid Command");
            }
        }
        System.out.println("----------------------------------------");
    }
    
    //stored information 
    private static ArrayList<Information> initiateInfoList() {
    ArrayList<Information> info = new ArrayList<>();
    info.add(new Information(null));
    info.add(new Information("education"));
    info.add(new Information("aware"));
    info.add(new Information("mitigate"));
    info.add(new Information("adapt"));  
    info.add(new Information("impact"));
    return info;
    }   
}
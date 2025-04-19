
package javaproject;

//information class
//to store and retrieve information 
public class Information {
    private String content;
    private String comment;

    public Information(String content) {
        this.content = content;
        this.comment ="";
    }
    
    public String getContent() {
        return content;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    
    @Override
    public String toString() {
        return "Content: " + content + "\nComments:" + comment; 
    }       
}


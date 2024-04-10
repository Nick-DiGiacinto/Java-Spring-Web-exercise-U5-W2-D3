package nickdg.U5W2D3.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(int id){
        super("the element with id " + id + " was not found");
    }
}

package noemipusceddu.U2W1L5be.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(long id){
        super("L'elemento con id " + id + " non è stato trovato sul database!");
    }
}

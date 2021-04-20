package exc;

public class DaoException extends Exception{

    public DaoException(String message){
        super("DAO problem: " +message);
    }
}

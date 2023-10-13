package model.exception;

//Subclasse de Exception

//SubClasse de exceções personalizadas
public class DomainException extends Exception{

    //Pegando argumento da superclasse Exception
    public DomainException(String msg){super(msg);}

}

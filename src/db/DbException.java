package db;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
	
	// Aqui nós criamos a exceção personalizada para não precisar toda hora ficar colocando um try catch
}

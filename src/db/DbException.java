package db;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
	
	// Aqui n�s criamos a exce��o personalizada para n�o precisar toda hora ficar colocando um try catch
}

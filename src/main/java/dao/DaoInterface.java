package dao;

public interface DaoInterface<D> {
	public void insert(D d);
	public void remove(D d);
}

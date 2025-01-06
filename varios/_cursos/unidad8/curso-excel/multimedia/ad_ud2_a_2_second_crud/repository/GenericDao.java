package ad.ad_ud2_a_2_second_crud.repository;

import java.util.List;

/**
 * Esta interfaz nos obliga a implementar todos los metodos habituales de un CRUD
 * @param <T>
 */
public interface GenericDao<T> {

		List<T> getAll() throws Exception;
		T getById (int id);
		void create(T t);
		void update(T t);
		void delete(int id);
	
}

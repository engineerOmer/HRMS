package inonu.hrms.core.dataAccess.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

        <S extends T>DataResult<S> insert(S entity);
        <S extends T> DataResult<S> update(S entity);
        <S extends T> List<S> insertAll(Iterable<S> entities);
        <S extends T> List<S> updateAll(Iterable<S> entities);


}

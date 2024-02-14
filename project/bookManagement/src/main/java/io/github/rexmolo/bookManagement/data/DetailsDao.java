package io.github.rexmolo.bookManagement.data;

import io.github.rexmolo.bookManagement.entity.Details;

import java.util.Collection;

public interface DetailsDao {

    Details findById(int id);
    Collection<Details> findAll();
    Details create();
    Details update();
    void delete();
}

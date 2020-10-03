//Llamar paquete
package com.acme.homemade.demo.domain.reposiroty;

//Importar modelo del Recipe y los frameworks de spring
import com.acme.homemade.demo.domain.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Importar utilidad de java y llamar interfaz publica
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Page<Recipe> findByUserChefId(Long userChefId, Pageable pageable);
     Optional<Recipe> findByIdAndUserChefId(Long Id,Long userChefId);

}

package br.com.reservaai.application.resources.item;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.item.Category;
import br.com.reservaai.domain.repositories.item.CategoryRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 24/09/2017
 */
@RestController
@RequestMapping("/category")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     *
     * @param category
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Category category) {
        Preconditions.checkNotNull(category);
        return this.categoryRepository.save(category).getId();
    }

    /**
     *
     * @param category
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Category category) {
        Preconditions.checkNotNull(category);
        Preconditions.checkNotNull(category.getId());
        this.categoryRepository.save(category);
    }

    /**
     *
     * @param id
     */
    @ResponseBody
    @ResponseStatus(OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final Category category = RestPreconditions.checkFound(
                this.categoryRepository.findOne(id));

        this.categoryRepository.delete(category);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Category findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.categoryRepository.findOne(id));
    }
}

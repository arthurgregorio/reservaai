package br.com.reservaai.application.resources.item;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.item.Item;
import br.com.reservaai.domain.repositories.item.ItemRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * The rest resource for the items
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@RestController
@RequestMapping("/item")
public class ItemResource {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Create an item
     *
     * @param item the item to create
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Item item) {
        Preconditions.checkNotNull(item);
        return this.itemRepository.save(item).getId();
    }

    /**
     * Update a existing item
     *
     * @param item the item to update, with its ID
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Item item) {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        this.itemRepository.save(item);
    }

    /**
     * Delete an item by the ID
     *
     * @param id the id of the item to delete
     */
    @ResponseBody
    @ResponseStatus(OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final Item item = RestPreconditions.checkFound(
                this.itemRepository.findOne(id));

        this.itemRepository.delete(item);
    }

    /**
     * Find and list all the items found on the databse
     *
     * @return the list of items found
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    /**
     * Find one item by the ID
     *
     * @param id the id of the item to search
     * @return the item found
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Item findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.itemRepository.findOne(id));
    }
}

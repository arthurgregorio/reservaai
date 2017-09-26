package br.com.reservaai.application.resources.item;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.item.State;
import br.com.reservaai.domain.repositories.item.StateRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 25/09/2017
 */
@RestController
@RequestMapping("/state")
public class StateResource {

    @Autowired
    private StateRepository stateRepository;

    /**
     *
     * @param state
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated State state) {
        Preconditions.checkNotNull(state);
        return this.stateRepository.save(state).getId();
    }

    /**
     *
     * @param state
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody State state) {
        Preconditions.checkNotNull(state);
        Preconditions.checkNotNull(state.getId());
        this.stateRepository.save(state);
    }

    /**
     *
     * @param id
     */
    @ResponseBody
    @ResponseStatus(OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final State state = RestPreconditions.checkFound(
                this.stateRepository.findOne(id));

        this.stateRepository.delete(state);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<State> findAll() {
        return this.stateRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public State findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.stateRepository.findOne(id));
    }
}

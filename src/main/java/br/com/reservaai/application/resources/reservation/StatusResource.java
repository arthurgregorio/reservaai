package br.com.reservaai.application.resources.reservation;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.reservation.Status;
import br.com.reservaai.domain.repositories.reservation.StatusRepository;
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
@RequestMapping("/status")
public class StatusResource {

    @Autowired
    private StatusRepository statusRepository;

    /**
     *
     * @param status
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Status status) {
        Preconditions.checkNotNull(status);
        return this.statusRepository.save(status).getId();
    }

    /**
     *
     * @param status
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Status status) {
        Preconditions.checkNotNull(status);
        Preconditions.checkNotNull(status.getId());
        this.statusRepository.save(status);
    }

    /**
     *
     * @param id
     */
    @ResponseBody
    @ResponseStatus(OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final Status status = RestPreconditions.checkFound(
                this.statusRepository.findOne(id));

        this.statusRepository.delete(status);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Status> findAll() {
        return this.statusRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Status findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.statusRepository.findOne(id));
    }
}

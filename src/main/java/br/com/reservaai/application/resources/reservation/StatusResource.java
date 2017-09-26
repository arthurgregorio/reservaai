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
 * The rest resource for the statuses of a reservation
 *
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
     * Create a new status
     *
     * @param status the status to create
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Status status) {
        Preconditions.checkNotNull(status);
        return this.statusRepository.save(status).getId();
    }

    /**
     * Update a given status
     *
     * @param status the status to update with its ID
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Status status) {
        Preconditions.checkNotNull(status);
        Preconditions.checkNotNull(status.getId());
        this.statusRepository.save(status);
    }

    /**
     * Delete the status by the given ID
     *
     * @param id the id of the status to delete
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
     * Find and list all the statuses available on the database
     *
     * @return the list of the statuses
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Status> findAll() {
        return this.statusRepository.findAll();
    }

    /**
     * Find one status by the given ID
     *
     * @param id the ID to find the status
     * @return the status found
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Status findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.statusRepository.findOne(id));
    }
}

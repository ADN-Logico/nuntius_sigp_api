/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.controller;

import ao.adnlogico.nuntius.multitenant.dto.AuthResponse;
import ao.adnlogico.nuntius.multitenant.exception.EntityNotFoundException;
import ao.adnlogico.nuntius.multitenant.security.RequestAuthorization;
import ao.adnlogico.nuntius.multitenant.tenant.user.User;
import ao.adnlogico.nuntius.multitenant.tenant.model_assembler.UserModelAssembler;
import ao.adnlogico.nuntius.multitenant.tenant.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author domingos.fernando
 */
@RestController
@RequestMapping("/nuntius/v1/api")
public class UserController implements Serializable
{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

//    @Autowired
//    roleTypeService service;
    private final UserRepository repository;
    private final UserModelAssembler assembler;

    public UserController(UserRepository repository, UserModelAssembler assembler)
    {

        this.repository = repository;
        this.assembler = assembler;
    }

    @RequestAuthorization
    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    public ResponseEntity<?> userInfo(@RequestParam String userName) throws AuthenticationException
    {
        User current = repository.findByEmail(userName);
        AuthResponse response = new AuthResponse(current.getId(), current.getEmail(), "");
        return ResponseEntity.ok(response);
    }

    @RequestAuthorization
    @GetMapping("/user")
    public CollectionModel<EntityModel<User>> all()
    {
        List<EntityModel<User>> users = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @RequestAuthorization
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user)
    {
        EntityModel<User> entityModel = assembler.toModel(repository.save(user));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @RequestAuthorization
    @GetMapping("/user/{id}")
    public EntityModel<User> findById(@PathVariable Long id)
    {
        User user = repository.findById(id) //
                .orElseThrow(() -> new EntityNotFoundException(new User(), id));

        return assembler.toModel(user);
    }

    @RequestAuthorization
    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User newUser, @PathVariable Long id)
    {
        User updatedUser = repository.findById(id) //
                .map(user -> {
                    user.setPhone(newUser.getPhone());
                    user.setPhoneAlt(newUser.getPhoneAlt());
                    user.setMechanographicNumber(newUser.getMechanographicNumber());
                    user.setDescription(newUser.getDescription());
                    user.setUpdatedAt(newUser.getCreatedAt());
                    user.setFkFunction(newUser.getFkFunction());
                    user.setFkRole(newUser.getFkRole());
                    return repository.save(user);
                }) //
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });

        EntityModel<User> entityModel = assembler.toModel(updatedUser);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @RequestAuthorization
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updatePassword(@RequestBody User newUser, @PathVariable Long id)
    {
        User updatedUser = repository.findById(id) //
                .map(user -> {
                    user.setPhone(newUser.getPhone());
                    user.setPhoneAlt(newUser.getPhoneAlt());
                    user.setMechanographicNumber(newUser.getMechanographicNumber());
                    user.setDescription(newUser.getDescription());
                    user.setUpdatedAt(newUser.getCreatedAt());
                    user.setFkFunction(newUser.getFkFunction());
                    user.setFkRole(newUser.getFkRole());
                    return repository.save(user);
                }) //
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });

        EntityModel<User> entityModel = assembler.toModel(updatedUser);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @RequestAuthorization
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}

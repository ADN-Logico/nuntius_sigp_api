/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.tenant.forwarding;

import ao.adnlogico.nuntius.multitenant.tenant.forwarding.ForwardingController;
import ao.adnlogico.nuntius.multitenant.tenant.forwarding.Forwarding;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 *
 * @author domingos.fernando
 */
@Component
public class ForwardingModelAssembler implements RepresentationModelAssembler<Forwarding, EntityModel<Forwarding>>
{

    @Override
    public EntityModel<Forwarding> toModel(Forwarding process)
    {

        return EntityModel.of(process, //
                linkTo(methodOn(ForwardingController.class).findById(process.getId())).withSelfRel(),
                linkTo(methodOn(ForwardingController.class).all()).withRel("provinces"));
    }
}

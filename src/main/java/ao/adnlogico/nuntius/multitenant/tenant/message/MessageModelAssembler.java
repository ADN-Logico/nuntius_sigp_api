/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.tenant.message;

import ao.adnlogico.nuntius.multitenant.tenant.message.Message;
import ao.adnlogico.nuntius.multitenant.tenant.message.MessageController;
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
public class MessageModelAssembler implements RepresentationModelAssembler<Message, EntityModel<Message>>
{

    @Override
    public EntityModel<Message> toModel(Message process)
    {

        return EntityModel.of(process, //
                linkTo(methodOn(MessageController.class).findById(process.getId())).withSelfRel(),
                linkTo(methodOn(MessageController.class).all()).withRel("provinces"));
    }
}

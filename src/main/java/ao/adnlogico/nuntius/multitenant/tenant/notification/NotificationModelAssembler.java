/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.tenant.notification;

import ao.adnlogico.nuntius.multitenant.tenant.notification.Notification;
import ao.adnlogico.nuntius.multitenant.tenant.notification.NotificationController;
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
public class NotificationModelAssembler implements RepresentationModelAssembler<Notification, EntityModel<Notification>>
{

    @Override
    public EntityModel<Notification> toModel(Notification process)
    {

        return EntityModel.of(process, //
                linkTo(methodOn(NotificationController.class).findById(process.getId())).withSelfRel(),
                linkTo(methodOn(NotificationController.class).all()).withRel("provinces"));
    }
}

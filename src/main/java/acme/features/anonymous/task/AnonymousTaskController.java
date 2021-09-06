package acme.features.anonymous.task;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.tasks.Task;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/task/")
public class AnonymousTaskController extends AbstractController<Anonymous, Task> {

	// Internal state --------------------------------------------------------
	
	
	@Autowired
	protected AnonymousTaskListPublicNonFinished listPublicNonFinishedService;
	
	@Autowired
	protected AnonymousTaskShowService showService;
	
	// Constructors ----------------------------------------------------------
	
	
	@PostConstruct
	protected void initialise() {
		super.addCustomCommand(CustomCommand.LIST_PUBLIC_NON_FINISHED, BasicCommand.LIST, this.listPublicNonFinishedService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
	
	
}

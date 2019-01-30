package es.urjc.etsii.dad.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class webController {

	@GetMapping("/index")
	public String indexPrueba() {
		return "index.html";
	}
}

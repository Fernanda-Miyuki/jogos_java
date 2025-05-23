package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Modo;
import application.repository.ModoRepository;

@Controller
@RequestMapping("/modos")
public class ModoController {
    @Autowired
    private ModoRepository modoRepo;

    @RequestMapping("/insert")
    public String insert() {
        return "/modos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("descricao") String descricao) {
        Modo modo = new Modo();
        modo.setDescricao(descricao);
        modoRepo.save(modo);
        return "redirect:/modos/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("modos", modoRepo.findAll());
        return "/modos/list";
    }
}



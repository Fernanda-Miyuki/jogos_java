package application.controller;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import application.model.Jogo;
import application.model.Modo;
import application.model.Genero;
import application.model.Plataforma;
import application.repository.JogoRepository;
import application.repository.ModoRepository;
import application.repository.GeneroRepository;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepo;

    @Autowired
    private ModoRepository modoRepo;

    @Autowired
    private GeneroRepository generoRepo;

    @Autowired
    private PlataformaRepository plataformaRepo;

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("modos", modoRepo.findAll());
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("plataformas", plataformaRepo.findAll());
        return "/jogos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("id_modo") long id_modo,
        @RequestParam("generos") long[] ids_generos,
        @RequestParam("plataformas") long[] ids_plataformas) {

        Optional<Modo> modo = modoRepo.findById(id_modo);

        if (modo.isPresent()) {
            Jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setModo(modo.get());

            for (long id : ids_plataformas) {
                Optional<Plataforma> plataforma = plataformaRepo.findById(id);
                if (plataforma.isPresent()) {
                    jogo.getPlataformas().add(plataforma.get());
                }
            }

            for (long id : ids_generos) {
                Optional<Genero> genero = generoRepo.findById(id);
                if (genero.isPresent()) {
                    jogo.getGeneros().add(genero.get());
                }
            }

            jogoRepo.save(jogo);
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("jogos", jogoRepo.findAll());
        return "/jogos/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable long id, Model ui) {
        Optional<Jogo> jogo = jogoRepo.findById(id);

        if (jogo.isPresent()) {
            ui.addAttribute("jogo", jogo.get());
            ui.addAttribute("modos", modoRepo.findAll());
            ui.addAttribute("generos", generoRepo.findAll());
            ui.addAttribute("plataformas", plataformaRepo.findAll());
            return "/jogos/update";
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("titulo") String titulo,
        @RequestParam("id_modo") long id_modo,
        @RequestParam("generos") long[] ids_generos,
        @RequestParam("plataformas") long[] ids_plataformas) {

        Optional<Jogo> result = jogoRepo.findById(id);

        if (result.isPresent()) {
            Jogo jogo = result.get();

            Optional<Modo> modo = modoRepo.findById(id_modo);
            if (modo.isPresent()) {
                jogo.setTitulo(titulo);
                jogo.setModo(modo.get());

                jogo.setPlataformas(new HashSet<Plataforma>());
                for (long idPlataforma : ids_plataformas) {
                    Optional<Plataforma> plataforma = plataformaRepo.findById(idPlataforma);
                    if (plataforma.isPresent()) {
                        jogo.getPlataformas().add(plataforma.get());
                    }
                }

                jogo.setGeneros(new HashSet<Genero>());
                for (long idGenero : ids_generos) {
                    Optional<Genero> genero = generoRepo.findById(idGenero);
                    if (genero.isPresent()) {
                        jogo.getGeneros().add(genero.get());
                    }
                }

                jogoRepo.save(jogo);
            }
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model ui) {
        Optional<Jogo> jogo = jogoRepo.findById(id);

        if (jogo.isPresent()) {
            ui.addAttribute("jogo", jogo.get());
            return "/jogos/delete";
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        jogoRepo.deleteById(id);
        return "redirect:/jogos/list";
    }
}

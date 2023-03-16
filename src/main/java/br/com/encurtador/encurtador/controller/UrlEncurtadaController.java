package br.com.encurtador.encurtador.controller;

import br.com.encurtador.encurtador.UrlDto;
import br.com.encurtador.encurtador.service.UrlEncurtadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/neblinly")
public class UrlEncurtadaController {

    @Autowired
    private UrlEncurtadaService service;

    @GetMapping("/{url}")
    public ModelAndView redirecionarParaUrl(@PathVariable String url) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(service.redirect(url));
        return new ModelAndView(redirectView);
    }

    @PostMapping("/url-encurtada/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody UrlDto url) {
        String cursoCreated = service.salvar(url);

        return ResponseEntity.status(201).body(cursoCreated);
    }

}

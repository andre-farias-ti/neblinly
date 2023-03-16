package br.com.encurtador.encurtador.service;

import br.com.encurtador.encurtador.UrlDto;
import br.com.encurtador.encurtador.model.UrlEncurtada;
import br.com.encurtador.encurtador.repository.UrlEncurtadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UrlEncurtadaService {
    @Autowired
    private UrlEncurtadaRepository repository;


    public String redirect(String url){
        return repository.findByEncurtada(url).getOriginal();
    }

    public String salvar(UrlDto url) {

        UrlEncurtada nova = new UrlEncurtada().toBuilder()
                .original(url.getUrlOiginal())
                .encurtada(GeradorDeStringAleatoria()).build();

        return "http://localhost:8081/neblinly/"+repository.save(nova).getEncurtada();
    }
    public UrlEncurtada buscarUrl(String entity){
        return repository.findByEncurtada(entity);
    }


    public String GeradorDeStringAleatoria() {

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int LENGTH = 6;

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder(LENGTH);

            for (int i = 0; i < LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                sb.append(randomChar);
            }

            return sb.toString();
    }

}

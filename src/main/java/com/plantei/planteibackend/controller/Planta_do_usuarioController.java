package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.Planta;
import com.plantei.planteibackend.model.Planta_do_usuario;
import com.plantei.planteibackend.repository.RepositorioPlanta_do_usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/planta_do_usuario")
public class Planta_do_usuarioController {
    @Autowired
    private RepositorioPlanta_do_usuario repositorioPlanta_do_usuario;

    /**
     * <p>Retorna uma lista com todas as plantas cadastradas no banco de dados.</p>
     * Path: api/planta/listar
     *
     * @return JSON com todas as plantas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<Planta_do_usuario> getAllPlants(HttpServletRequest request) {
        return repositorioPlanta_do_usuario.findAll();
    }

    /**
     * <p>Retorna os dados de uma planta cujo ID eh fornecido no path da requisicao.</p>
     * Path: api/planta_do_usuario/{id}
     *
     * @param id ID que identifica a planta_do_usuario no banco de dados.
     * @return JSON com os dados da planta_do_usuario.
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Planta_do_usuario> getPlantByid(@PathVariable long id) throws ResourceNotFoundException {
        Planta_do_usuario dadosPlanta_do_usuario = repositorioPlanta_do_usuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosPlanta_do_usuario);
    }

    /**
     * <p>Cadastra uma nova planta no banco de dados. Seus dados (JSON) sao passados no
     * body da requisicao.</p>
     * Path: api/planta/add
     *
     * @param planta Dados JSON da nova planta que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planta_do_usuario> addPlant(@RequestBody Planta_do_usuario planta_do_usuario) {
        repositorioPlanta_do_usuario.save(planta_do_usuario);

        return ResponseEntity.ok(planta_do_usuario);
    }

    /**
     * <p>Altera os dados de uma planta existente no banco de dados. Os seus dados (JSON) de alteracao sao dados
     * no body da requisicao.</p>
     * Path: api/planta/alterarDados/{id}
     *
     * @param id          ID da planta que se quer atualizar seus dados.
     * @param dadosPlanta Novos dados da planta_do_usuario.
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planta_do_usuario> updatePlant(@PathVariable long id, @RequestBody Planta_do_usuario dadosPlanta_do_usuario) throws ResourceNotFoundException {
        Planta_do_usuario planta_do_usuarioAlterada = repositorioPlanta_do_usuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));

        planta_do_usuarioAlterada.setNome(dadosPlanta_do_usuario.getNome());

        repositorioPlanta_do_usuario.save(planta_do_usuarioAlterada);

        return ResponseEntity.ok(planta_do_usuarioAlterada);
    }

    /**
     * Remove uma planta cadastrada no banco de dados.
     * Path: api/planta/remover/{id}
     *
     * @param id ID da planta que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePlantById(@PathVariable Long id) {
        repositorioPlanta_do_usuario.deleteById(id);

        return ResponseEntity.ok(id);
    }
}

package br.com.teste.controle;

import br.com.teste.UsuarioServico;
import br.com.teste.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {

    @Autowired
    private UsuarioServico servico;

    @PostMapping
    public ResponseEntity<Usuario>criarUsuario(@RequestBody Usuario usuario){
        var criar = servico.criarUsuario(usuario);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(criar.getId()).toUri();
        return ResponseEntity.created(uri).body(criar);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>buscarUsuarios(){
        return ResponseEntity.ok().body(servico.buscarUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario>atualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuario){
        return ResponseEntity.ok().body(servico.atualizarUsuario(id,usuario));
    }
}

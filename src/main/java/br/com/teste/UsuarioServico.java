package br.com.teste;

import br.com.teste.entidade.Usuario;
import br.com.teste.excessoes.UsuarioNaoEncontrado;
import br.com.teste.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario>buscarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario>buscar = usuarioRepositorio.findById(id);
        return buscar.orElseThrow( UsuarioNaoEncontrado::new);
    }

    public Usuario atualizarUsuario(Long id,Usuario usuario){
        var usuarioEntidade = buscarPorId(id);
        var atualizandoUsuario = Usuario.builder()
                .id(usuarioEntidade.getId())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntidade.getNome())
                .fone(usuario.getFone() != null ? usuario.getNome() : usuarioEntidade.getFone())
                .sexo(usuario.getSexo() != null ? usuario.getNome() : usuarioEntidade.getSexo())
                .build();
        return usuarioRepositorio.save(atualizandoUsuario);
    }
    public void deletarUsuario(Long id){
        buscarPorId(id);
        usuarioRepositorio.deleteById(id);
    }
}

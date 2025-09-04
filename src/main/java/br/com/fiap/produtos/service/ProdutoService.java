package br.com.fiap.produtos.service;

import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if(produtoOptional.isPresent()){
            return produtoOptional.get();
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto atualizar(Produto produto){
        Optional<Produto> produtoAtualizado = produtoRepository.findById(produto.getId());
        if(produtoAtualizado.isPresent()){
            return produtoRepository.save(produtoAtualizado.get());
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }

    public void excluir(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }
}
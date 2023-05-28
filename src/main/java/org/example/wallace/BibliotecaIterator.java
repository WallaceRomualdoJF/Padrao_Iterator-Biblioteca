package org.example.wallace;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Classe que implementa o Iterator para a coleção de livros
class BibliotecaIterator implements Iterator<Livro> {
    private Livro[] livros;
    private int indiceAtual;

    public BibliotecaIterator(Livro[] livros) {
        this.livros = livros;
        this.indiceAtual = 0;
    }

    @Override
    public boolean hasNext() {
        return indiceAtual < livros.length;
    }

    @Override
    public Livro next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não há mais livros na biblioteca.");
        }
        Livro livro = livros[indiceAtual];
        indiceAtual++;
        return livro;
    }
}

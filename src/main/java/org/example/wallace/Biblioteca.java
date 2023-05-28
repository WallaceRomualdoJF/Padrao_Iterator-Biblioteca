package org.example.wallace;

import java.util.Iterator;

// Classe que representa a biblioteca
public class Biblioteca implements Iterable<Livro> {
    public Livro[] livros;
    public int numLivros;

    public Biblioteca(int capacidade) {
        livros = new Livro[capacidade];
        numLivros = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (numLivros < livros.length) {
            livros[numLivros] = livro;
            numLivros++;
        }
    }

    @Override
    public Iterator<Livro> iterator() {
        return new BibliotecaIterator(livros);
    }

    public int getNumLivros() {
        return numLivros;
    }

    public Livro[] getLivros() {
        return new Livro[0];
    }
}

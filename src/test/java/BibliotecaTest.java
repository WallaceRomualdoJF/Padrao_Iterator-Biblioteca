import org.example.wallace.Biblioteca;
import org.example.wallace.Livro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void setup() {
        biblioteca = new Biblioteca(3);
        biblioteca.adicionarLivro(new Livro("Livro 1"));
        biblioteca.adicionarLivro(new Livro("Livro 2"));
        biblioteca.adicionarLivro(new Livro("Livro 3"));
    }

    @Test
    public void testIteratorRetornaLivrosCorretos() {
        Iterator<Livro> iterator = biblioteca.iterator();
        Assert.assertEquals("Livro 1", iterator.next().getTitulo());
        Assert.assertEquals("Livro 2", iterator.next().getTitulo());
        Assert.assertEquals("Livro 3", iterator.next().getTitulo());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorLancaExcecaoAposUltimoLivro() {
        Iterator<Livro> iterator = biblioteca.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next(); // Deve lançar NoSuchElementException
    }

    @Test
    public void testIteratorPermiteRemocaoDeLivro() {
        Iterator<Livro> iterator = biblioteca.iterator();
        iterator.next();
        iterator.remove();
        Assert.assertEquals(2, biblioteca.getNumLivros());
        Assert.assertEquals("Livro 2", biblioteca.getLivros()[0].getTitulo());
        Assert.assertEquals("Livro 3", biblioteca.getLivros()[1].getTitulo());
    }

    @Test
    public void testAdicionarLivroAlemDaCapacidadeMaxima() {
        biblioteca.adicionarLivro(new Livro("Livro 4"));
        biblioteca.adicionarLivro(new Livro("Livro 5"));
        Assert.assertEquals(3, biblioteca.getNumLivros());
        Assert.assertEquals("Livro 2", biblioteca.getLivros()[0].getTitulo());
        Assert.assertEquals("Livro 3", biblioteca.getLivros()[1].getTitulo());
        Assert.assertEquals("Livro 4", biblioteca.getLivros()[2].getTitulo()); // Último livro adicionado além da capacidade máxima
    }
}
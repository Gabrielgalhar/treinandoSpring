package Galhardone.exe.livraria.Service;

import Galhardone.exe.livraria.entity.Livro;
import Galhardone.exe.livraria.repository.LivroRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;


    public Livro creat(Livro obj){
        return (Livro) repository.save(obj);

    }

    public void delete(long id){
        repository.deleteById(id);
    }
    public Livro getId(long id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.get();
    }
    public List<Livro> getAll(){
        return repository.findAll();
    }
    public Livro update(Livro obj){
       Optional<Livro> newObj = repository.findById(obj.getId());
       UpdateLivro(newObj, obj);
       return (Livro) repository.save(newObj.get());
    }

    private void UpdateLivro(Optional<Livro> newObj, Livro obj) {
        newObj.get().setNome(obj.getNome());
    }


}

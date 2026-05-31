package com.FMDA.resena.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.FMDA.resena.Exception.ResenaDuplicadaException;
import com.FMDA.resena.Exception.ResenaNotFoundException;
import com.FMDA.resena.Model.Resena;
import com.FMDA.resena.Repository.ResenaRepository;
import com.FMDA.resena.dto.ResenaRequest;
import com.FMDA.resena.dto.ResenaResponse;

@Service
public class ResenaService {

    private final ResenaRepository repository;

    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public ResenaRepository repository() {
        return this.repository;
    }

    public List<ResenaResponse> listarTodos() {
        return repository.findAll().stream()
                .map(this::ConvertirAResponse)
                .collect(Collectors.toList());
    }

    public ResenaResponse buscarPorId(Long id) {
        Resena resena = repository.findById(id);
        if (resena == null) {
            throw new ResenaNotFoundException(id);
        }
        return ConvertirAResponse(resena);
    }

    public ResenaResponse crear(ResenaRequest request) {

        if (repository.findByUsuario(request.getUsuario()) != null) {
            throw new ResenaDuplicadaException(request.getUsuario());
        }

        Resena resena = new Resena();
        resena.setUsuario(request.getUsuario());
        resena.setCalificacion(Integer.parseInt(request.getCalificacion()));
        resena.setComentario(request.getComentario());

        Resena guardada = repository.save(resena);

        return ConvertirAResponse(guardada);
    }

    public void Eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResenaNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public ResenaResponse actualizar(Long id, ResenaRequest request) {
        if (!repository.existsById(id)) {
            throw new ResenaNotFoundException(id);
        }
        Resena resena = new Resena();
        resena.setId(id);
        resena.setUsuario(request.getUsuario());
        resena.setCalificacion(Integer.parseInt(request.getCalificacion()));
        resena.setComentario(request.getComentario());
        Resena actualizada = repository.update(resena);
        return ConvertirAResponse(actualizada);
    }

    public ResenaResponse ConvertirAResponse(Resena resena) {
        return new ResenaResponse(
                resena.getId(),
                resena.getUsuario(),
                resena.getCalificacion(),
                resena.getComentario(),
                resena.getFecharesena());
    }
}

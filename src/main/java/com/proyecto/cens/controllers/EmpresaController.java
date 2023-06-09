package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.EmpresaDao;
import com.proyecto.cens.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {
    @Autowired
    private EmpresaDao empresaDao;

    @RequestMapping(value = "api/empresa", method = RequestMethod.POST)
    public void crearEmpresa(@RequestBody Empresa empresa) {
        empresaDao.crear(empresa);
    }

    @RequestMapping(value = "api/modificar-empresa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa empresaExistente = empresaDao.obtenerPorId(id);

        if (empresaExistente != null) {
            empresaExistente.setRutEmpresa(empresa.getRutEmpresa());
            empresaExistente.setRazonSocial(empresa.getRazonSocial());
            empresaExistente.setFechaIngreso(empresa.getFechaIngreso());
            empresaDao.actualizar(empresaExistente);

            String mensajeEncontrado = "La empresa se ha actualizado correctamente";
            return ResponseEntity.ok(mensajeEncontrado);
        } else {
            String mensajeError = "El ID seleccionado no existe";
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/eliminar-empresa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Long id) {
        Empresa empresaExistente = empresaDao.obtenerPorId(id);

        if (empresaExistente != null) {
            empresaDao.eliminar(empresaExistente);

            String mensaje = "La empresa se ha eliminado correctamente";
            return ResponseEntity.ok(mensaje);
        } else {
            String mensajeError = "La empresa no existe";
            return ResponseEntity.ok(mensajeError);
        }
    }


    @GetMapping(value = "api/tabla-empresa")
    public List<Empresa> obtenerEmpresas() {
        return empresaDao.obtenerTodasLasEmpresas();
    }
}

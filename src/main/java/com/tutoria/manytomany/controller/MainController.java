package com.tutoria.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutoria.manytomany.dto.SubDTO;
import com.tutoria.manytomany.service.UsuarioService;

@RestController
public class MainController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PutMapping("/subscribe")
	public ResponseEntity<?> subscribe(@RequestBody SubDTO dto) {
		usuarioService.subscribe(dto.getIdUser(), dto.getIdCanal());
		return new ResponseEntity<>("te has subscrito", HttpStatus.OK);
	}
	
	@PutMapping("/unsubscribe")
	public ResponseEntity<?> unsubscribe(@RequestBody SubDTO dto) {
		usuarioService.unsubscribe(dto.getIdUser(), dto.getIdCanal());
		return new ResponseEntity<>("te has borrado", HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecanal/{id}")
	public ResponseEntity<?> deleteCanal(@PathVariable("id") int id) {
		usuarioService.deleteCanal(id);
		return new ResponseEntity<>("canal eliminado", HttpStatus.OK);
	}

}

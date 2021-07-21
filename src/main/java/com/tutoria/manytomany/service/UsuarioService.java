package com.tutoria.manytomany.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoria.manytomany.entity.Canal;
import com.tutoria.manytomany.entity.Usuario;
import com.tutoria.manytomany.repository.CanalRepository;
import com.tutoria.manytomany.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CanalRepository canalRepository;
	
	public void subscribe(int idUser, int idCanal) {
		Usuario usuario = usuarioRepository.findById(idUser).get();
		Canal canal = canalRepository.findById(idCanal).get();
		usuario.subscribe(canal);
		usuarioRepository.save(usuario);
	}
	
	public void unsubscribe(int idUser, int idCanal) {
		Usuario usuario = usuarioRepository.findById(idUser).get();
		Canal canal = canalRepository.findById(idCanal).get();
		usuario.unsubscribe(canal);
		usuarioRepository.save(usuario);
	}
	
	public void deleteCanal(int id) {
		canalRepository.deleteById(id);
	}

}

package br.com.fiap.gs2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.gs2.models.AmbienteModel;
import br.com.fiap.gs2.repositories.AmbienteRepository;

@Controller
@RequestMapping("/v1/ambiente")
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@PostMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<AmbienteModel> cadastroAmbiente(@RequestBody AmbienteModel ambiente){
		ambienteRepository.save(ambiente);
		return new ResponseEntity<AmbienteModel>(ambiente, HttpStatus.CREATED);
	}
	
	@GetMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<List<AmbienteModel>> listaAmbiente() {
		return new ResponseEntity<List<AmbienteModel>>(ambienteRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping
	@CrossOrigin
	@RequestMapping("/{ambienteID}")
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<AmbienteModel> itemAmbiente(@PathVariable int ambienteID) {
		return new ResponseEntity<AmbienteModel>(ambienteRepository.findById(ambienteID).get(), HttpStatus.OK);
	}
	
	@PutMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<AmbienteModel> atualizarAmbiente(@RequestBody AmbienteModel ambiente){
		Optional<AmbienteModel> ambienteAux = ambienteRepository.findById(ambiente.getAmbienteID());
		
		ambienteAux.get().setEstado(ambiente.getEstado());
		ambienteAux.get().setCidade(ambiente.getCidade());
		ambienteAux.get().setBairro(ambiente.getBairro());
		ambienteAux.get().setTemperaturaAmbiente(ambiente.getTemperaturaAmbiente());
		ambienteAux.get().setQualidadeDoAr(ambiente.getQualidadeDoAr());
		
		ambienteRepository.save(ambienteAux.get());
		return new ResponseEntity<AmbienteModel>(ambienteAux.get(), HttpStatus.OK);
	}
	
	@DeleteMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<AmbienteModel> deletarAmbiente(@RequestBody int ambienteID){
		ambienteRepository.deleteById(ambienteID);
		return new ResponseEntity<AmbienteModel>(HttpStatus.OK);
	}
}

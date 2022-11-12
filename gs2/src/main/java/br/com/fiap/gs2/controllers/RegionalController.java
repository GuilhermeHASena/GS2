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

import br.com.fiap.gs2.models.RegionalModel;
import br.com.fiap.gs2.repositories.RegionalRepository;

@Controller
@RequestMapping("/v1/regional")
public class RegionalController {
	
	@Autowired
	private RegionalRepository regionalRepository;
	
	@PostMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<RegionalModel> cadastroRegional(@RequestBody RegionalModel regional){
		regionalRepository.save(regional);
		return new ResponseEntity<RegionalModel>(regional, HttpStatus.CREATED);
	}
	
	@GetMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<List<RegionalModel>> listaRegional() {
		return new ResponseEntity<List<RegionalModel>>(regionalRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping
	@CrossOrigin
	@RequestMapping("/{regionalID}")
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<RegionalModel> itemRegional(@PathVariable int regionalID) {
		return new ResponseEntity<RegionalModel>(regionalRepository.findById(regionalID).get(), HttpStatus.OK);
	}
	
	@PutMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<RegionalModel> atualizarRegional(@RequestBody RegionalModel regional){
		Optional<RegionalModel> regionalAux = regionalRepository.findById(regional.getRegionalID());
		
		regionalAux.get().setDataDeOperacao(regional.getDataDeOperacao());
		regionalAux.get().setVeiculos(regional.getVeiculos());
		
		regionalRepository.save(regionalAux.get());
		return new ResponseEntity<RegionalModel>(regionalAux.get(), HttpStatus.OK);
	}
	
	@DeleteMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<RegionalModel> deletarRegional(@RequestBody int regionalID){
		regionalRepository.deleteById(regionalID);
		return new ResponseEntity<RegionalModel>(HttpStatus.OK);
	}
}

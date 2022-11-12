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

import br.com.fiap.gs2.models.VeiculoModel;
import br.com.fiap.gs2.repositories.VeiculoRepository;

@Controller
@RequestMapping("/v1/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<VeiculoModel> cadastroVeiculo(@RequestBody VeiculoModel veiculo){
		veiculoRepository.save(veiculo);
		return new ResponseEntity<VeiculoModel>(veiculo, HttpStatus.CREATED);
	}
	
	@GetMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<List<VeiculoModel>> listaVeiculos() {
		return new ResponseEntity<List<VeiculoModel>>(veiculoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping
	@CrossOrigin
	@RequestMapping("/{veiculoID}")
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<VeiculoModel> itemVeiculo(@PathVariable int veiculoID) {
		return new ResponseEntity<VeiculoModel>(veiculoRepository.findById(veiculoID).get(), HttpStatus.OK);
	}
	
	@PutMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<VeiculoModel> atualizarVeiculo(@RequestBody VeiculoModel veiculo){
		Optional<VeiculoModel> veiculoAux = veiculoRepository.findById(veiculo.getVeiculoID());
		
		veiculoAux.get().setAmbienteID(veiculo.getAmbienteID());
		veiculoAux.get().setMarca(veiculo.getMarca());
		veiculoAux.get().setModelo(veiculo.getModelo());
		veiculoAux.get().setPlaca(veiculo.getPlaca());
		veiculoAux.get().setQuilometragem(veiculo.getQuilometragem());
		
		veiculoRepository.save(veiculoAux.get());
		return new ResponseEntity<VeiculoModel>(veiculoAux.get(), HttpStatus.OK);
	}
	
	@DeleteMapping
	@CrossOrigin
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<VeiculoModel> deletarVeiculo(@RequestBody int veiculoID){
		veiculoRepository.deleteById(veiculoID);
		return new ResponseEntity<VeiculoModel>(HttpStatus.OK);
	}
}

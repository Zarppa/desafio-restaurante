package com.dbserver.desafioRastaurante.unit.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.dto.RestauranteDTO;
import com.dbserver.desafioRastaurante.dto.VotoDTO;
import com.dbserver.desafioRastaurante.entities.Profissional;
import com.dbserver.desafioRastaurante.entities.Restaurante;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.entities.Voto;
import com.dbserver.desafioRastaurante.repository.ProfissionalRepository;
import com.dbserver.desafioRastaurante.repository.RestauranteRepository;
import com.dbserver.desafioRastaurante.repository.VotacaoRepository;
import com.dbserver.desafioRastaurante.repository.VotoRepository;
import com.dbserver.desafioRastaurante.service.VotacaoService;
import com.dbserver.desafioRastaurante.service.exceptions.ActionDeniedException;
import com.dbserver.desafioRastaurante.util.CalendarUtil;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class VotacaoServiceTest {

	@Autowired
	private VotacaoService votacaoService;

	@MockBean
	private VotacaoRepository votacaoRepository;

	@MockBean
	private ProfissionalRepository profissionalRepository;

	@MockBean
	private VotoRepository votoRepository;

	@MockBean
	private RestauranteRepository restauranteRepository;

	private static final Date HOJE = CalendarUtil.truncate(Calendar.getInstance()).getTime();

	@Test
	public void deve_iniciar_votacao() {

		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Profissional profissional = new Profissional();
		profissional.setId(profissionalDTO.getId());
		profissional.setNome(profissionalDTO.getNome());

		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setFacilitador(profissional);

		BDDMockito.given(votacaoRepository.findByDataVotacao(Mockito.any(Date.class))).willReturn(null);
		BDDMockito.given(profissionalRepository.findById(Mockito.any(Integer.class)))
				.willReturn(Optional.of(profissional));
		BDDMockito.given(this.votacaoRepository.save(Mockito.any(Votacao.class))).willReturn(votacao);

		Votacao votacaoIniciada = votacaoService.iniciarVotacao(profissionalDTO);

		Assert.assertNotNull(votacaoIniciada);

	}

	@Test
	public void nao_deve_inicar_votacao_lancar_ActionDeniedException() {

		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		BDDMockito.given(votacaoRepository.findByDataVotacao(Mockito.any(Date.class))).willReturn(new Votacao());
		try {
			votacaoService.iniciarVotacao(profissionalDTO);

		} catch (ActionDeniedException e) {
			Assert.assertEquals("Votação já foi iniciada hoje", e.getMessage());
		}
	}

	@Test
	public void deve_apurar_vencedor_caminho_feliz() {

		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Profissional profissional = new Profissional();
		profissional.setId(profissionalDTO.getId());
		profissional.setNome(profissionalDTO.getNome());

		Restaurante vencedorEsperado = new Restaurante(1, "Palatos", null);

		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setFacilitador(profissional);
		votacao.setAtiva(Boolean.TRUE);
		votacao.setVencedor(vencedorEsperado);
		gerarVotos(votacao);

		BDDMockito.given(votacaoRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(votacao));
		BDDMockito.given(profissionalRepository.findById(Mockito.any(Integer.class)))
				.willReturn(Optional.of(profissional));
		BDDMockito.given(restauranteRepository.findById(Mockito.any(Integer.class)))
				.willReturn(Optional.of(vencedorEsperado));
		BDDMockito.given(votacaoRepository.save(Mockito.any(Votacao.class))).willReturn(votacao);

		Restaurante vencedor = votacaoService.apurarVencedor(profissionalDTO, 1);

		Assert.assertNotNull(vencedor);
		Assert.assertEquals(vencedorEsperado, vencedor);
	}

	@Test
	public void nao_deve_apurar_vencedor_votacao_inativa() throws ActionDeniedException {

		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setAtiva(Boolean.FALSE);

		BDDMockito.given(votacaoRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(votacao));
		BDDMockito.given(votacaoRepository.save(Mockito.any(Votacao.class))).willReturn(votacao);

		try {
			votacaoService.apurarVencedor(profissionalDTO, 1);
		} catch (ActionDeniedException e) {
			Assert.assertEquals("Votação não esta ativa.", e.getMessage());
		}
	}

	@Test
	public void nao_deve_apurar_vencedor_profissional_nao_facilitador() throws ActionDeniedException {

		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setAtiva(Boolean.TRUE);

		Profissional profissional = new Profissional();
		profissional.setId(profissionalDTO.getId());
		profissional.setNome(profissionalDTO.getNome());

		BDDMockito.given(votacaoRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(votacao));
		BDDMockito.given(votacaoRepository.save(Mockito.any(Votacao.class))).willReturn(votacao);
		BDDMockito.given(profissionalRepository.findById(Mockito.any(Integer.class)))
				.willReturn(Optional.of(profissional));

		try {
			votacaoService.apurarVencedor(profissionalDTO, 1);
		} catch (ActionDeniedException e) {
			Assert.assertEquals("Profissional não é o facilitador. Apenas o faclitador pode apurar o Resultado.",
					e.getMessage());
		}
	}
	
	@Test
	public void deve_computar_voto_profissional_caminho_feliz() {
		
		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setAtiva(Boolean.TRUE);
		votacao.setVotos(new ArrayList<Voto>());
		
		
		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Profissional profissional = new Profissional();
		profissional.setId(profissionalDTO.getId());
		profissional.setNome(profissionalDTO.getNome());
		
		RestauranteDTO r1 = new RestauranteDTO(1,null,null);
		Restaurante restaurante = new Restaurante(1, "Palatos", null);
			
		VotoDTO votoDTO = new VotoDTO();
		votoDTO.setProfissionalDTO(profissionalDTO);
		votoDTO.setRestauranteDTO(r1);
		
		Voto voto = new Voto();
		voto.setId(1);
		voto.setProfissional(profissional);
		voto.setRestaurante(restaurante);
		voto.setDataVoto(HOJE);
		
		BDDMockito.given(votacaoRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(votacao));
		BDDMockito.given(profissionalRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(profissional));
		BDDMockito.given(votoRepository.buscarVotoPorProfissionaleData(Mockito.any(Profissional.class),Mockito.any(Date.class))).willReturn(null);
		BDDMockito.given(votacaoRepository.findByVencedor(restaurante)).willReturn(null);
		BDDMockito.given(restauranteRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(restaurante));
		BDDMockito.given(votoRepository.save(Mockito.any(Voto.class))).willReturn(voto);
		
		Voto votoPersistido = votacaoService.votar(1, votoDTO);
		
		Assert.assertNotNull(votoPersistido);
		
	}
	
	@Test
	public void nao_deve_computar_voto_profissional_ja_votou() {
		
		Votacao votacao = new Votacao();
		votacao.setId(1);
		votacao.setAtiva(Boolean.TRUE);
		votacao.setVotos(new ArrayList<Voto>());
		
		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		profissionalDTO.setId(1);
		profissionalDTO.setNome("TESTE");

		Profissional profissional = new Profissional();
		profissional.setId(profissionalDTO.getId());
		profissional.setNome(profissionalDTO.getNome());
		
		RestauranteDTO r1 = new RestauranteDTO(1,null,null);
		Restaurante restaurante = new Restaurante(1, "Palatos", null);
			
		VotoDTO votoDTO = new VotoDTO();
		votoDTO.setProfissionalDTO(profissionalDTO);
		votoDTO.setRestauranteDTO(r1);
		
		Voto voto = new Voto();
		voto.setId(1);
		voto.setProfissional(profissional);
		voto.setRestaurante(restaurante);
		voto.setDataVoto(HOJE);
		
		BDDMockito.given(votacaoRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(votacao));
		BDDMockito.given(profissionalRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(profissional));
		BDDMockito.given(votoRepository.buscarVotoPorProfissionaleData(Mockito.any(Profissional.class),Mockito.any(Date.class))).willReturn(voto);
		BDDMockito.given(votacaoRepository.findByVencedor(restaurante)).willReturn(null);
		BDDMockito.given(restauranteRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.of(restaurante));
		BDDMockito.given(votoRepository.save(Mockito.any(Voto.class))).willReturn(voto);
		
		try{
			votacaoService.votar(1, votoDTO);
		} catch (ActionDeniedException e) {
			Assert.assertEquals("Profissional já votou hoje",
					e.getMessage());
		}
	}

	private void gerarVotos(Votacao votacao) {
		Profissional profissional1 = new Profissional();
		profissional1.setId(1);
		Profissional profissional2 = new Profissional();
		profissional2.setId(2);
		Profissional profissional3 = new Profissional();
		profissional3.setId(3);
		Restaurante r1 = new Restaurante(1, "Palatos", null);
		Restaurante r2 = new Restaurante(2, "Panorama Gastronomico", null);
		Voto voto1 = new Voto();
		voto1.setId(1);
		voto1.setDataVoto(HOJE);
		voto1.setRestaurante(r1);
		voto1.setProfissional(profissional2);
		Voto voto2 = new Voto();
		voto2.setId(2);
		voto2.setDataVoto(HOJE);
		voto2.setRestaurante(r1);
		voto2.setProfissional(profissional1);
		Voto voto3 = new Voto();
		voto3.setId(3);
		voto3.setDataVoto(HOJE);
		voto3.setRestaurante(r2);
		voto3.setProfissional(profissional3);

		votacao.setVotos(Arrays.asList(voto1, voto2, voto3));
	}

}

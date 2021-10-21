package br.com.fiap.iotintegration.service.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.iotintegration.model.Botao;
import br.com.fiap.iotintegration.repository.BotaoRepository;

@Service
public class MqttService {

	@Autowired
	private BotaoRepository repository;
	
	public Botao create(Object object) {
		Botao botao = new Botao();
		botao.setEstadoBotao(object.toString());
		return repository.save(botao);
	}
}

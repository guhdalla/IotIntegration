package br.com.fiap.iotintegration.config.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

import br.com.fiap.iotintegration.service.mqtt.MqttService;

@SpringBootApplication
public class MqttJavaApplication {

	@Autowired
	private MqttService service;
	
	private String broker = "tcp://broker.hivemq.com:1883";

	public static void main(String[] args) {
		new SpringApplicationBuilder(MqttJavaApplication.class).run(args);
	}

	@Bean
	public IntegrationFlow mqttInbound() {
		return IntegrationFlows
				.from(new MqttPahoMessageDrivenChannelAdapter(broker, "testClient-newgen", "bgmbnewgen8462/iot"))
				.handle(m -> System.out.println(service.create(m.getPayload()))).get();
	}

}
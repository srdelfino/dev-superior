package br.pro.delfino.trabalhofinal.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
//		PropertyMap<ClientDTO, Client> clientMap = new PropertyMap <ClientDTO, Client>() {
//			protected void configure() {
//				skip(destination.getId());
//			}
//		};
//
//		modelMapper.addMappings(clientMap);
			
	    return modelMapper;
	}
}

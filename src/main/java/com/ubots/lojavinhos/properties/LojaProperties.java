package com.ubots.lojavinhos.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("loja")
public class LojaProperties {

	private String cadastrourl;
	
	private String historicourl;

	public String getCadastrourl() {
		return cadastrourl;
	}

	public void setCadastrourl(String cadastrourl) {
		this.cadastrourl = cadastrourl;
	}

	public String getHistoricourl() {
		return historicourl;
	}

	public void setHistoricourl(String historicourl) {
		this.historicourl = historicourl;
	}
}

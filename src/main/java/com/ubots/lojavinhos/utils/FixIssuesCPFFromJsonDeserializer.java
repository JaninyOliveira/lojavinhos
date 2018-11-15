package com.ubots.lojavinhos.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Esse deserializer foi criado para ajustar os dados incongruentes retornados pela API json fornecida.
 * @author Janiny
 *
 */
public class FixIssuesCPFFromJsonDeserializer extends JsonDeserializer<String>
{
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String msString = node.asText();
        
        String primeiraIssue =  msString.substring(0, msString.indexOf("."));
        if(primeiraIssue.length() > 3) {
        	msString = msString.substring(primeiraIssue.length()-3, msString.length()); // CPFs na Compra tem zeros a mais do que nos Clientes, exceto a primeira compra
        }
        
        StringBuilder segundaIssue = new StringBuilder(msString);
        segundaIssue.setCharAt(msString.lastIndexOf("."), '-'); // CPFs na Compra possuem '.' enquanto no Clientes a ultima centena e separada por -

       return segundaIssue.toString();
    }
}

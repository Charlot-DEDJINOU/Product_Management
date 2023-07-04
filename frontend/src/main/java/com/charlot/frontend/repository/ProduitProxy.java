package com.charlot.frontend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.charlot.frontend.CustomProperties;
import com.charlot.frontend.model.Produit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProduitProxy {

    @Autowired
    private CustomProperties props;

    public List<Produit> getProduits() {
        String baseApiUrl = props.getApiUrl();
        String getProduitstUrl = baseApiUrl + "/list";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Produit>> response = restTemplate.exchange(
                getProduitstUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Produit>>() {
                });

        log.debug("Get Produits call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit getProduit(int id) {
		String baseApiUrl = props.getApiUrl();
		String getProduitUrl = baseApiUrl + "/read/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Produit> response = restTemplate.exchange(
				getProduitUrl, 
				HttpMethod.GET, 
				null,
				Produit.class
			);
		
		log.debug("Get Produit call " + response.getStatusCode().toString());
		
		return response.getBody();
	}

    public Produit createProduit(Produit e) {
        String baseApiUrl = props.getApiUrl();
        String createProduitUrl = baseApiUrl + "/create";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Produit> request = new HttpEntity<Produit>(e);
        ResponseEntity<Produit> response = restTemplate.exchange(
                createProduitUrl,
                HttpMethod.POST,
                request,
                Produit.class);

        log.debug("Create Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit updateProduit(Produit e) {
		String baseApiUrl = props.getApiUrl();
		String updateProduitUrl = baseApiUrl + "/update/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Produit> request = new HttpEntity<Produit>(e);
		ResponseEntity<Produit> response = restTemplate.exchange(
				updateProduitUrl, 
				HttpMethod.PUT, 
				request, 
				Produit.class);
		
		log.debug("Update Produit call " + response.getStatusCode().toString());
		
		return response.getBody();
	}

    public String deleteProduit(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteProduitUrl = baseApiUrl + "/delete/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(
				deleteProduitUrl, 
				HttpMethod.DELETE, 
				null, 
				String.class);
		
		log.debug("Delete Produit call " + response.getStatusCode().toString());

        return response.getBody();
	}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.censys.jackson.processing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author fcastillo
 */
public class App {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"success\":true,\"result\":[{\"productid\":\"75\",\"productname\":\"Personal\",\"tarjeta_id\":\"119\",\"id_facturador\":\"4\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"},\n"
                + "\n"
                + "{\"productid\":\"76\",\"productname\":\"Claro\",\"tarjeta_id\":\"115\",\"id_facturador\":\"3\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"},\n"
                + "\n"
                + "{\"productid\":\"77\",\"productname\":\"Movistar\",\"tarjeta_id\":\"116\",\"id_facturador\":\"1\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"},\n"
                + "\n"
                + "{\"productid\":\"78\",\"productname\":\"Nextel\",\"tarjeta_id\":\"118\",\"id_facturador\":\"5\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"}\n"
                + "\n"
                + ",{\"productid\":\"80\",\"productname\":\"Direct Tv\",\"tarjeta_id\":\"157\",\"id_facturador\":\"41\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"}\n"
                + "\n"
                + ",{\"productid\":\"81\",\"productname\":\"Tuenti - Quam\",\"tarjeta_id\":\"167\",\"id_facturador\":\"7\",\"id_servicio\":\"4912\",\"crmid\":\"36014\"}]}";

        // Leemos el JSON
        JsonNode node = objectMapper.readValue(json, JsonNode.class);

        // Obtenemos objeto result
        JsonNode array = node.get("result");

        if (array.isArray()) {
            for (JsonNode jsonNode : array) {
                String productId = jsonNode.get("productid").asText();
                String productName = jsonNode.get("productname").asText();
                String tarjetaId = jsonNode.get("tarjeta_id").asText();

                System.out.println("Id:: " + productId + "\t" + productName + "\t" + tarjetaId);
            }

        }
    }

}

package com.jafarofv.countries_api.initializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jafarofv.countries_api.entity.Country;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CountryInitializer {
    public static List<Country> readCountry() {
        String root = System.getProperty("user.dir");

        List<Country> countries = new ArrayList<>();
        File countryJson = new File(root + File.separator + "assets" + File.separator + "countries.json");
        try {
            Map<String, Map<String, Object>> result = new ObjectMapper()
                    .readValue(countryJson, HashMap.class);

            for (String code : result.keySet()) {
                Map<String, Object> valueMap = result.get(code);
                String name = valueMap.get("name").toString();
                String nativeName = valueMap.get("native").toString();
                String continent = valueMap.get("continent").toString();
                String capital = valueMap.get("capital").toString();
                String currency = valueMap.get("currency").toString();
                String languages = valueMap.get("languages").toString();
                int phone;
                try {
                    phone = Integer.parseInt(valueMap.get("phone").toString());

                } catch (NumberFormatException e) {
                    phone = -1;
                }
                String flagUrl = genegrateFlagUrl(code);

                Country c = Country.builder()
                        .code(code)
                        .name(name)
                        .nativeName(nativeName)
                        .continent(continent)
                        .capital(capital)
                        .phone(phone)
                        .currency(currency)
                        .languages(languages)
                        .flag(flagUrl)
                        .build();
                countries.add(c);
            }
        } catch (Exception e) {
            System.out.println("Xeta bas verdi: " + e.getMessage());
            log.error("Xeta bas verdi: " + e.getMessage());
        }
        return countries;
    }

    private static String genegrateFlagUrl(String id) {
        return "https://flagsapi.com/" + id + "/flat/64.png";
    }
}

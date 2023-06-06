package pl.comarch.szkolenia.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiClient {
    private RestTemplate restTemplate = new RestTemplate();

    public User getUser(int age, String name,
                        String surname, String h1,
                        String h2, User user) {
        String url3 = "http://localhost:8080/api/test5/{age}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("age", age+"");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url3)
                .queryParam("name", name)
                .queryParam("surname", surname)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("h1", h1);
        httpHeaders.add("h2", h2);

        HttpEntity<User> reqest = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<User> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.POST,
                reqest,
                User.class,
                pathVariables
        );

        HttpHeaders naglowki = response.getHeaders();
        for(Map.Entry<String, List<String>> entry : naglowki.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        int kodOdpowiedzi = response.getStatusCode().value();

        User responseUser = response.getBody();
        System.out.println("kod odpowiedzi: " + kodOdpowiedzi);
        System.out.println(responseUser.getId());
        System.out.println(responseUser.getLogin());
        System.out.println(responseUser.getPassword());

        return responseUser;
    }
}

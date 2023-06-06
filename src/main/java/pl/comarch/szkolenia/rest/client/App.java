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

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        /*String url = "http://localhost:8080/api/test2";

        User user = restTemplate.getForObject(url, User.class);
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());*/

        /*String url2 = "http://localhost:8080/api/test3";
        User postUser = new User(40, "wiesiek", "kowlaski");
        User receivedUser = restTemplate.postForObject(url2, postUser, User.class);
        System.out.println(receivedUser.getId());
        System.out.println(receivedUser.getLogin());
        System.out.println(receivedUser.getPassword());*/

        /*String url3 = "http://localhost:8080/api/test5/{age}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("age", "55");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url3)
                .queryParam("name", "zbyszek")
                .queryParam("surname", "kowalski")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("h1", "cos");
        httpHeaders.add("h2", "cos innego");

        User user2 = new User(123, "Karol", "Malinowski");

        HttpEntity<User> reqest = new HttpEntity<>(user2, httpHeaders);

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
        System.out.println(responseUser.getPassword());*/

        User user3 = new User(123, "Karol", "Malinowski");
        ApiClient apiClient = new ApiClient();
        User userFormServer = apiClient.getUser(33, "Bogdan",
                "Jakis", "naglowek1",
                "naglowek2", user3);
        System.out.println(userFormServer.getId());
        System.out.println(userFormServer.getLogin());
        System.out.println(userFormServer.getPassword());
    }
}

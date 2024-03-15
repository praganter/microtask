package dev.batuhanyetgin.msorder.client;


import dev.batuhanyetgin.msorder.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-book-service", path = "/v1/book")
public interface BookServiceClient {
    @GetMapping("/{isbn}")
    BookDto getDetails(@PathVariable Long isbn);

    @GetMapping("/isExists/{isbn}")
    boolean isExists(@PathVariable Long isbn);

    @PostMapping("/removeStock")
    void removeStock(@RequestBody BookDto bookDto);
}

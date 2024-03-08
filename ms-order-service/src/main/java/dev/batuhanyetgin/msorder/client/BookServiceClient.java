package dev.batuhanyetgin.msorder.client;

import dev.batuhanyetgin.msbookservice.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-book-service", path = "/v1/book")
public interface BookServiceClient {

    ResponseEntity<BookDto> getDetails(@PathVariable Long isbn);
}

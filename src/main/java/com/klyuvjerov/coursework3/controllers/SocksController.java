package com.klyuvjerov.coursework3.controllers;

import com.klyuvjerov.coursework3.controllers.dto.ResponseDto;
import com.klyuvjerov.coursework3.model.CottonContent;
import com.klyuvjerov.coursework3.model.SocksBatch;
import com.klyuvjerov.coursework3.model.SockSize;
import com.klyuvjerov.coursework3.model.SocksColor;
import com.klyuvjerov.coursework3.services.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
@Tag(name = "API по работе с носками", description = "работа с товаром на складе")
public class SocksController {
   private final SocksService socksService;

   @PostMapping
   @Operation(summary = "принимаем носки на склад")
   @ApiResponse(responseCode = "200", description = "операция успешна")
   @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат")
   @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> accept(@RequestBody SocksBatch socksBatch) {
      socksService.accept(socksBatch);
       return ResponseEntity.ok(new ResponseDto(" товар успешно добавлен на склад "));
    }

    @PutMapping
    @Operation(summary = "отпуск носков со склада")
    @ApiResponse(responseCode = "200", description = "операция успешна")
    @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> vacation(@RequestBody SocksBatch socksBatch) {
    int socksCount = socksService.vacation(socksBatch);
        return ResponseEntity.ok(new ResponseDto(socksCount + " носков отпущено со склада "));
    }

    @GetMapping
    @Operation(summary = "подсчёт общего количества носков")
    @ApiResponse(responseCode = "200", description = "операция успешна")
    @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> getCalculate(@RequestParam SocksColor socksColor,
                                             @RequestParam SockSize sockSize,
                                             @RequestParam CottonContent cottonContent){
        int socksCount = socksService.getCalculate(socksColor, sockSize, cottonContent);
        return ResponseEntity.ok(new ResponseDto( " количество носков " + socksCount));
    }

   @DeleteMapping
   @Operation(summary = "регистрирует списание брака со склада")
   @ApiResponse(responseCode = "200", description = "операция успешна")
   @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат")
   @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
   public ResponseEntity<ResponseDto> delete(@RequestBody SocksBatch socksBatch) {
       int socksCount = socksService.delete(socksBatch);
       return ResponseEntity.ok(new ResponseDto( " бракованный товар списан со склада в количестве " +
               socksCount + " пар "));
   }


}

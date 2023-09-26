package com.mycompany.myapp.web.controller;

import com.mycompany.myapp.converter.TestConverter;
import com.mycompany.myapp.exception.ResponseMessage;
import com.mycompany.myapp.exception.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.myapp.domain.Test;
import com.mycompany.myapp.exception.CustomExceptions;
import com.mycompany.myapp.service.TestService;
import com.mycompany.myapp.web.controller.base.BaseController;
import com.mycompany.myapp.web.dto.TestRequestDto;
import com.mycompany.myapp.web.dto.TestResponseDto;
import com.mycompany.myapp.web.dto.base.DefaultRes;

@Api(tags = "테스트 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController extends BaseController {
    private final TestService testService;
    private final TestConverter testConverter;

    @ApiOperation(value = "테스트 API")
    @ApiResponse(code = 200, message = "테스트 성공")
    @PostMapping
    public ResponseEntity createTest(@RequestBody TestRequestDto.CreateTestDto request){
        try {
            logger.info("Received request: method={}, path={}, description={}", "POST", "/my-profile/charge", "포인트 충전 API");

            Test test = testService.create(request.getName());
            TestResponseDto.CreateTestDto res = testConverter.toCreateTestDto(test);
            return new ResponseEntity( DefaultRes.res(StatusCode.OK, ResponseMessage.TEST_SUCCESS, res), HttpStatus.OK);
        } catch (CustomExceptions.testException e) {
            return handleApiException(e, HttpStatus.BAD_REQUEST);
        }
    }
}

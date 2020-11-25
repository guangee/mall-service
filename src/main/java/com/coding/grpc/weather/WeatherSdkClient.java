package com.coding.grpc.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class WeatherSdkClient {
    private final WeatherServiceGrpc.WeatherServiceBlockingStub blockingStub;
    private final WeatherServiceGrpc.WeatherServiceFutureStub futureStub;
    private final WeatherServiceGrpc.WeatherServiceStub stub;
}

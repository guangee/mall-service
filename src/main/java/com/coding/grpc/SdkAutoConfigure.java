package com.coding.grpc;

import com.coding.grpc.message.MessageSdkClient;
import com.coding.grpc.message.MessageServiceGrpc;
import com.coding.grpc.weather.WeatherSdkClient;
import com.coding.grpc.weather.WeatherServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author https://github.com/zziaguan/
 */
@Slf4j
@Configuration
public class SdkAutoConfigure {


    @GrpcClient("message")
    private MessageServiceGrpc.MessageServiceBlockingStub messageServiceBlockingStub;
    @GrpcClient("message")
    private MessageServiceGrpc.MessageServiceFutureStub messageServiceFutureStub;
    @GrpcClient("message")
    private MessageServiceGrpc.MessageServiceStub messageServiceStub;

    @GrpcClient("message")
    private WeatherServiceGrpc.WeatherServiceBlockingStub weatherServiceBlockingStub;
    @GrpcClient("message")
    private WeatherServiceGrpc.WeatherServiceFutureStub weatherServiceFutureStub;
    @GrpcClient("message")
    private WeatherServiceGrpc.WeatherServiceStub weatherServiceStub;

    @Bean
    @ConditionalOnMissingBean
    public MessageSdkClient messageSdkClient() {
        log.debug("配置messageSDK");
        return new MessageSdkClient(messageServiceBlockingStub, messageServiceFutureStub, messageServiceStub);
    }

    @Bean
    @ConditionalOnMissingBean
    public WeatherSdkClient weatherSdkClient() {
        log.debug("配置weatherSDK");
        return new WeatherSdkClient(weatherServiceBlockingStub, weatherServiceFutureStub, weatherServiceStub);
    }
}

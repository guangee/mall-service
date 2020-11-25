package com.coding.grpc.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class MessageSdkClient {
    private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;
    private final MessageServiceGrpc.MessageServiceFutureStub futureStub;
    private final MessageServiceGrpc.MessageServiceStub stub;

}

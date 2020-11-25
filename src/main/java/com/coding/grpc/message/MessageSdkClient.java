package com.coding.grpc.message;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSdkClient {
    @GrpcClient("message")
    private MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    public SendSmsReply demo(String phone) {
        return blockingStub.sendSmsCode(SendSmsRequest.newBuilder().setPhone(phone).build());
    }
}

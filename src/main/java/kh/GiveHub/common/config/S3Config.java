package kh.GiveHub.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import java.net.URI;

@Configuration
public class S3Config {
    @Value("${cloudflare.r2.account.id}")
    private String accountId;
    @Value("${cloudflare.r2.access.key}")
    private String accessKey;
    @Value("${cloudflare.r2.secret.key}")
    private String secretKey;

    @Bean
    public S3Client buildS3Client(){
        String endpoint = String.format("https://%s.r2.cloudflarestorage.com", accountId);

//        System.out.println("=== S3Config Debug ===");
//        System.out.println("Account ID: " + accountId);
//        System.out.println("Endpoint: " + endpoint);

        AwsBasicCredentials credentials = AwsBasicCredentials.create(
                accessKey, secretKey
        );

        S3Configuration serviceConfig = S3Configuration.builder()
                .pathStyleAccessEnabled(true)
                .chunkedEncodingEnabled(false)  // 추가
                .build();

        return S3Client.builder()
                .endpointOverride(URI.create(endpoint))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .region(Region.of("auto"))
                .serviceConfiguration(serviceConfig)
                .build();
    }

//    @Bean
//    public S3Presigner s3Presigner() {
//        String endpoint = String.format("https://%s.r2.cloudflarestorage.com", accountId);
//
//        return S3Presigner.builder()
//                .endpointOverride(URI.create(endpoint))
//                .credentialsProvider(StaticCredentialsProvider.create(
//                        AwsBasicCredentials.create(accessKey, secretKey)))
//                .region(Region.of("auto"))
//                .build();
//    }
}

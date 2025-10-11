package cn.javayong.magicdoc.view.store.test;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;
import java.io.InputStream;

public class MinioUnitTest {

    public static void main(String[] args) {
        try {
            // 1. 初始化 MinIO 客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint("http://localhost:9000") // MinIO 地址
                    // accessKey 和 secretKey
                    .credentials("yHxFBiulXKsuhbg9nHqO", "qmsQU4JuWuwlr3ZgY4eMFbQ9LaTzzEHMV6T722kC")
                    .build();

            // 2. 文件信息
            String bucketName = "datasets";
            String objectName = "mydataset1/images/xiaoyuanjiang.webp"; // 上传路径（类似目录）
            String filePath = "/Users/zhangyong/Pictures/xiaoyuanjiang.webp"; // 本地文件路径

            // 3. 上传文件（流式上传）
            try (InputStream in = new FileInputStream(filePath)) {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(objectName)
                                .stream(in, in.available(), -1)
                                .contentType("image/png") // 可根据文件类型设置
                                .build()
                );
                System.out.println("✅ 文件上传成功: " + objectName);
            }

            // 4. 拼接直链 URL（因为是 public bucket）
            String publicUrl = String.format("http://localhost:9000/%s/%s", bucketName, objectName);
            System.out.println("✅ 上传成功，直链地址：");
            System.out.println(publicUrl);

//            // 4. 生成临时访问链接（可选）
//            String url = minioClient.getPresignedObjectUrl(
//                    GetPresignedObjectUrlArgs.builder()
//                            .method(Method.GET)
//                            .bucket(bucketName)
//                            .object(objectName)
//                            .expiry(60 * 60) // 1小时有效
//                            .build()
//            );
//            System.out.println("📎 临时访问地址: " + url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

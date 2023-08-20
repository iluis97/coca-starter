package cn.luis.coca.oss.client;

import cn.luis.coca.dto.file.FileDownDTO;
import cn.luis.coca.dto.file.FileUploadDTO;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * s3 是一个协议
 * Simple Storage Service的缩写，即简单存储服务
 *
 * @author luis
 */
interface S3OssClient {

    /**
     * 创建bucket
     *
     * @param bucketName 存储桶名称
     */
    void createBucket(String bucketName);

    /**
     * 删除bucket
     *
     * @param bucketName 存储桶名称
     */
    void deleteBucket(String bucketName);

    /**
     * 获取url
     *
     * @param bucketName 存储桶名称
     * @param fileKey    aka fileFolder+fileName
     * @return url
     */
    String getObjectUrl(String bucketName, String fileKey);

    /**
     * 获取在线预览url
     *
     * @param bucketName 存储桶名称
     * @param fileKey    /a/b/c.txt
     * @param expiration 到期时间
     * @return 在线预览url
     */
    String getObjectPreviewUrl(String bucketName, String fileKey, LocalDateTime expiration);

    void deleteObject(String bucketName, String fileKeys);

    void deleteObjects(String bucketName, List<String> fileKeys);

    /**
     * @param bucketName  存储桶名称
     * @param fileFolder  /a/b/
     * @param fileName    c.txt
     * @param inputStream 文件流
     * @return FileUploadDTO
     */
    FileUploadDTO upload(String bucketName, String fileFolder, String fileName, InputStream inputStream) throws IOException;

    /**
     * @param bucketName     存储桶名称
     * @param fileFolder     /a/b/
     * @param fileName       c.txt
     * @param inputStream    文件流
     * @param objectMetadata 文件元数据 [一般要设置 setContentType、setContentDisposition] {@link #upload(String, String, String, InputStream)}
     * @return FileUploadDTO
     */
    FileUploadDTO upload(String bucketName, String fileFolder, String fileName, InputStream inputStream, ObjectMetadata objectMetadata) throws IOException;

    /**
     * 获取存储对象
     *
     * @param bucketName 存储桶名称
     * @param fileKey    aka fileFolder+fileName
     * @return 存储对象
     */
    FileDownDTO down(String bucketName, String fileKey) throws IOException;
}

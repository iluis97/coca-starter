package cn.luis.coca.oss.client;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author luis
 * @since 1.0
 * 2022/9/30 16:05
 */
public interface OssClient extends S3OssClient {

    /**
     * 想要更复杂订单操作可以直接获取AmazonS3，通过AmazonS3 来进行复杂的操作
     * <a href="https://docs.aws.amazon.com/zh_cn/sdk-for-java/v1/developer-guide/examples-s3-buckets.html">...</a>
     */
    AmazonS3 getS3Client();

    /**
     * 获取存储对象信息
     *
     * @param bucketName 存储桶名称
     * @param fileKey    aka fileFolder+fileName
     * @return 存储对象信息
     */
    S3Object getObjectInfo(String bucketName, String fileKey);

    /**
     * 上传文件
     *
     * @param bucketName  存储桶名称
     * @param fileKey     /a/b/c.txt
     * @param inputStream 文件流
     * @param size        文件大小
     * @param contextType 文件类型
     * @return PutObjectResult
     */
    PutObjectResult putObject(String bucketName, String fileKey, InputStream inputStream, long size, String contextType) throws IOException;

    default PutObjectResult putObject(String bucketName, String fileKey, InputStream stream) throws IOException {
        return putObject(bucketName, fileKey, stream, stream.available(), "application/octet-stream");
    }

}

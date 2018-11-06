package dev;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Risky57 on 2017/4/27.
 */
public class Main {

    private static final String URL_STUDIO = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533903197388&di=ed46d40502eeab2690c4c4e163876c23&imgtype=0&src=http%3A%2F%2Fi.shangc.net%2F2018%2F0626%2F20180626012039209.jpg";
    private static final String PATH_STUDIO = "/Users/dllo/Desktop";
    private static final String NAME_FILE_STUDIO = "AAA.jpg";
    private static OkHttpClient sClient;
    private static File sFile;


    public static void main(String[] args) throws IOException {

        // HTTP 协议的运用
        // 请求头 Range: bytes=start-end
        // 第一次请求, 只获取需要下载的文件的大小
        sClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(URL_STUDIO).build();
        Response response = sClient.newCall(request).execute();
        long contentLength = response.body().contentLength();

        // 判断本地文件是否存在
        sFile = new File(PATH_STUDIO, NAME_FILE_STUDIO);
        long currentLength = 0;
        if (sFile.exists()) {
            // 如果文件已经存在
            currentLength = sFile.length();
            System.out.println("文件已经存在: " + (currentLength * 100f / contentLength) + "%");
            if (currentLength == contentLength) {
                System.out.println("文件已经下载完毕");
                return;
            }
        } else {
            sFile.createNewFile();
            System.out.println("文件不存在");
        }
        startDownloadFile(currentLength, contentLength);
    }

    private static void startDownloadFile(long currentLength, long contentLength) throws IOException {
        long millis = System.currentTimeMillis();
        Request request = new Request.Builder()
                .header("Range", "bytes=" + currentLength + "-" + contentLength)
                .url(URL_STUDIO)
                .build();
        Response response = sClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        FileOutputStream fos = new FileOutputStream(sFile, true);
        byte[] bytes = new byte[1024];
        int length = -1;
        int lastProgress = 0;
        int sum = 0;
        while ((length = is.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
            currentLength += length;
            int progress = (int) (currentLength * 100f / contentLength);
            if (progress != lastProgress) {
                lastProgress = progress;
                System.out.println("下载进度: " + progress + "%");
                long l = System.currentTimeMillis() - millis;
                sum += l;
            }
        }
        System.out.println("消耗时间为"+sum);
        fos.close();
        is.close();
    }

}

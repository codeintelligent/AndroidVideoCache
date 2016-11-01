package com.danikula.videocache.file;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import com.danikula.videocache.ProxyCacheUtils;

/**
 * Implementation of {@link FileNameGenerator} that uses MD5 of url as file name
 *
 * @author Alexey Danilov (danikula@gmail.com).
 */
public class Md5FileNameGenerator implements FileNameGenerator {

    @Override
    public String generate(String url) {
        String extension = getExtension(url);
        String name = ProxyCacheUtils.computeMD5(url);
        return TextUtils.isEmpty(extension) ? name : name + "." + extension;
    }

    private String getExtension(String url) {
        if (TextUtils.isEmpty(url)) {
            return url;
        }

        return MimeTypeMap.getFileExtensionFromUrl(url);
    }
}

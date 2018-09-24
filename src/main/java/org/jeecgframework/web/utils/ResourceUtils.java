package org.jeecgframework.web.utils;

import org.jeecgframework.platform.util.FileUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2016/1/4.
 */
public class ResourceUtils extends FileUtils{
    //定义资源类型
    public final  static String  RESOURCE_TEMPLATE="resource/template";
    public final  static String  RESOURCE_FILE="resource/upload";
    /***
     * 获取图片保存路径
     * @return
     */
   public static  String getDateDir(){
       Date date = new Date();
       String path=new SimpleDateFormat("yyyy/MM/dd").format(date);
       return  path;
   }

    /***
     　　　   获取文件名
     @param fileName
      * @return
     **/
    public static String getFileName(String fileName) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String realFilename=sdf.format(new Date())+StringUtils.random(8);
        String extend = ResourceUtils.getExtend(fileName, "");// 获取文件扩展名
        if(StringUtils.isEmpty(extend)){
            return  realFilename;
        }
        return realFilename+"."+extend;//自定义文件名称
    }
    /***
     * 获取资源服务器的路径
     *
     * @return
     */
    public static  String getResourceLocalPath(){
        String  serverPath=ConfigUtils.getConfigByName("resource.server.path");
        return  serverPath;
    }

    /***
     * 获取资源请求路径
     *
     * @return
     */
    public static  String getResourcePublicURL(){
        String  url=ConfigUtils.getConfigByName("resource.public.url");
        return  url;
    }
}

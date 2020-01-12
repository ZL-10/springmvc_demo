package com.zl.control;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/user")
public class FileUpLoadController {
    @RequestMapping("/testUpLoad")
    public String  testUpLoad(HttpServletRequest request) throws Exception {
        System.out.println("开始上传");
        String path=request.getSession().getServletContext().getRealPath("/uploadFiles/");
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(fileItemFactory);
        List<FileItem> items=upload.parseRequest(request);
        for(FileItem item:items){
            if(item.isFormField()){

            }else{
                String fileName=item.getName();
                item.write(new File(path,fileName));
                item.delete();
            }

        }
        return "success";
    }

}

package com.qf.test;

public class Test {

    /*

    @ResponseBody
    @RequestMapping(value = "upload")
    public Map<String,Object> upload(MultipartFile dropzFile, HttpServletRequest request){
        System.out.println(dropzFile);
        Map<String,Object> result=new HashMap<String, Object>();
        //获取上传的文件名
        String fileName=dropzFile.getOriginalFilename();
        //设置文件上传路径
        String filePath=request.getSession().getServletContext().getRealPath("/static/upload");
        //获取文件的后缀名
        String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        //判断并创建上传文件夹
        File file=new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        //重新设置文件名为UUID
        file=new File(filePath, UUID.randomUUID()+fileSuffix);
        System.out.println(file.getAbsoluteFile());
        if(!file.exists()){
            try {
                file.createNewFile();
                //写入文件
                dropzFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 返回 JSON 数据，这里只带入了文件名
        result.put("fileName",file.getName());
        return result;
    }

     @ResponseBody
    @RequestMapping("addBrand")
    public Object addBrand(@RequestBody ProductBrandDto productBrandDto){

        String logo = productBrandDto.getLogo();
        if (logo.length()>0){
            productBrandDto.setLogo("http://localhost:8080/static/upload/"+logo);
        }
        int i = productBrandService.addBrand(productBrandDto);
        return i;
    }

     */
}


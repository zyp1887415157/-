import java.io.File;

class Main {

    public static void main(String[] args) {
        String path = "C:\\Program Files\\web\\apache-tomcat-7.0.86";
        File rootDir = new File(path);
        listFile(rootDir);
    }


    public static void listFile(File dir){
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                listFile(file);
            } else {
                String name = file.getName();
                if (name.startsWith(".")){
                    file.delete();
                }
            }
        }
    }

}

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Created by Sinme on 2015/10/29.
 */
public class HdfsDAOimpl implements HdfsDAO {
    private FileSystem fs;
    private Configuration conf;
    private FSDataOutputStream dos;

    public HdfsOperator() {
        conf = new Configuration();
        try {
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(Path path) {
        try {
            return fs.exists(path);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void append(Path path, byte[] readBuf) {
        try {
            dos = fs.append(path);
            dos.write(readBuf);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Path path, byte[] readBuf) {
        try {
            dos = fs.create(path);
            dos.write(readBuf);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Created by Sinme on 2015/10/29.
 */
public interface HdfsDAO {
    abstract public void create(Path path, byte[] readBuf);
    abstract public void append(Path path, byte[] readBuf);
    abstract public boolean exists(Path path);
}

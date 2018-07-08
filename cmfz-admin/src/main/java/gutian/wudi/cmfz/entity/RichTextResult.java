package gutian.wudi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-08 21:52
 **/
public class RichTextResult implements Serializable {
    private Integer errno;
    private ArrayList<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}

/**
 * FileName: netty.tcppackage2
 * Author    王磊
 * Date      2019/4/30 21:57
 * Description: person协议
 */
package netty.tcppackage2;

/**
 * person协议
 *
 * @author Administrator
 * @since 1.0.0
 */
public class PersonProtocol {
    private int length;
    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}

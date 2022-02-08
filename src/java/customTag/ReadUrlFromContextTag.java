/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* ReadUrlFromContexttTag
* Read from context quickly and reduce error by mapping resource.
*/
package customTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Admin
 */
public class ReadUrlFromContextTag extends SimpleTagSupport {

    private String url; //pass url as parameter to tag
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * doTag method do main activity of tag
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            PageContext pageContext = (PageContext)getJspContext(); // get pageContext
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            out.println(request.getContextPath()+url); //read url from root and join it with url passed then write it;
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ImportUrlTag tag", ex);
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
